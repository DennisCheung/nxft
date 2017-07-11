package com.wit.hnxft.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wit.hnxft.model.HnxftOrderModel;
import com.wit.hnxft.model.HnxftQuerySubjectOrderModel;

@Mapper
public interface HnxftSubjectQueryMapper {
    HnxftSubjectQueryMapper INSTANCE = Mappers.getMapper(HnxftSubjectQueryMapper.class);

    HnxftQuerySubjectOrderModel map(String subjectId, String subjectName, String balance, List<HnxftOrderModel> list, int costNum, String mobile,
            double ownExpenseSum, double govCostSum);
}
