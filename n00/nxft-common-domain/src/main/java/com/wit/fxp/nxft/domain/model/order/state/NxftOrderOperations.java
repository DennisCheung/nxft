package com.wit.fxp.nxft.domain.model.order.state;

import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;

/**
 * 操作。本接口定义了各状态所有可能的操作，某些操作可能只在某种状态下才允许执行。
 *
 * @author zqx
 *
 */
public interface NxftOrderOperations {

    /**
     * 生成下一环节
     * @param feedback
     * @return
     */
    NxftOrder.NextNode generateNextNode(NxftOrderStateController stateController, NxftOrder order);

    NxftOrderOperations 派单(
            NxftOrderStateController stateController, InvocationContext ic, Actor at,
            NxftOrder order, String desc);

    NxftOrderOperations 接单(
            NxftOrderStateController stateController, InvocationContext ic, Actor at,
            NxftOrder order, String desc);

    NxftOrderOperations 配送(
            NxftOrderStateController stateController, InvocationContext ic, Actor at,
            NxftOrder order, String desc);

    NxftOrderOperations 取消(
            NxftOrderStateController stateController, InvocationContext ic, Actor at,
            NxftOrder order, String desc);

}
