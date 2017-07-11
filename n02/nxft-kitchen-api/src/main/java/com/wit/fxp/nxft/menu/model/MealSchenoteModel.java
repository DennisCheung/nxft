package com.wit.fxp.nxft.menu.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class MealSchenoteModel {
    private String id;

    /** [组件] 排班信息 */
    private ScheInfo scheInfo;

    /** [组件] 创建信息 */
    private CreateInfo createInfo;

    /** [组件] 发布信息 */
    private PublishInfo publishInfo;

    private List<MealScheDayModel> mealSchedaySet;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class ScheInfo {
        /** [可空] 排班单备注 */
        private String schenoteDesc;

        /** [不可空] 厨房圈id */
        private String kitchenCircleId;

        /** [不可空] 排班起始日期=上周期终止日期 + 1 */
        private java.util.Date beginDate;

        /** [不可空] 厨房teamid */
        private String kitchenTeamId;

        /** [不可空] 排班终止日期 */
        private java.util.Date endDate;

        /** [不可空] 排班周期模式 WEEK 周 MONTH 月 */
        private String periodModel;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class CreateInfo {
        /** [不可空] 创建时间 */
        private java.util.Date createTime;

        /** [不可空] 创建工号id */
        private String createUserId;

        /** [不可空] 创建姓名 */
        private String createNickname;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class PublishInfo {
        /** [不可空] 是否已发布？ Y/N */
        private Boolean isPublished;

        /** [可空] 发布时间 */
        private java.util.Date publishTime;

        /** [可空] 发布工号id */
        private String publishUserId;

        /** [可空] 发布姓名 */
        private String publishNickname;
    }
}
