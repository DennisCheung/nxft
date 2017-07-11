package com.wit.fxp.nxft.ui.block.recharge.add;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

public interface RechargeView extends View, Component {

    String NAME = "rechargeView";

    void initView(RechargePresenter presenter);

    void refreshView(AddMoneyData data);
}
