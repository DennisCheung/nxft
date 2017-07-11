package com.wit.fxp.nxft.menu.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class AddMealScheDayCommand {

    private String mealSchenoteId;

    private String mealTypeId;

    private Date mealDate;

    private List<String> mealIds;

}
