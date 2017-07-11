package com.wit.fxp.nxft.domain.model.order.state.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.domain.model.order.state.NxftOrderStateController;
import com.wit.fxp.nxft.domain.model.order.state.助餐订单初始状态;
import com.wit.fxp.nxft.domain.model.order.state.助餐订单已取消;
import com.wit.fxp.nxft.domain.model.order.state.助餐订单已接单;
import com.wit.fxp.nxft.domain.model.order.state.助餐订单已派单;
import com.wit.fxp.nxft.domain.model.order.state.助餐订单已配送;

@Configuration
public class NxftOrderStateConfiguration {

    @Autowired 助餐订单初始状态 初始;
    @Autowired 助餐订单已派单 已派单;
    @Autowired 助餐订单已接单 已接单;
    @Autowired 助餐订单已取消 已取消;
    @Autowired 助餐订单已配送 已配送;

    @Bean
    public NxftOrderStateController nxftOrderStateController() {
        NxftOrderStateController stateController = new NxftOrderStateController();

        registerStates(stateController);
        registerSteps(stateController);

        stateController.registerHandler(null, (old, action, svcnote) -> {
        });

        stateController.registerHandler(DBC.助餐订单状态.已派单, (old, action, svcnote) -> {

        });

        stateController.registerHandler(DBC.助餐订单状态.已接单, (old, action, svcnote) -> {

        });

        stateController.registerHandler(DBC.助餐订单状态.已取消, (old, action, svcnote) -> {

        });

        stateController.registerHandler(DBC.助餐订单状态.已配送, (old, action, svcnote) -> {

        });

        return stateController;
    }

    private void registerStates(NxftOrderStateController stateController) {
        stateController.registerState(DBC.助餐订单状态.初始, 初始);
        stateController.registerState(DBC.助餐订单状态.已派单, 已派单);
        stateController.registerState(DBC.助餐订单状态.已接单, 已接单);
        stateController.registerState(DBC.助餐订单状态.已配送, 已配送);
        stateController.registerState(DBC.助餐订单状态.已取消, 已取消);
    }

    private void registerSteps(NxftOrderStateController stateController) {
        stateController.registerStep(DBC.助餐订单状态.初始, DBC.助餐订单动作.派单, DBC.助餐订单状态.已派单);

        stateController.registerStep(DBC.助餐订单状态.已派单, DBC.助餐订单动作.接单, DBC.助餐订单状态.已接单);

        stateController.registerStep(DBC.助餐订单状态.已接单, DBC.助餐订单动作.配送, DBC.助餐订单状态.已配送);

        stateController.registerStep(DBC.助餐订单状态.已派单, DBC.助餐订单动作.取消, DBC.助餐订单状态.已取消);

    }

}
