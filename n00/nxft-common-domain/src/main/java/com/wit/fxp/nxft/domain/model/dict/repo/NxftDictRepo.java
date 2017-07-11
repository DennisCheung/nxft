package com.wit.fxp.nxft.domain.model.dict.repo;

import java.util.List;

import com.wit.fxp.domain.model.circle.Team;
import com.wit.fxp.domain.model.person.Disease;
import com.wit.fxp.nxft.domain.model.dict.CircleKitchen;
import com.wit.fxp.nxft.domain.model.dict.MealType;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;

public interface NxftDictRepo {

    CircleKitchen getCircleKitchen(String circleId);

    List<MealType> findAllMealType();

    /**
     * 居家养老档案疾病表
     * @return
     */
    List<Disease> findHbcDisease();

    Team findTeamById(String teamId);

    NxftSubject findSubjectById(String subjectId);

}
