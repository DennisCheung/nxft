package com.wit.fxp.nxft.impl.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.nxft.app.model.SubjectDiseaseModel;
import com.wit.fxp.nxft.app.model.SubjectModel;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;
import com.wit.fxp.nxft.domain.model.subject.NxftSubjectDisease;

@Mapper
public interface SubjectDiseaseMapper {

    SubjectDiseaseMapper INSTANCE = Mappers.getMapper(SubjectDiseaseMapper.class);

    SubjectModel map(NxftSubject entity);

    SubjectDiseaseModel map(NxftSubjectDisease disease);

    default List<SubjectModel> map(List<NxftSubject> notes) {
        List<SubjectModel> models = new ArrayList<>();
        for (NxftSubject note : notes) {
            models.add(map(note));
        }
        return models;
    }
}
