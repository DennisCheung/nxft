package com.wit.fxp.nxft.menu.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import com.wit.datatype.IdAndName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class AddMealSetCommand {

    private String mealSetCode;

    @NotNull(message = "套餐名称不能为空")
    private String mealSetName;

    @NotNull(message = "套餐内容不能为空")
    private String mealSetContent;

    private IdAndName pepperyLevel; // 辣

    @NotNull(message = "套餐单价不能为空")
    @Max(value = 1000L)
    @Digits(integer = 4, fraction = 2)
    private Double mealPrice;

    private String photoId;

    private String mealSetDesc;

//    private Collection<IdAndName> mealDisease;

//    @NotNull(message = "餐别不能为空，请选择")
//    private IdAndName mealType; //餐别

}
