package com.wit.fxp.nxft.ui.block.compoundfood;

import java.io.Serializable;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wit.fxp.nxft.common.LayoutUtils;

/**
 * 查看配餐
 * @author wck
 *
 */
@PrototypeScope
@SpringView(name = ViewCompountFoodView.NAME)
public class ViewCompountFoodViewImpl extends Window implements ViewCompountFoodView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();
    private final HorizontalLayout titlehly = new HorizontalLayout();
    private final Label title = new Label("查看配餐");

    private final VerticalLayout middlevly = new VerticalLayout();
    private final Label orderNo = new Label("");
    private final Label orderTime = new Label("");
    private final Label foodType = new Label("");
    private final Label mealSet = new Label("");
    private final Label subjectName = new Label("");
    private final Label subjectNum = new Label("");
    private final Label foodClass = new Label(""); //菜系
    private final Label pungent = new Label(""); //辣
    private final Label deliverWay = new Label(""); //配送方式
    private final Label contactPhone = new Label(""); //联系电话
    private final Label address = new Label("");
    private final Button closeBtn = new Button("关闭");
    private final VerticalLayout leftvly = new VerticalLayout();
    private final VerticalLayout rightvly = new VerticalLayout();
    private final HorizontalLayout contenthly = new HorizontalLayout();

    @Override
    public void initView(ViewCompountFoodPresenter presenter) {
        buildView();
        addStyle();
        bind(presenter);
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

    private void bind(ViewCompountFoodPresenter presenter) {
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
        this.orderNo.addStyleName("orderNo");
        this.orderTime.addStyleName("orderTime");
        this.foodType.addStyleName("foodType");
        this.mealSet.addStyleName("mealSet");
        this.subjectName.addStyleName("subjectName");
        this.subjectNum.addStyleName("subjectNum");
        this.foodClass.addStyleName("foodClass");
        this.pungent.addStyleName("pungent");
        this.deliverWay.addStyleName("deliverWay");
        this.contactPhone.addStyleName("contactPhone");
        this.address.addStyleName("address");
        this.closeBtn.addStyleName("closeBtn");
        this.leftvly.addStyleName("leftvly");
        this.rightvly.addStyleName("rightvly");
        this.contenthly.addStyleName("contenthly");

    }

    private void buildView() {
        this.setContent(mainvly);

        mainvly.addComponent(titlehly);
        mainvly.addComponent(middlevly);
        mainvly.addComponent(closeBtn);
        mainvly.setComponentAlignment(closeBtn, Alignment.MIDDLE_CENTER);

        middlevly.addComponent(contenthly);
        middlevly.addComponent(LayoutUtils.getHorLayout("地址：", "100px", address, ""));

        titlehly.addComponent(title);
        contenthly.addComponents(this.leftvly, this.rightvly);

        this.leftvly.addComponents(LayoutUtils.getHorLayout("订单编号：", "100px", orderNo, ""));
        this.leftvly.addComponents(LayoutUtils.getHorLayout("餐别：", "100px", foodType, ""));
        this.leftvly.addComponents(LayoutUtils.getHorLayout("数量：", "100px", subjectNum, ""));
        this.leftvly.addComponents(LayoutUtils.getHorLayout("辣：", "100px", pungent, ""));
        this.leftvly.addComponents(LayoutUtils.getHorLayout("配送方式：", "100px", deliverWay, ""));

        this.rightvly.addComponents(LayoutUtils.getHorLayout("时间：", "100px", orderTime, ""));
        this.rightvly.addComponents(LayoutUtils.getHorLayout("套餐：", "100px", mealSet, ""));
        this.rightvly.addComponents(LayoutUtils.getHorLayout("姓名：", "100px", subjectName, ""));
        this.rightvly.addComponents(LayoutUtils.getHorLayout("菜系：", "100px", foodClass, ""));
        this.rightvly.addComponents(LayoutUtils.getHorLayout("联系电话：", "100px", contactPhone, ""));
    }

}
