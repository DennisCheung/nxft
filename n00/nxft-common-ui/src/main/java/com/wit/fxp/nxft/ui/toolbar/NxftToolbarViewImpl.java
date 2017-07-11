package com.wit.fxp.nxft.ui.toolbar;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.wit.fxp.nxft.ui.NxftUI;

@UIScope
@SpringView(name = NxftToolbarView.NAME, ui = NxftUI.class)
public class NxftToolbarViewImpl extends CustomComponent implements NxftToolbarView, Serializable {

    private static final long serialVersionUID = -5363855376879829655L;

    private final HorizontalLayout mainLayout = new HorizontalLayout();
    private final HorizontalLayout centerLayout = new HorizontalLayout();
    private final Image imageFu = new Image();
    private final Image imageLine = new Image();
    private final Label projectTitle = new Label("数字化健康驿站管理系统");
    private final HorizontalLayout centerLeftLayout = new HorizontalLayout();
    private final HorizontalLayout centerCenterLayout = new HorizontalLayout();
    private final HorizontalLayout centerRightLayout = new HorizontalLayout();

    private final HorizontalLayout menuHly = new HorizontalLayout();

    private final Button logoutButton = new Button("退出登录");

    private void addStyle() {
        Page page = Page.getCurrent();
        int browserWindowWidth = page.getBrowserWindowWidth();
        if (browserWindowWidth > 1230) {
            this.mainLayout.setWidth(page.getBrowserWindowWidth() - 3 + "px");
            this.centerCenterLayout.setWidth(page.getBrowserWindowWidth() * 0.65 + "px");
        }
        else {
            this.mainLayout.setWidth("1366px");
            this.centerCenterLayout.setWidth("880px");
        }
        this.centerLayout.setWidth("100%");
        this.centerLayout.setHeight("100%");
        page.addBrowserWindowResizeListener(e -> {
            if (page.getBrowserWindowWidth() > 1230) {
                this.mainLayout.setWidth(page.getBrowserWindowWidth() - 3 + "px");
                this.centerCenterLayout.setWidth(page.getBrowserWindowWidth() * 0.65 + "px");
            }
        });
        this.mainLayout.setHeight("50px");
        this.mainLayout.addStyleName("sctoolbarview");
        this.centerLeftLayout.setWidth("200px");
        this.centerLeftLayout.addStyleName("centerleftlayout");
        this.centerCenterLayout.addStyleName("centercenterlayout");
        this.imageFu.setWidth("88px");
        this.imageFu.setHeight("30px");
        this.imageLine.setHeight("30px");
        this.logoutButton.addStyleName("logoutButtonstyle");
        this.logoutButton.setIcon(new ThemeResource("ico/退出登录.png"), "退出登录");
    }

    @Override
    public void initView(NxftToolbarPresenter scToolbarPresenter) {
        this.mainLayout.addComponent(this.centerLayout);
        buildCenterLayout();

        this.setCompositionRoot(mainLayout);

        addStyle();

        logoutButton.addClickListener(e -> {
            scToolbarPresenter.logout();
        });
    }

    private void buildCenterLayout() {
        HorizontalLayout mainver = new HorizontalLayout();
        this.centerLayout.addComponent(mainver);
        mainver.addComponents(this.centerLeftLayout, this.centerCenterLayout, this.centerRightLayout);
        mainver.setHeight("100%");
        centerRightLayout.setHeight("100%");
        this.centerLeftLayout.addComponent(imageFu);
        this.centerLeftLayout.addComponent(imageLine);
        this.imageFu.setSource(new ThemeResource("image/fu_logo_02.png"));
        this.imageLine.setSource(new ThemeResource("image/line.png"));
        this.centerCenterLayout.addComponent(projectTitle);
    }

    @Override
    public void initMenu(LinkedHashMap<String, List<MenuItemViewModel>> vs) {
        menuHly.setHeight("200px");
        menuHly.setWidth("400px");
        vs.keySet().forEach(e -> {
            VerticalLayout commonvly = new VerticalLayout();
            VerticalLayout commonContentvly = new VerticalLayout();
            Label label = new Label("<span style='font-weight:bold;'>" + e + "</span>", ContentMode.HTML);
            commonvly.addComponent(label);
            label.setWidthUndefined();
            commonvly.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
            commonvly.addComponent(commonContentvly);
            menuHly.addComponent(commonvly);
            vs.get(e).forEach(e1 -> {
                Button btn = new Button(e1.getMenuText(), f -> e1.getCmd().accept(e1.getMenuName()));
                btn.addStyleName(ValoTheme.BUTTON_LINK);
                commonContentvly.addComponent(btn);
                commonContentvly.setComponentAlignment(btn, Alignment.MIDDLE_CENTER);
            });
        });
        PopupView popupView = new PopupView("菜单", menuHly);
        popupView.addStyleName("menutoolbar");
        popupView.setHideOnMouseOut(true);
        this.centerRightLayout.addComponents(popupView);
        this.centerRightLayout.addComponents(logoutButton);
        this.centerRightLayout.setComponentAlignment(popupView, Alignment.MIDDLE_RIGHT);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}
