package com.wit.fxp.nxft.ui.block.foodmenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.vaadin.ui.Notification;
import com.wit.fxp.nxft.menu.NxftMealSetApp;
import com.wit.fxp.nxft.menu.model.AddMealSetCommand;
import com.wit.fxp.nxft.menu.model.MealSetModel;
import com.wit.fxp.nxft.ui.block.event.RefreshFoodMenuEvent;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;

@PrototypeScope
@VaadinPresenter(viewName = AddMealSetView.NAME)
public class AddMealSetPresenter extends AbstractPresenter<AddMealSetView> {

    private final NxftMealSetApp nxftMealSetApp;
    private final UserSession userSession;
    private Boolean isEdit = false;
    private String mealSetId;

    @Autowired
    public AddMealSetPresenter(EventBus.UIEventBus eventBus, AddMealSetView view, ApplicationContext applicationContext,
            NxftMealSetApp nxftMealSetApp, UserSession userSession) {
        super(eventBus, view);
        this.nxftMealSetApp = nxftMealSetApp;
        this.userSession = userSession;
    }

    public void postInit(Object parameters) {
        Object[] objs = (Object[]) parameters;
        isEdit = (Boolean) objs[0];
        getView().initView(this, isEdit);
        if (isEdit) {
            mealSetId = (String) objs[1];
            MealSetModel mealSet = this.nxftMealSetApp.findMealSet(mealSetId);
            getView().refreshData(mealSet);
        }
    }

    public void saveMealSet(AddMealSetCommand command) {
        command.setPhotoId(null); // 暂时不实现上传图片功能
        if (isEdit) {
            this.nxftMealSetApp.editMealSet(mealSetId, command);
        }
        else {
            this.nxftMealSetApp.addMealSet(this.userSession.getInvoker(), command);
        }
        Notification.show("保存套餐成功");
        this.getEventBus().publish(this, new RefreshFoodMenuEvent());
    }

}
