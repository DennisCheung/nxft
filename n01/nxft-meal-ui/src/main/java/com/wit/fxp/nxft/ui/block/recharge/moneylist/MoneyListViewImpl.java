package com.wit.fxp.nxft.ui.block.recharge.moneylist;

import java.io.Serializable;
import java.util.List;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.app.model.SelectMoneyListInfo;
import com.wit.fxp.vaadin.ui.BeanTable;

@PrototypeScope
@SpringView(name = MoneyListView.NAME)
public class MoneyListViewImpl extends Window implements MoneyListView, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final Label title = new Label("查看充值流水：近20条记录");
    private final HorizontalLayout hor = new HorizontalLayout();
    private final Label lb = new Label("时段：");
    private final DateField df1 = new DateField();
    private final Label lb1 = new Label("-");
    private final DateField df2 = new DateField();
    private final CheckBox check = new CheckBox("是否本人");
    private final Button select = new Button("查询");
    private final BeanTable<MoneyListViewModel> beanTable;

    private static final BeanTable.CD[] TABLE_COL_DEFS = {
        new BeanTable.CD("姓名",         "name",      81),
        new BeanTable.CD("联系电话",            "phone",     101),
        new BeanTable.CD("充值时间",            "time",       156),
        new BeanTable.CD("充值金额(元)",            "jine",      106),
        new BeanTable.CD("余额(元)",         "yue",      79),
        new BeanTable.CD("操作人",         "hand",     100)
    };

    private final Button btn = new Button("关闭");

    public MoneyListViewImpl() {
        beanTable = createTable();
    }

    @Override
    public void initView(MoneyListPresenter presenter) {
        center();
        this.setResizable(false);
        this.setSizeUndefined();
        this.setModal(true);
        this.setContent(mainvly);
        this.setClosable(false);
        buildView();
        bind(presenter);

    }

    public void buildView() {
        addStyle();
        this.setContent(mainvly);
        mainvly.addComponents(title, hor, beanTable, btn);
        hor.addComponents(lb, df1, lb1, df2, check, select);
    }

    public void addStyle() {
        this.mainvly.addStyleName("MoneyListViewImpl");
        this.mainvly.setWidth("100%");
        this.title.addStyleName("title");
        this.hor.addStyleName("hor");
        this.lb.addStyleName("lb");
        this.check.addStyleName("check");
        this.select.addStyleName("select");
        this.beanTable.addStyleName("beanTable");

        this.btn.addStyleName("btn");

    }

    public void bind(MoneyListPresenter presenter) {
        btn.addClickListener(e -> {
            this.close();
        });

        select.addClickListener(e -> {
            presenter.showValue(SelectMoneyListInfo.builder()
                    ._begin_____(df1.getValue() == null ? DBC.BEGINTIME : df1.getValue())
                    ._end_______(df2.getValue() == null ? DBC.ENDTIME : df2.getValue())
                    ._isMine____(check.getValue())
                    ._build_());
        });
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void refreshView(List<MoneyListViewModel> models) {
        beanTable.getContainerDataSource().removeAllItems();
        if (models == null) {
            Notification.show("暂无相关数据！", Type.WARNING_MESSAGE);
            return;
        }

        beanTable.getContainerDataSource().addAll(models);
        beanTable.select(null);
    }

    private static BeanTable<MoneyListViewModel> createTable() {
        BeanTable<MoneyListViewModel> table = new BeanTable<>(MoneyListViewModel.class);
        table.setSelectable(false);
        table.setImmediate(true);
        table.setSortEnabled(false);
        table.setPageLength(11);
        table.initTable(TABLE_COL_DEFS);

        return table;
    }

}
