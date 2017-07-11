package com.wit.hnxft.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.nxft.domain.model.subject.NxftSubject;
import com.wit.hnxft.model.HnxftSubjectModel;

@Mapper
public interface HnxftSubjectMapper {

    HnxftSubjectMapper INSTANCE = Mappers.getMapper(HnxftSubjectMapper.class);

    HnxftSubjectModel map(NxftSubject entity, String balance, String age, String disease);

}
