package com.wit.fxp.nxft.impl.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.nxft.app.model.SubjectDiseaseModel;
import com.wit.fxp.nxft.domain.model.subject.NxftSubjectDisease;

@Mapper
public interface SubjectMapper {

    SubjectDiseaseMapper INSTANCE = Mappers.getMapper(SubjectDiseaseMapper.class);

    SubjectDiseaseModel map(NxftSubjectDisease entity);

    default List<SubjectDiseaseModel> map(List<NxftSubjectDisease> notes) {
        List<SubjectDiseaseModel> models = new ArrayList<>();
        for (NxftSubjectDisease note : notes) {
            models.add(map(note));
        }
        return models;
    }
}
