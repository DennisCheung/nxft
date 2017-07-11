package com.wit.fxp.nxft.ui.block.subject.add;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.datatype.IdAndName;
import com.wit.fxp.ui.regionalism.RegionalismPresenter;

public interface AddSubjectView extends View, Component {

    String NAME = "addSubjectView";

    void initView(AddSubjectPresenter presenter, RegionalismPresenter regPresenter);

    void refreshDict(List<IdAndName> teams, List<IdAndName> types, List<IdAndName> diseases,
            List<IdAndName> livecon, List<IdAndName> govhelp, List<IdAndName> jinji, List<IdAndName> relations,
            List<IdAndName> foodLoves);

    /**
     * 显示region
     */
    void showRegion(Component regionView);

}
