package com.wit.fxp.nxft.impl.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.nxft.app.model.FoodProhibitModel;
import com.wit.fxp.nxft.domain.model.dict.FoodProhibit;

@Mapper
public interface FoodProhibitMapper {

    FoodProhibitMapper INSTANCE = Mappers.getMapper(FoodProhibitMapper.class);

    FoodProhibitModel map(FoodProhibit entity);

    default List<FoodProhibitModel> map(List<FoodProhibit> notes) {
        List<FoodProhibitModel> models = new ArrayList<>();
        for (FoodProhibit note : notes) {
            models.add(map(note));
        }
        return models;
    }
}
