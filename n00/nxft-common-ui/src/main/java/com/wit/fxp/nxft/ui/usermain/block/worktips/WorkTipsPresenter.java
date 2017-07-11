package com.wit.fxp.nxft.ui.usermain.block.worktips;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.vaadin.spring.annotation.SpringComponent;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.todo.TodoHandlerManager;

@PrototypeScope
@VaadinPresenter(viewName = WorkTipsView.NAME)
@SpringComponent
public class WorkTipsPresenter extends AbstractPresenter<WorkTipsView> {

    @Autowired
    public WorkTipsPresenter(EventBus.UIEventBus eventBus, WorkTipsView view,
            TodoHandlerManager handlerManager) {
        super(eventBus, view);
    }

    public void postInit() {
        getView().initView(this);
    }

    public void refreshData() {
    }

    public void openCustomerPage() {
    }

}
