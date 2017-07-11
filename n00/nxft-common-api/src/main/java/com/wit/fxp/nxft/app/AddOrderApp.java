package com.wit.fxp.nxft.app;

import java.util.Date;
import java.util.List;

import com.wit.Invoker;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.app.common.model.KitchenMenuData;

/**
 *
 * @author qiuxu
 *
 */
public interface AddOrderApp {

    List<IdAndName> findAllMealType();

    void 派单(Invoker invoker, String personId, List<AddNxftOrderCommand> commands, String type);

    void 取消(Invoker invoker, String orderId);

    boolean findSubjectByPersonId(String personId);

    /**
     * 查找当前坐席所在circle签约的厨房在该日期（mealDate）所有餐别的套餐及其内容。
     * @param circleId 所在圈
     * @param mealDate 就餐日期
     * @param mealTypeId 餐别
     * @return
     */
    List<KitchenMenuData> findAllDatas(String circleId, String personId, Date mealDate);

    /**
     * 确认配送单
     * @param deliveId 配送单id
     */
    void comfirmDeliveNote(String deliveId, String userId, String teamId);

    /**
     * 订单发放
     * @param orderId 订单id
     * @param userId 用户id
     * @param teamId 助餐点id
     */
    void transmissionOrder(String orderId, String userId, String teamId);

    String findUpdateContent(String applicationId);
}
