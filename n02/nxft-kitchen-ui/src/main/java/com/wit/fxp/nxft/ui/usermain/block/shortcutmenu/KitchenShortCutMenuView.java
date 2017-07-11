package com.wit.fxp.nxft.ui.usermain.block.shortcutmenu;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

/**
 * 常用功能 快捷菜单
 * @author wck
 *
 */
public interface KitchenShortCutMenuView extends View, Component {

    String NAME = "KitchenShortCutMenuView";

    void initView(KitchenShortCutMenuPresenter presenter);

}
