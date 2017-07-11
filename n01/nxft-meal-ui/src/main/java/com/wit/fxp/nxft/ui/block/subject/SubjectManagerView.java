package com.wit.fxp.nxft.ui.block.subject;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.datatype.IdAndName;

/**
 * 客户名册管理。
 *
 * @author qiuxu
 *
 */
public interface SubjectManagerView extends View, Component {

    String NAME = "subjectManagerView";

    void initView(SubjectManagerPresenter presenter);

    void refreshData(List<SubjectViewModel> data);

    void refreshPageInfo(String total, int totalNum);

    void refreshTeams(List<IdAndName> teams);

}
