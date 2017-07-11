package com.wit.fxp.nxft.ui.usermain.block.shortcurmenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.nxft.ui.toolbar.menuhandler.MealMenuHandler;
import com.wit.fxp.nxft.ui.toolbar.menuhandler.MealMenuHandlerManager;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;

@PrototypeScope
@VaadinPresenter(viewName = MealShortCutMenuView.NAME)
public class MealShortCutMenuPresenter extends AbstractPresenter<MealShortCutMenuView> {

    private final MealMenuHandlerManager menuHandlerManager;

    @Autowired
    public MealShortCutMenuPresenter(EventBus.UIEventBus eventBus, MealShortCutMenuView view, MealMenuHandlerManager menuHandlerManager) {
        super(eventBus, view);
        this.menuHandlerManager = menuHandlerManager;
    }

    public void postInit() {
        getView().initView(this);
    }

    public void onShortCurtButtonClick(String menuName) {
        MealMenuHandler menuHandler = this.menuHandlerManager.getMealMenuHandler(menuName);
        menuHandler.handle(getView().getUI());
    }

}
