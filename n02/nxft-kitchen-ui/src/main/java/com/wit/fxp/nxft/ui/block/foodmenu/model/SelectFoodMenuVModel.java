package com.wit.fxp.nxft.ui.block.foodmenu.model;

import com.vaadin.ui.CheckBox;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class SelectFoodMenuVModel {

    private String id;

    private String mealId;

    private CheckBox checkbox;

    private String mealSetNo;

    private String mealSetName;

    private String mealSetContent;

    private String price;

    private String pungent;

    private String mealSetDesc;
}
