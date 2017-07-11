package com.wit.fxp.nxft.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.domain.model.person.Disease;
import com.wit.fxp.nxft.domain.model.meal.MealDisease;
import com.wit.fxp.nxft.domain.model.meal.MealScheday;
import com.wit.fxp.nxft.domain.model.meal.MealSchenote;
import com.wit.fxp.nxft.domain.model.meal.MealSet;
import com.wit.fxp.nxft.menu.model.HbcDiseaseModel;
import com.wit.fxp.nxft.menu.model.MealDiseaseModel;
import com.wit.fxp.nxft.menu.model.MealScheDayModel;
import com.wit.fxp.nxft.menu.model.MealSchenoteModel;
import com.wit.fxp.nxft.menu.model.MealSetModel;

@Mapper
public interface MealSetMapper {

    MealSetMapper INSTANCE = Mappers.getMapper(MealSetMapper.class);

    @Mapping(target = "logcdate", ignore = true)
    MealSetModel mapMealSet(MealSet entity);

    List<MealSetModel> mapMealSet(List<MealSet> entity);

    MealSchenoteModel.ScheInfo mapMealSchenote(MealSchenote.ScheInfo entity);

    MealSchenoteModel.CreateInfo mapMealSchenote(MealSchenote.CreateInfo entity);

    MealSchenoteModel.PublishInfo mapMealSchenote(MealSchenote.PublishInfo entity);

    MealSchenoteModel mapMealSchenote(MealSchenote entity);

    List<MealSchenoteModel> mapMealSchenote(List<MealSchenote> entity);

    MealScheDayModel mapMealScheDay(MealScheday entity);

    List<MealScheDayModel> mapMealScheDayModel(List<MealScheday> entity);

    HbcDiseaseModel mapHbcDisease(Disease entity);

    List<HbcDiseaseModel> mapHbcDisease(List<Disease> entity);

    MealDiseaseModel  mapMealDisease(MealDisease entity);

    List<MealDiseaseModel> mapMealDisease(List<MealDisease> entity);

}
