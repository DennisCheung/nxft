package com.wit.hnxft.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

/**
 * 对象统计模型
 * @author lyb
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@BuilderCall
public class HnxftSubjectCountModel {

    /** 1. [不可空] 本周新增对象*/
    private int newInWeekCount;

    /** 2. [不可空] 总计*/
    private int count;

    /** 3. [不可空] 类型列表*/
    private List<NameAndCount> list = new ArrayList<NameAndCount>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class NameAndCount {

        /** 1. [不可空] 类型名称*/
        private String name;

        /** 2. [不可空] 类型数量*/
        private int count;
    }
}
