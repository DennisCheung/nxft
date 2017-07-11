package com.wit.fxp.nxft.ui.toolbar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.security.VaadinSecurity;

import com.vaadin.spring.annotation.UIScope;
import com.wit.fxp.nxft.app.common.model.MenuItemModel;
import com.wit.fxp.nxft.ui.toolbar.menuhandler.MenuHandler;
import com.wit.fxp.nxft.ui.toolbar.menuhandler.MenuHandlerManager;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;

@UIScope
@VaadinPresenter(viewName = NxftToolbarView.NAME)
public class NxftToolbarPresenter extends AbstractPresenter<NxftToolbarView> {

    private final VaadinSecurity security;
    private final MenuHandlerManager menuHandlerManager;

    @Autowired
    public NxftToolbarPresenter(EventBus.UIEventBus eventBus, NxftToolbarView view, VaadinSecurity security, MenuHandlerManager menuHandlerManager) {
        super(eventBus, view);
        this.security = security;
        this.menuHandlerManager = menuHandlerManager;
    }

    public void postInit() {
        this.getView().initView(this);
        LinkedHashMap<String, List<MenuItemViewModel>> vs = toViewModel(getMenuData());
        this.getView().initMenu(vs);

    }

    public void logout() {
        this.security.logout();
    }

    private void onMenuClick(String menuName) {
        MenuHandler menuHandler = this.menuHandlerManager.getMenuHandler(menuName);
        menuHandler.handle(getView().getUI());
    }

    private LinkedHashMap<String, List<MenuItemModel>> getMenuData() {
        LinkedHashMap<String, List<MenuItemModel>> map = new LinkedHashMap<>();
        List<MenuItemModel> ms1 = new ArrayList<MenuItemModel>();
        List<MenuItemModel> ms2 = new ArrayList<MenuItemModel>();
        map.put("公共业务", ms1);
        map.put("理疗保健", ms2);
        return map;
    }

    private LinkedHashMap<String, List<MenuItemViewModel>> toViewModel(LinkedHashMap<String, List<MenuItemModel>> map) {
        LinkedHashMap<String, List<MenuItemViewModel>> viewMap = new LinkedHashMap<>();
        map.keySet().forEach(e -> {
            List<MenuItemViewModel> vs = new ArrayList<MenuItemViewModel>();
            map.get(e).forEach(e1 -> {
                vs.add(new MenuItemViewModel(e1.getMenuText(), e1.getMenuName(), t -> onMenuClick(t)));
            });
            viewMap.put(e, vs);
        });
        return viewMap;
    }

}
