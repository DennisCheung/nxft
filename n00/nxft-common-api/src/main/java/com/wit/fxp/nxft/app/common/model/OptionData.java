package com.wit.fxp.nxft.app.common.model;

import com.wit.datatype.IdAndName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class OptionData {

    private String mealDate;

    private IdAndName option;

    private boolean isEnable;

    private boolean isDisease;
}
