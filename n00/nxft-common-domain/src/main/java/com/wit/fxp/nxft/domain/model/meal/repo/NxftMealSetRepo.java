package com.wit.fxp.nxft.domain.model.meal.repo;

import java.util.Date;
import java.util.List;

import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.domain.model.meal.MealScheday;
import com.wit.fxp.nxft.domain.model.meal.MealSchenote;
import com.wit.fxp.nxft.domain.model.meal.MealSet;

public interface NxftMealSetRepo {

    void saveMealSet(MealSet entity);

    String mealNo(InvocationContext ic);

    List<MealSet> findMealSetList(String teamId, Integer startIndex, Integer pageSize);

    List<MealSet> findMealSetList(String teamId);

    List<MealSet> findMealSetList(String teamId, String searchValue);

    List<MealSet> findMealSetList(List<String> ids);

    Long findMealSetCount(String teamId);

    MealSet findMealSet(String id);

    Date findMaxEndDate(String teamId);

    void saveMealSchenote(MealSchenote entity);

    MealSchenote findLastMealSchenote(String teamId);

    MealSchenote findMealSchenoteById(String id);

    List<MealSchenote> findMealSchenoteList(String teamId, Date beginDate, Date endDate, Integer startIndex, Integer pageSize);

    Long findMealSchenoteCount(String teamId, Date beginDate, Date endDate);

    List<MealScheday> findMealScheDay(String mealSchenoteId, Date begin, Date end, String mealTypeId);

    void deleteSchenoteByid(String schenoteId);

    MealSchenote findMealSchenoteByZCDGZZ(String circleId, Date weekBegin, Date weekEnd);

}
