package com.wit.fxp.nxft.ui.block.foodmenu;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.fxp.nxft.compound.model.MealTypeModel;
import com.wit.fxp.nxft.menu.model.HbcDiseaseModel;
import com.wit.fxp.nxft.menu.model.MealSetModel;

public interface AddMealSetView extends View, Component {

    String NAME = "AddMealSetView";

    String TITLE = "新增套餐";

    void initView(AddMealSetPresenter presenter, boolean isEdit);

    void refreshData(MealSetModel mealSet);

    void initDict(List<HbcDiseaseModel> hbcDisease, List<MealTypeModel> mealTypeList);

}
