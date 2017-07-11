package com.wit.fxp.nxft.ui.usermain.block.shortcurmenu;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

/**
 * 常用功能 快捷菜单
 * @author wck
 *
 */
public interface MealShortCutMenuView extends View, Component {

    String NAME = "mealShortCutMenuView";

    void initView(MealShortCutMenuPresenter presenter);

}
