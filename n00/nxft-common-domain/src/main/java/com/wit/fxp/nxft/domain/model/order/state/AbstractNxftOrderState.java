package com.wit.fxp.nxft.domain.model.order.state;

import java.util.Date;

import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;

public abstract class AbstractNxftOrderState implements NxftOrderOperations {

    @Override
    public AbstractNxftOrderState 派单(NxftOrderStateController stateController, InvocationContext ic, Actor at, NxftOrder order, String data) {
        AbstractNxftOrderState nextState = step(stateController, at, order, DBC.助餐订单动作.派单, data, ic.now());
        return nextState;
    }

    @Override
    public AbstractNxftOrderState 接单(NxftOrderStateController stateController, InvocationContext ic, Actor at, NxftOrder order, String data) {
        AbstractNxftOrderState nextState = step(stateController, at, order, DBC.助餐订单动作.接单, data, ic.now());
        return nextState;
    }

    @Override
    public AbstractNxftOrderState 配送(NxftOrderStateController stateController, InvocationContext ic, Actor at, NxftOrder order, String data) {
        AbstractNxftOrderState nextState = step(stateController, at, order, DBC.助餐订单动作.配送, data, ic.now());
        return nextState;
    }

    @Override
    public AbstractNxftOrderState 取消(NxftOrderStateController stateController, InvocationContext ic, Actor at, NxftOrder order, String data) {
        AbstractNxftOrderState nextState = step(stateController, at, order, DBC.助餐订单动作.取消, data, ic.now());
        return nextState;
    }

    /**
     * 返回执行动作后的下一状态。
     *
     * @param stateValue
     * @param actionValue
     * @return
     */
    private AbstractNxftOrderState getNextState(NxftOrderStateController stateController, DBC.助餐订单动作 actionValue) {
        AbstractNxftOrderState nextState = stateController.getNextState(this, actionValue);
        if (nextState == null) {
            throw new IllegalStateException(String.format("在当前状态下不允许此操作：当前状态 = %s，操作 = %s", stateController.getStateValue(this), actionValue.nodeName()));
        }
        return nextState;
    }

    private AbstractNxftOrderState step(NxftOrderStateController stateController, Actor ic, NxftOrder order,
            DBC.助餐订单动作 actionValue, String data, Date time) {
        AbstractNxftOrderState newState = getNextState(stateController, actionValue);

        NxftOrder.NextNode nextAction = newState.generateNextNode(stateController, order);

        order.step(ic, stateController.getStateValue(newState), data, nextAction, actionValue, time);

        AbstractNxftOrderState old = stateController.getLastState(order);
        stateController.onStep(old, actionValue, order);
        return newState;
    }

}
