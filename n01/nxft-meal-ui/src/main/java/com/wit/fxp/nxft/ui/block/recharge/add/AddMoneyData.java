package com.wit.fxp.nxft.ui.block.recharge.add;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class AddMoneyData {

    private String name;

    private String gender;

    private String phone;

    private Double yue;
}
