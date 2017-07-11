package com.wit.fxp.nxft.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class OrderMoney {

    private Double deliveFee;

    private int quantity;

    private Double sumTotal;

    private Double sumPayment;

    private Double sumReceivable;
}
