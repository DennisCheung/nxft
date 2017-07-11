package com.wit.fxp.nxft.ui.workbench;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

public interface WorkbenchView extends View, Component {

    /**
     * 初始化视图。
     *
     * @param grab
     * @param todo
     */
    void initView(Component grab, Component todo);

}
