package com.wit.fxp.nxft.ui.block.foodmenu;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.vaadin.spring.annotation.PrototypeScope;

import com.benewit.core.env.CurrentDate;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.wit.fxp.nxft.common.LayoutUtils;
import com.wit.fxp.nxft.common.NxftTableUtils;
import com.wit.fxp.nxft.paging.PagingInfo;
import com.wit.fxp.nxft.ui.block.foodmenu.model.MealSetVModel;
import com.wit.fxp.nxft.ui.block.foodmenu.model.MenuFoodMenuVModel;
import com.wit.fxp.nxft.ui.components.PagingComponent;

/**
 *
 * @author wck
 *
 */
@PrototypeScope
@SpringView(name = FoodMenuView.NAME)
public class FoodMenuViewImpl extends CustomComponent implements FoodMenuView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final HorizontalLayout tophly = new HorizontalLayout();
    private final VerticalLayout bottomvly = new VerticalLayout();

    private final Button mealSetBtn = new Button("套餐");
    private final Button foodMenuBtn = new Button("菜谱");

    // 套餐
    private final VerticalLayout leftvly = new VerticalLayout();
    private final HorizontalLayout topmainHly = new HorizontalLayout();

    private final Button addMealSetBtn = new Button("新增套餐");

    private final Button printOrderBtn = new Button("打印订单");

    private final Button searchBtn = new Button("查询");

    private final Table table = new Table();
    private final VerticalLayout tablevly = new VerticalLayout();
    private final BeanItemContainer<MealSetVModel> container = new BeanItemContainer<>(MealSetVModel.class);
    private final PagingComponent pageComponent = new PagingComponent();

    // 菜谱
    private final VerticalLayout rightvly = new VerticalLayout();
    private final HorizontalLayout publishTopmainHly = new HorizontalLayout();

    private final DateField menuBeginTime = new DateField(); //订单时间
    private final DateField menuEndTime = new DateField(); //订单时间
    private final Button menuSearchBtn = new Button("查询");
    private final Button menuResetBtn = new Button("重置");

    private final Button addMenuBtn = new Button("新增菜谱");

    private final Table menuTable = new Table();
    private final VerticalLayout menuTablevly = new VerticalLayout();
    private final BeanItemContainer<MenuFoodMenuVModel> menuContainer = new BeanItemContainer<>(MenuFoodMenuVModel.class);
    private final PagingComponent menuPageComponent = new PagingComponent();

    @Override
    public void initView(FoodMenuPresenter presenter) {
        buildView();
        addStyle();
        bind(presenter);
        initQueryData();
    }

    private void initQueryData() {
        Calendar calendar = new GregorianCalendar();
        CurrentDate currentDate = new CurrentDate();
        calendar.setTime(currentDate.getCurrentDate());
        calendar.add(Calendar.MONTH, -1);
        this.menuBeginTime.setValue(calendar.getTime());
        calendar.add(Calendar.MONTH, 2);
        this.menuEndTime.setValue(calendar.getTime());
    }

    @Override
    public void refreshData(List<MealSetVModel> data) {
        Notification.show("共检索到" + data.size() + "数据");
        this.table.removeAllItems();
        this.container.removeAllItems();
        this.container.addAll(data);
    }

    @Override
    public void refreshPublishData(List<MenuFoodMenuVModel> data) {
        Notification.show("共检索到" + data.size() + "数据");
        this.menuTable.removeAllItems();
        this.menuContainer.removeAllItems();
        this.menuContainer.addAll(data);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void refreshPublish() {
        this.menuSearchBtn.click();
    }

    @Override
    public void refresh() {
        this.searchBtn.click();
    }

    private void bind(FoodMenuPresenter presenter) {
        mealSetBtn.addClickListener(e -> {
            bottomvly.removeAllComponents();
            bottomvly.addComponent(leftvly);
            mealSetBtn.addStyleName("selected");
            foodMenuBtn.removeStyleName("selected");
        });
        foodMenuBtn.addClickListener(e -> {
            bottomvly.removeAllComponents();
            bottomvly.addComponent(rightvly);
            foodMenuBtn.addStyleName("selected");
            mealSetBtn.removeStyleName("selected");
        });

        addMealSetBtn.addClickListener(e -> addMealSet(presenter));
        addMenuBtn.addClickListener(e -> addFoodMenu(presenter));

        this.pageComponent.addHandleListener(new PagingComponent.PageHandleListener() {

            @Override
            public void handleEvent(PagingInfo pageInfo) {
                presenter.refreshMealSetData(pageInfo);
            }
        });

        this.menuPageComponent.addHandleListener(new PagingComponent.PageHandleListener() {

            @Override
            public void handleEvent(PagingInfo pageInfo) {
                presenter.refreshMealScheData(pageInfo, menuBeginTime.getValue(), menuEndTime.getValue());
            }
        });

        menuResetBtn.addClickListener(e -> {
            initQueryData();
            this.searchBtn.click();
        });
    }

    private void addFoodMenu(FoodMenuPresenter presenter) {
        presenter.addFoodMenu();
    }

    private void addMealSet(FoodMenuPresenter presenter) {
        presenter.addMealSet();
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
            if (page.getBrowserWindowHeight() > 580) {
                this.table.setHeight((page.getBrowserWindowHeight() - 175) + "px");
            }
        });
        this.mainvly.addStyleName("foodmenuview");

        menuBeginTime.setDateFormat("yyyy年MM月dd日");
        menuEndTime.setDateFormat("yyyy年MM月dd日");

        this.tophly.addStyleName("tophly");
        this.bottomvly.addStyleName("bottomvly");

        this.mealSetBtn.addStyleName("foodMenuBtn");
        this.foodMenuBtn.addStyleName("publishFoodMenuBtn");

        this.leftvly.addStyleName("leftvly");
        this.topmainHly.addStyleName("topmainHly");

        this.printOrderBtn.addStyleName("printOrderBtn");

        this.table.addStyleName("table");

        this.pageComponent.addStyleName("pageComponent");

        this.rightvly.addStyleName("rightvly");
        this.publishTopmainHly.addStyleName("publishTopmainHly");

        this.menuSearchBtn.addStyleName("searchBtn");
        this.menuResetBtn.addStyleName("resetBtn");

        this.menuTable.addStyleName("table");

        addMenuBtn.addStyleName("addMenuBtn");
        addMealSetBtn.addStyleName("addMealSetBtn");

        mealSetBtn.addStyleName("selected");
    }

    private void buildView() {
        this.setCompositionRoot(mainvly);
        createTable(table, container);
        createMenuTable(this.menuTable, this.menuContainer);

        topmainHly.addComponent(addMealSetBtn);
        tablevly.addComponent(table);
        tablevly.setComponentAlignment(table, Alignment.MIDDLE_CENTER);

        this.pageComponent.postInit(tablevly, searchBtn, 20);

        publishTopmainHly.addComponent(LayoutUtils.getHorLayout("时段：", "", menuBeginTime, null));
        publishTopmainHly.addComponent(LayoutUtils.getHorLayout("至", "", menuEndTime, null));
        publishTopmainHly.addComponent(LayoutUtils.getHorLayout(null, "", menuSearchBtn, null));
        publishTopmainHly.addComponent(LayoutUtils.getHorLayout(null, "", menuResetBtn, null));
        publishTopmainHly.addComponent(LayoutUtils.getHorLayout(null, "", addMenuBtn, null));
        menuTablevly.addComponent(menuTable);
        menuTablevly.setComponentAlignment(menuTable, Alignment.MIDDLE_CENTER);

        this.menuPageComponent.postInit(menuTablevly, this.menuSearchBtn, 20);

        tophly.addComponents(this.mealSetBtn, this.foodMenuBtn);

        leftvly.addComponents(topmainHly, pageComponent);
        rightvly.addComponents(publishTopmainHly, menuPageComponent);

        this.bottomvly.addComponent(leftvly);

        this.mainvly.addComponents(this.tophly, this.bottomvly);
    }

    private void createTable(Table table, BeanItemContainer<MealSetVModel> container) {
        NxftTableUtils.getInstance()
                .addPropertyArray("mealSetNo", 1.5f, "套餐编号")
                .addPropertyArray("mealSetName", 2f, "套餐名称")
                .addPropertyArray("mealSetContent", 4f, "套餐内容")
                .addPropertyArray("price", 1.5f, "单价(元)")
                .addPropertyArray("pungent", 1f, "辣")
                .addPropertyArray("createTime", 3f, "生成时间")
                .addPropertyArray("mealSetDesc", 4f, "备注")
                .addPropertyArray("handleLayout", 2.5f, "操作")
                .initTable(table, container);
        table.setSelectable(true);
        table.setImmediate(true);
        table.setSortEnabled(false);
        table.setNullSelectionAllowed(false);
        table.setWidth("96%");
        table.setHeight("450px");
        table.addStyleName("table-1");
    }

    private void createMenuTable(Table table, BeanItemContainer<MenuFoodMenuVModel> container) {
        NxftTableUtils.getInstance()
            .addPropertyArray("menuName", 1f, "菜谱名称")
            .addPropertyArray("timePeriod", 2f, "时段")
            .addPropertyArray("menuState", 2f, "状态")
            .addPropertyArray("createTime", 2f, "生成时间")
            .addPropertyArray("handleLayout", 2f, "操作")
            .initTable(table, container);
        table.setSelectable(true);
        table.setImmediate(true);
        table.setSortEnabled(false);
        table.setNullSelectionAllowed(false);
        table.setWidth("96%");
        table.setHeight("450px");
        table.addStyleName("table-1");
    }
}
