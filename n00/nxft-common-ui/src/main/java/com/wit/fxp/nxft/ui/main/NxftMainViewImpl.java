package com.wit.fxp.nxft.ui.main;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.wit.fxp.nxft.ui.NxftUI;
import com.wit.fxp.nxft.ui.ViewName;
import com.wit.fxp.ui.workspace.WorkspaceUtils;
import com.wit.fxp.ui.workspace.page.DefaultPageContext;

@UIScope
@SpringView(name = NxftMainView.NAME, ui = NxftUI.class)
public class NxftMainViewImpl extends Panel implements NxftMainView {

    private static final long serialVersionUID = -5941154160163963189L;

    private final VerticalLayout main = new VerticalLayout();
    private final VerticalLayout top = new VerticalLayout();
    private final VerticalLayout bottom = new VerticalLayout();

    public NxftMainViewImpl() {
        setContent(main);
        main.addComponents(top, bottom);
    }

    @Override
    public void buildLayout(Component toolbar, Component workspace) {
        top.addComponent(toolbar);
        bottom.addComponent(workspace);
        addStyle();
    }

    @Override
    public void enter(ViewChangeEvent event) {
        //默认打开操作员主页和工作台
        WorkspaceUtils.getMainWorkspace(getUI()).openPage(DefaultPageContext.builder()
                ._viewName__________(ViewName.SUPPLIER_MAIN_VIEW_NAME)
                ._key_______________("")
                ._title_____________("我的主页")
                ._initParameters____(null)
                ._toReInitOnSwitch__(false)
                ._closable__________(false)
                ._build_());
    }

    public void addStyle() {
        this.setStyleName("scmainstyle");
        this.setSizeUndefined();
        Page page = Page.getCurrent();
        if (page.getBrowserWindowWidth() > 1230) {
            this.setWidth(page.getBrowserWindowWidth() + "px");
        }
        else {
            this.setWidth("1366px");
        }
        if (page.getBrowserWindowHeight() > 590) {
            this.setHeight(page.getBrowserWindowHeight() + "px");
        }
        else {
            this.setHeight("640px");
        }
        page.addBrowserWindowResizeListener(e -> {
            if (page.getBrowserWindowWidth() > 1230) {
                this.setWidth(page.getBrowserWindowWidth() + "px");
            }
            if (page.getBrowserWindowHeight() > 590) {
                this.setHeight(page.getBrowserWindowHeight() + "px");
            }
        });
    }

}
