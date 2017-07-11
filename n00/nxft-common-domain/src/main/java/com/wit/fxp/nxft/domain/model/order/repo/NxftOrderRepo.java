package com.wit.fxp.nxft.domain.model.order.repo;

import java.util.Date;
import java.util.List;

import com.wit.fxp.nxft.domain.model.order.NxftOrder;

/**
 * 订单
 * @author lyb
 */
public interface NxftOrderRepo {

    /**
     * 根据时间以及助餐点查找订单数量
     * @param time
     * @param end
     * @return
     */
    int findOrderCountByTeamId(String teamId, Date beginTime, Date endTime);

    NxftOrder findNxftOrder(String subjectId, Date mealDate, String mealTypeId, String mealId);

    /**
     * 根据助餐点以及对象id查找
     * @param teamId
     * @param subjectId
     * @return
     */
    List<NxftOrder> findNxftOrderByTeamIdAndSubjectId(String teamId, String subjectId);

    /**
     * 助餐点的客户一定时间内的订单数量
     * @param teamId
     * @param subjectId
     * @return
     */
    int findOrderDetailNum(String teamId, String subjectId, Date begin, Date end);

    /**
     * 分页查询
     * 根据助餐点以及对象查找订单明细列表
     * @param circleId
     * @param subjectId
     * @param begin
     * @param end
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<NxftOrder> findOrderDeatil(String teamId, String subjectId, Date begin, Date end, Integer startIndex, Integer pageSize);

    /**
     * 根据助餐点以及对象查找订单明细列表
     * @param teamId
     * @param subjectId
     * @param begin
     * @param end
     * @return
     */
    List<NxftOrder> findOrderDeatil(String teamId, String subjectId, Date begin, Date end);

    /**
     * 根据助餐点工作站id
     * 就餐时间
     * 餐别id
     * 查找订单列表
     * @param teamId
     * @param time
     * @param mealTypeId
     * @return
     */
    List<NxftOrder> findNxftOrderList(String teamId, Date time, String mealTypeId);

    /**
     * 根据助餐点工作站id
     * 就餐时间
     * 餐别id
     * 查找订单列表
     * @param teamId
     * @param time
     * @param mealTypeId
     * @return
     */
    int findNxftOrderListNum(String teamId, Date time, String mealTypeId);

    NxftOrder findById(String orderId);

    /**
     * 查找订单列表
     * @param teamId 助餐点
     * @param date 日期
     * @param mealtypeId 餐别id
     * @return
     */
    List<NxftOrder> findNxftOrderListByDate(String teamId, Date date, String mealtypeId);

    /**
     * 根据配送单id找到订单
     * @param deliverId
     * @return
     */
    List<NxftOrder> findNxftOrderByDeliverId(String deliverId);
}
