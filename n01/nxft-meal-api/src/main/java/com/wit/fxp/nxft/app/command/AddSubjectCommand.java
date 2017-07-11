package com.wit.fxp.nxft.app.command;

import java.util.Set;

import javax.validation.constraints.NotNull;

import com.wit.datatype.IdAndName;
import com.wit.fxp.validation.idcardnumber.CheckIdCardNumber;
import com.wit.fxp.validation.phonenumber.CheckPhoneNumber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class AddSubjectCommand {

    private String subjectId;

    @NotNull(message = "姓名不能为空！")
    private String name;

    @CheckPhoneNumber
    private String phone;

    @NotNull(message = "身份证不能为空！")
    @CheckIdCardNumber
    private String idNo;

    private String regionId;

    @NotNull(message = "详细地址不能为空！")
    private String address;

    @NotNull(message = "请选择对象类型！")
    private IdAndName subjectType;

    private Set<IdAndName> diseases;

    private String overDraft;

    @NotNull(message = "请选择配送方式！")
    private IdAndName sendType;

    @NotNull(message = "请选择助餐点！")
    private IdAndName mealSite;

    private String desc;

    private String jinjiName;

    @CheckPhoneNumber
    private String jinjiPhone;

    private IdAndName wnjinji;

    private IdAndName wrahuji;

    private Set<IdAndName> livingConditions;

    private boolean wrafuzhu;

    private IdAndName wchfuzhu;

    private boolean wraguom;

    private String tfguom;

    private Set<IdAndName> wchjinji;

    private String tfjinji;

    @NotNull
    private String lunchBoxNo;

    private IdAndName subjectFoodLove;

    private boolean isMealHelp;
}
