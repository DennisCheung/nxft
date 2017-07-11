package com.wit.fxp.nxft.ui.block.recharge;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

/**
 * 充值管理。
 *
 * @author qiuxu
 *
 */
public interface RechargeManagerView extends View, Component {

    String NAME = "rechargeManagerView";

    void initView(RechargeManagerPresenter presenter);

    void refreshData(List<RechargeViewModel> data);

    void refreshPageInfo(String total, int totalNum);

    void setBtn();

}
