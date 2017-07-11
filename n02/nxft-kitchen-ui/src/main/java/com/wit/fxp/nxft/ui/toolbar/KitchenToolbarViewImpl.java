package com.wit.fxp.nxft.ui.toolbar;

import java.io.Serializable;
import java.util.List;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.wit.fxp.nxft.ui.KitchenUI;

@UIScope
@SpringView(name = KitchenToolbarView.NAME, ui = KitchenUI.class)
public class KitchenToolbarViewImpl extends CustomComponent implements KitchenToolbarView, Serializable {

    private static final long serialVersionUID = -5363855376879829655L;

    private final HorizontalLayout mainLayout = new HorizontalLayout();
    private final HorizontalLayout centerLayout = new HorizontalLayout();
    private final Image imageFu = new Image();
    private final Image imageLine = new Image();
    private final Label projectTitle = new Label("健康助餐服务系统--厨房工作站");
    private final HorizontalLayout centerLeftLayout = new HorizontalLayout();
    private final HorizontalLayout centerCenterLayout = new HorizontalLayout();
    private final HorizontalLayout centerRightLayout = new HorizontalLayout();
    private final HorizontalSplitPanel contentLayout = new HorizontalSplitPanel();

    private final MenuBar barMenu = new MenuBar();

    private final Button logoutButton = new Button("退出登录");

    private void addStyle() {
        Page page = Page.getCurrent();
        int browserWindowWidth = page.getBrowserWindowWidth();
        this.centerLeftLayout.setWidth("200px");
        if (browserWindowWidth > 1230) {
            this.mainLayout.setWidth(page.getBrowserWindowWidth() - 3 + "px");
        }
        else {
            this.mainLayout.setWidth("1366px");
            this.centerCenterLayout.setWidth("880px");
        }
        this.contentLayout.setWidth("100%");
        page.addBrowserWindowResizeListener(e -> {
            if (page.getBrowserWindowWidth() > 1230) {
                this.mainLayout.setWidth(page.getBrowserWindowWidth() - 3 + "px");
            }
        });
        this.mainLayout.addStyleName("sctoolbarview");
        this.centerLeftLayout.addStyleName("centerleftlayout");
        this.centerCenterLayout.addStyleName("centercenterlayout");
        centerRightLayout.setWidth("100%");
        this.imageFu.setWidth("88px");
        this.imageFu.setHeight("30px");
        this.imageLine.setHeight("30px");
        this.logoutButton.addStyleName("logoutButtonstyle");
        this.contentLayout.setLocked(true);
//        this.logoutButton.setIcon(new ThemeResource("ico/退出登录.png"), "退出登录");
    }

    @Override
    public void initView(KitchenToolbarPresenter scToolbarPresenter) {
        this.mainLayout.addComponent(contentLayout);
        buildCenterLayout();

        this.setCompositionRoot(mainLayout);

        addStyle();

        logoutButton.addClickListener(e -> {
            scToolbarPresenter.logout();
        });
    }

    private void buildCenterLayout() {
        contentLayout.setFirstComponent(centerLayout);
        contentLayout.setSecondComponent(this.centerRightLayout);
        contentLayout.setSplitPosition(70f, Unit.PERCENTAGE);
        centerLayout.addComponents(this.centerLeftLayout, this.centerCenterLayout);
        this.centerLeftLayout.addComponent(imageFu);
        this.centerLeftLayout.addComponent(imageLine);
        this.imageFu.setSource(new ThemeResource("image/fu_logo_02.png"));
        this.imageLine.setSource(new ThemeResource("image/line.png"));
        this.centerCenterLayout.addComponent(projectTitle);
    }

    @Override
    public void initMenu(List<KCMenuItemViewModel> vs) {
        MenuBar.MenuItem mainItem = barMenu.addItem("菜单", null);
        vs.forEach(e -> mainItem.addItem(e.getMenuText(), f -> e.getCmd().accept(e.getMenuName())));
        HorizontalLayout rightwarp = new HorizontalLayout();
        rightwarp.addStyleName("rcrightwarp");
        rightwarp.addComponents(barMenu);
        rightwarp.addComponents(logoutButton);
        this.centerRightLayout.addComponent(rightwarp);
        this.centerRightLayout.setComponentAlignment(rightwarp, Alignment.MIDDLE_RIGHT);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}
