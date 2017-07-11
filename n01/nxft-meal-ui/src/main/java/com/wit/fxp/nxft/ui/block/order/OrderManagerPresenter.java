package com.wit.fxp.nxft.ui.block.order;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collectors;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.app.AddOrderApp;
import com.wit.fxp.nxft.app.OrderApp;
import com.wit.fxp.nxft.app.SubjecctApp;
import com.wit.fxp.nxft.app.common.model.OrderModel;
import com.wit.fxp.nxft.app.selectdata.OrderSelectInfo;
import com.wit.fxp.nxft.ui.block.order.showorder.ShowOrderPresenter;
import com.wit.fxp.nxft.ui.block.recharge.MyWindow;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;
import com.wit.fxp.ui.workspace.AbstractPagePresenter;

@PrototypeScope
@VaadinPresenter(viewName = OrderManagerView.NAME)
public class OrderManagerPresenter extends AbstractPagePresenter<OrderManagerView> {

    @Autowired private UserSession userSession;
    @Autowired private OrderApp app;
    @Autowired private AddOrderApp orderApp;
    @Autowired private ApplicationContext ac;
    @Autowired private SubjecctApp subjectApp;

    @Autowired
    public OrderManagerPresenter(EventBus.UIEventBus eventBus, OrderManagerView view) {
        super(eventBus, view);
    }

    @Override
    public void initPage(Object parameters) {
        getView().initView(this);
        refreshAll();
        refreshSelectInfo();
    }

    private void refreshSelectInfo() {
        List<IdAndName> subjectTypes = subjectApp.findSubjectTypes();
        List<IdAndName> sites = subjectApp.findTeams(userSession.getCircleId());
        List<IdAndName> states = Arrays.asList(new IdAndName("已派单", "已派单"), new IdAndName("已接单", "已接单"), new IdAndName("已配送", "已配送"),
                new IdAndName("已发放", "已发放"), new IdAndName("已取消", "已取消"));
        getView().refreshSelectInfo(sites, subjectTypes, states);
    }

    public void refreshAll() {
        getView().refreshData(toViewModels(app.findOrders(userSession.getInvoker(), null, 0)));

        int rowCount = app.fintOrderRowCount(userSession.getInvoker(), null);
        int pageNum = (rowCount - 1) / 8 + 1;
        getView().refreshPageInfo(String.valueOf(pageNum), rowCount);
    }

    public int getPageTotalNum(OrderSelectInfo info) {
        int rowCount = app.fintOrderRowCount(userSession.getInvoker(), info);
        return (rowCount - 1) / 8 + 1;
    }

    public void subjectQuery(OrderSelectInfo info, int pageNum) {
        List<OrderModel> models = app.findOrders(userSession.getInvoker(), info, pageNum);
        getView().refreshData(toViewModels(models));

        int rowCount = app.fintOrderRowCount(userSession.getInvoker(), info);
        int pageSize = (rowCount - 1) / 8 + 1;
        getView().refreshPageInfo(String.valueOf(pageSize), rowCount);
    }

    public List<OrderViewModel> toViewModels(List<OrderModel> models) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        return models.stream()
                .map(e -> {
                    HorizontalLayout hor = new HorizontalLayout();
                    Button btn2 = new Button("查看");
                    btn2.setStyleName(ValoTheme.BUTTON_LINK);
                    hor.addComponents(btn2);
                    btn2.addClickListener(f -> openShow(e.getId()));

                    if (e.getLastState().getLastState().equals(DBC.助餐订单状态.已派单.getValue())) {
                        Button btn1 = new Button("撤单");
                        btn1.setStyleName(ValoTheme.BUTTON_LINK);
                        hor.addComponent(btn1);
                        String userName = e.getSubjectInfo().getSubjectName();
                        String weekName = getWeek(e.getMealInfo().getWeek());
                        String createTime = sdf1.format(e.getMealInfo().getMealDate());
                        String mealName = e.getMealInfo().getMealTypeName() + " " + e.getMealInfo().getMealName();
                        btn1.addClickListener(ff -> cancelOrder(e.getId(), userName, weekName, createTime, mealName));
                    }

                    OrderViewModel model = OrderViewModel.builder()
                            ._orderId___(e.getId())
                            ._name______(e.getSubjectInfo().getSubjectName())
                            ._phone_____(e.getSubjectInfo().getContactPhone())
                            ._eatTime___(sdf1.format(e.getMealInfo().getMealDate()))
                            ._week______("星期" + getWeek(e.getMealInfo().getWeek()))
                            ._cb________(e.getMealInfo().getMealTypeName())
                            ._tc________(new Label(e.getMealInfo().getMealName()))
                            ._num_______(String.valueOf(e.getSettleInfo().getQuantity()))
                            ._createWay_(e.getCreateInfo().getCreateWay())
                            ._stype_____(e.getSubjectInfo().getDeliveType().equals("SITE") ? "助餐点" : "上门到户")
                            ._ctime_____(sdf.format(e.getCreateInfo().getCreateTime()))
                            ._state_____(e.getLastState().getLastState())
                            ._handname__(e.getLastState().getLastNickname())
                            ._hand______(hor)
                            ._build_();
                    return model;
                })
                .collect(Collectors.toList());
    }

    private void openShow(String id) {
        ShowOrderPresenter presenter = ac.getBean(ShowOrderPresenter.class);
        presenter.postInit(id);
        UI.getCurrent().addWindow((Window) presenter.getView());
    }

    private String getWeek(int index) {
        String[] week = {"错误", "一", "二", "三", "四", "五", "六", "天"};
        return week[index];
    }

    private void cancelOrder(String orderId, String userName, String weekName, String createTime, String mealName) {
        MyWindow window = new MyWindow("撤单");
        window.setWidth("550px");
        window.setHeight("127px");
        UI.getCurrent().addWindow(window);
        VerticalLayout form = new VerticalLayout();
        Label name = new Label(userName + " " + createTime);
        Label c1 = new Label("是否确定撤销“ ");
        Label c2 = new Label(" ");
        Label c3 = new Label(" ”的订单？");
        Label canch = new Label("周" + weekName + " " + mealName);

        name.setStyleName("namestyless");
        canch.setStyleName("namestyless");
        HorizontalLayout info = new HorizontalLayout();
        info.addComponents(c1, name, c2, canch, c3);
        info.setStyleName("infostyless");
        HorizontalLayout btnhly = new HorizontalLayout();
        btnhly.setStyleName("btnstyless");
        Button wconfirmBtn = new Button("确认撤单");
        Button wcancelBtn = new Button("取消");
        btnhly.addComponents(wconfirmBtn, wcancelBtn);
        form.addComponents(info, btnhly);
        form.setWidth("100%");
        wconfirmBtn.addStyleName("btn2");
        wcancelBtn.addStyleName("btn1");
        window.getMainContentLayout().addComponent(form);
        wconfirmBtn.addClickListener(e -> {
            orderApp.取消(userSession.getInvoker(), orderId);
            Notification.show("撤销成功！");
            refreshAll();
            window.close();
        });
        wcancelBtn.addClickListener(e -> {
            window.close();
        });
    }

}
