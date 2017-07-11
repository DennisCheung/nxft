package com.wit.fxp.nxft.domain.model.order.state;

import org.springframework.stereotype.Component;

import com.wit.fxp.nxft.domain.model.order.NxftOrder;

@Component
public class 助餐订单初始状态 extends AbstractNxftOrderState {

    @Override
    public NxftOrder.NextNode generateNextNode(NxftOrderStateController stateController, NxftOrder svcnote) {
        throw new IllegalStateException("系统内部错，本方法应不被调用。");
    }

}
