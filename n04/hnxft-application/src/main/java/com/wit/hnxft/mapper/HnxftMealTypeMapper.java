package com.wit.hnxft.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.nxft.domain.model.dict.MealType;
import com.wit.hnxft.model.HnxftMealTypeModel;

@Mapper
public interface HnxftMealTypeMapper {

    HnxftMealTypeMapper INSTANCE = Mappers.getMapper(HnxftMealTypeMapper.class);

    HnxftMealTypeModel map(MealType entity);

    List<HnxftMealTypeModel> map(List<MealType> entity);
}
