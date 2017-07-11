package com.wit.fxp.nxft.impl.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.nxft.app.model.SubjectTypeModel;
import com.wit.fxp.nxft.domain.model.dict.SubjectType;

@Mapper
public interface SubjectTypeMapper {

    SubjectTypeMapper INSTANCE = Mappers.getMapper(SubjectTypeMapper.class);

    SubjectTypeModel map(SubjectType entity);

    default List<SubjectTypeModel> map(List<SubjectType> notes) {
        List<SubjectTypeModel> models = new ArrayList<>();
        for (SubjectType note : notes) {
            models.add(map(note));
        }
        return models;
    }
}
