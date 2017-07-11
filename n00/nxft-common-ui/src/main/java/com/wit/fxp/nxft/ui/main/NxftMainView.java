package com.wit.fxp.nxft.ui.main;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

/**
 * 中心系统主界面
 * @author qiuxu
 *
 */
public interface NxftMainView extends View, Component {

    String NAME = "";

    /**
     *
     * @param toolbar 顶部信息，菜单显示
     * @param workspace 工作台及其他显示
     */
    void buildLayout(Component toolbar, Component workspace);

}
