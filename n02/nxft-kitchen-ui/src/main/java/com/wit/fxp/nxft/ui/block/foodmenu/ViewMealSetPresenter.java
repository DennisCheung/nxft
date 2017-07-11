package com.wit.fxp.nxft.ui.block.foodmenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.nxft.menu.NxftMealSetApp;
import com.wit.fxp.nxft.menu.model.MealSetModel;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;

@PrototypeScope
@VaadinPresenter(viewName = ViewMealSetView.NAME)
public class ViewMealSetPresenter extends AbstractPresenter<ViewMealSetView> {

    private final NxftMealSetApp nxftMealSetApp;

    @Autowired
    public ViewMealSetPresenter(EventBus.UIEventBus eventBus, ViewMealSetView view, ApplicationContext applicationContext,
            NxftMealSetApp nxftMealSetApp) {
        super(eventBus, view);
        this.nxftMealSetApp = nxftMealSetApp;
    }

    public void postInit(Object parameters) {
        String id = (String) parameters;
        MealSetModel mealSet = this.nxftMealSetApp.findMealSet(id);
        getView().initView(this);
        getView().refreshData(mealSet);
    }

}
