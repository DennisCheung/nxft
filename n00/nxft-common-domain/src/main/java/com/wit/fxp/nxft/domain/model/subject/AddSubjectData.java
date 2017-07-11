package com.wit.fxp.nxft.domain.model.subject;

import java.util.List;

import com.wit.datatype.IdAndName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class AddSubjectData {

    private String name;

    private String phone;

    private String idNo;

    private IdAndName gender;

    private String birthDay;

    private IdAndName region;

    private String address;

    private String jinjiname;

    private String jinjiphone;

    private IdAndName subjectType;

    private String subjectDesc;

    private String dType;

    private IdAndName team;

    private Double dd;

    private List<IdAndName> diseases;

    private IdAndName wnjinji;

    private IdAndName wrahuji;

    private List<IdAndName> livingConditions;

    private boolean wrafuzhu;

    private IdAndName wchfuzhu;

    private boolean wraguom;

    private String tfguom;

    private List<IdAndName> wchjinji;

    private String tfjinji;

    private String lunchBoxNo;

    private IdAndName subjectFoodLove;

    private boolean isMealHelp;

}
