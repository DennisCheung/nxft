package com.wit.hnxft.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.nxft.domain.model.order.NxftOrder;
import com.wit.hnxft.model.HnxftOrderModel;

@Mapper
public interface HnxftOrderMapper {

    HnxftOrderMapper INSTANCE = Mappers.getMapper(HnxftOrderMapper.class);

    HnxftOrderModel map(NxftOrder entity, String mealContext, String personMobile);

}
