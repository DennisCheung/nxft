package com.wit.fxp.nxft.ui.block.foodorder;

import java.io.Serializable;
import java.text.DecimalFormat;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.common.LayoutUtils;
import com.wit.fxp.nxft.compound.model.NxftOrderDetailModel;
import com.wit.fxp.nxft.utils.DateUtils;

/**
 * 查看配餐
 * @author wck
 *
 */
@PrototypeScope
@SpringView(name = ViewOrderView.NAME)
public class ViewOrderViewImpl extends Window implements ViewOrderView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();
    private final HorizontalLayout titlehly = new HorizontalLayout();
    private final Label title = new Label("查看订单");

    private final VerticalLayout middlevly = new VerticalLayout();
    private final TextField orderNo = new TextField();
    private final TextField contactPhone = new TextField();
    private final TextField week = new TextField();
    private final TextField mealName = new TextField();
    private final TextField quanlity = new TextField();
    private final TextField deliveWay = new TextField();
    private final TextField orderCreateTime = new TextField();
    private final TextField createWay = new TextField();

    private final TextField subjectName = new TextField();
    private final TextField mealTime = new TextField();
    private final TextField mealType = new TextField();
    private final TextField state = new TextField();
    private final TextField orderCreateName = new TextField();
    private final TextField price = new TextField();

    private final TextField deliveSiteName = new TextField();
    private final TextField deliveAddr = new TextField();
    private final TextField scheduleDesc = new TextField();
    private final Button closeBtn = new Button("关闭");
    private final VerticalLayout leftvly = new VerticalLayout();
    private final VerticalLayout rightvly = new VerticalLayout();
    private final HorizontalLayout contenthly = new HorizontalLayout();

    @Override
    public void initView(ViewOrderPresenter presenter, NxftOrderDetailModel nxftOrder) {
        buildView();
        addStyle();
        bind(presenter);
        initData(nxftOrder);
    }

    private void initData(NxftOrderDetailModel nxftOrder) {
        String[] weeks = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        orderNo.setValue(nxftOrder.getId());
        contactPhone.setValue(nxftOrder.getSubjectInfo().getContactPhone());
        week.setValue(weeks[nxftOrder.getMealInfo().getWeek() - 1]);
        mealName.setValue(nxftOrder.getMealInfo().getMealName());
        quanlity.setValue(nxftOrder.getSettleInfo().getQuantity() + "");
        deliveWay.setValue(DBC.配送方式.of(nxftOrder.getSubjectInfo().getDeliveType()).name());
        orderCreateTime.setValue(DateUtils.getShortDate(nxftOrder.getCreateInfo().getCreateTime()));
        createWay.setValue(nxftOrder.getCreateInfo().getCreateWay());

        subjectName.setValue(nxftOrder.getSubjectInfo().getSubjectName());
        mealTime.setValue(DateUtils.getShortDate(nxftOrder.getMealInfo().getMealDate()));
        mealType.setValue(DBC.餐别.of(nxftOrder.getMealInfo().getMealTypeId()).name());
        state.setValue(nxftOrder.getLastState().getLastState());
        orderCreateName.setValue(nxftOrder.getCreateInfo().getCreateUserName());
        DecimalFormat df = new DecimalFormat("########0.00");
        price.setValue(df.format(nxftOrder.getMealInfo().getMealPrice()));

        deliveSiteName.setValue(nxftOrder.getSubjectInfo().getDeliveSiteName());
        deliveAddr.setValue(nxftOrder.getSubjectInfo().getDeliveAddr());
        scheduleDesc.setValue(nxftOrder.getMealInfo().getScheduleDesc() == null ? "" : nxftOrder.getMealInfo().getScheduleDesc());
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

    private void bind(ViewOrderPresenter presenter) {
        this.closeBtn.addClickListener(e -> {
            this.close();
        });
    }

    private void addStyle() {
        this.center();
        this.setResizable(false);
        this.setClosable(false);
        this.setWidth("600px");
        this.setHeightUndefined();
        this.mainvly.addStyleName("ViewCompountFoodView");

        this.mainvly.setWidth("100%");
        titlehly.setWidth("100%");
        middlevly.setWidth("100%");
        this.titlehly.addStyleName("titlehly");
        this.title.addStyleName("title");

        this.middlevly.addStyleName("middlevly");
        this.week.addStyleName("week");
        this.orderNo.addStyleName("orderNo");
        this.contactPhone.addStyleName("contactPhone");
        this.closeBtn.addStyleName("closeBtn");
        this.leftvly.addStyleName("leftvly");
        this.rightvly.addStyleName("rightvly");
        this.contenthly.addStyleName("contenthly");
        this.mealName.addStyleName("mealName");
        this.quanlity.addStyleName("quanlity");
        this.price.addStyleName("quanlity");
        this.deliveWay.addStyleName("deliveWay");
        this.orderCreateTime.addStyleName("orderCreateTime");
        this.createWay.addStyleName("orderCreateTime");
        this.subjectName.addStyleName("subjectName");
        this.mealTime.addStyleName("mealTime");
        this.mealType.addStyleName("mealType");
        this.state.addStyleName("state");
        this.orderCreateName.addStyleName("orderCreateName");
        this.deliveSiteName.addStyleName("deliveSiteName");
        this.deliveAddr.addStyleName("deliveSiteName");
        this.scheduleDesc.addStyleName("scheduleDesc");
    }

    private void buildView() {
        this.setContent(mainvly);

        mainvly.addComponent(titlehly);
        mainvly.addComponent(middlevly);
        mainvly.addComponent(closeBtn);
        mainvly.setComponentAlignment(closeBtn, Alignment.MIDDLE_CENTER);

        middlevly.addComponent(contenthly);
        middlevly.addComponent(LayoutUtils.getHorLayout("助餐点：", "100px", deliveSiteName, ""));
        middlevly.addComponent(LayoutUtils.getHorLayout("配送地址：", "100px", deliveAddr, ""));
        middlevly.addComponent(LayoutUtils.getHorLayout("备注：", "100px", scheduleDesc, ""));

        titlehly.addComponent(title);
        contenthly.addComponents(this.leftvly, this.rightvly);

        this.leftvly.addComponents(LayoutUtils.getHorLayout("订单编号：", "100px", orderNo, ""));
        this.leftvly.addComponents(LayoutUtils.getHorLayout("联系电话：", "100px", contactPhone, ""));
        this.leftvly.addComponents(LayoutUtils.getHorLayout("星期：", "100px", week, ""));
        this.leftvly.addComponents(LayoutUtils.getHorLayout("套餐名称：", "100px", mealName, ""));
        this.leftvly.addComponents(LayoutUtils.getHorLayout("配送方式：", "100px", deliveWay, ""));
        this.leftvly.addComponents(LayoutUtils.getHorLayout("下单日期：", "100px", orderCreateTime, ""));
        this.leftvly.addComponents(LayoutUtils.getHorLayout("点餐方式：", "100px", createWay, ""));

        this.rightvly.addComponents(LayoutUtils.getHorLayout("客户：", "100px", subjectName, ""));
        this.rightvly.addComponents(LayoutUtils.getHorLayout("就餐日期：", "100px", mealTime, ""));
        this.rightvly.addComponents(LayoutUtils.getHorLayout("餐别：", "100px", mealType, ""));
        this.rightvly.addComponents(LayoutUtils.getHorLayout("份数：", "100px", quanlity, ""));
        this.rightvly.addComponents(LayoutUtils.getHorLayout("单价：", "100px", price, ""));
        this.rightvly.addComponents(LayoutUtils.getHorLayout("状态：", "100px", state, ""));
        this.rightvly.addComponents(LayoutUtils.getHorLayout("下单人：", "100px", orderCreateName, ""));
    }

}
