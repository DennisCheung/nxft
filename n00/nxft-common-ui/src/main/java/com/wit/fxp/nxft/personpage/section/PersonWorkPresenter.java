package com.wit.fxp.nxft.personpage.section;

import com.vaadin.ui.Component;
import com.wit.fxp.nxft.personpage.PersonPagePresenter;

/**
 * 客户主页右边→_→相关业务页面Presenter接口
 * @author wck
 *
 */
public interface PersonWorkPresenter {

    void postInit(PersonPagePresenter personPagePresenter, String subjectId, Object params);

    Component getPersonView();
}
