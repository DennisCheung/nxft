package com.wit.fxp.nxft.ui.usermain.block.shortcutmenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.nxft.ui.toolbar.menuhandler.KitchenMenuHandler;
import com.wit.fxp.nxft.ui.toolbar.menuhandler.KitchenMenuHandlerManager;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;

@PrototypeScope
@VaadinPresenter(viewName = KitchenShortCutMenuView.NAME)
public class KitchenShortCutMenuPresenter extends AbstractPresenter<KitchenShortCutMenuView> {

    private final KitchenMenuHandlerManager menuHandlerManager;

    @Autowired
    public KitchenShortCutMenuPresenter(EventBus.UIEventBus eventBus, KitchenShortCutMenuView view, KitchenMenuHandlerManager menuHandlerManager) {
        super(eventBus, view);
        this.menuHandlerManager = menuHandlerManager;
    }

    public void postInit() {
        getView().initView(this);
    }

    public void onShortCurtButtonClick(String menuName) {
        KitchenMenuHandler menuHandler = this.menuHandlerManager.getMenuHandler(menuName);
        menuHandler.handle(getView().getUI());
    }

}
