package com.wit.fxp.nxft.domain.model.order.state;

import org.springframework.stereotype.Component;

import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;

@Component
public class 助餐订单已派单 extends AbstractNxftOrderState {

    @Override
    public NxftOrder.NextNode generateNextNode(NxftOrderStateController stateController, NxftOrder svcnote) {
        DBC.助餐订单动作 defaultActionValue = stateController.getDefaultActionValue(this);
        String content = String.format("%s（%s %s）",
                "受理订餐",
                svcnote.getSubjectInfo().getSubjectName(),
                svcnote.getSubjectInfo().getDeliveType().equals("SITE") ? svcnote.getSubjectInfo().getDeliveSiteName()
                        : svcnote.getSubjectInfo().getRegionName() + svcnote.getSubjectInfo().getAddress());
        return NxftOrder.NextNode.fullBuilder()
                ._nextNodeId________(defaultActionValue.nodeId())
                ._nextNodeContent___(content)
                ._build_();
    }

}
