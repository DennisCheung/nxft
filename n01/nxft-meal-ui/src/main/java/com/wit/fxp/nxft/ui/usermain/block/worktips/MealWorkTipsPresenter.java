package com.wit.fxp.nxft.ui.usermain.block.worktips;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.annotation.EventBusListenerMethod;

import com.benewit.core.env.RuntimeContext;
import com.vaadin.spring.annotation.SpringComponent;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.app.ChartApp;
import com.wit.fxp.nxft.ui.block.recharge.event.RefreshChartEvent;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;

@PrototypeScope
@VaadinPresenter(viewName = MealWorkTipsView.NAME)
@SpringComponent
public class MealWorkTipsPresenter extends AbstractPresenter<MealWorkTipsView> {

    @Autowired private ChartApp app;
    @Autowired private UserSession userSession;
    @Autowired private RuntimeContext runtimeContext;

    @Autowired
    public MealWorkTipsPresenter(EventBus.UIEventBus eventBus, MealWorkTipsView view) {
        super(eventBus, view);
    }

    public void postInit() {
        getView().initView(this);
        refreshData();
    }

    public void refreshData() {
        Date now = runtimeContext.getCurrentDate();
        List<IdAndName> orderData = app.findChartOrders(userSession.getCircleId(), now);
        List<IdAndName> subjectData = app.findChartSubjects(userSession.getCircleId(), now);
        List<IdAndName> resourceData = app.findChartResources(userSession.getCircleId());
        getView().reDraw(orderData, subjectData, resourceData);
    }

    @EventBusListenerMethod
    void onRereshEvent(RefreshChartEvent event) {
        refreshData();
    }

}
