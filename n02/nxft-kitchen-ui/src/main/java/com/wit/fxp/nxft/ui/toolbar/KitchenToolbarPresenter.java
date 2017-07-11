package com.wit.fxp.nxft.ui.toolbar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.security.VaadinSecurity;

import com.vaadin.spring.annotation.UIScope;
import com.wit.fxp.nxft.MenuItemNames;
import com.wit.fxp.nxft.ui.toolbar.menuhandler.KitchenMenuHandler;
import com.wit.fxp.nxft.ui.toolbar.menuhandler.KitchenMenuHandlerManager;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;

@UIScope
@VaadinPresenter(viewName = KitchenToolbarView.NAME)
public class KitchenToolbarPresenter extends AbstractPresenter<KitchenToolbarView> {

    private final VaadinSecurity security;
    private final KitchenMenuHandlerManager menuHandlerManager;

    @Autowired
    public KitchenToolbarPresenter(EventBus.UIEventBus eventBus, KitchenToolbarView view, VaadinSecurity security, KitchenMenuHandlerManager menuHandlerManager) {
        super(eventBus, view);
        this.security = security;
        this.menuHandlerManager = menuHandlerManager;
    }

    public void postInit() {
        this.getView().initView(this);
        List<KCMenuItemViewModel> vs = toViewModel(getMenuData());
        this.getView().initMenu(vs);
    }

    public void logout() {
        this.security.logout();
    }

    private void onMenuClick(String menuName) {
        KitchenMenuHandler menuHandler = this.menuHandlerManager.getMenuHandler(menuName);
        menuHandler.handle(getView().getUI());
    }

    private List<KCMenuItemModel> getMenuData() {
        List<KCMenuItemModel> ms = new ArrayList<KCMenuItemModel>();
        ms.add(new KCMenuItemModel(MenuItemNames.配餐主界面菜单.订单汇总.name(), MenuItemNames.配餐主界面菜单.订单汇总.value()));
        ms.add(new KCMenuItemModel(MenuItemNames.配餐主界面菜单.菜谱管理.name(), MenuItemNames.配餐主界面菜单.菜谱管理.value()));
        ms.add(new KCMenuItemModel(MenuItemNames.配餐主界面菜单.订单管理.name(), MenuItemNames.配餐主界面菜单.订单管理.value()));
        ms.add(new KCMenuItemModel(MenuItemNames.配餐主界面菜单.配餐管理.name(), MenuItemNames.配餐主界面菜单.配餐管理.value()));
        return ms;
    }

    private List<KCMenuItemViewModel> toViewModel(List<KCMenuItemModel> ms) {
        List<KCMenuItemViewModel> vs = new ArrayList<KCMenuItemViewModel>();
        ms.forEach(e -> {
            vs.add(new KCMenuItemViewModel(e.getMenuText(), e.getMenuName(), t -> onMenuClick(t)));
        });
        return vs;
    }

}
