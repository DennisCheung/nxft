package com.wit.fxp.nxft.ui.usermain.block.worktips;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.datatype.IdAndName;

/**
 * 工作提示
 * @author wck
 *
 */
public interface MealWorkTipsView extends View, Component {

    String NAME = "mealWorkTipsView";

    void initView(MealWorkTipsPresenter presenter);

    void reDraw(List<IdAndName> orderData, List<IdAndName> subjectData, List<IdAndName> resourceData);

}
