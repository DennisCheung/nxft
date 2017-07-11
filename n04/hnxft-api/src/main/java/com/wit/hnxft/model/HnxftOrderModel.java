package com.wit.hnxft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

/**
 * 订单模型
 * @author lyb
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@BuilderCall
public class HnxftOrderModel {

    /** 1. [不可空] 主键 */
    private String id;

    /** 2. [可空] 配送单id */
    private String deliveNoteId;

    /** 3. [可空] 套餐内容 */
    private String mealContext;

    /** 4. [不可空] 客户电话 */
    private String personMobile;

    /** 5. [组件] 对象信息 */
    private HnxftOrderModel.SubjectInfo subjectInfo;

    /** 6. [组件] 菜谱信息 */
    private HnxftOrderModel.MealInfo mealInfo;

    /** 7. [组件] 结算信息 */
    private HnxftOrderModel.SettleInfo settleInfo;

    /** 8. [组件] 创建信息 */
    private HnxftOrderModel.CreateInfo createInfo;

    /** 9. [组件] 上次状态 */
    private HnxftOrderModel.LastState lastState;

    /** 10. [组件] 下一环节 */
    private HnxftOrderModel.NextNode nextNode;

    /** 11. [组件] 完成信息 */
    private HnxftOrderModel.CompleteInfo completeInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class SubjectInfo {
        /**1. [不可空] 对象id */
        private String subjectId;

        /**2. [不可空] 姓名 */
        private String subjectName;

        /**3. [不可空] 性别id */
        private String sexId;

        /**4. [不可空] 性别name */
        private String sexName;

        /**5. [不可空] [不可空] 联系电话 */
        private String contactPhone;

        /**6. [不可空] 行政区域ID */
        private String regionId;

        /**7. [不可空] 行政区域名称 */
        private String regionName;

        /**8. [可空] 详细地址 */
        private String address;

        /**9. [不可空] 对象类型id */
        private String subjectTypeId;

        /**10. [不可空] 对象类型名称 */
        private String subjectTypeName;

        /**11. [可空] 对象备注 */
        private String subjectDesc;

        /**12. [不可空] 客户所属的工作圈id */
        private String circleId;

        /**13. [不可空] 配送方式  助餐点 SITE  到户上门  HOME */
        private String deliveType;

        /**14. [可空] 配送地点id */
        private String deliveSiteId;

        /**15. [可空] 配送地点名称 当 fdelive_type = HOME 填 faddress */
        private String deliveSiteName;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
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
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class SettleInfo {
        /**1. [不可空] 数量 */
        private Integer quantity;

        /**2. [不可空] 配送费 */
        private Double deliveFee;

        /**3. [不可空] 金额 */
        private Double sumTotal;

        /**4. [不可空] 个人自付金额 */
        private Double sumPayment;

        /**5. [不可空] 应收金额 */
        private Double sumReceivable;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class CreateInfo {
        /**1. [不可空] 创建时间 */
        private java.util.Date createTime;

        /**4. [不可空] 创建操作员id */
        private String createUserId;

        /**5. [不可空] 创建操作员姓名 */
        private String createUserName;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class LastState {
        /**1. [不可空] 最后状态，完成时ID */
        private String lastState;

        /**2. [不可空] 最新完成时间 */
        private java.util.Date lastTime;

        /**3. [不可空] 最新完成操作员id */
        private String lastUserId;

        /**4. [不可空] 最新完成操作员name */
        private String lastNickname;

        /**5. [可空] 流程备注，如为退单，填退单原因。 */
        private String lastDesc;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class NextNode {
        /**1. [可空] 下一环节 常量，和环节状态、备注同时更新  */
        private String nextNodeId;

        /**1. [可空] 下一环节工作内容  */
        private String nextNodeContent;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class CompleteInfo {
        /**1. [不可空]  是否已完成？  Y/N */
        private Boolean isComplete;

        /**2. [可空] 完成状态  SUCCESS  成功  FAIL 失败（取消） */
        private String completeState;

        /**3. [可空] 失败原因名称  常量  客户取消 */
        private String failReasonName;

        /**4. [可空] 完成时间 */
        private java.util.Date completeTime;

        /**5. [可空] 完成操作员工号id */
        private String completeUserId;

        /**6. [可空] 完成操作员姓名 */
        private String completeNickname;

        /**7. [可空] 完成备注 */
        private String completeDesc;
    }
}
