package com.wit.fxp.nxft.ui.usermain.block.worktips;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.fxp.nxft.menu.model.DeliveNumModel;

/**
 * 工作提示
 * @author wck
 *
 */
public interface KitchenWorkTipsView extends View, Component {

    String NAME = "KitchenWorkTipsView";

    void initView(KitchenWorkTipsPresenter presenter);

    void refreshData(DeliveNumModel deliveNum);

}
