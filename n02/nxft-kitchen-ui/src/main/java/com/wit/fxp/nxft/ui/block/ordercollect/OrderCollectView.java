package com.wit.fxp.nxft.ui.block.ordercollect;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.fxp.nxft.compound.model.NxftOrderCollectModel;

public interface OrderCollectView extends View, Component {

    String NAME = "OrderCollectView";

    String TITLE = "订单汇总";

    void initView(OrderCollectPresenter presenter);

    void initData(List<NxftOrderCollectModel> nxftOrder);

}
