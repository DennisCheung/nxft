package com.wit.fxp.nxft.menu;

import java.util.Date;
import java.util.List;

import com.wit.Invoker;
import com.wit.fxp.nxft.menu.model.AddMealScheDayCommand;
import com.wit.fxp.nxft.menu.model.AddMealSetCommand;
import com.wit.fxp.nxft.menu.model.HbcDiseaseModel;
import com.wit.fxp.nxft.menu.model.MealScheDayModel;
import com.wit.fxp.nxft.menu.model.MealSchenoteModel;
import com.wit.fxp.nxft.menu.model.MealSetModel;
import com.wit.fxp.nxft.paging.PagingInfo;

public interface NxftMealSetApp {

    String BEAN_NAME = "NxftMealSetApp";

    void addMealSet(Invoker invoker, AddMealSetCommand command);

    List<MealSetModel> findMealSetList(String teamId, PagingInfo pageInfo);

    List<MealSetModel> findMealSetList(String teamId);

    List<MealSetModel> findMealSetList(String teamId, String searchValue);

    MealSetModel findMealSet(String id);

    void editMealSet(String mealSetId, AddMealSetCommand command);

    MealSchenoteModel newMaxEndDate(Invoker invoker);

    MealSchenoteModel findMealSchenote(String schenoteId);

    void editMealScheDays(AddMealScheDayCommand command);

    List<MealSchenoteModel> findMealSchenoteList(String teamId, PagingInfo pageInfo, Date beginDate, Date endDate);

    List<MealScheDayModel> findMealScheDay(String mealSchenoteId, Date mealDate, String mealTypeId);

    void returnPublishSchenote(Invoker invoker, String schenoteId);

    void publishSchenote(Invoker invoker, String schenoteId);

    void deleteSchenote(String schenoteId);

    List<HbcDiseaseModel> findHbcDisease();

}
