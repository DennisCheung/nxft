package com.wit.fxp.nxft.ui.block.ordercollect;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.benewit.core.env.CurrentDate;
import com.vaadin.ui.UI;
import com.wit.fxp.nxft.compound.NxftCompoundApp;
import com.wit.fxp.nxft.compound.model.NxftOrderCollectModel;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;
import com.wit.fxp.ui.workspace.AbstractPagePresenter;
import com.wit.fxp.ui.workspace.WorkspaceUtils;
import com.wit.fxp.ui.workspace.page.DefaultPageContext;

@PrototypeScope
@VaadinPresenter(viewName = OrderCollectView.NAME)
public class OrderCollectPresenter extends AbstractPagePresenter<OrderCollectView> {

    private final UserSession userSession;
    private final NxftCompoundApp nxftCompoundApp;

    @Autowired
    public OrderCollectPresenter(EventBus.UIEventBus eventBus, OrderCollectView view,
            UserSession userSession, NxftCompoundApp nxftCompoundApp) {
        super(eventBus, view);
        this.userSession = userSession;
        this.nxftCompoundApp = nxftCompoundApp;
    }

    @Override
    public void initPage(Object parameters) {
        getView().initView(this);
        Date currentDate = new CurrentDate().getCurrentDate();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, 2);
        List<NxftOrderCollectModel> nxftOrder = this.nxftCompoundApp.findNxftOrder(this.userSession.getTeamId(),
                currentDate, calendar.getTime());
        getView().initData(nxftOrder);
    }

    public void printOrder() {
        WorkspaceUtils.getMainWorkspace(UI.getCurrent()).openPage(DefaultPageContext.builder()
                ._viewName__________(PrintOrderCollectView.NAME)
                ._key_______________(PrintOrderCollectView.NAME)
                ._title_____________(PrintOrderCollectView.TITLE)
                ._initParameters____(null)
                ._toReInitOnSwitch__(false)
                ._closable__________(true)
                ._build_());
    }

}
