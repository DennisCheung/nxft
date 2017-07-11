package com.wit.fxp.nxft.ui.usermain.block.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.nxft.app.AddOrderApp;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;

@PrototypeScope
@VaadinPresenter(viewName = KitchenNoticeView.NAME)
public class KitchenNoticePresenter extends AbstractPresenter<KitchenNoticeView> {

    @Autowired private AddOrderApp app;
    @Autowired private UserSession userSession;

    @Autowired
    public KitchenNoticePresenter(EventBus.UIEventBus eventBus, KitchenNoticeView view) {
        super(eventBus, view);
    }

    public void refreshData() {
        String content = app.findUpdateContent(userSession.getApplicationId());
        getView().refreshData(content);
    }

}
