package com.wit.hnxft.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.domain.model.circle.Circle;
import com.wit.hnxft.model.HnxftCircleModel;

@Mapper
public interface HnxftCircleMapper {

    HnxftCircleMapper INSTANCE = Mappers.getMapper(HnxftCircleMapper.class);

    HnxftCircleModel map(Circle entity, int teamNum, Boolean isAdmin);
}
