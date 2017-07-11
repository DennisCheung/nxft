package com.wit.fxp.nxft.ui.usermain.block.shortcutmenu;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

/**
 * 常用功能 快捷菜单
 * @author qiuxu
 *
 */
public interface ShortCutMenuView extends View, Component {

    String NAME = "shortCutMenuView";

    void initView(ShortCutMenuPresenter presenter);

}
