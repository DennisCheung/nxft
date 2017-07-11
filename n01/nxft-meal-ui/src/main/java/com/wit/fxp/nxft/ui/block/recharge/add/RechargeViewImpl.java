package com.wit.fxp.nxft.ui.block.recharge.add;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wit.fxp.nxft.ui.components.IntegerField;
import com.wit.fxp.nxft.utils.StringUtils;
import com.wit.fxp.vaadin.ui.HorLabelAndLabel;

@PrototypeScope
@SpringView(name = RechargeView.NAME)
public class RechargeViewImpl extends Window implements RechargeView, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final Label title = new Label("充值");

    private final HorizontalLayout hor1 = new HorizontalLayout();
    private final HorizontalLayout hor2 = new HorizontalLayout();
    private final HorLabelAndLabel name = new HorLabelAndLabel("姓名", null);
    private final HorLabelAndLabel gender = new HorLabelAndLabel("性别", null);
    private final HorLabelAndLabel phone = new HorLabelAndLabel("电话", null);
    private final HorLabelAndLabel yue = new HorLabelAndLabel("余额", null);

    private final HorizontalLayout hor4 = new HorizontalLayout();
    private final Label lb = new Label("充值金额：");
    private final IntegerField ife = new IntegerField();
    private final Label lb1 = new Label("元");

    private final HorizontalLayout hor3 = new HorizontalLayout();
    private final Button btn1 = new Button("取消");
    private final Button btn = new Button("充值");

    @Autowired
    @Qualifier("validator")
    private javax.validation.Validator javaxValidator;

    @Override
    public void initView(RechargePresenter presenter) {
        center();
        this.setResizable(false);
        this.setSizeUndefined();
        this.setModal(true);
        this.setContent(mainvly);
        buildView();
        bind(presenter);

    }

    public void buildView() {
        addStyle();
        this.setContent(mainvly);
        mainvly.addComponents(title, hor1, hor2, hor4, hor3);
        hor4.addComponents(lb, ife, lb1);
        hor1.addComponents(name, gender);
        hor2.addComponents(phone, yue);
        hor3.addComponents(btn1, btn);
    }

    public void addStyle() {
        this.mainvly.addStyleName("RechargeViewImpl");

        this.mainvly.setWidth("100%");
        this.title.addStyleName("title");
        this.hor1.addStyleName("hor1");
        this.hor2.addStyleName("hor2");
        this.name.addStyleName("name");
        this.gender.addStyleName("gender");
        this.phone.addStyleName("phone");
        this.yue.addStyleName("yue");
        this.hor4.addStyleName("hor4");
        this.lb.addStyleName("lb");
        this.ife.addStyleName("ife");
        this.lb1.addStyleName("lb1");

        this.hor3.addStyleName("hor3");

        this.btn1.addStyleName("btn");
        this.btn.addStyleName("btn1");

    }

    public void bind(RechargePresenter presenter) {
        btn1.addClickListener(e -> this.close());
        btn.addClickListener(e -> {
            if (StringUtils.isEmpty(ife.getValue())) {
                Notification.show("请填写充值金额！");
                return;
            }
            if (Double.parseDouble(ife.getValue()) < 10) {
                Notification.show("十元起冲！");
                return;
            }

            if (Double.parseDouble(ife.getValue()) > 500) {
                Notification.show("最高充值500！");
                return;
            }
            presenter.add(Double.parseDouble(ife.getValue()));
            this.close();
        });
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void refreshView(AddMoneyData data) {
        name.getLbright().setValue(data.getName());
        gender.getLbright().setValue(data.getGender());
        phone.getLbright().setValue(data.getPhone());
        yue.getLbright().setValue(data.getYue() + "元");
    }

}
