package com.wit.fxp.nxft.ui.block.foodmenu;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wit.fxp.nxft.common.NxftTableUtils;
import com.wit.fxp.nxft.menu.model.MealScheDayModel;
import com.wit.fxp.nxft.ui.block.foodmenu.model.SelectFoodMenuVModel;

/**
 * @author wck
 *
 */
@PrototypeScope
@SpringView(name = SelectFoodMenuView.NAME)
public class SelectFoodMenuViewImpl extends Window implements SelectFoodMenuView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final HorizontalLayout titlehly = new HorizontalLayout();
    private final Label title = new Label("挑选套餐");

    private final HorizontalLayout searchhly = new HorizontalLayout();
    private final TextField searchTxt = new TextField();
    private final Button searchBtn = new Button("查询");

    private final Button cancelBtn = new Button("取消");
    private final Button confirmBtn = new Button("确定");
    private final HorizontalLayout btnhly = new HorizontalLayout();

    private final Table table = new Table();
    private final VerticalLayout tablevly = new VerticalLayout();
    private final BeanItemContainer<SelectFoodMenuVModel> container = new BeanItemContainer<>(SelectFoodMenuVModel.class);

    @Override
    public void initView(SelectFoodMenuPresenter presenter) {
        buildView(presenter);
        addStyle();
        bind(presenter);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void refreshData(List<SelectFoodMenuVModel> data, List<MealScheDayModel> mealScheDay, Boolean isPublish) {
        Notification.show("共检索到" + data.size() + "数据");
        this.table.removeAllItems();
        this.container.removeAllItems();
        this.container.addAll(data);

        if (isPublish) {
            this.table.setSelectable(false);
            this.searchBtn.setEnabled(false);
            this.searchTxt.setEnabled(false);
        }

        data.forEach(e -> {
            mealScheDay.forEach(e1 -> {
                if (e.getMealId().equals(e1.getMealId())) {
                    table.select(e);
                }
            });
            e.getCheckbox().addValueChangeListener(e1 -> {
                if (e.getCheckbox().getValue()) {
                    table.select(e);
                }
                else {
                    table.unselect(e);
                }
            });
            if (isPublish) {
                e.getCheckbox().setEnabled(false);
            }
        });
    }

    private void bind(SelectFoodMenuPresenter presenter) {
        cancelBtn.addClickListener(e -> {
            this.close();
        });
        table.addValueChangeListener(e -> {
            table.getItemIds().forEach(e1 -> {
                Collection<?> values = (Collection<?>) table.getValue();
                SelectFoodMenuVModel m = (SelectFoodMenuVModel) e1;
                if (values.contains(e1)) {
                    m.getCheckbox().setValue(true);
                }
                else {
                    m.getCheckbox().setValue(false);
                }
            });
        });

        confirmBtn.addClickListener(e -> {
            Collection<?> values = (Collection<?>) this.table.getValue();
            List<String> ids = values.stream().map(e1 -> {
                SelectFoodMenuVModel m = (SelectFoodMenuVModel) e1;
                return m.getMealId();
            })
                    .collect(Collectors.toList());
            presenter.editMealScheDay(ids);
            this.close();
        });
        searchBtn.addClickListener(e -> {
            String searchValue = this.searchTxt.getValue();
            if (searchValue == null || "".equals(searchValue.trim())) {
                Notification.show("请输入值", Notification.Type.WARNING_MESSAGE);
                return;
            }
            presenter.searchMealSetList(searchValue);
        });
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
        this.mainvly.addStyleName("SelectFoodMenuView");
        this.mainvly.setWidth("100%");

        this.tablevly.setWidth("100%");
        this.titlehly.setWidth("100%");
        this.btnhly.setWidth("100%");
        this.center();
        this.setWidth("999px");
        this.setHeightUndefined();
        this.setResizable(false);
        this.setClosable(false);

        this.titlehly.addStyleName("titlehly");
        this.title.addStyleName("title");

        this.searchhly.addStyleName("searchhly");
        this.searchBtn.addStyleName("searchBtn");
        this.searchTxt.addStyleName("searchTxt");
        this.searchTxt.setInputPrompt("请输入套餐名称或者内容搜索");

        this.cancelBtn.addStyleName("cancelBtn");
        this.confirmBtn.addStyleName("confirmBtn");
        this.btnhly.addStyleName("btnhly");

        this.table.addStyleName("table");
        this.tablevly.addStyleName("tablevly");

        this.table.setMultiSelect(true);
        this.table.setMultiSelectMode(MultiSelectMode.SIMPLE);
    }

    private void buildView(SelectFoodMenuPresenter presenter) {
        this.setContent(mainvly);

        createTable();

        mainvly.addComponent(titlehly);
        mainvly.addComponent(searchhly);
        mainvly.addComponent(tablevly);
        mainvly.addComponent(btnhly);

        mainvly.setComponentAlignment(searchhly, Alignment.MIDDLE_CENTER);

        btnhly.addComponents(cancelBtn, confirmBtn);
        btnhly.setComponentAlignment(cancelBtn, Alignment.MIDDLE_RIGHT);
        btnhly.setComponentAlignment(confirmBtn, Alignment.MIDDLE_LEFT);

        titlehly.addComponent(title);

        searchhly.addComponents(searchTxt, searchBtn);

        tablevly.addComponent(table);
        tablevly.setComponentAlignment(table, Alignment.MIDDLE_CENTER);
    }

    private void createTable() {
        NxftTableUtils.getInstance()
                .addPropertyArray("checkbox", 1f, "")
                .addPropertyArray("mealSetNo", 1f, "套餐编号")
                .addPropertyArray("mealSetName", 2f, "套餐名称")
                .addPropertyArray("mealSetContent", 2f, "套餐内容")
                .addPropertyArray("price", 2f, "单价")
                .addPropertyArray("pungent", 2f, "辣")
                .addPropertyArray("mealSetDesc", 2f, "备注")
                .initTable(table, container);
        table.setSelectable(true);
        table.setImmediate(true);
        table.setSortEnabled(false);
        table.setNullSelectionAllowed(false);
        table.setWidth("98%");
        table.setHeight("400px");
        table.addStyleName("table-1");
    }

}
