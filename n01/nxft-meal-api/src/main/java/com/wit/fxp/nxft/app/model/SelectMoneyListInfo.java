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
public class SelectMoneyListInfo {

    private Date begin;

    private Date end;

    private boolean isMine;
}
