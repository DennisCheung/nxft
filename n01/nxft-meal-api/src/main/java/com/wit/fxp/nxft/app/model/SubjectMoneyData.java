package com.wit.fxp.nxft.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class SubjectMoneyData {

    private String subjectId;

    private String name;

    private String gender;

    private String type;

    private Double yue;

    private Double touzhi;

    private String phone;
}
