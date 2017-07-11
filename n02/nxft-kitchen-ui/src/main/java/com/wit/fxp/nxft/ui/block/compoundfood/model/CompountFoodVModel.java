package com.wit.fxp.nxft.ui.block.compoundfood.model;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class CompountFoodVModel {

    private String id;

    private CheckBox checkBox;

    private String deliveNoteNo;

    private String mealTime;

    private String week;

    private String foodType;

    private Integer quanlity;

    private String deliverWay;

    private String deliveSiteName;

    private String state;

    private HorizontalLayout handleLayout;
}
