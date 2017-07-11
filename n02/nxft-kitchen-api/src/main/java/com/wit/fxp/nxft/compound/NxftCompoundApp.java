package com.wit.fxp.nxft.compound;

import java.util.Date;
import java.util.List;

import com.wit.Invoker;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.compound.model.DeliveNoteModel;
import com.wit.fxp.nxft.compound.model.HandCreatCompoundCommand;
import com.wit.fxp.nxft.compound.model.MealTypeModel;
import com.wit.fxp.nxft.compound.model.NxftOrderCollectModel;
import com.wit.fxp.nxft.compound.model.NxftOrderDetailModel;
import com.wit.fxp.nxft.menu.model.DeliveNumModel;
import com.wit.fxp.nxft.paging.PagingInfo;

/**
 * 订单详情和配餐管理app.
 * @author wck
 *
 */
public interface NxftCompoundApp {

    String BEAN_NAME = "NxftCompoundApp";

    void compoundCreateEveryDay(Date currentDate);

    void handCompoundCreate(Invoker invoker, HandCreatCompoundCommand command);

    List<NxftOrderDetailModel> findOrderDetail(String teamId, Date orderCreateB, Date orderCreateE, Date mealTimeB, Date mealTimeE, String subjectName,
            String orderState, String deliveSiteId, String subjectType, PagingInfo pageInfo);

    List<DeliveNoteModel> findDeliveNote(String teamId, PagingInfo pageInfo, Date mealDate, String state, String mealTypeId);

    void confirmDelive(Invoker invoker, String id);

    void confirmDelive(Invoker invoker, List<String> ids);

    List<NxftOrderCollectModel> findNxftOrder(String teamId, Date beginDate, Date endDate);

    DeliveNumModel findDeliveNum(String teamId);

    NxftOrderDetailModel findNxftOrder(String orderId);

    List<MealTypeModel> findMealTypeList();

    List<IdAndName> findDeliveSites(String kitchenTeamId);

    List<IdAndName> findSubjectTypes();

}
