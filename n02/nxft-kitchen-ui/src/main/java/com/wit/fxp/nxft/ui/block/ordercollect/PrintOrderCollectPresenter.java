package com.wit.fxp.nxft.ui.block.ordercollect;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.benewit.core.env.CurrentDate;
import com.wit.fxp.nxft.env.Nxft02Properties;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;
import com.wit.fxp.ui.workspace.AbstractPagePresenter;
import com.wit.fxp.ui.workspace.WorkspaceUtils;

@PrototypeScope
@VaadinPresenter(viewName = PrintOrderCollectView.NAME)
public class PrintOrderCollectPresenter extends AbstractPagePresenter<PrintOrderCollectView> {

    private final UserSession userSession;
    private final Nxft02Properties nxft02Properties;

    @Autowired
    public PrintOrderCollectPresenter(EventBus.UIEventBus eventBus, PrintOrderCollectView view, ApplicationContext applicationContext,
            UserSession userSession, Nxft02Properties nxft02Properties) {
        super(eventBus, view);
        this.userSession = userSession;
        this.nxft02Properties = nxft02Properties;
    }

    @Override
    public void initPage(Object parameters) {
        getView().initView(this);
        Date currentDate = new CurrentDate().getCurrentDate();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, 2);
    }

    public void print(Date begin, Date end, String mealTypeId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = String.format("%sNxftOrder.rptdesign&__format=pdf&beginTime=%s&endTime=%s&kitchenTeamId=%s&mealTypeId=%s",
                this.nxft02Properties.getNxftUrl(),
                dateFormat.format(begin), dateFormat.format(end), this.userSession.getTeamId(), mealTypeId);
        String url = this.nxft02Properties.getRootUrl() + format;
        getView().viewPrint(url);
    }

    public void closeView() {
        WorkspaceUtils.getNearMostWorkspace(getView()).closePage(getView());
    }

}
