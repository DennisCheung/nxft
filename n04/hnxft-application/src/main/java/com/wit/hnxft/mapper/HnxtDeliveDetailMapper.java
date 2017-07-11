package com.wit.hnxft.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.nxft.domain.model.order.DeliveDetail;
import com.wit.hnxft.model.HnxtDeliveDetailModel;

@Mapper
public interface HnxtDeliveDetailMapper {

    HnxtDeliveDetailMapper INSTANCE = Mappers.getMapper(HnxtDeliveDetailMapper.class);

    HnxtDeliveDetailModel map(DeliveDetail entity);

    List<HnxtDeliveDetailModel> map(List<DeliveDetail> entity);
}
