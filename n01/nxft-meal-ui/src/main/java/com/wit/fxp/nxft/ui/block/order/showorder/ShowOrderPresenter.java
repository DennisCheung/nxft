package com.wit.fxp.nxft.ui.block.order.showorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.nxft.app.SubjecctApp;
import com.wit.fxp.nxft.app.common.model.OrderModel;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;

@PrototypeScope
@VaadinPresenter(viewName = ShowOrderView.NAME)
public class ShowOrderPresenter extends AbstractPresenter<ShowOrderView> {

    @Autowired private SubjecctApp app;

    private String subjectId;

    @Autowired
    public ShowOrderPresenter(EventBus.UIEventBus eventBus, ShowOrderView view) {
        super(eventBus, view);
    }

    public void postInit(String subjectId) {
        getView().initView(this);
        this.subjectId = subjectId;
        showValue();
    }

    public void showValue() {
        OrderModel model = app.findOrderModel(subjectId);
        getView().refreshValue(model);

    }

}
