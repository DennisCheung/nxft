package com.wit.fxp.nxft.ui.block.order.showorder;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.fxp.nxft.app.common.model.OrderModel;

public interface ShowOrderView extends View, Component {

    String NAME = "showOrderView";

    void initView(ShowOrderPresenter presenter);

    void refreshValue(OrderModel model);

}
