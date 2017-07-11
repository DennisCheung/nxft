package com.wit.fxp.nxft.ui.block.foodmenu;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.vaadin.ui.CheckBox;
import com.wit.fxp.nxft.menu.NxftMealSetApp;
import com.wit.fxp.nxft.menu.model.AddMealScheDayCommand;
import com.wit.fxp.nxft.menu.model.MealScheDayModel;
import com.wit.fxp.nxft.menu.model.MealSchenoteModel;
import com.wit.fxp.nxft.menu.model.MealSetModel;
import com.wit.fxp.nxft.ui.block.event.RefreshMealNoteEvent;
import com.wit.fxp.nxft.ui.block.foodmenu.model.SelectFoodMenuVModel;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;

@PrototypeScope
@VaadinPresenter(viewName = SelectFoodMenuView.NAME)
public class SelectFoodMenuPresenter extends AbstractPresenter<SelectFoodMenuView> {

    private final UserSession userSession;
    private final NxftMealSetApp nxftMealSetApp;
    private String mealSchenoteId;
    private Date mealDate;
    private String mealTypeId;
    private List<MealScheDayModel> mealScheDay;
    private MealSchenoteModel mealSchenote;

    @Autowired
    public SelectFoodMenuPresenter(EventBus.UIEventBus eventBus, SelectFoodMenuView view, ApplicationContext applicationContext,
            UserSession userSession, NxftMealSetApp nxftMealSetApp) {
        super(eventBus, view);
        this.userSession = userSession;
        this.nxftMealSetApp = nxftMealSetApp;
    }

    public void postInit(String mealSchenoteId, Date mealDate, String mealTypeId) {
        this.mealSchenoteId = mealSchenoteId;
        this.mealDate = mealDate;
        this.mealTypeId = mealTypeId;
        getView().initView(this);
        List<MealSetModel> mealSet = this.nxftMealSetApp.findMealSetList(this.userSession.getTeamId());
        mealSchenote = this.nxftMealSetApp.findMealSchenote(mealSchenoteId);
        DecimalFormat df = new DecimalFormat("########0.00");
        List<SelectFoodMenuVModel> collect = mealSet.stream().map(e -> {
            Integer pepperyLevel = e.getPepperyLevel();
            String pungentName = null;
            if (pepperyLevel != null) {
                pungentName = pepperyLevel == 1 ? "有辣" : "无辣";
            }
            else {
                pungentName = null;
            }
            CheckBox checkbox = new CheckBox();
            return SelectFoodMenuVModel.builder()
                        ._id________________(null)
                        ._mealId____________(e.getId())
                        ._checkbox__________(checkbox)
                        ._mealSetNo_________(e.getMealCode())
                        ._mealSetName_______(e.getMealName())
                        ._mealSetContent____(e.getMealContent())
                        ._price_____________(df.format(e.getMealPrice()))
                        ._pungent___________(pungentName)
                        ._mealSetDesc_______(e.getMealDesc())
                        ._build_();
        })
                .collect(Collectors.toList());
        mealScheDay = this.nxftMealSetApp.findMealScheDay(mealSchenoteId, mealDate, mealTypeId);
        getView().refreshData(collect, mealScheDay, mealSchenote.getPublishInfo().getIsPublished());
    }

    public void editMealScheDay(List<String> ids) {
        AddMealScheDayCommand command = AddMealScheDayCommand.builder()
                ._mealSchenoteId____(this.mealSchenoteId)
                ._mealTypeId________(this.mealTypeId)
                ._mealDate__________(this.mealDate)
                ._mealIds___________(ids)
                ._build_();
        this.nxftMealSetApp.editMealScheDays(command);

        getEventBus().publish(this, new RefreshMealNoteEvent(this.userSession.getUserId(), this.mealSchenoteId, this.mealDate, this.mealTypeId));
    }

    public void searchMealSetList(String searchValue) {
        List<MealSetModel> mealSet = this.nxftMealSetApp.findMealSetList(this.userSession.getTeamId(), searchValue);
        DecimalFormat df = new DecimalFormat("########0.00");
        List<SelectFoodMenuVModel> collect = mealSet.stream().map(e -> {
            Integer pepperyLevel = e.getPepperyLevel();
            String pungentName = null;
            if (pepperyLevel != null) {
                pungentName = pepperyLevel == 1 ? "有辣" : "无辣";
            }
            else {
                pungentName = null;
            }
            CheckBox checkbox = new CheckBox();
            return SelectFoodMenuVModel.builder()
                        ._id________________(null)
                        ._mealId____________(e.getId())
                        ._checkbox__________(checkbox)
                        ._mealSetNo_________(e.getMealCode())
                        ._mealSetName_______(e.getMealName())
                        ._mealSetContent____(e.getMealContent())
                        ._price_____________(df.format(e.getMealPrice()))
                        ._pungent___________(pungentName)
                        ._mealSetDesc_______(e.getMealDesc())
                        ._build_();
        })
                .collect(Collectors.toList());
        getView().refreshData(collect, mealScheDay, mealSchenote.getPublishInfo().getIsPublished());
    }

}
