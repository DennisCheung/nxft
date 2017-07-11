package com.wit.fxp.nxft.app;

import java.util.List;

import com.wit.Invoker;
import com.wit.fxp.nxft.app.common.model.OrderModel;
import com.wit.fxp.nxft.app.model.SubjectModel;
import com.wit.fxp.nxft.app.selectdata.OrderSelectInfo;

public interface OrderApp {

    List<OrderModel> findOrders(Invoker invoker, OrderSelectInfo info, int pageNum);

    int fintOrderRowCount(Invoker invoker, OrderSelectInfo info);

    SubjectModel findSubjectModelByPersonId(String personId);

    Double findYue(String personId);

    String checkIsDisease(String mealId);
}
