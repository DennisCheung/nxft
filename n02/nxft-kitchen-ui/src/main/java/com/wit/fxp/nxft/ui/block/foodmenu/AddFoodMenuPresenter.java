package com.wit.fxp.nxft.ui.block.foodmenu;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.annotation.EventBusListenerMethod;

import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.wit.fxp.nxft.menu.NxftMealSetApp;
import com.wit.fxp.nxft.menu.model.MealScheDayModel;
import com.wit.fxp.nxft.menu.model.MealSchenoteModel;
import com.wit.fxp.nxft.ui.block.event.RefreshMealNoteEvent;
import com.wit.fxp.nxft.ui.block.event.RefreshMealScheEvent;
import com.wit.fxp.ui.event.InstanceKey;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;

@PrototypeScope
@VaadinPresenter(viewName = AddFoodMenuView.NAME)
public class AddFoodMenuPresenter extends AbstractPresenter<AddFoodMenuView> {

    private final ApplicationContext applicationContext;
    private final UserSession userSession;
    private final NxftMealSetApp nxftMealSetApp;
    private MealSchenoteModel mealSchenoteModel;

    @InstanceKey
    private String userId;

    @InstanceKey
    private String mealSchenoteId;

    private boolean isAdd = true;

    @Autowired
    public AddFoodMenuPresenter(EventBus.UIEventBus eventBus, AddFoodMenuView view, ApplicationContext applicationContext,
            UserSession userSession, NxftMealSetApp nxftMealSetApp) {
        super(eventBus, view);
        this.applicationContext = applicationContext;
        this.userSession = userSession;
        this.nxftMealSetApp = nxftMealSetApp;
    }

    public void postInit(String schenoteId) {
        getView().initView(this);
        if (schenoteId != null && !"".equals(schenoteId)) {
            mealSchenoteModel = this.nxftMealSetApp.findMealSchenote(schenoteId);
            this.mealSchenoteId = mealSchenoteModel.getId();
            getView().initData(mealSchenoteModel, this);
            getView().refreshData(mealSchenoteModel.getMealSchedaySet());
            this.isAdd = false;
        }
        else {
            mealSchenoteModel = this.nxftMealSetApp.newMaxEndDate(this.userSession.getInvoker());
            this.mealSchenoteId = mealSchenoteModel.getId();
            getView().initData(mealSchenoteModel, this);
        }
    }

    public void selectMenu(Date mealDate, String mealTypeId) {
        SelectFoodMenuPresenter bean = this.applicationContext.getBean(SelectFoodMenuPresenter.class);
        bean.postInit(mealSchenoteModel.getId(), mealDate, mealTypeId);
        UI.getCurrent().addWindow((Window) bean.getView());
    }

    public void refreshScheMana(boolean isHasAddMealSet) {
        if (isAdd && !isHasAddMealSet) {
            this.nxftMealSetApp.deleteSchenote(mealSchenoteModel.getId());
        }
        else {
            if (isAdd) {
                this.getEventBus().publish(this, new RefreshMealScheEvent());
            }
        }
    }

    @EventBusListenerMethod
    public void on(RefreshMealNoteEvent event) {
        List<MealScheDayModel> mealScheDay = this.nxftMealSetApp.findMealScheDay(event.getMealSchenoteId(), event.getMealDate(), event.getMealTypeId());
        getView().refreshData(mealScheDay, event.getMealDate(), event.getMealTypeId());
    }

}
