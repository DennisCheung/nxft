package com.wit.fxp.nxft.app.selectdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class SubjectSelectInfo {

    private String name;

    private String phone;

    private String sendType;
}
