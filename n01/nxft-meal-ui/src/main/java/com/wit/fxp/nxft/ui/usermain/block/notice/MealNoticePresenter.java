package com.wit.fxp.nxft.ui.usermain.block.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.nxft.app.AddOrderApp;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;

@PrototypeScope
@VaadinPresenter(viewName = MealNoticeView.NAME)
public class MealNoticePresenter extends AbstractPresenter<MealNoticeView> {

    @Autowired private AddOrderApp app;
    @Autowired private UserSession userSession;

    @Autowired
    public MealNoticePresenter(EventBus.UIEventBus eventBus, MealNoticeView view) {
        super(eventBus, view);
    }

    public void refreshData() {
        String content = app.findUpdateContent(userSession.getApplicationId());
        getView().refreshData(content);
    }

}
