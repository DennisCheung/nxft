package com.wit.fxp.nxft.ui.block.foodorder;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.ui.block.foodorder.model.FoodOrderVModel;

public interface FoodOrderView extends View, Component {

    String NAME = "FoodOrderView";

    String TITLE = "订单管理";

    void initView(FoodOrderPresenter presenter);

    void refreshData(List<FoodOrderVModel> data);

    void refresh();

    void refreshDictData(List<IdAndName> deliveSites, List<IdAndName> subjectTypes);

}
