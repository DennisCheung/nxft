package com.wit.fxp.nxft.ui.block.foodmenu;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.fxp.nxft.ui.block.foodmenu.model.MealSetVModel;
import com.wit.fxp.nxft.ui.block.foodmenu.model.MenuFoodMenuVModel;

public interface FoodMenuView extends View, Component {

    String NAME = "FoodMenuView";

    String TITLE = "菜谱管理";

    void initView(FoodMenuPresenter presenter);

    void refreshData(List<MealSetVModel> data);

    void refreshPublishData(List<MenuFoodMenuVModel> data);

    void refresh();

    void refreshPublish();

}
