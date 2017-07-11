package com.wit.fxp.nxft.schedule;

import com.wit.fxp.nxft.domain.model.order.NxftOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class NxftOrderGroupModel {

    private String groupId;

    private NxftOrder order;
}
