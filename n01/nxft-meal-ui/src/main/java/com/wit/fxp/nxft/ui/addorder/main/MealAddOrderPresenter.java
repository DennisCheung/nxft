package com.wit.fxp.nxft.ui.addorder.main;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.benewit.core.env.RuntimeContext;
import com.vaadin.ui.Notification;
import com.wit.Invoker;
import com.wit.fxp.nxft.app.AddNxftOrderCommand;
import com.wit.fxp.nxft.app.AddOrderApp;
import com.wit.fxp.nxft.app.OrderApp;
import com.wit.fxp.nxft.app.common.model.KitchenMenuData;
import com.wit.fxp.nxft.app.common.model.MyOrderList;
import com.wit.fxp.nxft.app.model.SubjectModel;
import com.wit.fxp.nxft.utils.DateUtils;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;
import com.wit.fxp.ui.workspace.AbstractPagePresenter;
import com.wit.fxp.ui.workspace.WorkspaceUtils;

@PrototypeScope
@VaadinPresenter(viewName = MealAddOrderView.NAME)
public class MealAddOrderPresenter extends AbstractPagePresenter<MealAddOrderView> {

    @Autowired private UserSession userSession;
    @Autowired private AddOrderApp app;
    @Autowired private OrderApp orderApp;
    @Autowired private RuntimeContext runtimeContext;

    private String teamId;

    private String userId;

    private String personId;

    @Autowired
    public MealAddOrderPresenter(EventBus.UIEventBus eventBus, MealAddOrderView view) {
        super(eventBus, view);
    }

    @Override
    public void initPage(Object parameters) {
        if (parameters == null) {
            teamId = userSession.getTeamId();
            userId = userSession.getUserId();
            personId = "12345678";
        }
        else {
            String[] values = (String[]) parameters;
            teamId = values[0];
            userId = values[1];
            personId = values[2];
        }
        postInit();
    }

    public void postInit() {
        getView().initView(this);
        refreshAll(DateUtils.parseShortDate(DateUtils.getNextDay(runtimeContext.getCurrentDate())));
        refreshSubjectInfo();
    }

    public void refreshAll(Date time) {
        List<KitchenMenuData> datas = app.findAllDatas(userSession.getCircleId(), personId, time);
        getView().addMeal(datas, this);
        refreshSubjectInfo();
    }

    public String checkIsDisease(String mealId) {
        return orderApp.checkIsDisease(mealId);
    }

    public void refreshSubjectInfo() {
        SubjectModel subject = orderApp.findSubjectModelByPersonId(personId);

        getView().refreshSubjectInfo(subject, orderApp.findYue(personId));
    }

    public void addOrder(List<MyOrderList> lists, Date mealDate) {
        if (personId == null) {
            Notification.show("请选择吃饭的人！");
            return;
        }

        boolean isSubject = app.findSubjectByPersonId(personId);

        if (isSubject) {
            Notification.show("客户不是暖心饭堂对象！");
            return;
        }

        List<AddNxftOrderCommand> commands = lists.stream().map(e -> {
            AddNxftOrderCommand command = AddNxftOrderCommand.builder()
                     ._mealDate______(DateUtils.getBegin(DateUtils.parseLongDate(e.getMealDate())))
                     ._mealTypeId____(e.getMealTypeId())
                     ._mealId________(e.getMealId())
                     ._build_();
            return command;
        }).collect(Collectors.toList());

        app.派单(Invoker.builder()
                ._teamId____(teamId)
                ._userId____(userId)
                ._build_(), personId, commands, "1");
        WorkspaceUtils.getNearMostWorkspace(getView()).closePage(getView());
    }

}
