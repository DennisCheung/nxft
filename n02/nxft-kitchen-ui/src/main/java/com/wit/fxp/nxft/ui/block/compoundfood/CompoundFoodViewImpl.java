package com.wit.fxp.nxft.ui.block.compoundfood;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.common.LayoutUtils;
import com.wit.fxp.nxft.common.NxftTableUtils;
import com.wit.fxp.nxft.compound.model.MealTypeModel;
import com.wit.fxp.nxft.env.CompoundCreateConfigure;
import com.wit.fxp.nxft.paging.PagingInfo;
import com.wit.fxp.nxft.ui.block.compoundfood.model.CompountFoodVModel;
import com.wit.fxp.nxft.ui.components.PagingComponent;
import com.wit.fxp.vaadin.ui.WNativeSelect;
import com.wit.utils.DateUtils;

/**
 *
 * @author wck
 *
 */
@PrototypeScope
@SpringView(name = CompoundFoodView.NAME)
public class CompoundFoodViewImpl extends CustomComponent implements CompoundFoodView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final VerticalLayout rightvly = new VerticalLayout();
    private final HorizontalLayout topmainHly = new HorizontalLayout();

    private final Button searchBtn = new Button("查询");
    private final Button resetBtn = new Button("重置");

    private final Button preDateBtn = new Button("前一天");
    private final Button nextDateBtn = new Button("后一天");
    private final DateField mealDate = new DateField();
    private final WNativeSelect stateSelect = new WNativeSelect();
    private final WNativeSelect mealSetSelect = new WNativeSelect(); //餐别
    private final Button batchDeliveBtn = new Button("批量配送");
    private final Button batchPrintBtn = new Button("批量打印配送单");

    private final Button handCreateCompoundBtn = new Button("手动生成配餐单");

    private final Table table = new Table();
    private final VerticalLayout tablevly = new VerticalLayout();
    private final BeanItemContainer<CompountFoodVModel> container = new BeanItemContainer<>(CompountFoodVModel.class);
    private final PagingComponent pageComponent = new PagingComponent();

    @Autowired private CompoundCreateConfigure compoundCreateConfigure;

    @Override
    public void initView(CompoundFoodPresenter presenter) {
        buildView();
        addStyle();
        bind(presenter);
        initData();
    }

    @Override
    public void initData(List<MealTypeModel> mealTypeList) {
        Date currentDate = new CurrentDate().getCurrentDate();
        Calendar cal = new GregorianCalendar();
        MealTypeModel m = null;
        for (int i = 0; i < mealTypeList.size(); i++) {
            cal.setTime(currentDate);
            MealTypeModel mealType = mealTypeList.get(i);
            String mealTime = mealType.getMealTime();
            String hourStr = mealTime.substring(0, 2);
            String minuteStr = mealTime.substring(2);
            int hourInt = Integer.parseInt(hourStr);
            int minuteInt = Integer.parseInt(minuteStr);
            cal.set(Calendar.HOUR_OF_DAY, hourInt);
            cal.set(Calendar.MINUTE, minuteInt);
            cal.add(Calendar.HOUR_OF_DAY, -mealType.getOrderBefore());
            Date mealTypeTime = cal.getTime();
            if (currentDate.after(mealTypeTime)) {
                m = mealType;
            }
        }
        if (m != null) {
            this.mealSetSelect.select(new IdAndName(m.getMealTypeId(), m.getMealTypeName()));
        }
        else {
            this.mealSetSelect.select(new IdAndName(null, "请选择"));
        }
    }

    private void initData() {
        this.mealDate.setValue(new CurrentDate().getCurrentDate());
        this.stateSelect.addWSelectItem(DBC.配送订单状态.已接单.value(), "未配送");
        this.stateSelect.addWSelectItem(DBC.配送订单状态.已配送.value(), "已配送");
        this.stateSelect.bindData();
        this.stateSelect.select(new IdAndName(DBC.配送订单状态.已接单.value(), "未配送"));

        this.mealSetSelect.addWSelectItem(null, "请选择");
        this.mealSetSelect.addWSelectItem(DBC.餐别.早餐.value(), DBC.餐别.早餐.name());
        this.mealSetSelect.addWSelectItem(DBC.餐别.午餐.value(), DBC.餐别.午餐.name());
        this.mealSetSelect.addWSelectItem(DBC.餐别.晚餐.value(), DBC.餐别.晚餐.name());
        this.mealSetSelect.bindData();
    }

    @Override
    public void refreshData(List<CompountFoodVModel> data) {
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

    private void bind(CompoundFoodPresenter presenter) {
        this.preDateBtn.addClickListener(e -> {
            Date value = this.mealDate.getValue();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(value);
            calendar.add(Calendar.DATE, -1);
            this.mealDate.setValue(calendar.getTime());
            this.searchBtn.click();
        });
        this.nextDateBtn.addClickListener(e -> {
            Date value = this.mealDate.getValue();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(value);
            calendar.add(Calendar.DATE, 1);
            this.mealDate.setValue(calendar.getTime());
            this.searchBtn.click();
        });

        this.pageComponent.addHandleListener(new PagingComponent.PageHandleListener() {

            @Override
            public void handleEvent(PagingInfo pageInfo) {
                IdAndName selectedWItem = stateSelect.getSelectedWItem();
                IdAndName mealTypeIdAndName = mealSetSelect.getSelectedWItem();
                presenter.refreshMealScheData(pageInfo, mealDate.getValue(), selectedWItem.getId(), mealTypeIdAndName == null ? null : mealTypeIdAndName.getId());
            }
        });

        this.batchDeliveBtn.addClickListener(e -> {
            List<String> list = new ArrayList<>();
            this.table.getItemIds().forEach(e1 -> {
                CompountFoodVModel vmodel = (CompountFoodVModel) e1;
                if (vmodel.getCheckBox().getValue()) {
                    list.add(vmodel.getId());
                }
            });
            if (list.size() == 0) {
                Notification.show("请选择配餐记录", Notification.Type.WARNING_MESSAGE);
            }
            else {
                presenter.batchDelive(list);
            }
        });

        stateSelect.addValueChangeListener(e -> {
            IdAndName selectedWItem = stateSelect.getSelectedWItem();
            if (DBC.配送订单状态.已配送.value().equals(selectedWItem.getId())) {
                this.searchBtn.click();
                this.batchDeliveBtn.setEnabled(false);
            }
            else {
                this.searchBtn.click();
                this.batchDeliveBtn.setEnabled(true);
            }
        });

        this.mealSetSelect.addValueChangeListener(e -> {
            this.searchBtn.click();
        });

        this.handCreateCompoundBtn.addClickListener(e -> {
            openHandCreate(presenter);
        });
    }

    private void openHandCreate(CompoundFoodPresenter presenter) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, compoundCreateConfigure.getCreateDays());
        if (mealDate.getValue() == null) {
            Notification.show("请选择生成时间", Notification.Type.WARNING_MESSAGE);
            return;
        }
        if ((mealDate.getValue().after(DateUtils.getBegin(new Date()))
                && mealDate.getValue().before(DateUtils.getEnd(cal.getTime())))
                || mealDate.getValue().equals(DateUtils.getBegin(new Date()))
                || mealDate.getValue().equals(DateUtils.getEnd(cal.getTime()))) {
            Window w = new Window();
            Label wtitleLabel = new Label();
            Button wcancelBtn = new Button("取消");
            Button wconfirmBtn = new Button("确定");
            TextField wdateField = new TextField();
            WNativeSelect wmealTypeSelect = new WNativeSelect();

            VerticalLayout wmainvly = new VerticalLayout();
            HorizontalLayout wtitlehly = new HorizontalLayout();
            VerticalLayout wcontentvly = new VerticalLayout();
            HorizontalLayout wbtnhly = new HorizontalLayout();

            wtitleLabel.setValue("手动生成配餐单");
            wcancelBtn.setCaption("取消");
            wconfirmBtn.setCaption("生成配餐单");
            wcancelBtn.addClickListener(e -> {
                w.close();
            });
            wconfirmBtn.addClickListener(e -> {
                IdAndName selectedWItem = wmealTypeSelect.getSelectedWItem();
                if (selectedWItem == null) {
                    Notification.show("餐别还未选择", Notification.Type.WARNING_MESSAGE);
                    wmealTypeSelect.focus();
                    return;
                }
                Date mealDateValue = mealDate.getValue();
                presenter.handCreate(mealDateValue, selectedWItem.getId());
                w.close();
            });

            wtitleLabel.addStyleName("titleLabel");
            wcancelBtn.addStyleName("cancelBtn");
            wconfirmBtn.addStyleName("confirmBtn");
            wdateField.addStyleName("wdateField");
            wmealTypeSelect.addStyleName("wmealTypeSelect");
            wdateField.setEnabled(false);

            wmainvly.addStyleName("HandCreateCompoundWindow");
            wtitlehly.addStyleName("titlehly");
            wcontentvly.addStyleName("contentvly");
            wbtnhly.addStyleName("btnhly");

            w.setContent(wmainvly);
            w.setWidth("350px");
            w.center();
            w.setResizable(false);
            w.setClosable(false);
            w.setModal(true);
            wmainvly.addComponents(wtitlehly, wcontentvly, wbtnhly);
            wtitlehly.addComponent(wtitleLabel);

            HorizontalLayout dateLayout = LayoutUtils.getHorLayout("配餐日期：", "100px", wdateField, null);
            wcontentvly.addComponent(dateLayout);
            HorizontalLayout mealTypeLayout = LayoutUtils.getHorLayout("餐别：", "100px", wmealTypeSelect, null);
            wcontentvly.addComponent(mealTypeLayout);
            dateLayout.addStyleName("dateLayout");
            mealTypeLayout.addStyleName("mealTypeLayout");

            wbtnhly.addComponents(wcancelBtn, wconfirmBtn);
            wbtnhly.setComponentAlignment(wcancelBtn, Alignment.MIDDLE_RIGHT);
            wtitlehly.setWidth("100%");
            wcontentvly.setWidth("100%");
            wbtnhly.setWidth("100%");

            wdateField.setValue(DateUtils.getShortDate(mealDate.getValue()));
            wmealTypeSelect.removeAllItems();
            List<MealTypeModel> mealTypeList = presenter.findMealTypeList();
            mealTypeList.forEach(e -> {
                wmealTypeSelect.addWSelectItem(e.getMealTypeId(), e.getMealTypeName());
            });
            wmealTypeSelect.bindData();
            UI.getCurrent().addWindow(w);
        }
        else {
            Notification.show("手动生成只能生成今天或明天的数据，请重新选择生成时间", Notification.Type.WARNING_MESSAGE);
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
        this.mainvly.addStyleName("compountfoodview");
        mealDate.setDateFormat("yyyy年MM月dd日");

        this.rightvly.addStyleName("rightvly");

        this.topmainHly.addStyleName("topmainHly");

        this.searchBtn.addStyleName("searchBtn");
        this.resetBtn.addStyleName("resetBtn");
        this.preDateBtn.addStyleName("preDateBtn");
        this.nextDateBtn.addStyleName("nextDateBtn");
        this.stateSelect.addStyleName("stateSelect");
        this.mealSetSelect.addStyleName("mealTypeSelect");
        this.batchDeliveBtn.addStyleName("batchDeliveBtn");
        this.batchPrintBtn.addStyleName("batchPrintBtn");
        this.handCreateCompoundBtn.addStyleName("handCreateCompoundBtn");

        this.table.addStyleName("table");

        this.stateSelect.setNullSelectionAllowed(false);
        this.stateSelect.setImmediate(true);
        this.mealSetSelect.setNullSelectionAllowed(false);
        this.mealSetSelect.setImmediate(true);
        this.batchPrintBtn.setVisible(false);

        this.handCreateCompoundBtn.setVisible(compoundCreateConfigure.getHandCreateVisiable());
    }

    private void buildView() {
        this.setCompositionRoot(mainvly);

        createTable(this.table, this.container);

        topmainHly.addComponent(LayoutUtils.getHorLayout(null, "", preDateBtn, null));
        topmainHly.addComponent(LayoutUtils.getHorLayout(null, "", mealDate, null));
        topmainHly.addComponent(LayoutUtils.getHorLayout(null, "", nextDateBtn, null));
        topmainHly.addComponent(LayoutUtils.getHorLayout("餐别：", "", mealSetSelect, null));
        topmainHly.addComponent(LayoutUtils.getHorLayout("状态：", "", stateSelect, null));
        topmainHly.addComponent(LayoutUtils.getHorLayout(null, "", searchBtn, null));
        topmainHly.addComponent(LayoutUtils.getHorLayout(null, "", handCreateCompoundBtn, null));
        topmainHly.addComponent(LayoutUtils.getHorLayout(null, "", batchDeliveBtn, null));
        topmainHly.addComponent(LayoutUtils.getHorLayout(null, "", batchPrintBtn, null));
        tablevly.addComponent(table);
        tablevly.setComponentAlignment(table, Alignment.MIDDLE_CENTER);

        this.pageComponent.postInit(tablevly, this.searchBtn, 20);

        rightvly.addComponents(topmainHly, pageComponent);

        this.mainvly.addComponents(rightvly);
    }

    private void createTable(Table table, BeanItemContainer<CompountFoodVModel> container) {
        NxftTableUtils.getInstance()
            .addPropertyArray("checkBox", 0.5f, "")
            .addPropertyArray("deliveNoteNo", 2f, "配餐单编号")
            .addPropertyArray("mealTime", 2.5f, "就餐时间")
            .addPropertyArray("week", 1.5f, "星期")
            .addPropertyArray("foodType", 2f, "餐别")
            .addPropertyArray("quanlity", 1f, "份数")
            .addPropertyArray("deliverWay", 2f, "配送方式")
            .addPropertyArray("deliveSiteName", 6f, "助餐点")
            .addPropertyArray("state", 2f, "状态")
            .addPropertyArray("handleLayout", 3f, "操作")
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
