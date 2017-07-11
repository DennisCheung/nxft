package com.wit.fxp.nxft.ui.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.annotation.EventBusListenerMethod;

import com.vaadin.spring.annotation.UIScope;
import com.wit.fxp.nxft.ui.NxftKitchenMainPresenterBean;
import com.wit.fxp.nxft.ui.toolbar.KitchenToolbarPresenter;
import com.wit.fxp.ui.event.StartupEvent;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.workspace.HasWorkspacePresenter;
import com.wit.fxp.ui.workspace.WorkspacePresenter;

@UIScope
@VaadinPresenter(viewName = KitchenMainView.NAME)
@NxftKitchenMainPresenterBean
public class KitchenMainPresenter extends AbstractPresenter<KitchenMainView> implements HasWorkspacePresenter {

    private final KitchenToolbarPresenter toolPresenter;
    private final WorkspacePresenter workspacePresenter;

    @Autowired
    public KitchenMainPresenter(EventBus.UIEventBus eventBus, KitchenMainView view, WorkspacePresenter workspacePresenter,
            KitchenToolbarPresenter toolPresenter) {
        super(eventBus, view);
        this.workspacePresenter = workspacePresenter;
        this.toolPresenter = toolPresenter;
    }

    @EventBusListenerMethod
    public void onStartup(StartupEvent e) {
        this.toolPresenter.postInit();
        getView().buildLayout(toolPresenter.getView(), workspacePresenter.getView());
    }

    @Override
    public WorkspacePresenter getWorkspacePresenter() {
        return workspacePresenter;
    }

}
