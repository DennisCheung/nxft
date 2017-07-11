package com.wit.fxp.nxft.impl.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.nxft.app.model.SubjectLivingCondiModel;
import com.wit.fxp.nxft.domain.model.subject.NxftSubjectLivingCondi;

@Mapper
public interface SubjectLivingCondiMapper {

    SubjectLivingCondiMapper INSTANCE = Mappers.getMapper(SubjectLivingCondiMapper.class);

    SubjectLivingCondiModel map(NxftSubjectLivingCondi entity);

    default List<SubjectLivingCondiModel> map(List<NxftSubjectLivingCondi> notes) {
        List<SubjectLivingCondiModel> models = new ArrayList<>();
        for (NxftSubjectLivingCondi note : notes) {
            models.add(map(note));
        }
        return models;
    }
}
