package com.wit.hnxft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

/**
 * 对象模型
 * @author lyb
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@BuilderCall
public class HnxftSubjectModel {
    /** 1. [不可空] 主键 */
    private String id;

    /** 2. [不可空] 联系电话 */
    private String contactPhone;

    /** 3. [不可空] 行政区域ID */
    private String regionId;

    /** 4. [不可空] 行政区域名称 */
    private String regionName;

    /** 5. [可空] 详细地址 */
    private String address;

    /** 6. [不可空] 余额 */
    private String balance;

    /** 7. [不可空] 年龄 */
    private String age;

    /** 8. [不可空] 对象常见疾病 */
    private String disease;

    /** 9. [组件] 客户信息 */
    private HnxftSubjectModel.PersonInfo personInfo;

    /** 10. [组件] 客户信息 */
    private HnxftSubjectModel.SubjectInfo subjectInfo;

    /** 11. [组件] 创建信息 */
    private HnxftSubjectModel.CreateInfo createInfo;

    /** 12. [组件] 注销信息 */
    private HnxftSubjectModel.CancelInfo cancelInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class PersonInfo {
        /**1. [不可空] 客户ID */
        private String personId;

        /**2. [不可空] 姓名 */
        private String subjectName;

        /**3. [不可空] 性别id     fxp.p_sex 字典 */
        private String sexId;

        /**4. [不可空] 性别name */
        private String sexName;

        /**5. [不可空] 证件类别id */
        private String idtypeId;

        /**6. [不可空] 证件类别中文 */
        private String idtypeName;

        /**7. [不可空] 身份证号 */
        private String idcardno;

        /**8. [不可空] 出生日期 */
        private java.util.Date birthDate;

        /**9. [不可空] 客户所属的工作圈id */
        private String circleId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class SubjectInfo {

        /**1. [可空] 联系人姓名 */
        private String relationName;

        /**2. [可空] 联系人电话 */
        private String relationPhone;

        /**3. [不可空] 对象类型id */
        private String subjectTypeId;

        /**4. [不可空] 对象类型中文名称 */
        private String subjectTypeName;

        /**5. [可空] 对象备注 */
        private String subjectDesc;

        /**6. [不可空] 配送方式  助餐点 SITE  到户上门  HOME */
        private String deliveType;

        /**7. [可空] 配送地点id */
        private String deliveSiteId;

        /**8. [可空] 配送地点名称 */
        private String deliveSiteName;

        /**9. [不可空] 配餐透支额度 */
        private Double overdraft;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class CreateInfo {

        /**1. [不可空] 创建时间 */
        private java.util.Date createTime;

        /**2. [不可空] 创建工作圈id */
        private String createCircleId;

        /**3. [不可空] 创建工作组id */
        private String createTeamId;

        /**4. [不可空] 创建工号id */
        private String createUserId;

        /**5. [不可空] 创建姓名 */
        private String createNickname;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @BuilderCall
    public static class CancelInfo {

        /**1. [不可空] 是否被注销 */
        private Boolean isCancel;

        /**2. [可空] 注销原因 */
        private String cancelReason;

        /**3. [可空] 注销机器时间 */
        private java.util.Date cancelDate;

        /**4. [可空] 注销操作员id */
        private String cancelUserId;

        /**5. [可空] 注销操作员姓名 */
        private String cancelUserName;
    }

}
