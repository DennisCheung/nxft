package com.wit.hnxft.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wit.fxp.domain.model.circle.Team;
import com.wit.hnxft.model.HnxftTeamModel;

@Mapper
public interface HnxftTeamMapper {

    HnxftTeamMapper INSTANCE = Mappers.getMapper(HnxftTeamMapper.class);

    @Mapping(target = "circleId", source = "entity.circle.id")
    HnxftTeamModel map(Team entity, String appId);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "circleId", source = "circle.id")
    @Mapping(target = "appId", source = "entity.application.id")
    HnxftTeamModel mapHnxftTeamModel(Team entity);

    List<HnxftTeamModel> mapHnxftTeamModel(List<Team> entity);

}
