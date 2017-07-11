package com.wit.fxp.nxft.compound.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class DeliveNoteModel {
    private String id;

    /** [组件] 配送信息 */
    private DeliveInfo deliveInfo;

    /** [组件] 创建信息 */
    private CreateInfo createInfo;

    /** [组件] 上次状态 */
    private LastState lastState;

    /** [组件] 下一环节 */
    private NextNode nextNode;

    /** [组件] 完成情况 */
    private CompleteInfo completeInfo;

    private List<DeliveDetailModel> deliveDetailSet;

    private List<NxftOrderDetailModel> nxftOrderSet;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class DeliveInfo {
        /** [不可空] 客户所属的工作圈id */
        private String circleId;

        /** [不可空] 配送方式  助餐点 SITE  到户上门  HOME */
        private String deliveType;

        /** [不可空] 配送地点id */
        private String deliveSiteId;

        /** [不可空] 配送地点名称  当 fdelive_type = HOME 填 faddress */
        private String deliveSiteName;

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

        /** [不可空] 数量 */
        private Integer quantity;

        /** [不可空] 数量描述 */
        private String quantityDesc;

        /** [不可空] 配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name */
        private String deliveAddr;
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

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class NextNode {

        /** [可空] 下一环节 常量，和环节状态、备注同时更新 */
        private String nextNodeId;

        /** [可空] 下一环节工作内容 */
        private String nextNodeContent;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class CompleteInfo {
        /** [不可空] 是否已完成？  Y/N */
        private Boolean isComplete;

        /** [可空] 完成状态  SUCCESS  成功  FAIL 失败（取消） */
        private String completeState;

        /** [可空] 失败原因名称  常量  客户取消、改派 */
        private String failReasonName;

        /** [可空] 完成时间 */
        private java.util.Date completeTime;

        /** [可空] 完成操作员工号id */
        private String completeUserId;

        /** [可空] 完成操作员姓名 */
        private String completeNickname;

        /** [可空] 完成备注 */
        private String completeDesc;
    }
}
