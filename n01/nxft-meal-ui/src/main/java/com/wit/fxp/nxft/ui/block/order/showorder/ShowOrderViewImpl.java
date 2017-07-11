package com.wit.fxp.nxft.ui.block.order.showorder;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wit.fxp.nxft.app.common.model.OrderModel;
import com.wit.fxp.vaadin.ui.HorLabelAndLabel;

@PrototypeScope
@SpringView(name = ShowOrderView.NAME)
public class ShowOrderViewImpl extends Window implements ShowOrderView, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final Label title = new Label("查看");

    private final HorizontalLayout hor1 = new HorizontalLayout();
    private final HorLabelAndLabel orderno = new HorLabelAndLabel("订单编号", null);
    private final HorLabelAndLabel name = new HorLabelAndLabel("姓名", null);

    private final HorizontalLayout hor2 = new HorizontalLayout();
    private final HorLabelAndLabel phone = new HorLabelAndLabel("联系电话", null);
    private final HorLabelAndLabel time = new HorLabelAndLabel("就餐日期", null);

    private final HorizontalLayout hor3 = new HorizontalLayout();
    private final HorLabelAndLabel week = new HorLabelAndLabel("星期", null);
    private final HorLabelAndLabel cb = new HorLabelAndLabel("餐别", null);

    private final HorizontalLayout hor4 = new HorizontalLayout();
    private final HorLabelAndLabel tc = new HorLabelAndLabel("套餐", null);
    private final HorLabelAndLabel num = new HorLabelAndLabel("数量", null);

    private final HorizontalLayout hor4a = new HorizontalLayout();
    private final HorLabelAndLabel tca = new HorLabelAndLabel("单价", null);
    private final HorLabelAndLabel numa = new HorLabelAndLabel("点餐方式", null);

    private final HorizontalLayout hor44 = new HorizontalLayout();
    private final HorLabelAndLabel xiadan = new HorLabelAndLabel("下单日期", null);
    private final HorLabelAndLabel handu = new HorLabelAndLabel("操作人", null);

    private final HorizontalLayout hor5 = new HorizontalLayout();
    private final HorLabelAndLabel state = new HorLabelAndLabel("状态", null);
    private final HorLabelAndLabel stype = new HorLabelAndLabel("配送方式", null);

    private final HorizontalLayout hor6 = new HorizontalLayout();
    private final HorLabelAndLabel address = new HorLabelAndLabel("地址", null);

    private final HorizontalLayout hor7 = new HorizontalLayout();
    private final HorLabelAndLabel desc = new HorLabelAndLabel("备注", null);
    private final Button btn = new Button("关闭");

    @Autowired
    @Qualifier("validator")
    private javax.validation.Validator javaxValidator;

    @Override
    public void initView(ShowOrderPresenter presenter) {
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
        mainvly.addComponents(title, hor1, hor2, hor3, hor4, hor4a, hor44, hor5, hor6, hor7, btn);
        hor1.addComponents(orderno, name);
        hor2.addComponents(phone, time);
        hor3.addComponents(week, cb);
        hor4.addComponents(tc, num);
        hor4a.addComponents(tca, numa);
        hor44.addComponents(xiadan, handu);
        hor5.addComponents(state, stype);
        hor6.addComponent(address);
        hor7.addComponent(desc);
    }

    public void addStyle() {
        this.mainvly.setWidth("100%");
        this.mainvly.addStyleName("ShowOrderViewImpl");

        this.title.addStyleName("title");

        this.hor1.addStyleName("hor1");
        this.orderno.addStyleName("orderno");
        this.name.addStyleName("name");

        this.hor2.addStyleName("hor2");
        this.phone.addStyleName("phone");
        this.time.addStyleName("time");

        this.hor3.addStyleName("hor3");
        this.week.addStyleName("week");
        this.cb.addStyleName("cb");

        this.hor4.addStyleName("hor4");
        this.tc.addStyleName("tc");
        this.num.addStyleName("num");

        this.hor4a.addStyleName("hor4");
        this.tca.addStyleName("tc");
        this.numa.addStyleName("num");

        this.hor44.addStyleName("hor44");
        this.xiadan.addStyleName("xiadan");
        this.handu.addStyleName("handu");

        this.hor5.addStyleName("hor5");
        this.state.addStyleName("state");
        this.stype.addStyleName("stype");

        this.hor6.addStyleName("hor6");
        this.address.addStyleName("address");

        this.hor7.addStyleName("hor7");
        this.desc.addStyleName("desc");
        this.btn.addStyleName("btn");

    }

    public void bind(ShowOrderPresenter presenter) {
        btn.addClickListener(e -> this.close());
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void refreshValue(OrderModel model) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        orderno.getLbright().setValue(model.getId());
        name.getLbright().setValue(model.getSubjectInfo().getSubjectName());
        phone.getLbright().setValue(model.getSubjectInfo().getContactPhone());
        time.getLbright().setValue(df.format(model.getMealInfo().getMealDate()));
        week.getLbright().setValue("星期" + model.getMealInfo().getWeek());
        cb.getLbright().setValue(model.getMealInfo().getMealTypeName());
        tc.getLbright().setValue(model.getMealInfo().getMealName());
        tca.getLbright().setValue(model.getMealInfo().getMealPrice() + "元");
        num.getLbright().setValue(model.getSettleInfo().getQuantity() + "份");
        numa.getLbright().setValue(model.getCreateInfo().getCreateWay());
        state.getLbright().setValue(model.getLastState().getLastState());
        xiadan.getLbright().setValue(sdf.format(model.getCreateInfo().getCreateTime()));
        handu.getLbright().setValue(model.getCreateInfo().getCreateUserName());
        stype.getLbright().setValue(model.getSubjectInfo().getDeliveType().equals("SITE") ? "助餐点" : "到户上门");
        String addresss = model.getSubjectInfo().getAddress() == null ? "" : model.getSubjectInfo().getAddress();
        String addressss = (model.getSubjectInfo().getRegionName() + addresss).trim();
        address.getLbright().setValue(model.getSubjectInfo().getDeliveType().equals("SITE") ? model.getSubjectInfo().getDeliveSiteName()
                : addressss);
        desc.getLbright().setValue(model.getSubjectInfo().getSubjectDesc());
    }

}
