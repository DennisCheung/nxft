package com.wit.fxp.nxft.domain.model.subject;

import java.util.Collection;
import java.util.List;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.datatype.IdAndName;
import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.domain.model.person.Person;
import com.wit.fxp.nxft.domain.model.subject.base.AbstractNxftSubject;
import com.wit.fxp.nxft.utils.DateUtils;
import com.wit.utils.CollectionUtils;

/**
 * 配餐对象对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractNxftSubject
 */
public class NxftSubject extends AbstractLoggingEntity<String> implements PropertyChecker {

    @lombok.experimental.BuilderCall(builderMethodName = "新建")
    public static NxftSubject newNxftSubjectPerson(InvocationContext ic, Actor actor, Person person, AddSubjectData data) {
        return NxftSubject.fullNxftSubjectBuilder()
                ._id____________________(ic.generateId(NxftSubject.class))
                ._contactPhone__________(data.getPhone())
                ._regionId______________(data.getRegion() == null ? null : data.getRegion().getId())
                ._regionName____________(data.getRegion() == null ? null : data.getRegion().getName())
                ._address_______________(data.getAddress())
                ._isNative______________(data.getWrahuji() == null ? false : data.getWrahuji().getId().equals("1") ? true : false)
                ._livingCondiName_______(null)
                ._familyRelationId______(data.getWnjinji() == null ? null : data.getWnjinji().getId())
                ._familyRelationName____(data.getWnjinji() == null ? null : data.getWnjinji().getName())
                ._isGovHelp_____________(data.isWrafuzhu())
                ._govHelpId_____________(data.getWchfuzhu() == null ? null : data.getWchfuzhu().getId())
                ._govHelpName___________(data.getWchfuzhu() == null ? null : data.getWchfuzhu().getName())
                ._haveFoodAllergy_______(data.isWraguom())
                ._foodAllergy___________(data.getTfguom())
                ._subjectFoodProhibit___(null)
                ._personInfo____________(PersonInfo.fullBuilder()
                        ._personId______________(person.getId())
                        ._subjectName___________(person.getBasicInfo().getPersonName())
                        ._sexId_________________(person.getBasicInfo().getSexId())
                        ._sexName_______________(person.getBasicInfo().getSexName())
                        ._idtypeId______________("01")
                        ._idtypeName____________("二代身份证")
                        ._idcardno______________(person.getBasicInfo().getIdNo() == null ? data.getIdNo() : person.getBasicInfo().getIdNo())
                        ._birthDate_____________(person.getBasicInfo().getBirthDate())
                        ._subjectFoodLoveId_____(data.getSubjectFoodLove().getId())
                        ._subjectFoodLoveName___(data.getSubjectFoodLove().getName())
                        ._circleId______________(person.getCircleInfo().getCircleId())
                        ._isMealHelp____________(data.isMealHelp())
                        ._build_())
                ._subjectInfo___________(SubjectInfo.fullBuilder()
                        ._relationName______(data.getJinjiname())
                        ._relationPhone_____(data.getJinjiphone())
                        ._subjectTypeId_____(data.getSubjectType().getId())
                        ._subjectTypeName___(data.getSubjectType().getName())
                        ._subjectDesc_______(data.getSubjectDesc())
                        ._deliveType________(data.getDType())
                        ._deliveSiteId______(data.getTeam().getId())
                        ._deliveSiteName____(data.getTeam().getName())
                        ._overdraft_________(data.getDd())
                        ._subjectDisease____(null)
                        ._lunchBoxNo________(data.getLunchBoxNo())
                        ._build_())
                ._createInfo____________(CreateInfo.fullBuilder()
                        ._createTime________(ic.now())
                        ._createCircleId____(actor.getCircle().getId())
                        ._createTeamId______(actor.getTeam().getId())
                        ._createUserId______(actor.getUser().getId())
                        ._createNickname____(actor.getUser().getBasicInfo().getNickname())
                        ._build_())
                ._cancelInfo____________(CancelInfo.EMPTY)
                ._build_();
    }

    public void updateSubjectDisease(InvocationContext ic, List<IdAndName> diseases) {
        if (diseases == null) {
            nxftSubjectDiseaseSet.clear();
        }
        else {
            CollectionUtils.<NxftSubjectDisease, IdAndName>mergeInvoker()
                    ._target____(nxftSubjectDiseaseSet)
                    ._source____(diseases)
                    ._comp______((a, b) -> a.getDiseaseId().equals(b.getId()))
                    ._createNew_(e -> NxftSubjectDisease.newNxftSubjectDisease(ic, e, getId()))
                    ._invoke_();

            IdAndName other = IdAndName.getById(diseases, "99");
            if (other != null) {
                NxftSubjectDisease dis = this.getById(nxftSubjectDiseaseSet, "99");
                if (dis != null) {
                    dis.updateName(other.getName());
                }
            }
        }

        this.subjectInfo = this.subjectInfo.updateDiseaseDesc(IdAndName.toNames(diseases, "，"));
    }

    public void updateLivingCon(InvocationContext ic, List<IdAndName> livs) {
        if (livs == null) {
            nxftSubjectLivingCondiSet.clear();
        }
        else {
            CollectionUtils.<NxftSubjectLivingCondi, IdAndName>mergeInvoker()
                    ._target____(nxftSubjectLivingCondiSet)
                    ._source____(livs)
                    ._comp______((a, b) -> a.getLivingCondiId().equals(b.getId()))
                    ._createNew_(e -> NxftSubjectLivingCondi.newNxftSubjectLivingCondi(ic, e, getId()))
                    ._invoke_();
        }

        this.livingCondiName = IdAndName.toNames(livs, "，");

    }

    public void updateFoodbiHits(InvocationContext ic, List<IdAndName> hits) {
        if (hits == null) {
            nxftSubjectFoodProhibitSet.clear();
        }
        else {
            CollectionUtils.<NxftSubjectFoodProhibit, IdAndName>mergeInvoker()
                    ._target____(nxftSubjectFoodProhibitSet)
                    ._source____(hits)
                    ._comp______((a, b) -> a.getFoodProhibitId().equals(b.getId()))
                    ._createNew_(e -> NxftSubjectFoodProhibit.newNxftSubjectFoodProhibit(ic, e, getId()))
                    ._invoke_();

            IdAndName other = IdAndName.getById(hits, "99");
            if (other != null) {
                NxftSubjectFoodProhibit dis = this.getFpById(nxftSubjectFoodProhibitSet, "99");
                if (dis != null) {
                    dis.updateName(other.getName());
                }
            }
        }

        this.subjectFoodProhibit = IdAndName.toNames(hits, "，");
    }

    public void update(AddSubjectData data) {
        this.regionId = data.getRegion().getId();
        this.regionName = data.getRegion().getName();
        this.address = data.getAddress();
        this.contactPhone = data.getPhone();
        this.isNative = data.getWrahuji() == null ? false : data.getWrahuji().getId().equals("1") ? true : false;
        this.familyRelationId = data.getWnjinji() == null ? null : data.getWnjinji().getId();
        this.familyRelationName = data.getWnjinji() == null ? null : data.getWnjinji().getName();
        this.isGovHelp = data.isWrafuzhu();
        this.govHelpId = data.getWchfuzhu() == null ? null : data.getWchfuzhu().getId();
        this.govHelpName = data.getWchfuzhu() == null ? null : data.getWchfuzhu().getName();
        this.haveFoodAllergy = data.isWraguom();
        this.foodAllergy = data.getTfguom();
        this.subjectInfo = NxftSubject.SubjectInfo.fullBuilder()
                ._relationName______(data.getJinjiname())
                ._relationPhone_____(data.getJinjiphone())
                ._subjectTypeId_____(data.getSubjectType().getId())
                ._subjectTypeName___(data.getSubjectType().getName())
                ._subjectDesc_______(data.getSubjectDesc())
                ._deliveType________(data.getDType())
                ._deliveSiteId______(data.getTeam().getId())
                ._deliveSiteName____(data.getTeam().getName())
                ._overdraft_________(data.getDd())
                ._subjectDisease____(null)
                ._lunchBoxNo________(data.getLunchBoxNo())
                ._build_();

        this.personInfo = NxftSubject.PersonInfo.fullBuilder()
                ._personId______________(this.personInfo.getPersonId())
                ._subjectName___________(data.getName())
                ._sexId_________________(data.getGender().getId())
                ._sexName_______________(data.getGender().getName())
                ._idtypeId______________(this.personInfo.getIdtypeId())
                ._idtypeName____________(this.personInfo.getIdtypeName())
                ._idcardno______________(data.getIdNo())
                ._birthDate_____________(DateUtils.parseShortDate(data.getBirthDay()))
                ._subjectFoodLoveId_____(data.getSubjectFoodLove().getId())
                ._subjectFoodLoveName___(data.getSubjectFoodLove().getName())
                ._circleId______________(this.personInfo.getCircleId())
                ._isMealHelp____________(data.isMealHelp())
                ._build_();
    }

    public NxftSubjectDisease getById(Collection<NxftSubjectDisease> c, String id) {
        NxftSubjectDisease found = null;
        for (NxftSubjectDisease ian : c) {
            if (ian.getDiseaseId().equals(id)) {
                found = ian;
                break;
            }
        }
        return found;
    }

    public NxftSubjectFoodProhibit getFpById(Collection<NxftSubjectFoodProhibit> c, String id) {
        NxftSubjectFoodProhibit found = null;
        for (NxftSubjectFoodProhibit ian : c) {
            if (ian.getFoodProhibitId().equals(id)) {
                found = ian;
                break;
            }
        }
        return found;
    }

//    /**
//     * 创建{@link NxftSubject}对象。
//     *
//     * @param id {@code NxftSubject}对象的ID
//     */
//    public NxftSubject(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.contactPhone = null;
//        this.regionId = null;
//        this.regionName = null;
//    }

    // ---------- NxftSubject.__PersonInfo组件定义
    /**
     * [组件类] 客户信息。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class PersonInfo extends AbstractNxftSubject._PersonInfo {

        public static final PersonInfo EMPTY = new PersonInfo();

        // BEGIN>>>@$^*!#%&PersonInfo
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        PersonInfo() {
            super();
        }

        /**
         * 完整构造函数。除实体关系字段（如果有的话）外，其它字段按不可变类设计，具体请参见父类说明。
         *
         * <ul>
         * <li>对于基本字段，如果是可变类则拷贝，否则直接引用。</li>
         * <li>对于组件字段，直接引用。</li>
         * <li>对于实体字段，直接引用</li>
         * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
         * </ul>
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
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public PersonInfo(String personId, String subjectName, String sexId, String sexName, String idtypeId, String idtypeName, String idcardno, java.util.Date birthDate, String subjectFoodLoveId, String subjectFoodLoveName, String circleId, Boolean isMealHelp) {
            super(personId, subjectName, sexId, sexName, idtypeId, idtypeName, idcardno, birthDate, subjectFoodLoveId, subjectFoodLoveName, circleId, isMealHelp);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@PersonInfo

    }   // PersonInfo

    // ---------- NxftSubject.__SubjectInfo组件定义
    /**
     * [组件类] 客户信息。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class SubjectInfo extends AbstractNxftSubject._SubjectInfo {

        public static final SubjectInfo EMPTY = new SubjectInfo();

        public SubjectInfo updateDiseaseDesc(String updateDesc) {
            return new SubjectInfo(relationName, relationPhone, subjectTypeId, subjectTypeName, subjectDesc,
                    deliveType, deliveSiteId, deliveSiteName, overdraft, updateDesc, lunchBoxNo);
        }

        // BEGIN>>>@$^*!#%&SubjectInfo
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        SubjectInfo() {
            super();
        }

        /**
         * 完整构造函数。除实体关系字段（如果有的话）外，其它字段按不可变类设计，具体请参见父类说明。
         *
         * <ul>
         * <li>对于基本字段，如果是可变类则拷贝，否则直接引用。</li>
         * <li>对于组件字段，直接引用。</li>
         * <li>对于实体字段，直接引用</li>
         * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
         * </ul>
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
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public SubjectInfo(String relationName, String relationPhone, String subjectTypeId, String subjectTypeName, String subjectDesc, String deliveType, String deliveSiteId, String deliveSiteName, Double overdraft, String subjectDisease, String lunchBoxNo) {
            super(relationName, relationPhone, subjectTypeId, subjectTypeName, subjectDesc, deliveType, deliveSiteId, deliveSiteName, overdraft, subjectDisease, lunchBoxNo);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@SubjectInfo

    }   // SubjectInfo

    // ---------- NxftSubject.__CreateInfo组件定义
    /**
     * [组件类] 创建信息。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class CreateInfo extends AbstractNxftSubject._CreateInfo {

        public static final CreateInfo EMPTY = new CreateInfo();

        // BEGIN>>>@$^*!#%&CreateInfo
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        CreateInfo() {
            super();
        }

        /**
         * 完整构造函数。除实体关系字段（如果有的话）外，其它字段按不可变类设计，具体请参见父类说明。
         *
         * <ul>
         * <li>对于基本字段，如果是可变类则拷贝，否则直接引用。</li>
         * <li>对于组件字段，直接引用。</li>
         * <li>对于实体字段，直接引用</li>
         * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
         * </ul>
         *
         * @param createTime [不可空] 创建时间
         * @param createCircleId [不可空] 创建工作圈id
         * @param createTeamId [不可空] 创建工作组id
         * @param createUserId [不可空] 创建工号id
         * @param createNickname [不可空] 创建姓名
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public CreateInfo(java.util.Date createTime, String createCircleId, String createTeamId, String createUserId, String createNickname) {
            super(createTime, createCircleId, createTeamId, createUserId, createNickname);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@CreateInfo

    }   // CreateInfo

    // ---------- NxftSubject.__CancelInfo组件定义
    /**
     * [组件类] 注销信息。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class CancelInfo extends AbstractNxftSubject._CancelInfo {

        public static final CancelInfo EMPTY = new CancelInfo();

        // BEGIN>>>@$^*!#%&CancelInfo
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        CancelInfo() {
            super();
        }

        /**
         * 完整构造函数。除实体关系字段（如果有的话）外，其它字段按不可变类设计，具体请参见父类说明。
         *
         * <ul>
         * <li>对于基本字段，如果是可变类则拷贝，否则直接引用。</li>
         * <li>对于组件字段，直接引用。</li>
         * <li>对于实体字段，直接引用</li>
         * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
         * </ul>
         *
         * @param isCancel [不可空] 是否被注销
         * @param cancelReason [可空] 注销原因
         * @param cancelDate [可空] 注销机器时间
         * @param cancelUserId [可空] 注销操作员id
         * @param cancelUserName [可空] 注销操作员姓名
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public CancelInfo(Boolean isCancel, String cancelReason, java.util.Date cancelDate, String cancelUserId, String cancelUserName) {
            super(isCancel, cancelReason, cancelDate, cancelUserId, cancelUserName);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@CancelInfo

    }   // CancelInfo

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 8228817923363352243L;

    /** 13. [可空] 联系电话 */
    protected String contactPhone;

    /** 14. [不可空] 行政区域ID */
    protected String regionId;

    /** 15. [不可空] 行政区域名称 */
    protected String regionName;

    /** 16. [可空] 详细地址 */
    protected String address;

    /** 16.1. [可空] 是否本地户籍（本镇）Y/N */
    protected Boolean isNative;

    /** 16.2. [可空] 居住情况，多选，用逗号分隔 */
    protected String livingCondiName;

    /** 17.1. [可空] 联系人关系ID */
    protected String familyRelationId;

    /** 17.2. [可空] 联系人关系name */
    protected String familyRelationName;

    /** 18.1. [可空] 是否属于政府扶助类型 */
    protected Boolean isGovHelp;

    /** 18.2. [可空] 政府扶助类型id */
    protected String govHelpId;

    /** 18.3. [可空] 政府扶助类型中文名称 */
    protected String govHelpName;

    /** 20.2. [不可空] 是否有食物过敏 */
    protected Boolean haveFoodAllergy;

    /** 20.3. [可空] 食物过敏 */
    protected String foodAllergy;

    /** 20.4. [可空] 对象食物禁忌，名称逗号分隔 */
    protected String subjectFoodProhibit;

    /** [组件] 客户信息 */
    private NxftSubject.PersonInfo personInfo;

    /** [组件] 客户扩展信息 */
    private NxftSubject.SubjectInfo subjectInfo;

    /** [组件] 创建信息 */
    private NxftSubject.CreateInfo createInfo;

    /** [组件] 注销信息 */
    private NxftSubject.CancelInfo cancelInfo;

    /** [实体集合] 对象常见病 */
    private java.util.Set<com.wit.fxp.nxft.domain.model.subject.NxftSubjectDisease> nxftSubjectDiseaseSet =
            new java.util.HashSet<com.wit.fxp.nxft.domain.model.subject.NxftSubjectDisease>();

    /** [实体集合] 客户禁忌食物集合 */
    private java.util.Set<com.wit.fxp.nxft.domain.model.subject.NxftSubjectFoodProhibit> nxftSubjectFoodProhibitSet =
            new java.util.HashSet<com.wit.fxp.nxft.domain.model.subject.NxftSubjectFoodProhibit>();

    /** [实体集合] 客户居住情况集合 */
    private java.util.Set<com.wit.fxp.nxft.domain.model.subject.NxftSubjectLivingCondi> nxftSubjectLivingCondiSet =
            new java.util.HashSet<com.wit.fxp.nxft.domain.model.subject.NxftSubjectLivingCondi>();

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected NxftSubject() {
        super();
    }

    /**
     * 拷贝构造函数。
     *
     * <ul>
     * <li>对于组件字段，直接引用。</li>
     * <li>对于实体字段，直接引用</li>
     * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
     * </ul>
     *
     * @param mark 本参数暂没用到
     * @param copy 准备从中拷贝其属性的同类型对象
     */
    public NxftSubject(int mark, NxftSubject copy) {
        this(copy.getId(), copy.getContactPhone(), copy.getRegionId(), copy.getRegionName(), copy.getAddress(), copy.getIsNative(), copy.getLivingCondiName(), copy.getFamilyRelationId(), copy.getFamilyRelationName(), copy.getIsGovHelp(), copy.getGovHelpId(), copy.getGovHelpName(), copy.getHaveFoodAllergy(), copy.getFoodAllergy(), copy.getSubjectFoodProhibit(), copy.getPersonInfo(), copy.getSubjectInfo(), copy.getCreateInfo(), copy.getCancelInfo());
        nxftSubjectDiseaseSet = copy.internalGetNxftSubjectDiseaseSet();
        nxftSubjectFoodProhibitSet = copy.internalGetNxftSubjectFoodProhibitSet();
        nxftSubjectLivingCondiSet = copy.internalGetNxftSubjectLivingCondiSet();
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 配餐对象ID
     * @param contactPhone [可空] 联系电话
     * @param regionId [不可空] 行政区域ID
     * @param regionName [不可空] 行政区域名称
     * @param address [可空] 详细地址
     * @param isNative [可空] 是否本地户籍（本镇）Y/N
     * @param livingCondiName [可空] 居住情况，多选，用逗号分隔
     * @param familyRelationId [可空] 联系人关系ID
     * @param familyRelationName [可空] 联系人关系name
     * @param isGovHelp [可空] 是否属于政府扶助类型
     * @param govHelpId [可空] 政府扶助类型id
     * @param govHelpName [可空] 政府扶助类型中文名称
     * @param haveFoodAllergy [不可空] 是否有食物过敏
     * @param foodAllergy [可空] 食物过敏
     * @param subjectFoodProhibit [可空] 对象食物禁忌，名称逗号分隔
     * @param personInfo 客户信息
     * @param subjectInfo 客户扩展信息
     * @param createInfo 创建信息
     * @param cancelInfo 注销信息
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullNxftSubjectBuilder")
    private NxftSubject(String id, String contactPhone, String regionId, String regionName, String address, Boolean isNative, String livingCondiName, String familyRelationId, String familyRelationName, Boolean isGovHelp, String govHelpId, String govHelpName, Boolean haveFoodAllergy, String foodAllergy, String subjectFoodProhibit, NxftSubject.PersonInfo personInfo, NxftSubject.SubjectInfo subjectInfo, NxftSubject.CreateInfo createInfo, NxftSubject.CancelInfo cancelInfo) {
        super(id);
        this.contactPhone = SafeCopier.copy(contactPhone);
        this.regionId = SafeCopier.copy(regionId);
        this.regionName = SafeCopier.copy(regionName);
        this.address = SafeCopier.copy(address);
        this.isNative = SafeCopier.copy(isNative);
        this.livingCondiName = SafeCopier.copy(livingCondiName);
        this.familyRelationId = SafeCopier.copy(familyRelationId);
        this.familyRelationName = SafeCopier.copy(familyRelationName);
        this.isGovHelp = SafeCopier.copy(isGovHelp);
        this.govHelpId = SafeCopier.copy(govHelpId);
        this.govHelpName = SafeCopier.copy(govHelpName);
        this.haveFoodAllergy = SafeCopier.copy(haveFoodAllergy);
        this.foodAllergy = SafeCopier.copy(foodAllergy);
        this.subjectFoodProhibit = SafeCopier.copy(subjectFoodProhibit);
        this.personInfo = personInfo;
        this.subjectInfo = subjectInfo;
        this.createInfo = createInfo;
        this.cancelInfo = cancelInfo;
    }

// ---------- getter/setter

    /**
     * 返回配餐对象ID。
     *
     * @return 配餐对象ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置配餐对象ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 配餐对象ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回联系电话。
     *
     * @return [可空] 联系电话
     */
    public String getContactPhone() {
        return SafeCopier.copy(contactPhone);
    }

    /**
     * 返回行政区域ID。
     *
     * @return [不可空] 行政区域ID
     */
    public String getRegionId() {
        return SafeCopier.copy(regionId);
    }

    /**
     * 返回行政区域名称。
     *
     * @return [不可空] 行政区域名称
     */
    public String getRegionName() {
        return SafeCopier.copy(regionName);
    }

    /**
     * 返回详细地址。
     *
     * @return [可空] 详细地址
     */
    public String getAddress() {
        return SafeCopier.copy(address);
    }

    /**
     * 返回是否本地户籍（本镇）Y/N。
     *
     * @return [可空] 是否本地户籍（本镇）Y/N
     */
    public Boolean getIsNative() {
        return SafeCopier.copy(isNative);
    }

    /**
     * 返回居住情况，多选，用逗号分隔。
     *
     * @return [可空] 居住情况，多选，用逗号分隔
     */
    public String getLivingCondiName() {
        return SafeCopier.copy(livingCondiName);
    }

    /**
     * 返回联系人关系ID。
     *
     * @return [可空] 联系人关系ID
     */
    public String getFamilyRelationId() {
        return SafeCopier.copy(familyRelationId);
    }

    /**
     * 返回联系人关系name。
     *
     * @return [可空] 联系人关系name
     */
    public String getFamilyRelationName() {
        return SafeCopier.copy(familyRelationName);
    }

    /**
     * 返回是否属于政府扶助类型。
     *
     * @return [可空] 是否属于政府扶助类型
     */
    public Boolean getIsGovHelp() {
        return SafeCopier.copy(isGovHelp);
    }

    /**
     * 返回政府扶助类型id。
     *
     * @return [可空] 政府扶助类型id
     */
    public String getGovHelpId() {
        return SafeCopier.copy(govHelpId);
    }

    /**
     * 返回政府扶助类型中文名称。
     *
     * @return [可空] 政府扶助类型中文名称
     */
    public String getGovHelpName() {
        return SafeCopier.copy(govHelpName);
    }

    /**
     * 返回是否有食物过敏。
     *
     * @return [不可空] 是否有食物过敏
     */
    public Boolean getHaveFoodAllergy() {
        return SafeCopier.copy(haveFoodAllergy);
    }

    /**
     * 返回食物过敏。
     *
     * @return [可空] 食物过敏
     */
    public String getFoodAllergy() {
        return SafeCopier.copy(foodAllergy);
    }

    /**
     * 返回对象食物禁忌，名称逗号分隔。
     *
     * @return [可空] 对象食物禁忌，名称逗号分隔
     */
    public String getSubjectFoodProhibit() {
        return SafeCopier.copy(subjectFoodProhibit);
    }

    /**
     * 返回客户信息[组件]。
     *
     * @return 客户信息
     */
    public NxftSubject.PersonInfo getPersonInfo() {
        return personInfo == null ? NxftSubject.PersonInfo.EMPTY : personInfo;
    }

    /**
     * 返回客户扩展信息[组件]。
     *
     * @return 客户扩展信息
     */
    public NxftSubject.SubjectInfo getSubjectInfo() {
        return subjectInfo == null ? NxftSubject.SubjectInfo.EMPTY : subjectInfo;
    }

    /**
     * 返回创建信息[组件]。
     *
     * @return 创建信息
     */
    public NxftSubject.CreateInfo getCreateInfo() {
        return createInfo == null ? NxftSubject.CreateInfo.EMPTY : createInfo;
    }

    /**
     * 返回注销信息[组件]。
     *
     * @return 注销信息
     */
    public NxftSubject.CancelInfo getCancelInfo() {
        return cancelInfo == null ? NxftSubject.CancelInfo.EMPTY : cancelInfo;
    }

    /**
     * 返回对象常见病[实体集合]。
     *
     * @return [不可修改集合类{@link java.util.Collections#unmodifiableSet}] 对象常见病
     */
    public java.util.Set<com.wit.fxp.nxft.domain.model.subject.NxftSubjectDisease> getNxftSubjectDiseaseSet() {
        if (nxftSubjectDiseaseSet == null) {
            return java.util.Collections.emptySet();
        }
        else {
            return java.util.Collections.unmodifiableSet(nxftSubjectDiseaseSet);
        }
    }

    /**
     * 返回对象常见病[实体集合]，本方法供内部使用。
     *
     * @return 对象常见病
     */
    private java.util.Set<com.wit.fxp.nxft.domain.model.subject.NxftSubjectDisease> internalGetNxftSubjectDiseaseSet() {
        return nxftSubjectDiseaseSet;
    }

    /**
     * 返回客户禁忌食物集合[实体集合]。
     *
     * @return [不可修改集合类{@link java.util.Collections#unmodifiableSet}] 客户禁忌食物集合
     */
    public java.util.Set<com.wit.fxp.nxft.domain.model.subject.NxftSubjectFoodProhibit> getNxftSubjectFoodProhibitSet() {
        if (nxftSubjectFoodProhibitSet == null) {
            return java.util.Collections.emptySet();
        }
        else {
            return java.util.Collections.unmodifiableSet(nxftSubjectFoodProhibitSet);
        }
    }

    /**
     * 返回客户禁忌食物集合[实体集合]，本方法供内部使用。
     *
     * @return 客户禁忌食物集合
     */
    private java.util.Set<com.wit.fxp.nxft.domain.model.subject.NxftSubjectFoodProhibit> internalGetNxftSubjectFoodProhibitSet() {
        return nxftSubjectFoodProhibitSet;
    }

    /**
     * 返回客户居住情况集合[实体集合]。
     *
     * @return [不可修改集合类{@link java.util.Collections#unmodifiableSet}] 客户居住情况集合
     */
    public java.util.Set<com.wit.fxp.nxft.domain.model.subject.NxftSubjectLivingCondi> getNxftSubjectLivingCondiSet() {
        if (nxftSubjectLivingCondiSet == null) {
            return java.util.Collections.emptySet();
        }
        else {
            return java.util.Collections.unmodifiableSet(nxftSubjectLivingCondiSet);
        }
    }

    /**
     * 返回客户居住情况集合[实体集合]，本方法供内部使用。
     *
     * @return 客户居住情况集合
     */
    private java.util.Set<com.wit.fxp.nxft.domain.model.subject.NxftSubjectLivingCondi> internalGetNxftSubjectLivingCondiSet() {
        return nxftSubjectLivingCondiSet;
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractNxftSubject.checkProperties(getContactPhone(), getRegionId(), getRegionName(), getAddress(), getIsNative(), getLivingCondiName(), getFamilyRelationId(), getFamilyRelationName(), getIsGovHelp(), getGovHelpId(), getGovHelpName(), getHaveFoodAllergy(), getFoodAllergy(), getSubjectFoodProhibit(), getPersonInfo(), getSubjectInfo(), getCreateInfo(), getCancelInfo());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
