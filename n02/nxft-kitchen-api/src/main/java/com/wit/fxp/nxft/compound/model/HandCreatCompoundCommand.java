package com.wit.fxp.nxft.compound.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class HandCreatCompoundCommand {

    private Date mealDate;

    private String mealTypeId;
}
