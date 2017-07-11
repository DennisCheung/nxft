package com.wit.fxp.nxft.ui.usermain.main;

import java.io.Serializable;
import java.util.List;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.wit.fxp.nxft.ui.KitchenViewName;
import com.wit.fxp.nxft.ui.usermain.TeamViewModel;
import com.wit.fxp.vaadin.ui.HorLabelAndLabel;

@PrototypeScope
@SpringView(name = KitchenViewName.KITCHEN_MAIN_VIEW_NAME)
public class KitchenUserMainViewImpl extends CustomComponent implements KitchenUserMainView, View, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 个人主页分为三块 上下 上面分为 左右 左边分为上下 下面分为左右
     */
    private final VerticalLayout mainvly = new VerticalLayout();

    private final VerticalSplitPanel mainVsp = new VerticalSplitPanel();
    private final VerticalSplitPanel mainTopVsp = new VerticalSplitPanel();
    private final HorizontalSplitPanel topHsp = new HorizontalSplitPanel();
    private final HorizontalLayout bottomhly = new HorizontalLayout();
    private final HorizontalLayout bottomInfo = new HorizontalLayout();
    private final Label suppliername = new Label("");
    private final Label supplier = new Label("");
    private final HorLabelAndLabel bianhao = new HorLabelAndLabel("编号", "");
    private final HorLabelAndLabel status = new HorLabelAndLabel("当前状态", "在线");
    private final MenuBar barMenu = new MenuBar();

    public KitchenUserMainViewImpl() {
        buildView();
        bind();
    }

    public void buildView() {
        addStyle();
        this.setCompositionRoot(mainvly);
        mainvly.addComponent(mainVsp);
        mainVsp.setFirstComponent(mainTopVsp);
        mainVsp.setSecondComponent(bottomInfo);
        mainTopVsp.setFirstComponent(topHsp);
        topHsp.setSecondComponent(bottomhly);
        bottomInfo.addComponents(suppliername, supplier, bianhao, status, barMenu);

    }

    public void bind() {

    }

    public void addStyle() {
        Page page = Page.getCurrent();
        if (page.getBrowserWindowWidth() > 1230) {
            mainVsp.setWidth(page.getBrowserWindowWidth() - 4 + "px");
        }
        else {
            mainVsp.setWidth("1356px");
        }
        mainVsp.setHeight(page.getBrowserWindowHeight() - 95 + "px");
        page.addBrowserWindowResizeListener(e -> {
            if (page.getBrowserWindowWidth() > 1230) {
                mainVsp.setWidth(page.getBrowserWindowWidth() - 4 + "px");
            }
            if (page.getBrowserWindowHeight() > 590) {
                mainVsp.setHeight(page.getBrowserWindowHeight() - 95 + "px");
            }
        });
        mainVsp.setSplitPosition(95, Unit.PERCENTAGE);
        mainVsp.setLocked(true);

        mainTopVsp.setSplitPosition(40, Unit.PERCENTAGE);
        mainTopVsp.setLocked(true);
        mainTopVsp.setSizeFull();

        topHsp.setSplitPosition(70, Unit.PERCENTAGE);
        topHsp.setLocked(true);
        topHsp.setSizeFull();

        bottomhly.setSizeFull();
        this.mainvly.addStyleName("usermainviewimpl");
        mainTopVsp.addStyleName("mainvsp");
        bottomInfo.addStyleName("bottominfo");
        barMenu.addStyleName("mainvspbarmenustytyly");
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void refreshView(Component shortCutMenu, Component workTips, Component notice) {
        topHsp.setFirstComponent(shortCutMenu);
        topHsp.setSecondComponent(notice);
        mainTopVsp.setSecondComponent(workTips);
    }

    @Override
    public void refreshLoginInfo(String userId, String nickName, String deptName) {
        suppliername.setValue(nickName);
        supplier.setValue("(" + deptName + ")");
        bianhao.getLbright().setValue(userId);
    }

    @Override
    public void initChangeSiteMenu(List<TeamViewModel> models, KitchenUserMainPresenter presenter) {
        barMenu.removeItems();
        MenuBar.MenuItem mainItem = barMenu.addItem("切换", null);
        models.forEach(e -> {
            mainItem.addItem(e.getName(), new MenuBar.Command() {
                private static final long serialVersionUID = 1L;

                @Override
                public void menuSelected(MenuItem selectedItem) {
                    presenter.refreshPage(e.getTeamId());
                }
            });
        });
    }

}
