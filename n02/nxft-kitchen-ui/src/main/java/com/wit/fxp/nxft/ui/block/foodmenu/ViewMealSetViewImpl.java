package com.wit.fxp.nxft.ui.block.foodmenu;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.stream.Collectors;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wit.fxp.nxft.common.LayoutUtils;
import com.wit.fxp.nxft.menu.model.MealSetModel;
import com.wit.fxp.vaadin.server.data.fieldgroup.FxpBeanFieldGroup;

/**
 * @author wck
 *
 */
@PrototypeScope
@SpringView(name = ViewMealSetView.NAME)
public class ViewMealSetViewImpl extends Window implements ViewMealSetView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final HorizontalLayout titlehly = new HorizontalLayout();
    private final Label title = new Label("查看套餐");

    private final VerticalLayout formvly = new VerticalLayout();
    private final TextField mealSetNo = new TextField();
    private final TextField mealSetName = new TextField();
    private final TextField mealSetContent = new TextField();
    private final TextField price = new TextField();
    private final TextField pungent = new TextField();
    private final TextField mealSetDesc = new TextField();
    private final TextArea mealDisease = new TextArea();

    private final Button closeBtn = new Button("关闭");
    private final HorizontalLayout btnhly = new HorizontalLayout();

    @Autowired
    @Qualifier("validator")
    private Validator javaxValidator;

    @Override
    public void initView(ViewMealSetPresenter presenter) {
        buildView();
        addStyle();
        bind(presenter);
    }

    @Override
    public void refreshData(MealSetModel mealSet) {
        FxpBeanFieldGroup<MealSetModel> group = new FxpBeanFieldGroup<>(javaxValidator, MealSetModel.class);
        group.setItemDataSource(mealSet);
        group.bind(mealSetNo, "mealCode");
        group.bind(mealSetName, "mealName");
        group.bind(mealSetContent, "mealContent");
//        group.bind(price, "mealPrice");
        group.bind(mealSetDesc, "mealDesc");
        DecimalFormat df = new DecimalFormat("########0.00");
        price.setValue(df.format(mealSet.getMealPrice()));
        pungent.setValue(mealSet.getPepperyLevel() != null && 1 == mealSet.getPepperyLevel() ? "有辣" : "无辣");
        String collect = mealSet.getMealDiseaseSet().stream().map(e -> e.getDiseaseName()).collect(Collectors.joining("、"));
        mealDisease.setValue(collect);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    private void bind(ViewMealSetPresenter presenter) {
        this.closeBtn.addClickListener(e -> {
            this.close();
        });
        Iterator<Component> coms = formvly.iterator();
        while (coms.hasNext()) {
            Component next = coms.next();
            next.setEnabled(false);
        }
    }

    private void addStyle() {
        Page page = Page.getCurrent();
        if (page.getBrowserWindowWidth() > 1230) {
            this.mainvly.setWidth(page.getBrowserWindowWidth() + "px");
        }
        else {
            this.mainvly.setWidth("1366px");
        }
        page.addBrowserWindowResizeListener(e -> {
            if (page.getBrowserWindowWidth() > 1230) {
                this.mainvly.setWidth(page.getBrowserWindowWidth() + "px");
            }
        });
        this.mainvly.addStyleName("ViewMealSetView");
        this.mainvly.setWidth("100%");
        this.center();
        this.titlehly.setWidth("100%");
        this.setWidth("550px");
        this.setHeightUndefined();
        this.setResizable(false);
        this.setClosable(false);

        this.titlehly.addStyleName("titlehly");
        this.title.addStyleName("title");

        this.formvly.addStyleName("formvly");
        this.mealSetNo.addStyleName("mealSetNo");
        this.mealSetName.addStyleName("mealSetName");
        this.mealSetContent.addStyleName("mealSetContent");
        this.price.addStyleName("price");
        this.pungent.addStyleName("pungent");
        this.mealSetDesc.addStyleName("mealSetDesc");
//        this.mealDisease.addStyleName("mealSetDesc");

        this.closeBtn.addStyleName("closeBtn");
        this.btnhly.addStyleName("btnhly");

        mealDisease.setRows(4);
    }

    private void buildView() {
        this.setContent(mainvly);

        mainvly.addComponents(titlehly, formvly, btnhly);
        btnhly.addComponents(closeBtn);

        titlehly.addComponent(title);

        formvly.addComponent(LayoutUtils.getHorLayout("套餐编号：", "100px", mealSetNo, ""));
        formvly.addComponent(LayoutUtils.getHorLayout("套餐名称：", "100px", mealSetName, ""));
        formvly.addComponent(LayoutUtils.getHorLayout("套餐内容：", "100px", mealSetContent, ""));
        formvly.addComponent(LayoutUtils.getHorLayout("单价：", "100px", price, "", "元"));
        formvly.addComponent(LayoutUtils.getHorLayout("辣：", "100px", pungent, ""));
        formvly.addComponent(LayoutUtils.getHorLayout("备注：", "100px", mealSetDesc, ""));
        formvly.addComponent(LayoutUtils.getHorLayout("禁忌疾病：", "100px", mealDisease, ""));

    }

}
