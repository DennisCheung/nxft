package com.wit.fxp.nxft.ui.block.compoundfood;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.nxft.paging.PagingInfo;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;

@PrototypeScope
@VaadinPresenter(viewName = ViewCompountFoodView.NAME)
public class ViewCompountFoodPresenter extends AbstractPresenter<ViewCompountFoodView> {

    @Autowired
    public ViewCompountFoodPresenter(EventBus.UIEventBus eventBus, ViewCompountFoodView view, ApplicationContext applicationContext) {
        super(eventBus, view);
    }

    public void postInit() {
        getView().initView(this);
    }

    public void refreshData(Date beginTime, Date endTime, String subjectName, PagingInfo pageInfo) {
    }

}
