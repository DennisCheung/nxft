package com.wit.fxp.nxft.impl.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.nxft.app.model.SubjectFoodProhibitModel;
import com.wit.fxp.nxft.domain.model.subject.NxftSubjectFoodProhibit;

@Mapper
public interface SubjectFoodProhibitMapper {

    SubjectFoodProhibitMapper INSTANCE = Mappers.getMapper(SubjectFoodProhibitMapper.class);

    SubjectFoodProhibitModel map(NxftSubjectFoodProhibit entity);

    default List<SubjectFoodProhibitModel> map(List<NxftSubjectFoodProhibit> notes) {
        List<SubjectFoodProhibitModel> models = new ArrayList<>();
        for (NxftSubjectFoodProhibit note : notes) {
            models.add(map(note));
        }
        return models;
    }
}
