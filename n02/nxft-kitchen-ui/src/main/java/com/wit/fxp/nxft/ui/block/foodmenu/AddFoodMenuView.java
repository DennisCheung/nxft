package com.wit.fxp.nxft.ui.block.foodmenu;

import java.util.Date;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.fxp.nxft.menu.model.MealScheDayModel;
import com.wit.fxp.nxft.menu.model.MealSchenoteModel;

public interface AddFoodMenuView extends View, Component {

    String NAME = "AddFoodMenuView";

    String TITLE = "新增菜谱";

    void initView(AddFoodMenuPresenter presenter);

    void initData(MealSchenoteModel mealSchenoteModel, AddFoodMenuPresenter presenter);

    void refreshData(List<MealScheDayModel> mealScheDay, Date mealDate, String mealTypeId);

    void refreshData(List<MealScheDayModel> mealSchedaySet);

}
