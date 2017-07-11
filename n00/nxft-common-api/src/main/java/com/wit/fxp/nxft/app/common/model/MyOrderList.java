package com.wit.fxp.nxft.app.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class MyOrderList {

    private String mealDate;

    private String mealId;

    private String mealName;

    private String mealTypeId;

    private String mealTypeName;

}
