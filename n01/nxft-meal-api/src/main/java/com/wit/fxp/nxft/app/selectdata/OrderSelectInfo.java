package com.wit.fxp.nxft.app.selectdata;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class OrderSelectInfo {

    private Date createBegin;

    private Date createEnd;

    private Date eatBegin;

    private Date eatEnd;

    private String name;

    private String teamId;

    private String state;

    private String subjectTypeId;
}
