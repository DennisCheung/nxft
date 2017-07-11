package com.wit.fxp.nxft.personpage.section;

import com.vaadin.ui.Component;
import com.wit.fxp.nxft.personpage.PersonPagePresenter;

/**
 * 客户主页根据点击左边导航显示界面
 * @author wck
 *
 */
public interface PersonPageInfoHandler {

    String viewName();

    Component handle(PersonPagePresenter personPagePresenter, String subjectId, Object params);

}
