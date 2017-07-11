package com.wit.fxp.nxft.domain.model.order.repo;

import java.util.Date;
import java.util.List;

import com.wit.fxp.domain.model.account.Account;
import com.wit.fxp.domain.model.account.AccountList;
import com.wit.fxp.domain.model.circle.Circle;
import com.wit.fxp.domain.model.circle.Team;
import com.wit.fxp.nxft.domain.model.order.DeliveCreateLog;
import com.wit.fxp.nxft.domain.model.order.DeliveDetail;
import com.wit.fxp.nxft.domain.model.order.DeliveDetailNum;
import com.wit.fxp.nxft.domain.model.order.DeliveNote;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;

/**
 * （厨房）订单详情和配餐
 * @author wck
 *
 */
public interface NxftDeliveRepo {

    List<NxftOrder> findUnDeliveOrder(String mealTypeId, Date beginDate, Date endDate);

    List<NxftOrder> findUnDeliveOrder(String teamId, String mealTypeId, Date beginDate, Date endDate);

    void saveDeliveNote(DeliveNote entity);

    void saveDeliveDetail(DeliveDetail entity);

    List<NxftOrder> findOrderDetail(String teamId, Date orderCreateB, Date orderCreateE, Date mealTimeB, Date mealTimeE,
            String subjectName, String orderState, String deliveSiteId, String subjectType, Integer startIndex, Integer pageSize);

    Long findOrderDetailCount(String teamId, Date orderCreateB, Date orderCreateE, Date mealTimeB, Date mealTimeE,
            String subjectName, String orderState, String deliveSiteId, String subjectType);

    List<DeliveCreateLog> findDeliveCreateLog(Date beginDate, Date endDate, String mealTypeId);

    void saveDeliveCreateLog(DeliveCreateLog entity);

    Account findAccountBySubjectId(String subjectId);

    void saveAccountList(AccountList entity);

    Circle getCircleByKitchen(String kitchenId);

    Long findDeliveNoteCount(String teamId, Date mealDateBegin, Date mealDateEnd, String state, String mealTypeId);

    List<DeliveNote> findDeliveNote(String teamId, Date mealDateBegin, Date mealDateEnd, String state, String mealTypeId);

    DeliveNote findDeliveNoteById(String id);

    List<NxftOrder> findNxftOrderByDeliveNoteId(String deliveNoteId);

    List<NxftOrder> findNxftOrder(String teamId, Date begin, Date end);

    List<DeliveDetailNum> findDeliveDetailByTime(String teamId, Date begin, Date end);

    NxftOrder findNxftOrderById(String orderId);

    /**
     * 查询配送单
     * @param teamId 助餐点
     * @param mealDateBegin 就餐开始
     * @param mealDateEnd 就餐结束
     * @param state 状态
     * @return
     */
    List<DeliveNote> findDeliveNote(String teamId, Date mealDateBegin, Date mealDateEnd, String state);

    /**
     * 查询配送单明细
     * @param deliveId 配送单id
     * @return
     */
    List<DeliveDetail> findDeliveDetailByDeliveId(String deliveId);

    List<Team> findDeliveSiteByKitchenTeamId(String kitchenTeamId);

}
