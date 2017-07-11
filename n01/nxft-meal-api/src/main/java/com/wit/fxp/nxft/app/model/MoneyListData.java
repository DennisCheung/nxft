package com.wit.fxp.nxft.app.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class MoneyListData {

    private String name;

    private String phone;

    private Date time;

    private Double jine;

    private Double yue;

    private String handname;
}
