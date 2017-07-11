package com.wit.fxp.nxft.ui.block.foodorder.model;

import com.vaadin.ui.Button;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class FoodOrderVModel {

    private String id;

    private String subjectName;

    private String mealDate;

    private String week;

    private String createTime;

    private String foodType;

    private String mealSet; // 套餐

    private Integer quanlity; // 份数

    private String deliverWay;

    private String deliveSiteName;

    private String state;

    private String createNickName;

    private String createWay; // 订餐方式

    private Button handleBtn;
}
