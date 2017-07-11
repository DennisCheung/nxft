package com.wit.fxp.nxft.ui.block.ordercollect;

import java.io.Serializable;
import java.util.Date;

import org.vaadin.spring.annotation.PrototypeScope;

import com.benewit.core.env.CurrentDate;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.common.LayoutUtils;
import com.wit.fxp.nxft.ui.components.WNativeSelect;
import com.wit.utils.DateUtils;

/**
 * 打印订单汇总信息
 * @author wck
 *
 */
@PrototypeScope
@SpringView(name = PrintOrderCollectView.NAME)
public class PrintOrderCollectViewImpl extends CustomComponent implements PrintOrderCollectView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final HorizontalLayout tophly = new HorizontalLayout();
    private final VerticalLayout bottomvly = new VerticalLayout();
    private final HorizontalLayout btnhly = new HorizontalLayout();

    private final DateField begin = new DateField();
    private final DateField end = new DateField();
    private final WNativeSelect select = new WNativeSelect();
    private final Button searchBtn = new Button("查询");

    private final BrowserFrame printView = new BrowserFrame();

    private final HorizontalLayout titlehly = new HorizontalLayout();
    private final Label title = new Label("打印订单");

    private final Button closeWindowBtn = new Button("关闭窗口");

    @Override
    public void initView(PrintOrderCollectPresenter presenter) {
        buildView();
        addStyle();
        bind(presenter);
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

    @Override
    public void viewPrint(String url) {
        this.printView.setSource(new com.vaadin.server.ExternalResource(url));
    }

    private void bind(PrintOrderCollectPresenter presenter) {
        select.addWSelectItem(DBC.餐别.早餐.value(), DBC.餐别.早餐.name());
        select.addWSelectItem(DBC.餐别.午餐.value(), DBC.餐别.午餐.name());
        select.addWSelectItem(DBC.餐别.晚餐.value(), DBC.餐别.晚餐.name());
        select.bindData();
        select.select(new IdAndName(DBC.餐别.早餐.value(), DBC.餐别.早餐.name()));

        closeWindowBtn.addClickListener(e -> {
            presenter.closeView();
        });

        searchBtn.addClickListener(e -> {
            presenter.print(DateUtils.getBegin(begin.getValue()), DateUtils.getEnd(end.getValue()), select.getSelectedWItem().getId());
        });

        Date currentDate = new CurrentDate().getCurrentDate();
        this.begin.setValue(DateUtils.getBegin(currentDate));
        this.end.setValue(DateUtils.getEnd(currentDate));
        this.searchBtn.click();
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
        this.bottomvly.setWidth("100%");
        this.titlehly.setWidth("100%");
        this.btnhly.setWidth("100%");
        this.printView.setHeight("550px");
        this.printView.setWidth("100%");
        this.mainvly.addStyleName("printOrderCollectView");
        this.tophly.addStyleName("topvly");
        this.bottomvly.addStyleName("bottomvly");
        this.begin.setDateFormat("yyyy年MM月dd日");
        this.end.setDateFormat("yyyy年MM月dd日");

        this.setSizeUndefined();

        select.setNullSelectionAllowed(false);

        tophly.addStyleName("tophly");
        bottomvly.addStyleName("bottomvly");
        btnhly.addStyleName("btnhly");
        end.addStyleName("end");
        begin.addStyleName("begin");
        select.addStyleName("select");
        searchBtn.addStyleName("searchBtn");
        printView.addStyleName("printView");
        titlehly.addStyleName("titlehly");
        title.addStyleName("title");
        closeWindowBtn.addStyleName("closeWindowBtn");
    }

    private void buildView() {
        this.setCompositionRoot(mainvly);
        mainvly.addComponents(titlehly, bottomvly, btnhly);
        bottomvly.addComponent(tophly);
        titlehly.addComponent(title);
        tophly.addComponent(LayoutUtils.getHorLayout(null, null, begin, "", end, "", "", "至"));
        tophly.addComponent(select);
        tophly.addComponent(searchBtn);

        bottomvly.addComponent(printView);

        btnhly.addComponent(closeWindowBtn);
        btnhly.setComponentAlignment(closeWindowBtn, Alignment.MIDDLE_CENTER);
    }

}
