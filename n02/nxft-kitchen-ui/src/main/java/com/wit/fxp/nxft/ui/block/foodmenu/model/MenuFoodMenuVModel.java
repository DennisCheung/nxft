package com.wit.fxp.nxft.ui.block.foodmenu.model;

import java.util.Date;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class MenuFoodMenuVModel {

    private String id;

    private String menuName;

    private String timePeriod;

    private Label menuState;

    private Date createTime;

    private HorizontalLayout handleLayout;
}
