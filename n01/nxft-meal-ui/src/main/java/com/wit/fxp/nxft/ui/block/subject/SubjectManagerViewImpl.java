package com.wit.fxp.nxft.ui.block.subject;

import java.io.Serializable;
import java.util.List;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.app.selectdata.SubjectSelectInfo;
import com.wit.fxp.nxft.ui.components.WNativeSelect;
import com.wit.fxp.ui.utils.FieldUtils;
import com.wit.fxp.vaadin.ui.BeanTable;

@PrototypeScope
@SpringView(name = SubjectManagerView.NAME)
public class SubjectManagerViewImpl extends CustomComponent implements SubjectManagerView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final HorizontalLayout selecthor = new HorizontalLayout();
    private final Label lbtitle = new Label("查询条件：");
    private final TextField name = new TextField();
    private final TextField phone = new TextField();
    private final Label lbps = new Label("助餐点：");
    private final WNativeSelect address = new WNativeSelect();

    private final Button select = new Button("查询");
    private final Button clean = new Button("重置");
    private final Button add = new Button("新增对象");

    private final BeanTable<SubjectViewModel> beanTable;

    private static final BeanTable.CD[] TABLE_COL_DEFS = {
        new BeanTable.CD("客户姓名",         "name",      90),
        new BeanTable.CD("性别",            "gender",    60),
        new BeanTable.CD("年龄",            "age",       60),
        new BeanTable.CD("助餐点",          "idNo",      160),
        new BeanTable.CD("客户类型",         "type",      140),
        new BeanTable.CD("联系电话",         "phone",     150),
        new BeanTable.CD("配送方式",         "sendType",  140),
        new BeanTable.CD("地址",            "address",    340),
        new BeanTable.CD("操作",            "hand",       107)
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

    public SubjectManagerViewImpl() {
        beanTable = createTable();
    }

    @Override
    public void initView(SubjectManagerPresenter presenter) {
        buildView();
        bind(presenter);
    }

    public void buildView() {
        addStyle();
        name.setInputPrompt("输入客户姓名");
        phone.setInputPrompt("输入客户手机");
        this.setCompositionRoot(mainvly);
        mainvly.addComponents(selecthor, beanTable, pagehor);
        selecthor.addComponents(lbtitle, name, phone, lbps, address, select, clean, add);
        pagehor.addComponents(first, up, down, last, now, pp, total, totalNum);
        first.setStyleName(ValoTheme.BUTTON_LINK);
        up.setStyleName(ValoTheme.BUTTON_LINK);
        down.setStyleName(ValoTheme.BUTTON_LINK);
        last.setStyleName(ValoTheme.BUTTON_LINK);
        select.setClickShortcut(KeyCode.ENTER);  //键盘快捷键 enter键

    }

    public void addStyle() {
        this.mainvly.addStyleName("SubjectManagerView");

        this.selecthor.addStyleName("selecthor");
        this.lbtitle.addStyleName("lbtitle");
        this.name.addStyleName("name");
        this.phone.addStyleName("phone");
        this.lbps.addStyleName("lbps");
        this.address.addStyleName("address");

        this.select.addStyleName("select");
        this.clean.addStyleName("clean");
        this.add.addStyleName("add");

        this.beanTable.addStyleName("beanTable");

        this.pagehor.addStyleName("pagehor");
        this.first.addStyleName("first");
        this.up.addStyleName("up");
        this.down.addStyleName("down");
        this.last.addStyleName("last");
        this.now.addStyleName("now");
        this.pp.addStyleName("pp");
        this.total.addStyleName("total");
        this.totalNum.addStyleName("totalNum");
    }

    public void bind(SubjectManagerPresenter presenter) {

        add.addClickListener(e -> {
            presenter.openAddSubject();
        });

        clean.addClickListener(e -> this.cleanAll());

        select.addClickListener(e -> {
            SubjectSelectInfo info = getQueryInfo();
            presenter.subjectQuery(info, 0);
            now.setValue("1");
            beanTable.select(null);
        });

        down.addClickListener(e -> {
            if (presenter.getPageTotalNum(getQueryInfo()) == Integer.parseInt(now.getValue())) {
                Notification.show("已是末页", Type.WARNING_MESSAGE);
                return;
            }
            SubjectSelectInfo info = getQueryInfo();
            presenter.subjectQuery(info, Integer.parseInt(now.getValue()) * 8);
            beanTable.select(null);
            now.setValue(String.valueOf(Integer.parseInt(now.getValue()) + 1));
        });

        first.addClickListener(e -> {
            SubjectSelectInfo info = getQueryInfo();
            presenter.subjectQuery(info, 0);
            beanTable.select(null);
            now.setValue("1");
        });

        last.addClickListener(e -> {
            SubjectSelectInfo info = getQueryInfo();
            presenter.subjectQuery(info, (presenter.getPageTotalNum(getQueryInfo()) - 1) * 8);
            beanTable.select(null);
            now.setValue(String.valueOf(presenter.getPageTotalNum(getQueryInfo())));
        });

        up.addClickListener(e -> {
            if ("1".equals(now.getValue())) {
                Notification.show("已是第一页", Type.WARNING_MESSAGE);
                return;
            }
            SubjectSelectInfo info = getQueryInfo();
            presenter.subjectQuery(info, (Integer.parseInt(now.getValue()) - 2) * 8);
            beanTable.select(null);
            now.setValue(String.valueOf(Integer.parseInt(now.getValue()) - 1));
        });
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void refreshData(List<SubjectViewModel> data) {
        beanTable.getContainerDataSource().removeAllItems();
        if (data == null) {
            Notification.show("暂无相关数据！", Type.WARNING_MESSAGE);
            return;
        }

        beanTable.getContainerDataSource().addAll(data);
        beanTable.select(null);
    }

    private static BeanTable<SubjectViewModel> createTable() {
        BeanTable<SubjectViewModel> table = new BeanTable<>(SubjectViewModel.class);
        table.setSelectable(false);
        table.setImmediate(true);
        table.setSortEnabled(false);
        table.setPageLength(8);
        table.initTable(TABLE_COL_DEFS);

        return table;
    }

    private void cleanAll() {
        this.name.setValue("");
        this.phone.setValue("");
        this.address.select(null);
    }

    @Override
    public void refreshPageInfo(String total, int totalNum) {
        this.total.setValue(total);
        this.totalNum.setValue("共" + totalNum + "条数据");
    }

    private SubjectSelectInfo getQueryInfo() {
        String cname = FieldUtils.fieldStringValue(this.name);
        String cphone = FieldUtils.fieldStringValue(this.phone);
        String stype = this.address.getValue() == null ? null : ((IdAndName) this.address.getValue()).getId();
        return SubjectSelectInfo.builder()
                ._name______(cname)
                ._phone_____(cphone)
                ._sendType__(stype)
                ._build_();
    }

    @Override
    public void refreshTeams(List<IdAndName> teams) {
        teams.forEach(e -> {
            address.addWSelectItem(e.getId(), e.getName());
        });
        address.bindData();
    }

}
