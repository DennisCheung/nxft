package com.wit.fxp.nxft.ui.block.recharge.showinfo;

import com.vaadin.ui.Button;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class ShowRechargeViewModel {

    private String time;

    private String week;

    private String money;

    private Button btn;
}
