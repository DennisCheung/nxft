package com.wit.fxp.nxft.ui.block.foodorder;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.annotation.EventBusListenerMethod;

import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.DBC.餐别;
import com.wit.fxp.nxft.compound.NxftCompoundApp;
import com.wit.fxp.nxft.compound.model.NxftOrderDetailModel;
import com.wit.fxp.nxft.paging.PagingInfo;
import com.wit.fxp.nxft.ui.block.event.RefreshCompoundEvent;
import com.wit.fxp.nxft.ui.block.foodorder.model.FoodOrderVModel;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;
import com.wit.fxp.ui.workspace.AbstractPagePresenter;
import com.wit.fxp.ui.workspace.WorkspaceUtils;
import com.wit.fxp.ui.workspace.page.DefaultPageContext;
import com.wit.utils.DateUtils;

@PrototypeScope
@VaadinPresenter(viewName = FoodOrderView.NAME)
public class FoodOrderPresenter extends AbstractPagePresenter<FoodOrderView> {

    private final NxftCompoundApp nxftCompoundApp;
    private final UserSession userSession;
    private final ApplicationContext applicationContext;

    @Autowired
    public FoodOrderPresenter(EventBus.UIEventBus eventBus, FoodOrderView view, ApplicationContext applicationContext,
            NxftCompoundApp nxftCompoundApp, UserSession userSession) {
        super(eventBus, view);
        this.nxftCompoundApp = nxftCompoundApp;
        this.userSession = userSession;
        this.applicationContext = applicationContext;
    }

    @Override
    public void initPage(Object parameters) {
        getView().initView(this);
        List<IdAndName> deliveSites = this.nxftCompoundApp.findDeliveSites(this.userSession.getTeamId());
        List<IdAndName> subjectTypes = this.nxftCompoundApp.findSubjectTypes();
        this.getView().refreshDictData(deliveSites, subjectTypes);
        this.getView().refresh();
    }

    public void refreshData(Date orderCreateB, Date orderCreateE, Date mealTimeB, Date mealTimeE, String subjectName,
            String orderState, String deliveSiteId, String subjectType, PagingInfo pageInfo) {
        orderCreateB = orderCreateB == null ? null : DateUtils.getBegin(orderCreateB);
        orderCreateE = orderCreateE == null ? null : DateUtils.getEnd(orderCreateE);
        mealTimeB = mealTimeB == null ? null : DateUtils.getBegin(mealTimeB);
        mealTimeE = mealTimeE == null ? null : DateUtils.getEnd(mealTimeE);
        List<NxftOrderDetailModel> orderDetail = this.nxftCompoundApp.findOrderDetail(this.userSession.getTeamId(), orderCreateB, orderCreateE,
                mealTimeB, mealTimeE, subjectName, orderState, deliveSiteId, subjectType, pageInfo);
        String[] weeks = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        List<FoodOrderVModel> collect = orderDetail.stream().map(e -> {
            Button viewBtn = new Button("查看");
            viewBtn.addClickListener(e1 -> {
                ViewOrderPresenter bean = this.applicationContext.getBean(ViewOrderPresenter.class);
                bean.postInit(e.getId());
                UI.getCurrent().addWindow((Window) bean.getView());
            });
            餐别 mealType = DBC.餐别.of(e.getMealInfo().getMealTypeId() + "");
            return FoodOrderVModel.builder()
                    ._id________________(e.getId())
                    ._subjectName_______(e.getSubjectInfo().getSubjectName())
                    ._mealDate__________(DateUtils.getShortDate(e.getMealInfo().getMealDate()))
                    ._week______________(weeks[e.getMealInfo().getWeek() - 1])
                    ._createTime________(DateUtils.getLongDate(e.getCreateInfo().getCreateTime()))
                    ._foodType__________(mealType.name())
                    ._mealSet___________(e.getMealInfo().getMealName())
                    ._quanlity__________(e.getSettleInfo().getQuantity())
                    ._deliverWay________(DBC.配送方式.of(e.getSubjectInfo().getDeliveType()).name())
                    ._deliveSiteName____(e.getSubjectInfo().getDeliveSiteName())
                    ._state_____________(e.getLastState().getLastState())
                    ._createNickName____(e.getCreateInfo().getCreateUserName())
                    ._createWay_________(e.getCreateInfo().getCreateWay())
                    ._handleBtn_________(viewBtn)
                    ._build_();
        })
                .collect(Collectors.toList());
        getView().refreshData(collect);
    }

    public void printOrder() {
        WorkspaceUtils.getMainWorkspace(UI.getCurrent()).openPage(DefaultPageContext.builder()
                ._viewName__________(PrintFoodOrderView.NAME)
                ._key_______________(PrintFoodOrderView.NAME)
                ._title_____________(PrintFoodOrderView.TITLE)
                ._initParameters____(null)
                ._toReInitOnSwitch__(false)
                ._closable__________(true)
                ._build_());
    }

    @EventBusListenerMethod
    public void on(RefreshCompoundEvent event) {
        this.getView().refresh();
    }

}
