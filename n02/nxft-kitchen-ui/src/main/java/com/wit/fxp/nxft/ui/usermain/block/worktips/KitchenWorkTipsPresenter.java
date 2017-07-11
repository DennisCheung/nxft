package com.wit.fxp.nxft.ui.usermain.block.worktips;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.vaadin.spring.annotation.SpringComponent;
import com.wit.fxp.nxft.compound.NxftCompoundApp;
import com.wit.fxp.nxft.menu.model.DeliveNumModel;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.todo.TodoHandlerManager;
import com.wit.fxp.ui.user.UserSession;

@PrototypeScope
@VaadinPresenter(viewName = KitchenWorkTipsView.NAME)
@SpringComponent
public class KitchenWorkTipsPresenter extends AbstractPresenter<KitchenWorkTipsView> {

    private final NxftCompoundApp nxftCompoundApp;
    private final UserSession userSession;

    @Autowired
    public KitchenWorkTipsPresenter(EventBus.UIEventBus eventBus, KitchenWorkTipsView view,
            TodoHandlerManager handlerManager, NxftCompoundApp nxftCompoundApp, UserSession userSession) {
        super(eventBus, view);
        this.nxftCompoundApp = nxftCompoundApp;
        this.userSession = userSession;
    }

    public void postInit() {
        getView().initView(this);
    }

    public void refreshData() {
        DeliveNumModel deliveNum = this.nxftCompoundApp.findDeliveNum(this.userSession.getTeamId());
        getView().refreshData(deliveNum);
    }

}
