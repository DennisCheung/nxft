package com.wit.fxp.nxft.ui.usermain.block.notice;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

/**
 * 公告
 * @author qiuxu
 *
 */
public interface NoticeView extends View, Component {

    String NAME = "noticeView";

    void refreshData(String content);
}
