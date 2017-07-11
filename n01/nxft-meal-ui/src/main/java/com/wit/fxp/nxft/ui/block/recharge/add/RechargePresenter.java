package com.wit.fxp.nxft.ui.block.recharge.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.wit.fxp.nxft.app.SubjecctApp;
import com.wit.fxp.nxft.app.model.SubjectMoneyData;
import com.wit.fxp.nxft.ui.block.recharge.MyWindow;
import com.wit.fxp.nxft.ui.block.recharge.event.RefreshEvent;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;

@PrototypeScope
@VaadinPresenter(viewName = RechargeView.NAME)
public class RechargePresenter extends AbstractPresenter<RechargeView> {

    @Autowired private SubjecctApp app;
    @Autowired private UserSession userSession;
    private String subjectId;
    private String userName;

    @Autowired
    public RechargePresenter(EventBus.UIEventBus eventBus, RechargeView view) {
        super(eventBus, view);
    }

    public void postInit(String subjectId) {
        getView().initView(this);
        this.subjectId = subjectId;
        show();
    }

    public void show() {
        SubjectMoneyData data = app.findSubjectMoney(subjectId);
        this.userName = data.getName();
        getView().refreshView(AddMoneyData.builder()
                ._name______(data.getName())
                ._gender____(data.getGender())
                ._phone_____(data.getPhone())
                ._yue_______(data.getYue())
                ._build_());
    }

    public void add(Double money) {
        MyWindow window = new MyWindow("充值确认");
        window.setWidth("260px");
        window.setHeight("127px");
        UI.getCurrent().addWindow(window);
        VerticalLayout form = new VerticalLayout();
        Label name = new Label(userName);
        Label c1 = new Label("确定对客户");
        Label c2 = new Label("充值");
        Label c3 = new Label("元？");
        Label canch = new Label(money.toString());

        name.setStyleName("namestyless");
        canch.setStyleName("namestyless");
        HorizontalLayout info = new HorizontalLayout();
        info.addComponents(c1, name, c2, canch, c3);
        info.setStyleName("infostyless");
        HorizontalLayout btnhly = new HorizontalLayout();
        btnhly.setStyleName("btnstyless");
        Button wconfirmBtn = new Button("确认充值");
        Button wcancelBtn = new Button("取消");
        btnhly.addComponents(wconfirmBtn, wcancelBtn);
        form.addComponents(info, btnhly);
        form.setWidth("100%");
        wconfirmBtn.addStyleName("btn2");
        wcancelBtn.addStyleName("btn1");
        window.getMainContentLayout().addComponent(form);
        wconfirmBtn.addClickListener(e -> {
            app.recharge(userSession.getInvoker(), subjectId, money, userSession.getApplicationId());
            Notification.show("充值成功！");
            getEventBus().publish(this, new RefreshEvent());
            window.close();
        });
        wcancelBtn.addClickListener(e -> {
            window.close();
        });
    }

}
