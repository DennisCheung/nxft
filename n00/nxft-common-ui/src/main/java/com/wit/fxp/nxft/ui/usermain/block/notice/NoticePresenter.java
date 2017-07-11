package com.wit.fxp.nxft.ui.usermain.block.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;

@PrototypeScope
@VaadinPresenter(viewName = NoticeView.NAME)
public class NoticePresenter extends AbstractPresenter<NoticeView> {

    @Autowired
    public NoticePresenter(EventBus.UIEventBus eventBus, NoticeView view) {
        super(eventBus, view);
    }

    public void refreshData() {
        String content = "通知：本周五（2015-10-23）全体员工在大会议室参加业务培训，请准时出席。";
        getView().refreshData(content);
    }

}
