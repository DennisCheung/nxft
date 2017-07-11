package com.wit.fxp.nxft.ui.block.foodmenu;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.fxp.nxft.menu.model.MealSetModel;

public interface ViewMealSetView extends View, Component {

    String NAME = "ViewMealSetView";

    String TITLE = "查看套餐";

    void initView(ViewMealSetPresenter presenter);

    void refreshData(MealSetModel mealSet);

}
