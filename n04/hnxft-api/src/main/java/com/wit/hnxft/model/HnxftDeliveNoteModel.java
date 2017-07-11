package com.wit.hnxft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class HnxftDeliveNoteModel {

    /** 1. 配送单id */
    private String id;

    /** 2. [组件] 配送信息 */
    private HnxftDeliveNoteModel.DeliveInfo deliveInfo;

    /** 3. [组件] 创建信息 */
    private HnxftDeliveNoteModel.CreateInfo createInfo;

    /** 4. [组件] 上次状态 */
    private HnxftDeliveNoteModel.LastState lastState;

    /** 5. [组件] 下一环节 */
    private HnxftDeliveNoteModel.NextNode nextNode;

    /** 6. [组件] 完成情况 */
    private HnxftDeliveNoteModel.CompleteInfo completeInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class DeliveInfo {

        /**1. [不可空] 客户所属的工作圈id */
        private String circleId;

        /**2. [不可空] 配送方式  助餐点 SITE  到户上门  HOME */
        private String deliveType;

        /**3. [不可空] 配送地点id */
        private String deliveSiteId;

        /**4. [不可空] 配送地点名称  当 fdelive_type = HOME 填 faddress */
        private String deliveSiteName;

        /**5. [不可空] 厨房圈id */
        private String kitchenCircleId;

        /**6. [不可空] 厨房teamid */
        private String kitchenTeamId;

        /**7. [不可空] 就餐日期 */
        private java.util.Date mealDate;

        /**8. [不可空] 周几 */
        private Integer week;

        /**9. [不可空] 餐别ID */
        private String mealTypeId;

        /**10. [不可空] 餐别名称 */
        private String mealTypeName;

        /**11. [不可空] 数量 */
        private Integer quantity;

        /**12. [不可空] 数量描述 */
        private String quantityDesc;

        /**13. [不可空] 配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name */
        private String deliveAddr;

        /**14. [可空] 联系人 */
        private String contactPerson;

        /**15. [可空] 联系手机 */
        private String contactMobile;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class CreateInfo {
        /**1. [不可空] 创建时间 */
        private java.util.Date createTime;

        /**2. [不可空] 创建操作员id */
        private String createUserId;

        /**3. [不可空] 创建操作员姓名 */
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

        /**1. [可空] 下一环节 常量，和环节状态、备注同时更新 */
        private String nextNodeId;

        /**2. [可空] 下一环节工作内容 */
        private String nextNodeContent;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class CompleteInfo {

        /**1. [不可空] 是否已完成？  Y/N */
        private Boolean isComplete;

        /**2. [可空] 完成状态  SUCCESS  成功  FAIL 失败（取消） */
        private String completeState;

        /**3. [可空] 失败原因名称  常量  客户取消、改派 */
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
