package com.wit.fxp.nxft.domain.model.order.state;

import org.springframework.stereotype.Component;

import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;

@Component
public class 助餐订单已配送 extends AbstractNxftOrderState {

    @Override
    public NxftOrder.NextNode generateNextNode(NxftOrderStateController stateController, NxftOrder svcnote) {
        DBC.助餐订单动作 defaultActionValue = stateController.getDefaultActionValue(this);
        String content = String.format("%s（%s %s%s）",
                "撤销走出围栏服务单",
//                svcnote.getPersonInfo().getPersonName(),
//                svcnote.getPersonInfo().getRegionName(),
                "dd");
        return NxftOrder.NextNode.fullBuilder()
                ._nextNodeId________(defaultActionValue.nodeId())
                ._nextNodeContent___(content)
                ._build_();
    }

}
