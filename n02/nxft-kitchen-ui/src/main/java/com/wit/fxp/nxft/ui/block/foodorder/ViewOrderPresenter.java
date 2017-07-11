package com.wit.fxp.nxft.ui.block.foodorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.nxft.compound.NxftCompoundApp;
import com.wit.fxp.nxft.compound.model.NxftOrderDetailModel;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;

@PrototypeScope
@VaadinPresenter(viewName = ViewOrderView.NAME)
public class ViewOrderPresenter extends AbstractPresenter<ViewOrderView> {

    private final NxftCompoundApp nxftCompoundApp;

    @Autowired
    public ViewOrderPresenter(EventBus.UIEventBus eventBus, ViewOrderView view, ApplicationContext applicationContext,
            NxftCompoundApp nxftCompoundApp) {
        super(eventBus, view);
        this.nxftCompoundApp = nxftCompoundApp;
    }

    public void postInit(String orderId) {
        NxftOrderDetailModel nxftOrder = this.nxftCompoundApp.findNxftOrder(orderId);
        getView().initView(this, nxftOrder);
    }

}
