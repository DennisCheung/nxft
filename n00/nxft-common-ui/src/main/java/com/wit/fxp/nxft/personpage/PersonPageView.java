package com.wit.fxp.nxft.personpage;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.fxp.nxft.ui.ViewName;

public interface PersonPageView extends View, Component {

    String NAME = ViewName.PERSON_MAIN_PAGE;

    String TITLE = "客户主页";

    void initView(PersonPagePresenter presenter, String subjectId);

    void setBottomRight(Component component);

    void refreshData();

    void setPersonInfoShowView(Component personView);

    void selectSfNote(String sfNoteId);

}
