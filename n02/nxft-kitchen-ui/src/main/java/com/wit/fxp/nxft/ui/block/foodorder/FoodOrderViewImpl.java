package com.wit.fxp.nxft.ui.block.foodorder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.vaadin.spring.annotation.PrototypeScope;

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
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.common.LayoutUtils;
import com.wit.fxp.nxft.common.NxftTableUtils;
import com.wit.fxp.nxft.paging.PagingInfo;
import com.wit.fxp.nxft.ui.block.foodorder.model.FoodOrderVModel;
import com.wit.fxp.nxft.ui.components.PagingComponent;
import com.wit.fxp.vaadin.ui.WNativeSelect;
import com.wit.utils.DateUtils;

/**
 *
 * @author wck
 *
 */
@PrototypeScope
@SpringView(name = FoodOrderView.NAME)
public class FoodOrderViewImpl extends CustomComponent implements FoodOrderView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final HorizontalLayout topmainHly = new HorizontalLayout();

    private final WNativeSelect queryType = new WNativeSelect(); //查询方式
    private final DateField orderCreateBegin = new DateField();
    private final DateField orderCreateEnd = new DateField();
    private final TextField subjectName = new TextField();

    private final DateField mealTimeBegin = new DateField();
    private final DateField mealTimeEnd = new DateField();

    private final WNativeSelect orderState = new WNativeSelect();
    private final WNativeSelect subjectType = new WNativeSelect();
    private final WNativeSelect deliveSite = new WNativeSelect();

    private final Button searchBtn = new Button("查询");
    private final Button resetBtn = new Button("重置");

    private final Button printOrderBtn = new Button("打印订单");

    private final Table table = new Table();
    private final VerticalLayout tablevly = new VerticalLayout();
    private final BeanItemContainer<FoodOrderVModel> container = new BeanItemContainer<>(FoodOrderVModel.class);
    private final PagingComponent pageComponent = new PagingComponent();

    private final HorizontalLayout queryhly = new HorizontalLayout();
    private HorizontalLayout orderCreatehly;
    private HorizontalLayout mealTimehly;
    private HorizontalLayout subjectNamehly;
    private HorizontalLayout orderStatehly;
    private HorizontalLayout subjectTypehly;
    private HorizontalLayout deliveSitehly;

    @Override
    public void initView(FoodOrderPresenter presenter) {
        buildView();
        addStyle();
        bind(presenter);
        initQueryData();
    }

    private void initQueryData() {
        this.mealTimeBegin.clear();
        this.mealTimeEnd.clear();
        this.orderCreateBegin.setValue(DateUtils.getBegin(new Date()));
        this.orderCreateEnd.setValue(DateUtils.getEnd(new Date()));
        this.subjectName.clear();
    }

    @Override
    public void refreshDictData(List<IdAndName> deliveSites, List<IdAndName> subjectTypes) {
        deliveSite.addWSelectItem(null, "全部");
        deliveSites.forEach(e -> {
            deliveSite.addWSelectItem(e.getId(), e.getName());
        });
        deliveSite.bindData();
        deliveSite.select(new IdAndName(null, "全部"));
        subjectType.addWSelectItem(null, "全部");
        subjectTypes.forEach(e -> {
            subjectType.addWSelectItem(e.getId(), e.getName());
        });
        subjectType.bindData();
        subjectType.select(new IdAndName(null, "全部"));
    }

    @Override
    public void refreshData(List<FoodOrderVModel> data) {
        Notification.show("共检索到" + data.size() + "数据");
        this.table.removeAllItems();
        this.container.removeAllItems();
        this.container.addAll(data);
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

    @Override
    public void refresh() {
        this.searchBtn.click();
    }

    private void bind(FoodOrderPresenter presenter) {
        this.printOrderBtn.addClickListener(e -> openPrintOrder(presenter));
        this.queryType.addValueChangeListener(e -> {
            IdAndName selectedWItem = this.queryType.getSelectedWItem();
            if (selectedWItem == null) {
                return;
            }
            if ("1".equals(selectedWItem.getId())) {
                queryhly.removeAllComponents();
                queryhly.addComponents(orderCreatehly, deliveSitehly, orderStatehly);
            }
            else if ("2".equals(selectedWItem.getId())) {
                queryhly.removeAllComponents();
                queryhly.addComponents(mealTimehly, deliveSitehly, subjectTypehly, orderStatehly);
            }
            else {
                queryhly.removeAllComponents();
                queryhly.addComponents(subjectNamehly, mealTimehly, orderStatehly);
            }
        });

        this.queryType.addWSelectItem("1", "下单日期");
        this.queryType.addWSelectItem("2", "就餐日期");
        this.queryType.addWSelectItem("3", "客户姓名");
        this.queryType.bindData();
        this.queryType.select(new IdAndName("1", "下单日期"));

        this.pageComponent.addHandleListener(new PagingComponent.PageHandleListener() {

            @Override
            public void handleEvent(PagingInfo pageInfo) {
                IdAndName selectedWItem = queryType.getSelectedWItem();
                if ("1".equals(selectedWItem.getId())) {
                    presenter.refreshData(orderCreateBegin.getValue(), orderCreateEnd.getValue(), null, null, null,
                            orderState.getSelectedWItem().getId(), deliveSite.getSelectedWItem().getId(), null, pageInfo);
                }
                else if ("2".equals(selectedWItem.getId())) {
                    presenter.refreshData(null, null, mealTimeBegin.getValue(), mealTimeEnd.getValue(), null,
                            orderState.getSelectedWItem().getId(), deliveSite.getSelectedWItem().getId(), subjectType.getSelectedWItem().getId(), pageInfo);
                }
                else {
                    presenter.refreshData(null, null, mealTimeBegin.getValue(), mealTimeEnd.getValue(),
                            subjectName.getValue(), orderState.getSelectedWItem().getId(), null, null, pageInfo);
                }
            }
        });

        resetBtn.addClickListener(e -> {
            initQueryData();
            this.searchBtn.click();
        });

        String[] state = {"全部", "已派单", "已接单 ", "已配送", "已发放 ", "已取消"};
        for (String s : state) {
            if ("全部".equals(s)) {
                orderState.addWSelectItem(null, s);
            }
            else {
                orderState.addWSelectItem(s, s);
            }
        }
        orderState.bindData();
        orderState.select(new IdAndName(null, "全部"));
    }

    private void openPrintOrder(FoodOrderPresenter presenter) {
        presenter.printOrder();
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
        this.mainvly.addStyleName("foodorderview");

        orderCreateBegin.setDateFormat("yyyy年MM月dd日");
        orderCreateEnd.setDateFormat("yyyy年MM月dd日");
        mealTimeBegin.setDateFormat("yyyy年MM月dd日");
        mealTimeEnd.setDateFormat("yyyy年MM月dd日");

        this.topmainHly.addStyleName("tophly");

        this.queryType .addStyleName("queryType ");
        this.subjectName .addStyleName("subjectName ");
        this.searchBtn.addStyleName("searchBtn");
        this.resetBtn.addStyleName("resetBtn");

        this.printOrderBtn.addStyleName("printOrderBtn");

        this.table.addStyleName("table");
        this.queryhly.addStyleName("queryhly");
        this.orderCreatehly.addStyleName("orderCreatehly");
        this.mealTimehly.addStyleName("mealTimehly");
        this.subjectNamehly.addStyleName("subjectNamehly");
        this.queryType.setImmediate(true);
        this.queryType.select(new IdAndName("1", "下单时间"));

        this.queryType.setNullSelectionAllowed(false);
        this.orderState.setNullSelectionAllowed(false);
        this.deliveSite.setNullSelectionAllowed(false);
        this.subjectType.setNullSelectionAllowed(false);
    }

    private void buildView() {
        this.setCompositionRoot(mainvly);
        createTable(table, container);

        orderCreatehly = LayoutUtils.getHorLayout("下单日期：", "", orderCreateBegin, "", orderCreateEnd, "", null, "至");
        mealTimehly = LayoutUtils.getHorLayout("就餐日期：", "", mealTimeBegin, "", mealTimeEnd, "", null, "至");
        subjectNamehly = LayoutUtils.getHorLayout("客户姓名：", "", subjectName, null);
        orderStatehly = LayoutUtils.getHorLayout("状态：", "", orderState, null);
        deliveSitehly = LayoutUtils.getHorLayout("助餐点：", "", deliveSite, null);
        subjectTypehly = LayoutUtils.getHorLayout("对象类型：", "", subjectType, null);
        topmainHly.addComponent(LayoutUtils.getHorLayout("查询方式：", "", queryType, null));
        topmainHly.addComponent(queryhly);
        topmainHly.addComponent(LayoutUtils.getHorLayout(null, "", searchBtn, null));
        topmainHly.addComponent(LayoutUtils.getHorLayout(null, "", resetBtn, null));
        tablevly.addComponent(table);
        tablevly.setComponentAlignment(table, Alignment.MIDDLE_CENTER);

        this.pageComponent.postInit(tablevly, this.searchBtn, 20);
        mainvly.addComponents(topmainHly, pageComponent);

    }

    private void createTable(Table table, BeanItemContainer<FoodOrderVModel> container) {
        NxftTableUtils.getInstance()
                .addPropertyArray("subjectName", 2f, "客户")
                .addPropertyArray("mealDate", 2.5f, "就餐日期")
                .addPropertyArray("week", 1.5f, "星期")
                .addPropertyArray("foodType", 1.2f, "餐别")
                .addPropertyArray("mealSet", 5f, "套餐")
                .addPropertyArray("quanlity", 1.2f, "份数")
                .addPropertyArray("deliveSiteName", 3f, "助餐点")
                .addPropertyArray("createTime", 3f, "下单时间")
                .addPropertyArray("createWay", 2f, "点餐方式")
                .addPropertyArray("state", 1.5f, "状态")
                .addPropertyArray("handleBtn", 2f, "操作")
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
