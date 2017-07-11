package com.wit.hnxft.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class HnxftCircleAndTeamModel {

    /** 1. [不可空] 工作圈-组列表*/
    private List<HnxftCircleAndTeamListModel> list = new ArrayList<HnxftCircleAndTeamListModel>();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class HnxftCircleAndTeamListModel {

        /** 1. [不可空] 工作圈*/
        private HnxftCircleModel circleModel;

        /** 2. [不可空] 工作组列表*/
        private List<HnxftTeamModel> teamList = new ArrayList<HnxftTeamModel>();
    }
}
