package com.wit.fxp.nxft.app.model;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class SubjectModel {

    private String id;

    /** 13. [不可空] 联系电话 */
    private String contactPhone;

    /** 14. [不可空] 行政区域ID */
    private String regionId;

    /** 15. [不可空] 行政区域名称 */
    private String regionName;

    /** 16. [可空] 详细地址 */
    private String address;

    /** 16.1. [可空] 是否本地户籍（本镇）Y/N */
    private Boolean isNative;

    /** 16.2. [可空] 居住情况，多选，用逗号分隔 */
    private String livingCondiName;

    /** 17.1. [可空] 联系人关系ID */
    private String familyRelationId;

    /** 17.2. [可空] 联系人关系name */
    private String familyRelationName;

    /** 18.1. [可空] 是否属于政府扶助类型 */
    private Boolean isGovHelp;

    /** 18.2. [可空] 政府扶助类型id */
    private String govHelpId;

    /** 18.3. [可空] 政府扶助类型中文名称 */
    private String govHelpName;

    /** 20.2. [不可空] 是否有食物过敏 */
    private Boolean haveFoodAllergy;

    /** 20.3. [可空] 食物过敏 */
    private String foodAllergy;

    /** 20.4. [可空] 对象食物禁忌，名称逗号分隔 */
    private String subjectFoodProhibit;

    /** [组件] 客户信息 */
    private SubjectModel.PersonInfo personInfo;

    /** [组件] 客户信息 */
    private SubjectModel.SubjectInfo subjectInfo;

    /** [组件] 创建信息 */
    private SubjectModel.CreateInfo createInfo;

    /** [组件] 注销信息 */
    private SubjectModel.CancelInfo cancelInfo;

    private Set<SubjectDiseaseModel> nxftSubjectDiseaseSet = new HashSet<>();

    private Set<SubjectFoodProhibitModel> nxftSubjectFoodProhibitSet = new HashSet<>();

    private Set<SubjectLivingCondiModel> nxftSubjectLivingCondiSet = new HashSet<>();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class PersonInfo {
        private String personId;
        private String subjectName;
        private String sexId;
        private String sexName;
        private String idtypeId;
        private String idtypeName;
        private String idcardno;
        private java.util.Date birthDate;
        private String subjectFoodLoveId;
        private String subjectFoodLoveName;
        private String circleId;
        private Boolean isMealHelp;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class SubjectInfo {
        private String relationName;
        private String relationPhone;
        private String subjectTypeId;
        private String subjectTypeName;
        private String subjectDisease;
        private String subjectDesc;
        private String deliveType;
        private String deliveSiteId;
        private String deliveSiteName;
        private Double overdraft;
        private String lunchBoxNo;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class CreateInfo {
        private java.util.Date createTime;
        private String createCircleId;
        private String createTeamId;
        private String createUserId;
        private String createNickname;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class CancelInfo {
        private Boolean isCancel;
        private String cancelReason;
        private java.util.Date cancelDate;
        private String cancelUserId;
        private String cancelUserName;
    }

}
