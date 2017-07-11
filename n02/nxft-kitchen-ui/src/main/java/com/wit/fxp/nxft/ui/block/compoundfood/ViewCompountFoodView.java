package com.wit.fxp.nxft.ui.block.compoundfood;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

public interface ViewCompountFoodView extends View, Component {

    String NAME = "ViewCompountFoodView";

    String TITLE = "查看配餐";

    void initView(ViewCompountFoodPresenter presenter);

}
