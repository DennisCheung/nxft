package com.wit.fxp.nxft.compound.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class NxftOrderDetailModel {
    private String id;

    /** 33. [可空] 配送单id */
    private String deliveNoteId;

    /** [组件] 对象信息 */
    private SubjectInfo subjectInfo;

    /** [组件] 菜谱信息 */
    private MealInfo mealInfo;

    /** [组件] 结算信息 */
    private SettleInfo settleInfo;

    /** [组件] 创建信息 */
    private CreateInfo createInfo;

    /** [组件] 上次状态 */
    private LastState lastState;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class SubjectInfo {
        /** [不可空] 对象id */
        private String subjectId;

        /** [不可空] 姓名 */
        private String subjectName;

        /** [不可空] 性别id */
        private String sexId;

        /** [不可空] 性别name */
        private String sexName;

        /** [不可空] 联系电话 */
        private String contactPhone;

        /** [不可空] 行政区域ID */
        private String regionId;

        /** [不可空] 行政区域名称 */
        private String regionName;

        /** [可空] 详细地址 */
        private String address;

        /** [不可空] 对象类型id */
        private String subjectTypeId;

        /** [不可空] 对象类型名称 */
        private String subjectTypeName;

        /** [可空] 对象备注 */
        private String subjectDesc;

        /** [不可空] 客户所属的工作圈id */
        private String circleId;

        /** [不可空] 配送方式  助餐点 SITE  到户上门  HOME */
        private String deliveType;

        /** [可空] 配送地点id */
        private String deliveSiteId;

        /** [可空] 配送地点名称 当 fdelive_type = HOME 填 faddress */
        private String deliveSiteName;

        /** [不可空] 配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name */
        private String deliveAddr;

        /** [可空] 饭盒编号 */
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
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class SettleInfo {
        /** [不可空] 数量 */
        private Integer quantity;

        /** [不可空] 配送费 */
        private Double deliveFee;

        /** [不可空] 金额 */
        private Double sumTotal;

        /** [不可空] 个人自付金额 */
        private Double sumPayment;

        /** [不可空] 应收金额 */
        private Double sumReceivable;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class CreateInfo {
        /** [不可空] 创建时间 */
        private java.util.Date createTime;

        /** [不可空] 创建操作员id */
        private String createUserId;

        /** [不可空] 创建操作员姓名 */
        private String createUserName;

        /** [不可空] 订餐方式  坐席  助餐点 */
        private String createWay;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class LastState {
        /** [不可空] 最后状态，完成时ID */
        private String lastState;

        /** [不可空] 最新完成时间 */
        private java.util.Date lastTime;

        /** [不可空] 最新完成操作员id */
        private String lastUserId;

        /** [不可空] 最新完成操作员name */
        private String lastNickname;

        /** [可空] 流程备注，如为退单，填退单原因。 */
        private String lastDesc;
    }
}
