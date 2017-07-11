package com.wit.fxp.nxft.ui.block.recharge.moneylist;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

public interface MoneyListView extends View, Component {

    String NAME = "moneyListView";

    void initView(MoneyListPresenter presenter);

    void refreshView(List<MoneyListViewModel> models);

}
