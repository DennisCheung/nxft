package com.wit.fxp.nxft.ui.usermain.block.notice;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

/**
 * 公告
 * @author wck
 *
 */
public interface KitchenNoticeView extends View, Component {

    String NAME = "KitchenNoticeView";

    void refreshData(String content);
}
