package com.wit.fxp.nxft.domain.model.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;
import com.wit.fxp.nxft.domain.model.order.state.NxftOrderStateController;

@Service
@Transactional
public class NxftOrderServiceImpl implements NxftOrderService {

    @Autowired private NxftOrderStateController controller;

    @Override
    public void 派单(InvocationContext ic, Actor actor, NxftOrder order) {
        controller.派单(ic, actor, order, null);
    }

}
