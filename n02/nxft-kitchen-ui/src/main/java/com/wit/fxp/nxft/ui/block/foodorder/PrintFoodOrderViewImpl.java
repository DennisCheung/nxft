package com.wit.fxp.nxft.ui.block.foodorder;

import java.io.Serializable;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.wit.fxp.vaadin.ui.WCheckBox;

/**
 *
 * @author wck
 *
 */
@PrototypeScope
@SpringView(name = PrintFoodOrderView.NAME)
public class PrintFoodOrderViewImpl extends CustomComponent implements PrintFoodOrderView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final Label title = new Label("分类");
    private final HorizontalSplitPanel contenthsp = new HorizontalSplitPanel();
    private final VerticalLayout leftvly = new VerticalLayout();
    private final VerticalLayout rightvly = new VerticalLayout();
    private final HorizontalLayout rightContenthly = new HorizontalLayout();

    private final Button printBtn = new Button("打印预览");

    private final Button todayBtn = new Button("今天");
    private final Button tomorrowBtn = new Button("明天");

    private final VerticalLayout fBreakfastvly = new VerticalLayout();
    private final Label fBreakfastTitle = new Label("早餐");
    private final WCheckBox fBreakfastCheckbox = new WCheckBox();
    private final CheckBox fBreakfastAll = new CheckBox("全选");
    private final Label fBreakfastNum = new Label("56");
    private final VerticalLayout fLunchvly = new VerticalLayout();
    private final Label fLunchTitle = new Label("午餐");
    private final WCheckBox fLunchCheckbox = new WCheckBox();
    private final CheckBox fLunchAll = new CheckBox("全选");
    private final Label fLunchNum = new Label("3");
    private final VerticalLayout fDinnervly = new VerticalLayout();
    private final Label fDinnerTitle = new Label("晚餐");
    private final WCheckBox fDinnerCheckbox = new WCheckBox();
    private final CheckBox fDinnerAll = new CheckBox("全选");
    private final Label fDinnerNum = new Label("4");

    private final VerticalLayout sBreakfastvly = new VerticalLayout();
    private final Label sBreakfastTitle = new Label("早餐");
    private final WCheckBox sBreakfastCheckbox = new WCheckBox();
    private final CheckBox sBreakfastAll = new CheckBox("全选");
    private final Label sBreakfastNum = new Label("22");
    private final VerticalLayout sLunchvly = new VerticalLayout();
    private final Label sLunchTitle = new Label("午餐");
    private final WCheckBox sLunchCheckbox = new WCheckBox();
    private final CheckBox sLunchAll = new CheckBox("全选");
    private final Label sLunchNum = new Label("22");
    private final VerticalLayout sDinnervly = new VerticalLayout();
    private final Label sDinnerTitle = new Label("晚餐");
    private final WCheckBox sDinnerCheckbox = new WCheckBox();
    private final CheckBox sDinnerAll = new CheckBox("全选");
    private final Label sDinnerNum = new Label("23");

    @Override
    public void initView(PrintFoodOrderPresenter presenter) {
        buildView();
        addStyle();
        bind(presenter);
        bindData(presenter);
    }

    private void bindData(PrintFoodOrderPresenter presenter) {
        fBreakfastCheckbox.addOptionItem("1", "1111");
        fBreakfastCheckbox.addOptionItem("2", "2222");
        fBreakfastCheckbox.bindData();

        sLunchCheckbox.addOptionItem("1", "1111");
        sLunchCheckbox.addOptionItem("2", "2222");
        sLunchCheckbox.bindData();
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

    private void bind(PrintFoodOrderPresenter presenter) {
        this.todayBtn.addClickListener(e -> today());
        this.tomorrowBtn.addClickListener(e -> tomorrow());
    }

    private void tomorrow() {
        this.rightContenthly.removeAllComponents();
        this.rightContenthly.addComponents(sBreakfastvly, sLunchvly, sDinnervly);
        this.todayBtn.removeStyleName("checked");
        this.tomorrowBtn.addStyleName("checked");
    }

    private void today() {
        this.rightContenthly.removeAllComponents();
        this.rightContenthly.addComponents(fBreakfastvly, fLunchvly, fDinnervly);
        this.tomorrowBtn.removeStyleName("checked");
        this.todayBtn.addStyleName("checked");
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
        this.mainvly.addStyleName("printfoodorderview");

        this.title.addStyleName("title");
        this.contenthsp.addStyleName("contenthsp");

        this.leftvly.addStyleName("leftvly");
        this.rightvly.addStyleName("rightvly");
        this.rightContenthly.addStyleName("rightContenthly");

        this.rightvly.addStyleName("bottomvly");

        this.todayBtn.addStyleName("todayBtn");
        this.tomorrowBtn.addStyleName("tomorrowBtn");

        this.fBreakfastvly.addStyleName("fBreakfastvly");
        this.fBreakfastTitle.addStyleName("fBreakfastTitle");
        this.fBreakfastCheckbox.addStyleName("fBreakfastCheckbox");
        this.fBreakfastAll.addStyleName("fBreakfastAll");
        this.fBreakfastNum.addStyleName("sBreakfastNum");

        this.fLunchvly.addStyleName("fBreakfastvly");
        this.fLunchTitle.addStyleName("fBreakfastTitle");
        this.fLunchCheckbox.addStyleName("fBreakfastCheckbox");
        this.fLunchAll.addStyleName("fBreakfastAll");
        this.fLunchNum.addStyleName("sBreakfastNum");

        this.fDinnervly.addStyleName("fBreakfastvly");
        this.fDinnerTitle.addStyleName("fBreakfastTitle");
        this.fDinnerCheckbox.addStyleName("fBreakfastCheckbox");
        this.fDinnerAll.addStyleName("fBreakfastAll");
        this.fDinnerNum.addStyleName("sBreakfastNum");

        this.sBreakfastvly.addStyleName("fBreakfastvly");
        this.sBreakfastTitle.addStyleName("fBreakfastTitle");
        this.sBreakfastCheckbox.addStyleName("fBreakfastCheckbox");
        this.sBreakfastAll.addStyleName("fBreakfastAll");
        this.sBreakfastNum.addStyleName("sBreakfastNum");

        this.sLunchvly.addStyleName("fBreakfastvly");
        this.sLunchTitle.addStyleName("fBreakfastTitle");
        this.sLunchCheckbox.addStyleName("fBreakfastCheckbox");
        this.sLunchAll.addStyleName("fBreakfastAll");
        this.sLunchNum.addStyleName("sBreakfastNum");

        this.sDinnervly.addStyleName("fBreakfastvly");
        this.sDinnerTitle.addStyleName("fBreakfastTitle");
        this.sDinnerCheckbox.addStyleName("fBreakfastCheckbox");
        this.sDinnerAll.addStyleName("fBreakfastAll");
        this.sDinnerNum.addStyleName("sBreakfastNum");

        this.printBtn.addStyleName("printBtn");
    }

    private void buildView() {
        this.setCompositionRoot(mainvly);

        HorizontalLayout titlehly = new HorizontalLayout();
        titlehly.addComponents(title);
        mainvly.addComponents(titlehly, contenthsp);
        contenthsp.setFirstComponent(this.leftvly);
        contenthsp.setSecondComponent(this.rightvly);
        contenthsp.setLocked(true);
        contenthsp.setSplitPosition(15, Unit.PERCENTAGE);

        this.leftvly.addComponents(this.todayBtn, this.tomorrowBtn);

        this.rightvly.addComponents(this.rightContenthly, this.printBtn);
        this.rightContenthly.addComponents(fBreakfastvly, fLunchvly, fDinnervly);

        buildFoodvly(fBreakfastvly, this.fBreakfastTitle, this.fBreakfastCheckbox, this.fBreakfastAll, this.fBreakfastNum);
        buildFoodvly(fLunchvly, this.fLunchTitle, this.fLunchCheckbox, this.fLunchAll, this.fLunchNum);
        buildFoodvly(fDinnervly, this.fDinnerTitle, this.fDinnerCheckbox, this.fDinnerAll, this.fDinnerNum);
        buildFoodvly(this.sBreakfastvly, this.sBreakfastTitle, this.sBreakfastCheckbox, this.sBreakfastAll, this.sBreakfastNum);
        buildFoodvly(this.sLunchvly, this.sLunchTitle, this.sLunchCheckbox, this.sLunchAll, this.sLunchNum);
        buildFoodvly(this.sDinnervly, this.sDinnerTitle, this.sDinnerCheckbox, this.sDinnerAll, this.sDinnerNum);
    }

    private void buildFoodvly(VerticalLayout vly, Label title, WCheckBox checkbox, CheckBox all, Label num) {
        HorizontalLayout titlehly = new HorizontalLayout();
        VerticalLayout contentvly = new VerticalLayout();
        VerticalLayout checkvly = new VerticalLayout();
        titlehly.addComponent(title);
        titlehly.setWidth("100%");
        checkvly.setWidth("100%");
        contentvly.setWidth("100%");
        checkvly.addStyleName("checkvly");
        titlehly.addStyleName("titlehly");
        contentvly.addStyleName("checkcontentvly");
        HorizontalLayout bhly = new HorizontalLayout();
        HorizontalLayout bNumhly = new HorizontalLayout();
        checkvly.addComponent(checkbox);
        vly.addComponents(titlehly, contentvly);
        contentvly.addComponents(checkvly, bhly);
        contentvly.setComponentAlignment(bhly, Alignment.BOTTOM_CENTER);
        bhly.setWidth("100%");
        bhly.addComponents(all, bNumhly);
        bNumhly.addComponents(new Label("已选择"), num, new Label("个"));
        bhly.addStyleName("bhly");
        bNumhly.addStyleName("bNumhly");
    }

}
