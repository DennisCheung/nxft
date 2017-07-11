package com.wit.hnxft.api.order;

import java.util.Date;
import java.util.List;

import com.wit.hnxft.model.HnxftDeliveNoteModel;
import com.wit.hnxft.model.HnxftMealTypeModel;
import com.wit.hnxft.model.HnxftOrderCountModel;
import com.wit.hnxft.model.HnxftOrderModel;
import com.wit.hnxft.model.HnxftQuerySubjectOrderModel;
import com.wit.hnxft.model.HnxftSchenoteModel;
import com.wit.hnxft.model.HnxtDeliveDetailModel;

/**
 * 助餐点工作站订单接口
 * @author lyb
 *
 */
public interface HnxftOrderApp {

    /**
     * 得到订单统计模型
     * @param teamId
     * @return
     */
    HnxftOrderCountModel statisticsOrder(String teamId);

    /**
     * 得到订单列表
     * 根据就餐时间，助餐点id，餐别id
     * @param teamId
     * @param time
     * @param mealTypeId
     * @return
     */
    List<HnxftOrderModel> findHnxftOrderList(String teamId, Date time, String mealTypeId);

    /**
     * 查找所有餐别类型
     * @return
     */
    List<HnxftMealTypeModel> findAllMealType();

    /**
     * 查找助餐点工作站对象订单列表
     * @param teamId
     * @param subjectId
     * @param date
     * @return
     */
    List<HnxftQuerySubjectOrderModel> findHnxftOrderModelListBySubject(String teamId, Date date);

    /**
     * 查找配送单
     * @param teamId 助餐点id
     * @param state 状态
     * @return
     * 现在到过去两天
     */
    List<HnxftDeliveNoteModel> findHnxftDeliveNoteList(String teamId, String state);

    /**
     * 查找配送单明细
     * @param deliveId 配送单
     * @return
     */
    List<HnxtDeliveDetailModel> findHnxftDeliveDetailList(String deliveId);

    /**
     * 查找可进行发放的订单
     * @param teamId 助餐带你
     * @param date 日期
     * @param mealTypeId 餐别id
     * @return
     */
    List<HnxftOrderModel> findHnxftOrderListForTransmission(String teamId, Date date, String mealTypeId);

    HnxftSchenoteModel findScheData(String teamId, String weekDateBegin);

    Date plusWeek(String preDate, Integer add);

}
