package com.wit.hnxft.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.nxft.domain.model.order.DeliveNote;
import com.wit.hnxft.model.HnxftDeliveNoteModel;

@Mapper
public interface HnxftDeliveNoteMapper {

    HnxftDeliveNoteMapper INSTANCE = Mappers.getMapper(HnxftDeliveNoteMapper.class);

    HnxftDeliveNoteModel map(DeliveNote entity);

    List<HnxftDeliveNoteModel> map(List<DeliveNote> entity);
}
