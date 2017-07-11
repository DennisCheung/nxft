package com.wit.hnxft.api.team;

import java.util.List;

import com.wit.hnxft.model.HnxftCircleAndTeamModel;
import com.wit.hnxft.model.HnxftTeamModel;

/**
 * 助餐点工作站工作组接口
 * @author lyb
 *
 */
public interface HnxftTeamApp {

    /**
     * 根据操作员id以及应用id查找工作组列表
     * @param userId
     * @param appId
     * @return
     */
    List<HnxftTeamModel> findUserTeam(String userId, String appId);

    /**
     * 根据userId查找工作圈与助餐点
     * @param userId
     * @return
     */
    HnxftCircleAndTeamModel findCircleAndTeam(String userId);
}
