package com.wit.fxp.nxft.ui.usermain.block.worktips;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

/**
 * 工作提示
 * @author wck
 *
 */
public interface WorkTipsView extends View, Component {

    String NAME = "workTipsView";

    void initView(WorkTipsPresenter presenter);

    void refreshData(WorkTipsModel workTipsModel);

}
