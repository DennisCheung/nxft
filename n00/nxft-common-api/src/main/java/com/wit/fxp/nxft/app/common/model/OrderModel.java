package com.wit.fxp.nxft.app.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class OrderModel {

    private String id;

    /** 33. [可空] 配送单id */
    private String deliveNoteId;

    /** [组件] 对象信息 */
    private OrderModel.SubjectInfo subjectInfo;

    /** [组件] 菜谱信息 */
    private OrderModel.MealInfo mealInfo;

    /** [组件] 结算信息 */
    private OrderModel.SettleInfo settleInfo;

    /** [组件] 创建信息 */
    private OrderModel.CreateInfo createInfo;

    /** [组件] 上次状态 */
    private OrderModel.LastState lastState;

    /** [组件] 下一环节 */
    private OrderModel.NextNode nextNode;

    /** [组件] 完成信息 */
    private OrderModel.CompleteInfo completeInfo;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class SubjectInfo {
        private String subjectId;
        private String subjectName;
        private String sexId;
        private String sexName;
        private String contactPhone;
        private String regionId;
        private String regionName;
        private String address;
        private String subjectTypeId;
        private String subjectTypeName;
        private String subjectDesc;
        private String circleId;
        private String deliveType;
        private String deliveSiteId;
        private String deliveSiteName;
        private String lunchBoxNo;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class MealInfo {
        /** [不可空] 厨房圈id */
        private String kitchenCircleId;

        /** [不可空] 厨房teamid */
        private String kitchenTeamId;

        /** [不可空] 就餐日期 */
        private java.util.Date mealDate;

        /** [不可空] 周几 */
        private Integer week;

        /** [不可空] 餐别ID */
        private String mealTypeId;

        /** [不可空] 餐别名称 */
        private String mealTypeName;

        /** [不可空] 套餐id */
        private String mealId;

        /** [不可空] 套餐CODE */
        private String mealCode;

        /** [不可空] 套餐名称 */
        private String mealName;

        /** [不可空] 单价 */
        private Double mealPrice;

        /** [可空] 备注 */
        private String scheduleDesc;

        /** [可空] 套餐内容 */
        private String mealContent;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class SettleInfo {
        private Integer quantity;
        private Double deliveFee;
        private Double sumTotal;
        private Double sumPayment;
        private Double sumReceivable;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class CreateInfo {
        private java.util.Date createTime;
        private String createUserId;
        private String createUserName;
        private String createWay;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class LastState {
        private String lastState;
        private java.util.Date lastTime;
        private String lastUserId;
        private String lastNickname;
        private String lastDesc;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class NextNode {
        private String nextNodeId;
        private String nextNodeContent;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class CompleteInfo {
        private Boolean isComplete;
        private String completeState;
        private String failReasonName;
        private java.util.Date completeTime;
        private String completeUserId;
        private String completeNickname;
        private String completeDesc;
    }

}
