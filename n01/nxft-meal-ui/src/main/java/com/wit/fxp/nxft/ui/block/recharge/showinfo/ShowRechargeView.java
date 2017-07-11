package com.wit.fxp.nxft.ui.block.recharge.showinfo;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

public interface ShowRechargeView extends View, Component {

    String NAME = "ShowRechargeView";

    void initView(ShowRechargePresenter presenter);

    void refreshView(List<ShowRechargeViewModel> models);

}
