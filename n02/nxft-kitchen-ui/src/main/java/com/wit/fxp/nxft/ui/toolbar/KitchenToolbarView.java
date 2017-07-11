package com.wit.fxp.nxft.ui.toolbar;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

public interface KitchenToolbarView extends View, Component {

    String NAME = "KitchenToolbarView";

    void initView(KitchenToolbarPresenter scToolbarPresenter);

    void initMenu(List<KCMenuItemViewModel> vs);
}
