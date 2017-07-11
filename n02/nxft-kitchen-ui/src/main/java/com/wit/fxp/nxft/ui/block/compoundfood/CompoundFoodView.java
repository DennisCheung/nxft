package com.wit.fxp.nxft.ui.block.compoundfood;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.fxp.nxft.compound.model.MealTypeModel;
import com.wit.fxp.nxft.ui.block.compoundfood.model.CompountFoodVModel;

public interface CompoundFoodView extends View, Component {

    String NAME = "CompountFoodView";

    String TITLE = "配餐管理";

    void initView(CompoundFoodPresenter presenter);

    void refreshData(List<CompountFoodVModel> data);

    /**
     * 刷新配餐
     */
    void refresh();

    void initData(List<MealTypeModel> mealTypeList);

}
