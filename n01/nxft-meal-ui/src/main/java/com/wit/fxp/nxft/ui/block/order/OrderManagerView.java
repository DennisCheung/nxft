package com.wit.fxp.nxft.ui.block.order;

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
public interface OrderManagerView extends View, Component {

    String NAME = "orderManagerView";

    void initView(OrderManagerPresenter presenter);

    void refreshData(List<OrderViewModel> data);

    void refreshPageInfo(String total, int totalNum);

    void refreshSelectInfo(List<IdAndName> sites, List<IdAndName> subjectTypes, List<IdAndName> states);

}
