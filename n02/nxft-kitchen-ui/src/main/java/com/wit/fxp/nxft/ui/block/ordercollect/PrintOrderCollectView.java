package com.wit.fxp.nxft.ui.block.ordercollect;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

public interface PrintOrderCollectView extends View, Component {

    String NAME = "PrintOrderCollectView";

    String TITLE = "打印订单汇总";

    void initView(PrintOrderCollectPresenter presenter);

    void viewPrint(String url);

}
