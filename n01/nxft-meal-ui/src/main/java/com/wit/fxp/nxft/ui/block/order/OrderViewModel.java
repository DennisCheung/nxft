package com.wit.fxp.nxft.ui.block.order;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class OrderViewModel {

    private String orderId;

    private String name;

    private String phone;

    private String eatTime;

    private String week;

    private String cb;

    private Label tc;

    private String num;

    private String createWay;

    private String stype;

    private String ctime;

    private String state;

    private String handname;

    private HorizontalLayout hand;

}
