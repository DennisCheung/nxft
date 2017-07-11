package com.wit.fxp.nxft.domain.model.subject.repo;

import java.util.Date;
import java.util.List;

import com.wit.fxp.domain.model.account.Account;
import com.wit.fxp.domain.model.account.AccountList;
import com.wit.fxp.domain.model.account.AccountPerson;
import com.wit.fxp.domain.model.circle.Application;
import com.wit.fxp.domain.model.circle.Team;
import com.wit.fxp.domain.model.person.Disease;
import com.wit.fxp.domain.model.person.Person;
import com.wit.fxp.nxft.domain.model.dict.CircleKitchen;
import com.wit.fxp.nxft.domain.model.dict.FoodLove;
import com.wit.fxp.nxft.domain.model.dict.FoodProhibit;
import com.wit.fxp.nxft.domain.model.dict.SubjectAssistance;
import com.wit.fxp.nxft.domain.model.dict.SubjectType;
import com.wit.fxp.nxft.domain.model.meal.MealDisease;
import com.wit.fxp.nxft.domain.model.meal.MealScheday;
import com.wit.fxp.nxft.domain.model.order.DeliveDetailNum;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;
import com.wit.fxp.nxft.domain.model.sis.SisServiceResource;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;
import com.wit.fxp.nxft.domain.model.subject.NxftSubjectSmsLog;

public interface SubjectRepo {

    List<NxftSubject> findSubjectByQuery(String circleId, String teamid, String name, String phone, String sendType,
            int pageNum);

    List<NxftSubject> findMaSubjectByQuery(String circleId, String teamid, String name, String phone, boolean isOver, int pageNum);

    List<NxftSubject> findAllSubjects(String circleId, String teamId, int pageNum);

    List<NxftOrder> findOrderByQuery(String circleId, String teamid, Date begin1, Date end1, Date begin2, Date end2,
            String name, String teamId, String subjectTypeId, String state, int pageNum);

    List<NxftOrder> findAllOrders(String circleId, String teamId, int pageNum);

    List<NxftSubject> findMaSubjectCountByQuery(String circleId, String teamid, String name, String phone, boolean isOver);

    int findSubjectCountByQuery(String circleId, String teamid, String name, String phone, String sendType);

    int findAllSubjectsCount(String circleId, String teamId);

    int findOrderCountByQuery(String circleId, String teamid, Date begin1, Date end1, Date begin2, Date end2,
            String name, String teamId, String subjectTypeId, String state);

    int findAllOrdersCount(String circleId, String teamId);

    List<SubjectType> findAllTypes();

    List<Team> findTeamsByCircleId(String circleId);

    Person findPersonByPhone(String phone);

    Person findPersonByIdNo(String idNo);

    NxftSubject findSubjectByIdNo(String idNo);

    NxftSubject findSubjectByPhone(String phone);

    void addSubject(NxftSubject subject);

    List<Team> findCreateFamilyTeam(String circleId);

    NxftSubject findById(String id);

    NxftOrder findOrderById(String id);

    int findSubjectByType(String circleId, String type);

    int findSubjectByDate(String circleId, Date begin, Date end);

    int findOrdersByDate(String circleId, Date begin, Date end);

    NxftSubject findSubjectByPersonId(String personId);

    MealScheday findMealScheDay(String kitTeamId, Date mealDate, String mealId, String mealTypeId);

    void addOrder(NxftOrder order);

    CircleKitchen findKitchen(String circle);

    SubjectAssistance findSa(String circleId, String subjectTypeId, String mealTypeId);

    List<MealScheday> findMealBykit(String kitTeamId, String mealTypeId, Date mealDate);

    List<SisServiceResource> findAllByCircleId(String circleId);

    Account findAccountByPersonId(String personId);

    void addAccount(Account account);

    void addAcountPerson(AccountPerson ap);

    List<Disease> findDiseases();

    List<MealDisease> findMealDiseasesByMealId(String mealId);

    /**
     * 删除充值流水对象
     * @param list 充值流水对象     *
     */
    void deleteAccountList(AccountList list);

    List<FoodProhibit> findHibits();

    List<FoodLove> findFoodLove();

    void addSmsLog(NxftSubjectSmsLog log);

    List<DeliveDetailNum> findDeliveDetailByTime(String circleId, Date now);

    Application findApplicationById(String id);

}
