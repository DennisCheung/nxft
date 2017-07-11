package com.wit.fxp.nxft.ui.block.compoundfood;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.common.NxftConfirmWindow;
import com.wit.fxp.nxft.compound.NxftCompoundApp;
import com.wit.fxp.nxft.compound.model.DeliveNoteModel;
import com.wit.fxp.nxft.compound.model.HandCreatCompoundCommand;
import com.wit.fxp.nxft.compound.model.MealTypeModel;
import com.wit.fxp.nxft.env.Nxft02Properties;
import com.wit.fxp.nxft.paging.PagingInfo;
import com.wit.fxp.nxft.ui.block.compoundfood.model.CompountFoodVModel;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;
import com.wit.fxp.ui.workspace.AbstractPagePresenter;
import com.wit.utils.DateUtils;

@PrototypeScope
@VaadinPresenter(viewName = CompoundFoodView.NAME)
public class CompoundFoodPresenter extends AbstractPagePresenter<CompoundFoodView> {

    private final NxftCompoundApp nxftCompoundApp;
    private final UserSession userSession;

    @Autowired
    private Nxft02Properties nxft02Properties;

    @Autowired
    public CompoundFoodPresenter(EventBus.UIEventBus eventBus, CompoundFoodView view, ApplicationContext applicationContext,
            NxftCompoundApp nxftCompoundApp, UserSession userSession) {
        super(eventBus, view);
        this.nxftCompoundApp = nxftCompoundApp;
        this.userSession = userSession;
    }

    @Override
    public void initPage(Object parameters) {
        getView().initView(this);
        List<MealTypeModel> mealTypeList = this.nxftCompoundApp.findMealTypeList();
        getView().initData(mealTypeList);
        this.getView().refresh();
    }

    public void refreshMealScheData(PagingInfo pageInfo, Date value, String stateId, String mealTypeId) {
        List<DeliveNoteModel> deliveNote = this.nxftCompoundApp.findDeliveNote(this.userSession.getTeamId(), pageInfo, value, stateId, mealTypeId);
        List<CompountFoodVModel> collect = deliveNote.stream().map(e -> {
            String[] week = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
            HorizontalLayout horLayout = new HorizontalLayout();
            Button view = new Button("预览及打印");
            Button delive = new Button("配送");
            horLayout.addComponent(view);
            view.addClickListener(f -> this.printSvcnote(e.getId(), e.getDeliveInfo().getDeliveType()));
            String state = "已配送";
            if (DBC.配送订单状态.已接单.value().equals(e.getLastState().getLastState())) {
                horLayout.addComponent(delive);
                delive.addClickListener(e1 -> {
                    delive(e);
                });
                state = "未配送";
            }
            CompountFoodVModel vmodel = CompountFoodVModel.builder()
                    ._id________________(e.getId())
                    ._checkBox__________(new CheckBox())
                    ._deliveNoteNo______(e.getId())
                    ._mealTime__________(DateUtils.getShortDate(e.getDeliveInfo().getMealDate()))
                    ._week______________(week[e.getDeliveInfo().getWeek() - 1])
                    ._foodType__________(e.getDeliveInfo().getMealTypeName())
                    ._quanlity__________(e.getDeliveInfo().getQuantity())
                    ._deliverWay________(DBC.配送方式.of(e.getDeliveInfo().getDeliveType()).name())
                    ._deliveSiteName____(e.getDeliveInfo().getDeliveSiteName())
                    ._state_____________(state)
                    ._handleLayout______(horLayout)
                    ._build_();
            return vmodel;
        })
                .collect(Collectors.toList());
        getView().refreshData(collect);
    }

    private void delive(DeliveNoteModel e) {
        NxftConfirmWindow cw = new NxftConfirmWindow();
        Button.ClickListener clickListener = new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(ClickEvent event) {
                nxftCompoundApp.confirmDelive(userSession.getInvoker(), e.getId());
                getView().refresh();
            }
        };
        cw.initView("配送确认", "确认配送订单号" + e.getId(), "取消", "确认配送成功", clickListener);
        UI.getCurrent().addWindow(cw);
    }

    public void batchDelive(List<String> list) {
        String collect = list.stream().collect(Collectors.joining("，"));
        NxftConfirmWindow cw = new NxftConfirmWindow();
        Button.ClickListener clickListener = new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(ClickEvent event) {
                nxftCompoundApp.confirmDelive(userSession.getInvoker(), list);
                getView().refresh();
            }
        };
        cw.initView("配送确认", "确认配送订单号" + collect, "取消", "确认配送成功", clickListener);
        UI.getCurrent().addWindow(cw);
    }

    /**
     * 配送单打印服务
     */
    public void printSvcnote(String deliveNoteId, String deliveType) {
        Window window = new Window("打印预览");
        window.setModal(true);
        window.center();
        window.setResizable(false);
        window.setWidth("820px");
        window.setHeight("620px");
        UI.getCurrent().addWindow(window);
        BrowserFrame printView = new BrowserFrame();
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(printView);
        printView.setSizeFull();
        layout.setSizeFull();
        window.setContent(layout);
        String url = this.nxft02Properties.getRootUrl() + getUrl(deliveNoteId, deliveType);
        printView.setSource(new com.vaadin.server.ExternalResource(url));
    }

    private String getUrl(String deliveNoteId, String deliveType) {
        if (DBC.配送方式.到户.value().equals(deliveType)) {
            return String.format("%sNxftCompoundHome.rptdesign&__format=pdf&deliveNoteId=%s",
                    this.nxft02Properties.getNxftUrl(),
                    deliveNoteId);
        }
        return String.format("%sNxftCompoundSite.rptdesign&__format=pdf&deliveNoteId=%s",
                this.nxft02Properties.getNxftUrl(),
                deliveNoteId);
    }

    public List<MealTypeModel> findMealTypeList() {
        return this.nxftCompoundApp.findMealTypeList();
    }

    public void handCreate(Date mealDateValue, String mealTypeId) {
        HandCreatCompoundCommand command = HandCreatCompoundCommand.builder()
                ._mealDate______(mealDateValue)
                ._mealTypeId____(mealTypeId)
                ._build_();
        this.nxftCompoundApp.handCompoundCreate(this.userSession.getInvoker(), command);
        getView().refresh();
    }

}
