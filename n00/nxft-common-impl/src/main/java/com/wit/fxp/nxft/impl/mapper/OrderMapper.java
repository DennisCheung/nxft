package com.wit.fxp.nxft.impl.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.nxft.app.common.model.OrderModel;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderModel.CompleteInfo map(NxftOrder.CompleteInfo entity);

    OrderModel.CreateInfo map(NxftOrder.CreateInfo entity);

    OrderModel.LastState map(NxftOrder.LastState entity);

    OrderModel.NextNode map(NxftOrder.NextNode entity);

    OrderModel.SettleInfo map(NxftOrder.SettleInfo entity);

    OrderModel.SubjectInfo map(NxftOrder.SubjectInfo entity);

    OrderModel.MealInfo map(NxftOrder.MealInfo entity);

    OrderModel map(NxftOrder entity);

    default List<OrderModel> map(List<NxftOrder> notes) {
        List<OrderModel> models = new ArrayList<>();
        for (NxftOrder note : notes) {
            models.add(map(note));
        }
        return models;
    }
}
