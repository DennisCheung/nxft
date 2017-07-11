package com.wit.fxp.nxft.ui.block.foodorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.workspace.AbstractPagePresenter;

@PrototypeScope
@VaadinPresenter(viewName = PrintFoodOrderView.NAME)
public class PrintFoodOrderPresenter extends AbstractPagePresenter<PrintFoodOrderView> {

    @Autowired
    public PrintFoodOrderPresenter(EventBus.UIEventBus eventBus, PrintFoodOrderView view, ApplicationContext applicationContext) {
        super(eventBus, view);
    }

    @Override
    public void initPage(Object parameters) {
        getView().initView(this);
    }

}
