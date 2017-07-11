package com.wit.fxp.nxft.ui.usermain.block.shortcutmenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.nxft.ui.toolbar.menuhandler.MenuHandler;
import com.wit.fxp.nxft.ui.toolbar.menuhandler.MenuHandlerManager;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;

@PrototypeScope
@VaadinPresenter(viewName = ShortCutMenuView.NAME)
public class ShortCutMenuPresenter extends AbstractPresenter<ShortCutMenuView> {

    private final MenuHandlerManager menuHandlerManager;

    @Autowired
    public ShortCutMenuPresenter(EventBus.UIEventBus eventBus, ShortCutMenuView view, MenuHandlerManager menuHandlerManager) {
        super(eventBus, view);
        this.menuHandlerManager = menuHandlerManager;
    }

    public void postInit() {
        getView().initView(this);
    }

    public void onShortCurtButtonClick(String menuName) {
        MenuHandler menuHandler = this.menuHandlerManager.getMenuHandler(menuName);
        menuHandler.handle(getView().getUI());
    }

}
