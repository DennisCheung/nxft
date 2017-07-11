package com.wit.fxp.nxft.ui.toolbar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.security.VaadinSecurity;

import com.vaadin.spring.annotation.UIScope;
import com.wit.fxp.nxft.MenuItemNames;
import com.wit.fxp.nxft.ui.toolbar.menuhandler.MealMenuHandler;
import com.wit.fxp.nxft.ui.toolbar.menuhandler.MealMenuHandlerManager;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;

@UIScope
@VaadinPresenter(viewName = MealToolbarView.NAME)
public class MealToolbarPresenter extends AbstractPresenter<MealToolbarView> {

    private final VaadinSecurity security;
    private final MealMenuHandlerManager menuHandlerManager;

    @Autowired
    public MealToolbarPresenter(EventBus.UIEventBus eventBus, MealToolbarView view, VaadinSecurity security, MealMenuHandlerManager menuHandlerManager) {
        super(eventBus, view);
        this.security = security;
        this.menuHandlerManager = menuHandlerManager;
    }

    public void postInit() {
        this.getView().initView(this);
        List<MealMenuItemViewModel> vs = toViewModel(getMenuData());
        this.getView().initMenu(vs);
    }

    public void logout() {
        this.security.logout();
    }

    private void onMenuClick(String menuName) {
        MealMenuHandler menuHandler = this.menuHandlerManager.getMealMenuHandler(menuName);
        menuHandler.handle(getView().getUI());
    }

    private List<MealMenuItemModel> getMenuData() {
        List<MealMenuItemModel> ms = new ArrayList<MealMenuItemModel>();
        ms.add(new MealMenuItemModel(MenuItemNames.助餐主界面菜单.对象管理.name(), MenuItemNames.助餐主界面菜单.对象管理.value()));
        ms.add(new MealMenuItemModel(MenuItemNames.助餐主界面菜单.订单管理.name(), MenuItemNames.助餐主界面菜单.订单管理.value()));
        ms.add(new MealMenuItemModel(MenuItemNames.助餐主界面菜单.充值.name(), MenuItemNames.助餐主界面菜单.充值.value()));
        return ms;
    }

    private List<MealMenuItemViewModel> toViewModel(List<MealMenuItemModel> ms) {
        List<MealMenuItemViewModel> vs = new ArrayList<MealMenuItemViewModel>();
        ms.forEach(e -> {
            vs.add(new MealMenuItemViewModel(e.getMenuText(), e.getMenuName(), t -> onMenuClick(t)));
        });
        return vs;
    }

}
