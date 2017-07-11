package com.wit.fxp.nxft.ui.block.foodmenu.model;

import com.vaadin.ui.HorizontalLayout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class MealSetVModel {

    private String id;

    private String mealSetNo;

    private String mealSetName;

    /** 内容 */
    private String mealSetContent;

    /** 单价 */
    private String price;

    /** 辣 */
    private String pungent;

    private String mealSetDesc;

    private String createTime;

    private String mealDisease;

    private HorizontalLayout handleLayout;

}
