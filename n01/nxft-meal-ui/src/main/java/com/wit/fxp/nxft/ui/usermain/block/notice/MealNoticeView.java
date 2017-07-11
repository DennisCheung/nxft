package com.wit.fxp.nxft.ui.usermain.block.notice;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

/**
 * 公告
 * @author wck
 *
 */
public interface MealNoticeView extends View, Component {

    String NAME = "mealNoticeView";

    void refreshData(String content);
}
