package com.wit.fxp.nxft.ui.block.subject.show;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.app.model.SubjectModel;

public interface ShowSubjectView extends View, Component {

    String NAME = "showSubjectView";

    void initView(ShowSubjectPresenter presenter);

    void refreshDict(List<IdAndName> teams, List<IdAndName> types, List<IdAndName> diseases,
            List<IdAndName> livecon, List<IdAndName> govhelp, List<IdAndName> jinji, List<IdAndName> relations,
            List<IdAndName> fls);

    /**
     * 显示region
     */
    void showRegion(Component regionView);

    void refreshValue(SubjectModel model);

}
