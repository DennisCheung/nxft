package com.wit.fxp.nxft.ui.toolbar;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

public interface MealToolbarView extends View, Component {

    String NAME = "mealToolbarView";

    void initView(MealToolbarPresenter scToolbarPresenter);

    void initMenu(List<MealMenuItemViewModel> vs);
}
