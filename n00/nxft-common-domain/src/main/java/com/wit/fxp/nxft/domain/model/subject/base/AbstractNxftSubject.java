// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.subject.base;

import com.benewit.core.utils.SafeCopier;

/**
 * 配餐对象工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String subjectId 对象id
 * 2. [不可空] String personId 客户ID
 * 3. [不可空] String subjectName 姓名
 * 4. [不可空] String sexId 性别id     fxp.p_sex 字典
 * 5. [不可空] String sexName 性别name
 * 6. [不可空] String idtypeId 证件类别id
 * 7. [不可空] String idtypeName 证件类别中文
 * 8. [不可空] String idcardno 身份证号
 * 9. [不可空] java.util.Date birthDate 出生日期
 * 13. [可空] String contactPhone 联系电话
 * 14. [不可空] String regionId 行政区域ID
 * 15. [不可空] String regionName 行政区域名称
 * 16. [可空] String address 详细地址
 * 16.1. [可空] Boolean isNative 是否本地户籍（本镇）Y/N
 * 16.2. [可空] String livingCondiName 居住情况，多选，用逗号分隔
 * 17. [可空] String relationName 联系人姓名
 * 17.1. [可空] String familyRelationId 联系人关系ID
 * 17.2. [可空] String familyRelationName 联系人关系name
 * 18. [可空] String relationPhone 联系人电话
 * 18.1. [可空] Boolean isGovHelp 是否属于政府扶助类型
 * 18.2. [可空] String govHelpId 政府扶助类型id
 * 18.3. [可空] String govHelpName 政府扶助类型中文名称
 * 19. [不可空] String subjectTypeId 对象类型id
 * 20. [不可空] String subjectTypeName 对象类型中文名称
 * 20.1. [可空] String subjectDisease 对象所患疾病，名称逗号分隔
 * 20.2. [不可空] Boolean haveFoodAllergy 是否有食物过敏
 * 20.3. [可空] String foodAllergy 食物过敏
 * 20.4. [可空] String subjectFoodProhibit 对象食物禁忌，名称逗号分隔
 * 20.5. [可空] String lunchBoxNo 饭盒编号
 * 20.6. [可空] String subjectFoodLoveId 对象饮食偏好id
 * 20.7. [可空] String subjectFoodLoveName 对象饮食偏好name
 * 20.8. [可空] Boolean isMealHelp 进餐是否协助
 * 21. [可空] String subjectDesc 对象备注
 * 22. [不可空] String circleId 客户所属的工作圈id
 * 23. [不可空] String deliveType 配送方式  助餐点 SITE  到户上门  HOME
 * 24. [不可空] String deliveSiteId 配送地点id
 * 25. [不可空] String deliveSiteName 配送地点名称
 * 26. [不可空] Double overdraft 配餐透支额度
 * 27. [不可空] java.util.Date createTime 创建时间
 * 28. [不可空] String createCircleId 创建工作圈id
 * 29. [不可空] String createTeamId 创建工作组id
 * 30. [不可空] String createUserId 创建工号id
 * 31. [不可空] String createNickname 创建姓名
 * 32. [不可空] Boolean isCancel 是否被注销
 * 33. [可空] String cancelReason 注销原因
 * 34. [可空] java.util.Date cancelDate 注销机器时间
 * 35. [可空] String cancelUserId 注销操作员id
 * 36. [可空] String cancelUserName 注销操作员姓名
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-subject/java/domain/com/wit/fxp/nxft/domain/model/subject/base/NxftSubject.html">NxftSubject代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractNxftSubject {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String contactPhone, String regionId, String regionName, String address, Boolean isNative, String livingCondiName, String familyRelationId, String familyRelationName, Boolean isGovHelp, String govHelpId, String govHelpName, Boolean haveFoodAllergy, String foodAllergy, String subjectFoodProhibit, _PersonInfo personInfo, _SubjectInfo subjectInfo, _CreateInfo createInfo, _CancelInfo cancelInfo) {

        if (contactPhone != null && contactPhone.length() > 30) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[contactPhone(联系电话)]属性超长，最大允许30，实际为" + contactPhone.length() + "。");
        }

        if (regionId == null) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[regionId(行政区域ID)]属性不能为空。");
        }

        if (regionId != null && regionId.length() > 32) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[regionId(行政区域ID)]属性超长，最大允许32，实际为" + regionId.length() + "。");
        }

        if (regionName == null) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[regionName(行政区域名称)]属性不能为空。");
        }

        if (regionName != null && regionName.length() > 80) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[regionName(行政区域名称)]属性超长，最大允许80，实际为" + regionName.length() + "。");
        }

        if (address != null && address.length() > 200) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[address(详细地址)]属性超长，最大允许200，实际为" + address.length() + "。");
        }

        if (livingCondiName != null && livingCondiName.length() > 60) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[livingCondiName(居住情况，多选，用逗号分隔)]属性超长，最大允许60，实际为" + livingCondiName.length() + "。");
        }

        if (familyRelationId != null && familyRelationId.length() > 32) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[familyRelationId(联系人关系ID)]属性超长，最大允许32，实际为" + familyRelationId.length() + "。");
        }

        if (familyRelationName != null && familyRelationName.length() > 30) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[familyRelationName(联系人关系name)]属性超长，最大允许30，实际为" + familyRelationName.length() + "。");
        }

        if (govHelpId != null && govHelpId.length() > 32) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[govHelpId(政府扶助类型id)]属性超长，最大允许32，实际为" + govHelpId.length() + "。");
        }

        if (govHelpName != null && govHelpName.length() > 30) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[govHelpName(政府扶助类型中文名称)]属性超长，最大允许30，实际为" + govHelpName.length() + "。");
        }

        if (haveFoodAllergy == null) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[haveFoodAllergy(是否有食物过敏)]属性不能为空。");
        }

        if (foodAllergy != null && foodAllergy.length() > 200) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[foodAllergy(食物过敏)]属性超长，最大允许200，实际为" + foodAllergy.length() + "。");
        }

        if (subjectFoodProhibit != null && subjectFoodProhibit.length() > 100) {
            throw new RuntimeException("[NxftSubject(配餐对象)]对象的[subjectFoodProhibit(对象食物禁忌，名称逗号分隔)]属性超长，最大允许100，实际为" + subjectFoodProhibit.length() + "。");
        }

        if (personInfo != null) {
            checkComponentProperties("NxftSubject#personInfo", personInfo);
        }

        if (subjectInfo != null) {
            checkComponentProperties("NxftSubject#subjectInfo", subjectInfo);
        }

        if (createInfo != null) {
            checkComponentProperties("NxftSubject#createInfo", createInfo);
        }

        if (cancelInfo != null) {
            checkComponentProperties("NxftSubject#cancelInfo", cancelInfo);
        }
    }

    /**
     * 检查[客户信息]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param personInfo 客户信息
     */
    private static void checkComponentProperties(String compPropertyName, _PersonInfo personInfo) {

        if (personInfo.getPersonId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[personId(客户ID)]属性不能为空。");
        }

        if (personInfo.getPersonId() != null && personInfo.getPersonId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[personId(客户ID)]属性超长，最大允许32，实际为" + personInfo.getPersonId().length() + "。");
        }

        if (personInfo.getSubjectName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectName(姓名)]属性不能为空。");
        }

        if (personInfo.getSubjectName() != null && personInfo.getSubjectName().length() > 80) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectName(姓名)]属性超长，最大允许80，实际为" + personInfo.getSubjectName().length() + "。");
        }

        if (personInfo.getSexId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[sexId(性别id     fxp.p_sex 字典)]属性不能为空。");
        }

        if (personInfo.getSexId() != null && personInfo.getSexId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[sexId(性别id     fxp.p_sex 字典)]属性超长，最大允许32，实际为" + personInfo.getSexId().length() + "。");
        }

        if (personInfo.getSexName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[sexName(性别name)]属性不能为空。");
        }

        if (personInfo.getSexName() != null && personInfo.getSexName().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[sexName(性别name)]属性超长，最大允许30，实际为" + personInfo.getSexName().length() + "。");
        }

        if (personInfo.getIdtypeId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[idtypeId(证件类别id)]属性不能为空。");
        }

        if (personInfo.getIdtypeId() != null && personInfo.getIdtypeId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[idtypeId(证件类别id)]属性超长，最大允许32，实际为" + personInfo.getIdtypeId().length() + "。");
        }

        if (personInfo.getIdtypeName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[idtypeName(证件类别中文)]属性不能为空。");
        }

        if (personInfo.getIdtypeName() != null && personInfo.getIdtypeName().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[idtypeName(证件类别中文)]属性超长，最大允许30，实际为" + personInfo.getIdtypeName().length() + "。");
        }

        if (personInfo.getIdcardno() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[idcardno(身份证号)]属性不能为空。");
        }

        if (personInfo.getIdcardno() != null && personInfo.getIdcardno().length() > 20) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[idcardno(身份证号)]属性超长，最大允许20，实际为" + personInfo.getIdcardno().length() + "。");
        }

        if (personInfo.getBirthDate() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[birthDate(出生日期)]属性不能为空。");
        }

        if (personInfo.getSubjectFoodLoveId() != null && personInfo.getSubjectFoodLoveId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectFoodLoveId(对象饮食偏好id)]属性超长，最大允许32，实际为" + personInfo.getSubjectFoodLoveId().length() + "。");
        }

        if (personInfo.getSubjectFoodLoveName() != null && personInfo.getSubjectFoodLoveName().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectFoodLoveName(对象饮食偏好name)]属性超长，最大允许30，实际为" + personInfo.getSubjectFoodLoveName().length() + "。");
        }

        if (personInfo.getCircleId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[circleId(客户所属的工作圈id)]属性不能为空。");
        }

        if (personInfo.getCircleId() != null && personInfo.getCircleId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[circleId(客户所属的工作圈id)]属性超长，最大允许32，实际为" + personInfo.getCircleId().length() + "。");
        }
    }

    /**
     * 检查[客户扩展信息]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param subjectInfo 客户扩展信息
     */
    private static void checkComponentProperties(String compPropertyName, _SubjectInfo subjectInfo) {

        if (subjectInfo.getRelationName() != null && subjectInfo.getRelationName().length() > 40) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[relationName(联系人姓名)]属性超长，最大允许40，实际为" + subjectInfo.getRelationName().length() + "。");
        }

        if (subjectInfo.getRelationPhone() != null && subjectInfo.getRelationPhone().length() > 40) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[relationPhone(联系人电话)]属性超长，最大允许40，实际为" + subjectInfo.getRelationPhone().length() + "。");
        }

        if (subjectInfo.getSubjectTypeId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectTypeId(对象类型id)]属性不能为空。");
        }

        if (subjectInfo.getSubjectTypeId() != null && subjectInfo.getSubjectTypeId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectTypeId(对象类型id)]属性超长，最大允许32，实际为" + subjectInfo.getSubjectTypeId().length() + "。");
        }

        if (subjectInfo.getSubjectTypeName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectTypeName(对象类型中文名称)]属性不能为空。");
        }

        if (subjectInfo.getSubjectTypeName() != null && subjectInfo.getSubjectTypeName().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectTypeName(对象类型中文名称)]属性超长，最大允许30，实际为" + subjectInfo.getSubjectTypeName().length() + "。");
        }

        if (subjectInfo.getSubjectDesc() != null && subjectInfo.getSubjectDesc().length() > 256) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectDesc(对象备注)]属性超长，最大允许256，实际为" + subjectInfo.getSubjectDesc().length() + "。");
        }

        if (subjectInfo.getDeliveType() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveType(配送方式  助餐点 SITE  到户上门  HOME)]属性不能为空。");
        }

        if (subjectInfo.getDeliveType() != null && subjectInfo.getDeliveType().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveType(配送方式  助餐点 SITE  到户上门  HOME)]属性超长，最大允许30，实际为" + subjectInfo.getDeliveType().length() + "。");
        }

        if (subjectInfo.getDeliveSiteId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveSiteId(配送地点id)]属性不能为空。");
        }

        if (subjectInfo.getDeliveSiteId() != null && subjectInfo.getDeliveSiteId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveSiteId(配送地点id)]属性超长，最大允许32，实际为" + subjectInfo.getDeliveSiteId().length() + "。");
        }

        if (subjectInfo.getDeliveSiteName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveSiteName(配送地点名称)]属性不能为空。");
        }

        if (subjectInfo.getDeliveSiteName() != null && subjectInfo.getDeliveSiteName().length() > 40) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveSiteName(配送地点名称)]属性超长，最大允许40，实际为" + subjectInfo.getDeliveSiteName().length() + "。");
        }

        if (subjectInfo.getOverdraft() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[overdraft(配餐透支额度)]属性不能为空。");
        }

        if (subjectInfo.getSubjectDisease() != null && subjectInfo.getSubjectDisease().length() > 100) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectDisease(对象所患疾病，名称逗号分隔)]属性超长，最大允许100，实际为" + subjectInfo.getSubjectDisease().length() + "。");
        }

        if (subjectInfo.getLunchBoxNo() != null && subjectInfo.getLunchBoxNo().length() > 20) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lunchBoxNo(饭盒编号)]属性超长，最大允许20，实际为" + subjectInfo.getLunchBoxNo().length() + "。");
        }
    }

    /**
     * 检查[创建信息]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param createInfo 创建信息
     */
    private static void checkComponentProperties(String compPropertyName, _CreateInfo createInfo) {

        if (createInfo.getCreateTime() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createTime(创建时间)]属性不能为空。");
        }

        if (createInfo.getCreateCircleId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createCircleId(创建工作圈id)]属性不能为空。");
        }

        if (createInfo.getCreateCircleId() != null && createInfo.getCreateCircleId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createCircleId(创建工作圈id)]属性超长，最大允许32，实际为" + createInfo.getCreateCircleId().length() + "。");
        }

        if (createInfo.getCreateTeamId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createTeamId(创建工作组id)]属性不能为空。");
        }

        if (createInfo.getCreateTeamId() != null && createInfo.getCreateTeamId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createTeamId(创建工作组id)]属性超长，最大允许32，实际为" + createInfo.getCreateTeamId().length() + "。");
        }

        if (createInfo.getCreateUserId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createUserId(创建工号id)]属性不能为空。");
        }

        if (createInfo.getCreateUserId() != null && createInfo.getCreateUserId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createUserId(创建工号id)]属性超长，最大允许32，实际为" + createInfo.getCreateUserId().length() + "。");
        }

        if (createInfo.getCreateNickname() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createNickname(创建姓名)]属性不能为空。");
        }

        if (createInfo.getCreateNickname() != null && createInfo.getCreateNickname().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createNickname(创建姓名)]属性超长，最大允许30，实际为" + createInfo.getCreateNickname().length() + "。");
        }
    }

    /**
     * 检查[注销信息]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param cancelInfo 注销信息
     */
    private static void checkComponentProperties(String compPropertyName, _CancelInfo cancelInfo) {

        if (cancelInfo.getIsCancel() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[isCancel(是否被注销)]属性不能为空。");
        }

        if (cancelInfo.getCancelReason() != null && cancelInfo.getCancelReason().length() > 60) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[cancelReason(注销原因)]属性超长，最大允许60，实际为" + cancelInfo.getCancelReason().length() + "。");
        }

        if (cancelInfo.getCancelUserId() != null && cancelInfo.getCancelUserId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[cancelUserId(注销操作员id)]属性超长，最大允许32，实际为" + cancelInfo.getCancelUserId().length() + "。");
        }

        if (cancelInfo.getCancelUserName() != null && cancelInfo.getCancelUserName().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[cancelUserName(注销操作员姓名)]属性超长，最大允许30，实际为" + cancelInfo.getCancelUserName().length() + "。");
        }
    }

    // ---------- _PersonInfo组件定义
    /**
     * [组件类] 客户信息。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _PersonInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 客户ID */
        protected final String personId;

        /** [不可空] 姓名 */
        protected final String subjectName;

        /** [不可空] 性别id     fxp.p_sex 字典 */
        protected final String sexId;

        /** [不可空] 性别name */
        protected final String sexName;

        /** [不可空] 证件类别id */
        protected final String idtypeId;

        /** [不可空] 证件类别中文 */
        protected final String idtypeName;

        /** [不可空] 身份证号 */
        protected final String idcardno;

        /** [不可空] 出生日期 */
        protected final java.util.Date birthDate;

        /** [可空] 对象饮食偏好id */
        protected final String subjectFoodLoveId;

        /** [可空] 对象饮食偏好name */
        protected final String subjectFoodLoveName;

        /** [不可空] 客户所属的工作圈id */
        protected final String circleId;

        /** [可空] 进餐是否协助 */
        protected final Boolean isMealHelp;

        // _PersonInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _PersonInfo() {
            personId = null;
            subjectName = null;
            sexId = null;
            sexName = null;
            idtypeId = null;
            idtypeName = null;
            idcardno = null;
            birthDate = null;
            subjectFoodLoveId = null;
            subjectFoodLoveName = null;
            circleId = null;
            isMealHelp = false;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _PersonInfo(_PersonInfo copy) {
            this( copy.personId, copy.subjectName, copy.sexId, copy.sexName, copy.idtypeId, copy.idtypeName, copy.idcardno, copy.birthDate, copy.subjectFoodLoveId, copy.subjectFoodLoveName, copy.circleId, copy.isMealHelp);
        }

        /**
         * 完整构造函数。
         *
         * @param personId [不可空] 客户ID
         * @param subjectName [不可空] 姓名
         * @param sexId [不可空] 性别id     fxp.p_sex 字典
         * @param sexName [不可空] 性别name
         * @param idtypeId [不可空] 证件类别id
         * @param idtypeName [不可空] 证件类别中文
         * @param idcardno [不可空] 身份证号
         * @param birthDate [不可空] 出生日期
         * @param subjectFoodLoveId [可空] 对象饮食偏好id
         * @param subjectFoodLoveName [可空] 对象饮食偏好name
         * @param circleId [不可空] 客户所属的工作圈id
         * @param isMealHelp [可空] 进餐是否协助
         */
        protected _PersonInfo(String personId, String subjectName, String sexId, String sexName, String idtypeId, String idtypeName, String idcardno, java.util.Date birthDate, String subjectFoodLoveId, String subjectFoodLoveName, String circleId, Boolean isMealHelp) {
            this.personId = SafeCopier.copy(personId);
            this.subjectName = SafeCopier.copy(subjectName);
            this.sexId = SafeCopier.copy(sexId);
            this.sexName = SafeCopier.copy(sexName);
            this.idtypeId = SafeCopier.copy(idtypeId);
            this.idtypeName = SafeCopier.copy(idtypeName);
            this.idcardno = SafeCopier.copy(idcardno);
            this.birthDate = SafeCopier.copy(birthDate);
            this.subjectFoodLoveId = SafeCopier.copy(subjectFoodLoveId);
            this.subjectFoodLoveName = SafeCopier.copy(subjectFoodLoveName);
            this.circleId = SafeCopier.copy(circleId);
            this.isMealHelp = SafeCopier.copy(isMealHelp);
        }


        // _PersonInfo属性的getter/setter


        /** @return [不可空] 客户ID */
        public String getPersonId() {
            return SafeCopier.copy(personId);
        }

        /** @return [不可空] 姓名 */
        public String getSubjectName() {
            return SafeCopier.copy(subjectName);
        }

        /** @return [不可空] 性别id     fxp.p_sex 字典 */
        public String getSexId() {
            return SafeCopier.copy(sexId);
        }

        /** @return [不可空] 性别name */
        public String getSexName() {
            return SafeCopier.copy(sexName);
        }

        /** @return [不可空] 证件类别id */
        public String getIdtypeId() {
            return SafeCopier.copy(idtypeId);
        }

        /** @return [不可空] 证件类别中文 */
        public String getIdtypeName() {
            return SafeCopier.copy(idtypeName);
        }

        /** @return [不可空] 身份证号 */
        public String getIdcardno() {
            return SafeCopier.copy(idcardno);
        }

        /** @return [不可空] 出生日期 */
        public java.util.Date getBirthDate() {
            return SafeCopier.copy(birthDate);
        }

        /** @return [可空] 对象饮食偏好id */
        public String getSubjectFoodLoveId() {
            return SafeCopier.copy(subjectFoodLoveId);
        }

        /** @return [可空] 对象饮食偏好name */
        public String getSubjectFoodLoveName() {
            return SafeCopier.copy(subjectFoodLoveName);
        }

        /** @return [不可空] 客户所属的工作圈id */
        public String getCircleId() {
            return SafeCopier.copy(circleId);
        }

        /** @return [可空] 进餐是否协助 */
        public Boolean getIsMealHelp() {
            return SafeCopier.copy(isMealHelp);
        }

        // _PersonInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(personId);
            builder.append(subjectName);
            builder.append(sexId);
            builder.append(sexName);
            builder.append(idtypeId);
            builder.append(idtypeName);
            builder.append(idcardno);
            builder.append(birthDate);
            builder.append(subjectFoodLoveId);
            builder.append(subjectFoodLoveName);
            builder.append(circleId);
            builder.append(isMealHelp);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _PersonInfo other = (_PersonInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(personId, other.personId);
            builder.append(subjectName, other.subjectName);
            builder.append(sexId, other.sexId);
            builder.append(sexName, other.sexName);
            builder.append(idtypeId, other.idtypeId);
            builder.append(idtypeName, other.idtypeName);
            builder.append(idcardno, other.idcardno);
            builder.append(birthDate, other.birthDate);
            builder.append(subjectFoodLoveId, other.subjectFoodLoveId);
            builder.append(subjectFoodLoveName, other.subjectFoodLoveName);
            builder.append(circleId, other.circleId);
            builder.append(isMealHelp, other.isMealHelp);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("personId", personId);
            builder.append("subjectName", subjectName);
            builder.append("sexId", sexId);
            builder.append("sexName", sexName);
            builder.append("idtypeId", idtypeId);
            builder.append("idtypeName", idtypeName);
            builder.append("idcardno", idcardno);
            builder.append("birthDate", birthDate);
            builder.append("subjectFoodLoveId", subjectFoodLoveId);
            builder.append("subjectFoodLoveName", subjectFoodLoveName);
            builder.append("circleId", circleId);
            builder.append("isMealHelp", isMealHelp);
            return builder.toString();
        }

    }    // _PersonInfo

    // ---------- _SubjectInfo组件定义
    /**
     * [组件类] 客户扩展信息。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _SubjectInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [可空] 联系人姓名 */
        protected final String relationName;

        /** [可空] 联系人电话 */
        protected final String relationPhone;

        /** [不可空] 对象类型id */
        protected final String subjectTypeId;

        /** [不可空] 对象类型中文名称 */
        protected final String subjectTypeName;

        /** [可空] 对象备注 */
        protected final String subjectDesc;

        /** [不可空] 配送方式  助餐点 SITE  到户上门  HOME */
        protected final String deliveType;

        /** [不可空] 配送地点id */
        protected final String deliveSiteId;

        /** [不可空] 配送地点名称 */
        protected final String deliveSiteName;

        /** [不可空] 配餐透支额度 */
        protected final Double overdraft;

        /** [可空] 对象所患疾病，名称逗号分隔 */
        protected final String subjectDisease;

        /** [可空] 饭盒编号 */
        protected final String lunchBoxNo;

        // _SubjectInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _SubjectInfo() {
            relationName = null;
            relationPhone = null;
            subjectTypeId = null;
            subjectTypeName = null;
            subjectDesc = null;
            deliveType = null;
            deliveSiteId = null;
            deliveSiteName = null;
            overdraft = null;
            subjectDisease = null;
            lunchBoxNo = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _SubjectInfo(_SubjectInfo copy) {
            this( copy.relationName, copy.relationPhone, copy.subjectTypeId, copy.subjectTypeName, copy.subjectDesc, copy.deliveType, copy.deliveSiteId, copy.deliveSiteName, copy.overdraft, copy.subjectDisease, copy.lunchBoxNo);
        }

        /**
         * 完整构造函数。
         *
         * @param relationName [可空] 联系人姓名
         * @param relationPhone [可空] 联系人电话
         * @param subjectTypeId [不可空] 对象类型id
         * @param subjectTypeName [不可空] 对象类型中文名称
         * @param subjectDesc [可空] 对象备注
         * @param deliveType [不可空] 配送方式  助餐点 SITE  到户上门  HOME
         * @param deliveSiteId [不可空] 配送地点id
         * @param deliveSiteName [不可空] 配送地点名称
         * @param overdraft [不可空] 配餐透支额度
         * @param subjectDisease [可空] 对象所患疾病，名称逗号分隔
         * @param lunchBoxNo [可空] 饭盒编号
         */
        protected _SubjectInfo(String relationName, String relationPhone, String subjectTypeId, String subjectTypeName, String subjectDesc, String deliveType, String deliveSiteId, String deliveSiteName, Double overdraft, String subjectDisease, String lunchBoxNo) {
            this.relationName = SafeCopier.copy(relationName);
            this.relationPhone = SafeCopier.copy(relationPhone);
            this.subjectTypeId = SafeCopier.copy(subjectTypeId);
            this.subjectTypeName = SafeCopier.copy(subjectTypeName);
            this.subjectDesc = SafeCopier.copy(subjectDesc);
            this.deliveType = SafeCopier.copy(deliveType);
            this.deliveSiteId = SafeCopier.copy(deliveSiteId);
            this.deliveSiteName = SafeCopier.copy(deliveSiteName);
            this.overdraft = SafeCopier.copy(overdraft);
            this.subjectDisease = SafeCopier.copy(subjectDisease);
            this.lunchBoxNo = SafeCopier.copy(lunchBoxNo);
        }


        // _SubjectInfo属性的getter/setter


        /** @return [可空] 联系人姓名 */
        public String getRelationName() {
            return SafeCopier.copy(relationName);
        }

        /** @return [可空] 联系人电话 */
        public String getRelationPhone() {
            return SafeCopier.copy(relationPhone);
        }

        /** @return [不可空] 对象类型id */
        public String getSubjectTypeId() {
            return SafeCopier.copy(subjectTypeId);
        }

        /** @return [不可空] 对象类型中文名称 */
        public String getSubjectTypeName() {
            return SafeCopier.copy(subjectTypeName);
        }

        /** @return [可空] 对象备注 */
        public String getSubjectDesc() {
            return SafeCopier.copy(subjectDesc);
        }

        /** @return [不可空] 配送方式  助餐点 SITE  到户上门  HOME */
        public String getDeliveType() {
            return SafeCopier.copy(deliveType);
        }

        /** @return [不可空] 配送地点id */
        public String getDeliveSiteId() {
            return SafeCopier.copy(deliveSiteId);
        }

        /** @return [不可空] 配送地点名称 */
        public String getDeliveSiteName() {
            return SafeCopier.copy(deliveSiteName);
        }

        /** @return [不可空] 配餐透支额度 */
        public Double getOverdraft() {
            return SafeCopier.copy(overdraft);
        }

        /** @return [可空] 对象所患疾病，名称逗号分隔 */
        public String getSubjectDisease() {
            return SafeCopier.copy(subjectDisease);
        }

        /** @return [可空] 饭盒编号 */
        public String getLunchBoxNo() {
            return SafeCopier.copy(lunchBoxNo);
        }

        // _SubjectInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(relationName);
            builder.append(relationPhone);
            builder.append(subjectTypeId);
            builder.append(subjectTypeName);
            builder.append(subjectDesc);
            builder.append(deliveType);
            builder.append(deliveSiteId);
            builder.append(deliveSiteName);
            builder.append(overdraft);
            builder.append(subjectDisease);
            builder.append(lunchBoxNo);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _SubjectInfo other = (_SubjectInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(relationName, other.relationName);
            builder.append(relationPhone, other.relationPhone);
            builder.append(subjectTypeId, other.subjectTypeId);
            builder.append(subjectTypeName, other.subjectTypeName);
            builder.append(subjectDesc, other.subjectDesc);
            builder.append(deliveType, other.deliveType);
            builder.append(deliveSiteId, other.deliveSiteId);
            builder.append(deliveSiteName, other.deliveSiteName);
            builder.append(overdraft, other.overdraft);
            builder.append(subjectDisease, other.subjectDisease);
            builder.append(lunchBoxNo, other.lunchBoxNo);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("relationName", relationName);
            builder.append("relationPhone", relationPhone);
            builder.append("subjectTypeId", subjectTypeId);
            builder.append("subjectTypeName", subjectTypeName);
            builder.append("subjectDesc", subjectDesc);
            builder.append("deliveType", deliveType);
            builder.append("deliveSiteId", deliveSiteId);
            builder.append("deliveSiteName", deliveSiteName);
            builder.append("overdraft", overdraft);
            builder.append("subjectDisease", subjectDisease);
            builder.append("lunchBoxNo", lunchBoxNo);
            return builder.toString();
        }

    }    // _SubjectInfo

    // ---------- _CreateInfo组件定义
    /**
     * [组件类] 创建信息。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _CreateInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 创建时间 */
        protected final java.util.Date createTime;

        /** [不可空] 创建工作圈id */
        protected final String createCircleId;

        /** [不可空] 创建工作组id */
        protected final String createTeamId;

        /** [不可空] 创建工号id */
        protected final String createUserId;

        /** [不可空] 创建姓名 */
        protected final String createNickname;

        // _CreateInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _CreateInfo() {
            createTime = null;
            createCircleId = null;
            createTeamId = null;
            createUserId = null;
            createNickname = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _CreateInfo(_CreateInfo copy) {
            this( copy.createTime, copy.createCircleId, copy.createTeamId, copy.createUserId, copy.createNickname);
        }

        /**
         * 完整构造函数。
         *
         * @param createTime [不可空] 创建时间
         * @param createCircleId [不可空] 创建工作圈id
         * @param createTeamId [不可空] 创建工作组id
         * @param createUserId [不可空] 创建工号id
         * @param createNickname [不可空] 创建姓名
         */
        protected _CreateInfo(java.util.Date createTime, String createCircleId, String createTeamId, String createUserId, String createNickname) {
            this.createTime = SafeCopier.copy(createTime);
            this.createCircleId = SafeCopier.copy(createCircleId);
            this.createTeamId = SafeCopier.copy(createTeamId);
            this.createUserId = SafeCopier.copy(createUserId);
            this.createNickname = SafeCopier.copy(createNickname);
        }


        // _CreateInfo属性的getter/setter


        /** @return [不可空] 创建时间 */
        public java.util.Date getCreateTime() {
            return SafeCopier.copy(createTime);
        }

        /** @return [不可空] 创建工作圈id */
        public String getCreateCircleId() {
            return SafeCopier.copy(createCircleId);
        }

        /** @return [不可空] 创建工作组id */
        public String getCreateTeamId() {
            return SafeCopier.copy(createTeamId);
        }

        /** @return [不可空] 创建工号id */
        public String getCreateUserId() {
            return SafeCopier.copy(createUserId);
        }

        /** @return [不可空] 创建姓名 */
        public String getCreateNickname() {
            return SafeCopier.copy(createNickname);
        }

        // _CreateInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(createTime);
            builder.append(createCircleId);
            builder.append(createTeamId);
            builder.append(createUserId);
            builder.append(createNickname);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _CreateInfo other = (_CreateInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(createTime, other.createTime);
            builder.append(createCircleId, other.createCircleId);
            builder.append(createTeamId, other.createTeamId);
            builder.append(createUserId, other.createUserId);
            builder.append(createNickname, other.createNickname);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("createTime", createTime);
            builder.append("createCircleId", createCircleId);
            builder.append("createTeamId", createTeamId);
            builder.append("createUserId", createUserId);
            builder.append("createNickname", createNickname);
            return builder.toString();
        }

    }    // _CreateInfo

    // ---------- _CancelInfo组件定义
    /**
     * [组件类] 注销信息。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _CancelInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 是否被注销 */
        protected final Boolean isCancel;

        /** [可空] 注销原因 */
        protected final String cancelReason;

        /** [可空] 注销机器时间 */
        protected final java.util.Date cancelDate;

        /** [可空] 注销操作员id */
        protected final String cancelUserId;

        /** [可空] 注销操作员姓名 */
        protected final String cancelUserName;

        // _CancelInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _CancelInfo() {
            isCancel = false;
            cancelReason = null;
            cancelDate = null;
            cancelUserId = null;
            cancelUserName = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _CancelInfo(_CancelInfo copy) {
            this( copy.isCancel, copy.cancelReason, copy.cancelDate, copy.cancelUserId, copy.cancelUserName);
        }

        /**
         * 完整构造函数。
         *
         * @param isCancel [不可空] 是否被注销
         * @param cancelReason [可空] 注销原因
         * @param cancelDate [可空] 注销机器时间
         * @param cancelUserId [可空] 注销操作员id
         * @param cancelUserName [可空] 注销操作员姓名
         */
        protected _CancelInfo(Boolean isCancel, String cancelReason, java.util.Date cancelDate, String cancelUserId, String cancelUserName) {
            this.isCancel = SafeCopier.copy(isCancel);
            this.cancelReason = SafeCopier.copy(cancelReason);
            this.cancelDate = SafeCopier.copy(cancelDate);
            this.cancelUserId = SafeCopier.copy(cancelUserId);
            this.cancelUserName = SafeCopier.copy(cancelUserName);
        }


        // _CancelInfo属性的getter/setter


        /** @return [不可空] 是否被注销 */
        public Boolean getIsCancel() {
            return SafeCopier.copy(isCancel);
        }

        /** @return [可空] 注销原因 */
        public String getCancelReason() {
            return SafeCopier.copy(cancelReason);
        }

        /** @return [可空] 注销机器时间 */
        public java.util.Date getCancelDate() {
            return SafeCopier.copy(cancelDate);
        }

        /** @return [可空] 注销操作员id */
        public String getCancelUserId() {
            return SafeCopier.copy(cancelUserId);
        }

        /** @return [可空] 注销操作员姓名 */
        public String getCancelUserName() {
            return SafeCopier.copy(cancelUserName);
        }

        // _CancelInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(isCancel);
            builder.append(cancelReason);
            builder.append(cancelDate);
            builder.append(cancelUserId);
            builder.append(cancelUserName);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _CancelInfo other = (_CancelInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(isCancel, other.isCancel);
            builder.append(cancelReason, other.cancelReason);
            builder.append(cancelDate, other.cancelDate);
            builder.append(cancelUserId, other.cancelUserId);
            builder.append(cancelUserName, other.cancelUserName);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("isCancel", isCancel);
            builder.append("cancelReason", cancelReason);
            builder.append("cancelDate", cancelDate);
            builder.append("cancelUserId", cancelUserId);
            builder.append("cancelUserName", cancelUserName);
            return builder.toString();
        }

    }    // _CancelInfo

}
