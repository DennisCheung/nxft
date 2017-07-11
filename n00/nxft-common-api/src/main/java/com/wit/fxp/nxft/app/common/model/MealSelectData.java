package com.wit.fxp.nxft.app.common.model;

import java.util.Date;

import com.wit.datatype.IdAndName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class MealSelectData {

    private Date mealDate;

    private IdAndName meal;

    private IdAndName mealType;
}
