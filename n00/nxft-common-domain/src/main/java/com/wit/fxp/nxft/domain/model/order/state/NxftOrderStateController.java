package com.wit.fxp.nxft.domain.model.order.state;

import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.DBC.助餐订单状态;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;
import com.wit.state.AbstractStateController;

/**
 * 状态控制器。本控制器登记了所有的状态对象，以及从一个状态到另一个状态的步进，
 * 并据此把实际的{@link NxftOrderOperations 操作}委托给对应的状态对象去处理。
 *
 * @author zqx
 *
 */
public class NxftOrderStateController extends AbstractStateController<DBC.助餐订单状态, DBC.助餐订单动作, AbstractNxftOrderState, NxftOrder> {

    public NxftOrder.NextNode generateNextNode(NxftOrder svcnote) {
        return getLastState(svcnote).generateNextNode(this, svcnote);
    }

    public NxftOrderOperations 派单(InvocationContext ic, Actor at, NxftOrder svcnote, String desc) {
        return getLastState(svcnote).派单(this, ic, at, svcnote, desc);
    }

    public NxftOrderOperations 接单(InvocationContext ic, Actor at, NxftOrder svcnote, String desc) {
        return getLastState(svcnote).接单(this, ic, at, svcnote, desc);
    }

    public NxftOrderOperations 配餐(InvocationContext ic, Actor at, NxftOrder svcnote, String desc) {
        return getLastState(svcnote).配送(this, ic, at, svcnote, desc);
    }

    public NxftOrderOperations 取消(InvocationContext ic, Actor at, NxftOrder svcnote, String desc) {
        return getLastState(svcnote).取消(this, ic, at, svcnote, desc);
    }

    @Override
    protected 助餐订单状态 getStateEnum(NxftOrder entity) {
        return DBC.助餐订单状态.valueOf(entity.getLastState().getLastState());
    }

    /*package*/AbstractNxftOrderState getLastState(NxftOrder svcnote) {
        AbstractNxftOrderState state = getStateObject(getStateEnum(svcnote));
        return state;
    }

}
