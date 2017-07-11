package com.wit.fxp.nxft.ui.block.foodorder;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.fxp.nxft.compound.model.NxftOrderDetailModel;

public interface ViewOrderView extends View, Component {

    String NAME = "ViewOrderView";

    String TITLE = "查看订单详情";

    void initView(ViewOrderPresenter presenter, NxftOrderDetailModel nxftOrder);

}
