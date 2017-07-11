package com.wit.fxp.nxft.ui.block.foodorder;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

public interface PrintFoodOrderView extends View, Component {

    String NAME = "PrintFoodOrderView";

    String TITLE = "打印订单";

    void initView(PrintFoodOrderPresenter presenter);

}
