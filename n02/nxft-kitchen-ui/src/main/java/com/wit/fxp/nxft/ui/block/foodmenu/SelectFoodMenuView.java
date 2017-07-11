package com.wit.fxp.nxft.ui.block.foodmenu;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.fxp.nxft.menu.model.MealScheDayModel;
import com.wit.fxp.nxft.ui.block.foodmenu.model.SelectFoodMenuVModel;

public interface SelectFoodMenuView extends View, Component {

    String NAME = "SelectFoodMenuView";

    String TITLE = "挑选套餐";

    void initView(SelectFoodMenuPresenter presenter);

    void refreshData(List<SelectFoodMenuVModel> data, List<MealScheDayModel> mealScheDay, Boolean isPublish);

}
