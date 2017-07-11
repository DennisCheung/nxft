package com.wit.fxp.nxft.personpage.section;

import com.vaadin.ui.UI;
import com.wit.fxp.nxft.ui.ViewName;
import com.wit.fxp.ui.workspace.WorkspaceUtils;
import com.wit.fxp.ui.workspace.page.DefaultPageContext;

public class PersonPageUtils {

    public static final String SFTYPE = "sfopen";

    public static void openPersonPage(PersonPageRightPartEvent event, String... openType) {
        PersonPageRightPartParams params = PersonPageRightPartParams.builder()
                ._subjectId_____________(event.getSubjectId())
                ._params________________(event.getParams())
                ._personWorkPresenter___(event.getPersonWorkPresenter())
                ._openType______________(openType.length == 0 ? null : openType[0])
                ._build_();
        WorkspaceUtils.getMainWorkspace(UI.getCurrent()).openPage(DefaultPageContext.builder()
                ._viewName__________(ViewName.PERSON_MAIN_PAGE)
                ._key_______________(event.getKey() + event.getPersonWorkPresenter().getClass().getSimpleName())
                ._title_____________(event.getViewTitle())
                ._initParameters____(params)
                ._toReInitOnSwitch__(false)
                ._closable__________(true)
                ._build_());
    }
}
