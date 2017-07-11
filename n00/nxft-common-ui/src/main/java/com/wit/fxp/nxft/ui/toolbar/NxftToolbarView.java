package com.wit.fxp.nxft.ui.toolbar;

import java.util.LinkedHashMap;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

public interface NxftToolbarView extends View, Component {

    String NAME = "ScToolbarView";

    void initView(NxftToolbarPresenter nxftAssistToolbarPresenter);

    void initMenu(LinkedHashMap<String, List<MenuItemViewModel>> vs);

}
