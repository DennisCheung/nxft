package com.wit.fxp.nxft.ui.block.order;

import java.io.Serializable;
import java.util.List;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.app.selectdata.OrderSelectInfo;
import com.wit.fxp.nxft.ui.components.WNativeSelect;
import com.wit.fxp.ui.utils.FieldUtils;
import com.wit.fxp.vaadin.ui.BeanTable;

@PrototypeScope
@SpringView(name = OrderManagerView.NAME)
public class OrderManagerViewImpl extends CustomComponent implements OrderManagerView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final HorizontalLayout selecthor = new HorizontalLayout();
    private final Label lbsettype = new Label("查询方式：");
    private final WNativeSelect nsselecttype = new WNativeSelect();
    private final VerticalLayout changevly = new VerticalLayout();
    private final HorizontalLayout shor1 = new HorizontalLayout();
    private final Label lbct1 = new Label("下单时间：");
    private final DateField df1 = new DateField();
    private final Label lb1 = new Label("至");
    private final DateField df2 = new DateField();
    private final Label lbzhucan = new Label("助餐点：");
    private final WNativeSelect nszhucan = new WNativeSelect();
    private final Label lbstate = new Label("状态：");
    private final WNativeSelect nsstate = new WNativeSelect();

    private final HorizontalLayout shor2 = new HorizontalLayout();
    private final Label lbct2 = new Label("就餐时间：");
    private final DateField df3 = new DateField();
    private final Label lb2 = new Label("至");
    private final DateField df4 = new DateField();
    private final Label lbzhucan1 = new Label("助餐点：");
    private final WNativeSelect nszhucan1 = new WNativeSelect();
    private final Label lbduix = new Label("对象类型：");
    private final WNativeSelect nxduix = new WNativeSelect();
    private final Label lbstate1 = new Label("状态：");
    private final WNativeSelect nsstate1 = new WNativeSelect();

    private final HorizontalLayout shor3 = new HorizontalLayout();
    private final Label lbcname = new Label("客户姓名：");
    private final TextField name = new TextField();
    private final Label lbct21 = new Label("就餐时间：");
    private final DateField df31 = new DateField();
    private final Label lb21 = new Label("至");
    private final DateField df41 = new DateField();
    private final Label lbstate11 = new Label("状态：");
    private final WNativeSelect nsstate11 = new WNativeSelect();

    private final Button select = new Button("查询");
    private final Button clean = new Button("重置");

    private final BeanTable<OrderViewModel> beanTable;

    private static final BeanTable.CD[] TABLE_COL_DEFS = {
        new BeanTable.CD("客户",            "name",         106),
        new BeanTable.CD("就餐日期",         "eatTime",      100),
        new BeanTable.CD("星期",            "week",         70),
        new BeanTable.CD("餐别",            "cb",           70),
        new BeanTable.CD("套餐",            "tc",           250),
        new BeanTable.CD("份数",            "num",          60),
        new BeanTable.CD("配送方式",         "stype",       94),
        new BeanTable.CD("下单日期",         "ctime",       155),
        new BeanTable.CD("点餐方式",         "createWay",    90),
        new BeanTable.CD("状态",            "state",       85),
        new BeanTable.CD("操作人",           "handname",   91),
        new BeanTable.CD("操作",            "hand",        160)
    };

    private final HorizontalLayout pagehor = new HorizontalLayout();
    private final Button first = new Button("首页");
    private final Button up = new Button("<<上一页");
    private final Button down = new Button("下一页>>");
    private final Button last = new Button("尾页");
    private final Label now = new Label("1");
    private final Label pp = new Label("/");
    private final Label total = new Label("24");
    private final Label totalNum = new Label("共2243条数据");

    public OrderManagerViewImpl() {
        beanTable = createTable();
    }

    @Override
    public void initView(OrderManagerPresenter presenter) {
        buildView();
        bind(presenter);
    }

    public void buildView() {
        addStyle();
        name.setInputPrompt("输入客户姓名");
        this.setCompositionRoot(mainvly);
        mainvly.addComponents(selecthor, beanTable, pagehor);
        selecthor.addComponents(lbsettype, nsselecttype, changevly, select, clean);
        changevly.addComponents(shor1, shor2, shor3);
        shor1.addComponents(lbct1, df1, lb1, df2, lbzhucan, nszhucan, lbstate, nsstate);
        shor2.addComponents(lbct2, df3, lb2, df4, lbzhucan1, nszhucan1, lbduix, nxduix, lbstate1, nsstate1);
        shor3.addComponents(lbcname, name, lbct21, df31, lb21, df41, lbstate11, nsstate11);
        pagehor.addComponents(first, up, down, last, now, pp, total, totalNum);
        first.setStyleName(ValoTheme.BUTTON_LINK);
        up.setStyleName(ValoTheme.BUTTON_LINK);
        down.setStyleName(ValoTheme.BUTTON_LINK);
        last.setStyleName(ValoTheme.BUTTON_LINK);
        select.setClickShortcut(KeyCode.ENTER);  //键盘快捷键 enter键
        df1.setDateFormat("yyyy-MM-dd");
        df2.setDateFormat("yyyy-MM-dd");
        df3.setDateFormat("yyyy-MM-dd");
        df4.setDateFormat("yyyy-MM-dd");
        df31.setDateFormat("yyyy-MM-dd");
        df41.setDateFormat("yyyy-MM-dd");
        nsselecttype.addWSelectItem("1", "下单日期");
        nsselecttype.addWSelectItem("2", "就餐日期");
        nsselecttype.addWSelectItem("3", "客户姓名");
        nsselecttype.bindData();
        nsselecttype.setImmediate(true);
        nsselecttype.select(new IdAndName("1", "下单日期"));
        nsselecttype.setNullSelectionAllowed(false);
        shor2.setVisible(false);
        shor3.setVisible(false);

        setNativeSelect();

    }

    public void addStyle() {
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
                this.beanTable.setHeight((page.getBrowserWindowHeight() - 175) + "px");
            }
        });
        this.mainvly.addStyleName("OrderManagerViewImpl");
        this.selecthor.addStyleName("selecthor");
        this.lbct1.addStyleName("lbct1");
        this.lb1.addStyleName("lb1");
        this.lbct2.addStyleName("lbct1");
        this.lb2.addStyleName("lb1");
        this.name.addStyleName("name");

        this.select.addStyleName("select");
        this.clean.addStyleName("clean");

        this.beanTable.addStyleName("beanTable");
        this.beanTable.setWidth("100%");

        this.pagehor.addStyleName("pagehor");
        this.first.addStyleName("first");
        this.up.addStyleName("up");
        this.down.addStyleName("down");
        this.last.addStyleName("last");
        this.now.addStyleName("now");
        this.pp.addStyleName("pp");
        this.total.addStyleName("total");
        this.totalNum.addStyleName("totalNum");
        lbcname.setStyleName("mealorderlbcnamestyle");
        lbzhucan.setStyleName("mealorderlbzhucanstyle");
        lbstate.setStyleName("mealorderlbstatestyle");
        lbzhucan1.setStyleName("mealorderlbzhucanstyle");
        lbstate1.setStyleName("mealorderlbstatestyle");
        lbduix.setStyleName("mealorderlbduixstyle");
        lbstate11.setStyleName("mealorderlbstatestyle");
    }

    public void bind(OrderManagerPresenter presenter) {
        nsselecttype.addValueChangeListener(e -> {
            cleanAll();
            if (((IdAndName) nsselecttype.getValue()).getId().equals("1")) {
                shor2.setVisible(false);
                shor3.setVisible(false);
                shor1.setVisible(true);
            }
            else if (((IdAndName) nsselecttype.getValue()).getId().equals("2")) {
                shor1.setVisible(false);
                shor2.setVisible(true);
                shor3.setVisible(false);
            }
            else if (((IdAndName) nsselecttype.getValue()).getId().equals("3")) {
                shor1.setVisible(false);
                shor2.setVisible(false);
                shor3.setVisible(true);
            }
            else {
                shor1.setVisible(true);
                shor2.setVisible(false);
                shor3.setVisible(false);
            }
        });
        clean.addClickListener(e -> this.cleanAll());

        select.addClickListener(e -> {
            OrderSelectInfo info = getQueryInfo();
            presenter.subjectQuery(info, 0);
            now.setValue("1");
            beanTable.select(null);
        });

        down.addClickListener(e -> {
            if (presenter.getPageTotalNum(getQueryInfo()) == Integer.parseInt(now.getValue())) {
                Notification.show("已是末页", Type.WARNING_MESSAGE);
                return;
            }
            OrderSelectInfo info = getQueryInfo();
            presenter.subjectQuery(info, Integer.parseInt(now.getValue()) * 8);
            beanTable.select(null);
            now.setValue(String.valueOf(Integer.parseInt(now.getValue()) + 1));
        });

        first.addClickListener(e -> {
            OrderSelectInfo info = getQueryInfo();
            presenter.subjectQuery(info, 0);
            beanTable.select(null);
            now.setValue("1");
        });

        last.addClickListener(e -> {
            OrderSelectInfo info = getQueryInfo();
            presenter.subjectQuery(info, (presenter.getPageTotalNum(getQueryInfo()) - 1) * 8);
            beanTable.select(null);
            now.setValue(String.valueOf(presenter.getPageTotalNum(getQueryInfo())));
        });

        up.addClickListener(e -> {
            if ("1".equals(now.getValue())) {
                Notification.show("已是第一页", Type.WARNING_MESSAGE);
                return;
            }
            OrderSelectInfo info = getQueryInfo();
            presenter.subjectQuery(info, (Integer.parseInt(now.getValue()) - 2) * 8);
            beanTable.select(null);
            now.setValue(String.valueOf(Integer.parseInt(now.getValue()) - 1));
        });
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void refreshData(List<OrderViewModel> data) {
        beanTable.getContainerDataSource().removeAllItems();
        if (data == null) {
            Notification.show("暂无相关数据！", Type.WARNING_MESSAGE);
            return;
        }

        beanTable.getContainerDataSource().addAll(data);
        beanTable.select(null);
    }

    private static BeanTable<OrderViewModel> createTable() {
        BeanTable<OrderViewModel> table = new BeanTable<>(OrderViewModel.class);
        table.setSelectable(false);
        table.setImmediate(true);
        table.setSortEnabled(false);
        table.setPageLength(8);
        table.initTable(TABLE_COL_DEFS);

        return table;
    }

    private void cleanAll() {
        this.name.setValue("");
        df1.setValue(null);
        df2.setValue(null);
        df3.setValue(null);
        df4.setValue(null);
        df31.setValue(null);
        df41.setValue(null);
        nszhucan.select(new IdAndName("ALL", "全部"));
        nsstate.select(new IdAndName("ALL", "全部"));
        nxduix.select(new IdAndName("ALL", "全部"));
        nszhucan1.select(new IdAndName("ALL", "全部"));
        nsstate1.select(new IdAndName("ALL", "全部"));
        nsstate11.select(new IdAndName("ALL", "全部"));
    }

    @Override
    public void refreshPageInfo(String total, int totalNum) {
        this.total.setValue(total);
        this.totalNum.setValue("共" + totalNum + "条数据");
    }

    private OrderSelectInfo getQueryInfo() {
        if (((IdAndName) nsselecttype.getValue()).getId().equals("1")) {
            return OrderSelectInfo.builder()
                    ._createBegin___(df1.getValue() == null ? DBC.BEGINTIME : df1.getValue())
                    ._createEnd_____(df2.getValue() == null ? DBC.ENDTIME : df2.getValue())
                    ._eatBegin______(null)
                    ._eatEnd________(null)
                    ._name__________(null)
                    ._teamId________(((IdAndName) nszhucan.getValue()).getId())
                    ._state_________(((IdAndName) nsstate.getValue()).getId())
                    ._subjectTypeId_(null)
                    ._build_();
        }
        else if (((IdAndName) nsselecttype.getValue()).getId().equals("2")) {
            return OrderSelectInfo.builder()
                    ._createBegin___(null)
                    ._createEnd_____(null)
                    ._eatBegin______(df3.getValue() == null ? DBC.BEGINTIME : df3.getValue())
                    ._eatEnd________(df4.getValue() == null ? DBC.ENDTIME : df4.getValue())
                    ._name__________(null)
                    ._teamId________(((IdAndName) nszhucan1.getValue()).getId())
                    ._state_________(((IdAndName) nsstate1.getValue()).getId())
                    ._subjectTypeId_(((IdAndName) nxduix.getValue()).getId())
                    ._build_();
        }
        else {
            return OrderSelectInfo.builder()
                    ._createBegin___(null)
                    ._createEnd_____(null)
                    ._eatBegin______(df31.getValue() == null ? DBC.BEGINTIME : df31.getValue())
                    ._eatEnd________(df41.getValue() == null ? DBC.ENDTIME : df41.getValue())
                    ._name__________(FieldUtils.fieldStringValue(name))
                    ._teamId________(null)
                    ._state_________(((IdAndName) nsstate11.getValue()).getId())
                    ._subjectTypeId_(null)
                    ._build_();
        }
    }

    @Override
    public void refreshSelectInfo(List<IdAndName> sites, List<IdAndName> subjectTypes, List<IdAndName> states) {
        sites.forEach(e -> {
            nszhucan.addWSelectItem(e.getId(), e.getName());
            nszhucan1.addWSelectItem(e.getId(), e.getName());
        });
        nszhucan.bindData();
        nszhucan1.bindData();

        subjectTypes.forEach(e -> {
            nxduix.addWSelectItem(e.getId(), e.getName());
        });
        nxduix.bindData();

        states.forEach(e -> {
            nsstate.addWSelectItem(e.getId(), e.getName());
            nsstate1.addWSelectItem(e.getId(), e.getName());
            nsstate11.addWSelectItem(e.getId(), e.getName());
        });
        nsstate.bindData();
        nsstate1.bindData();
        nsstate11.bindData();
    }

    private void setNativeSelect() {
        nszhucan.addWSelectItem("ALL", "全部");
        nszhucan.bindData();
        nszhucan.select(new IdAndName("ALL", "全部"));
        nszhucan.setImmediate(true);
        nszhucan.setNullSelectionAllowed(false);
        nszhucan1.addWSelectItem("ALL", "全部");
        nszhucan1.bindData();
        nszhucan1.setImmediate(true);
        nszhucan1.select(new IdAndName("ALL", "全部"));
        nszhucan1.setNullSelectionAllowed(false);
        nxduix.addWSelectItem("ALL", "全部");
        nxduix.bindData();
        nxduix.setImmediate(true);
        nxduix.select(new IdAndName("ALL", "全部"));
        nxduix.setNullSelectionAllowed(false);
        nsstate11.addWSelectItem("ALL", "全部");
        nsstate11.bindData();
        nsstate11.setImmediate(true);
        nsstate11.select(new IdAndName("ALL", "全部"));
        nsstate11.setNullSelectionAllowed(false);
        nsstate1.addWSelectItem("ALL", "全部");
        nsstate1.bindData();
        nsstate1.setImmediate(true);
        nsstate1.select(new IdAndName("ALL", "全部"));
        nsstate1.setNullSelectionAllowed(false);
        nsstate.addWSelectItem("ALL", "全部");
        nsstate.bindData();
        nsstate.setImmediate(true);
        nsstate.select(new IdAndName("ALL", "全部"));
        nsstate.setNullSelectionAllowed(false);
    }

}
