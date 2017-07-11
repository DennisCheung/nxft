package com.wit.fxp.nxft.domain.model.order.service;

import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;

/**
 *
 * @author qiuxu
 *
 */
public interface NxftOrderService {

    void 派单(InvocationContext ic, Actor actor, NxftOrder order);
}
