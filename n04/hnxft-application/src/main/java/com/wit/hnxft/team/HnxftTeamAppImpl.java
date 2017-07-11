package com.wit.hnxft.team;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wit.fxp.domain.model.circle.TeamMember;
import com.wit.fxp.domain.service.circle.GzqCircleService;
import com.wit.fxp.domain.service.circle.GzqCircleTeamMemberModel;
import com.wit.fxp.domain.service.team.GzqTeamService;
import com.wit.hnxft.api.team.HnxftTeamApp;
import com.wit.hnxft.mapper.HnxftCircleMapper;
import com.wit.hnxft.mapper.HnxftTeamMapper;
import com.wit.hnxft.model.HnxftCircleAndTeamModel;
import com.wit.hnxft.model.HnxftCircleAndTeamModel.HnxftCircleAndTeamListModel;
import com.wit.hnxft.model.HnxftTeamModel;

@Component
@Transactional
public class HnxftTeamAppImpl implements HnxftTeamApp {

    @Autowired GzqTeamService gzqTeamService;
    @Autowired GzqCircleService gzqCircleService;

    @Override
    public List<HnxftTeamModel> findUserTeam(String userId, String appId) {
        List<TeamMember> list = this.gzqTeamService.findTeamListByAppIdAndUserId(appId, userId);
        if (list.isEmpty()) {
            return new ArrayList<HnxftTeamModel>();
        }
        else {
            return list.stream().map(e -> {
                return HnxftTeamMapper.INSTANCE.map(e.getTeam(), e.getTeam().getApplication().getId());
            }).collect(Collectors.toList());
        }
    }

    @Override
    public HnxftCircleAndTeamModel findCircleAndTeam(String userId) {
        List<HnxftCircleAndTeamListModel> list = new ArrayList<HnxftCircleAndTeamListModel>();
        GzqCircleTeamMemberModel model = this.gzqCircleService.查找我的工作圈组信息(userId, com.wit.fxp.nxft.DBC.子系统.助餐点工作站.value());

        model.getCircles().forEach(e -> {
            list.add(HnxftCircleAndTeamListModel.builder()
                    ._circleModel___(HnxftCircleMapper.INSTANCE.map(e.getCircle(), 0, false))
                    ._teamList______(HnxftTeamMapper.INSTANCE.mapHnxftTeamModel(e.getTeamList()))
                    ._build_());
        });

        return HnxftCircleAndTeamModel.builder()
                ._list__(list)
                ._build_();
    }

}
