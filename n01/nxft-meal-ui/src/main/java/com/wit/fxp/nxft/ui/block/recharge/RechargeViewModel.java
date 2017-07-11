package com.wit.fxp.nxft.ui.block.recharge;

import com.vaadin.ui.HorizontalLayout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class RechargeViewModel {

    private String subjectId;

    private String name;

    private String gender;

    private String type;

    private Double yue;

    private Double touzhi;

    private String phone;

    private HorizontalLayout hand;

}
