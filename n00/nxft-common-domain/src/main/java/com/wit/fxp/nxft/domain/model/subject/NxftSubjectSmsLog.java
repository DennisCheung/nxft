package com.wit.fxp.nxft.domain.model.subject;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.domain.model.subject.base.AbstractNxftSubjectSmsLog;

/**
 * 暖心饭堂对象短信日志对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractNxftSubjectSmsLog
 */
public class NxftSubjectSmsLog extends AbstractLoggingEntity<String> implements PropertyChecker {

    @lombok.experimental.BuilderCall(builderMethodName = "新建")
    public static NxftSubjectSmsLog newNxftSubjectSmsLog(InvocationContext ic, Actor actor, SmsLogData data) {
        return NxftSubjectSmsLog.fullNxftSubjectSmsLogBuilder()
                ._id____________(ic.generateId(NxftSubjectSmsLog.class))
                ._tspName_______(data.getTspName())
                ._subjectId_____(data.getSubject().getId())
                ._subjectName___(data.getSubject().getName())
                ._circleId______(actor.getCircle().getId())
                ._createTime____(ic.now())
                ._smsContent____(data.getSmsContent())
                ._smsType_______("TEXT")
                ._smsDesc_______(data.getSmsDesc())
                ._toNumber______(data.getToNumber())
                ._toName________(data.getToName())
                ._relationName__("本人")
                ._userCircleId__(actor.getCircle().getId())
                ._userTeamId____(actor.getTeam().getId())
                ._userUserId____(actor.getUser().getId())
                ._userNickname__(actor.getUser().getBasicInfo().getNickname())
                ._build_();

    }

//    /**
//     * 创建{@link NxftSubjectSmsLog}对象。
//     *
//     * @param id {@code NxftSubjectSmsLog}对象的ID
//     */
//    public NxftSubjectSmsLog(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.tspName = null;
//        this.subjectId = null;
//        this.subjectName = null;
//        this.circleId = null;
//        this.createTime = null;
//        this.smsContent = null;
//        this.smsType = null;
//        this.toNumber = null;
//        this.toName = null;
//        this.userUserId = null;
//        this.userNickname = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 1784857813175527492L;

    /** 2. [不可空] 通讯服务商如：云之讯、容联 协同通讯 */
    protected String tspName;

    /** 3. [不可空] 监测对象ID */
    protected String subjectId;

    /** 4. [不可空] 对象姓名 */
    protected String subjectName;

    /** 5. [不可空] 客户所属的工作圈id */
    protected String circleId;

    /** 6. [不可空] 创建时间 */
    protected java.util.Date createTime;

    /** 7. [不可空] 短信内容 */
    protected String smsContent;

    /** 8. [不可空] 短信类型  TEXT  文字短信  VOICE  语音短信 */
    protected String smsType;

    /** 9. [可空] 业务说明,如 坐席订餐、助餐点订餐 */
    protected String smsDesc;

    /** 10. [不可空] 客户电话号码 */
    protected String toNumber;

    /** 11. [不可空] 短信接收人姓名 */
    protected String toName;

    /** 12. [可空] 与对象关系name，本人或对象联系人关系 */
    protected String relationName;

    /** 13. [可空] 操作员圈id */
    protected String userCircleId;

    /** 14. [可空] 操作员工作组id */
    protected String userTeamId;

    /** 15. [不可空] 操作员id */
    protected String userUserId;

    /** 16. [不可空] 操作员姓名 */
    protected String userNickname;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected NxftSubjectSmsLog() {
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
    public NxftSubjectSmsLog(int mark, NxftSubjectSmsLog copy) {
        this(copy.getId(), copy.getTspName(), copy.getSubjectId(), copy.getSubjectName(), copy.getCircleId(), copy.getCreateTime(), copy.getSmsContent(), copy.getSmsType(), copy.getSmsDesc(), copy.getToNumber(), copy.getToName(), copy.getRelationName(), copy.getUserCircleId(), copy.getUserTeamId(), copy.getUserUserId(), copy.getUserNickname());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 暖心饭堂对象短信日志ID
     * @param tspName [不可空] 通讯服务商如：云之讯、容联 协同通讯
     * @param subjectId [不可空] 监测对象ID
     * @param subjectName [不可空] 对象姓名
     * @param circleId [不可空] 客户所属的工作圈id
     * @param createTime [不可空] 创建时间
     * @param smsContent [不可空] 短信内容
     * @param smsType [不可空] 短信类型  TEXT  文字短信  VOICE  语音短信
     * @param smsDesc [可空] 业务说明,如 坐席订餐、助餐点订餐
     * @param toNumber [不可空] 客户电话号码
     * @param toName [不可空] 短信接收人姓名
     * @param relationName [可空] 与对象关系name，本人或对象联系人关系
     * @param userCircleId [可空] 操作员圈id
     * @param userTeamId [可空] 操作员工作组id
     * @param userUserId [不可空] 操作员id
     * @param userNickname [不可空] 操作员姓名
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullNxftSubjectSmsLogBuilder")
    private NxftSubjectSmsLog(String id, String tspName, String subjectId, String subjectName, String circleId, java.util.Date createTime, String smsContent, String smsType, String smsDesc, String toNumber, String toName, String relationName, String userCircleId, String userTeamId, String userUserId, String userNickname) {
        super(id);
        this.tspName = SafeCopier.copy(tspName);
        this.subjectId = SafeCopier.copy(subjectId);
        this.subjectName = SafeCopier.copy(subjectName);
        this.circleId = SafeCopier.copy(circleId);
        this.createTime = SafeCopier.copy(createTime);
        this.smsContent = SafeCopier.copy(smsContent);
        this.smsType = SafeCopier.copy(smsType);
        this.smsDesc = SafeCopier.copy(smsDesc);
        this.toNumber = SafeCopier.copy(toNumber);
        this.toName = SafeCopier.copy(toName);
        this.relationName = SafeCopier.copy(relationName);
        this.userCircleId = SafeCopier.copy(userCircleId);
        this.userTeamId = SafeCopier.copy(userTeamId);
        this.userUserId = SafeCopier.copy(userUserId);
        this.userNickname = SafeCopier.copy(userNickname);
    }

// ---------- getter/setter

    /**
     * 返回暖心饭堂对象短信日志ID。
     *
     * @return 暖心饭堂对象短信日志ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置暖心饭堂对象短信日志ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 暖心饭堂对象短信日志ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回通讯服务商如：云之讯、容联 协同通讯。
     *
     * @return [不可空] 通讯服务商如：云之讯、容联 协同通讯
     */
    public String getTspName() {
        return SafeCopier.copy(tspName);
    }

    /**
     * 返回监测对象ID。
     *
     * @return [不可空] 监测对象ID
     */
    public String getSubjectId() {
        return SafeCopier.copy(subjectId);
    }

    /**
     * 返回对象姓名。
     *
     * @return [不可空] 对象姓名
     */
    public String getSubjectName() {
        return SafeCopier.copy(subjectName);
    }

    /**
     * 返回客户所属的工作圈id。
     *
     * @return [不可空] 客户所属的工作圈id
     */
    public String getCircleId() {
        return SafeCopier.copy(circleId);
    }

    /**
     * 返回创建时间。
     *
     * @return [不可空] 创建时间
     */
    public java.util.Date getCreateTime() {
        return SafeCopier.copy(createTime);
    }

    /**
     * 返回短信内容。
     *
     * @return [不可空] 短信内容
     */
    public String getSmsContent() {
        return SafeCopier.copy(smsContent);
    }

    /**
     * 返回短信类型  TEXT  文字短信  VOICE  语音短信。
     *
     * @return [不可空] 短信类型  TEXT  文字短信  VOICE  语音短信
     */
    public String getSmsType() {
        return SafeCopier.copy(smsType);
    }

    /**
     * 返回业务说明,如 坐席订餐、助餐点订餐。
     *
     * @return [可空] 业务说明,如 坐席订餐、助餐点订餐
     */
    public String getSmsDesc() {
        return SafeCopier.copy(smsDesc);
    }

    /**
     * 返回客户电话号码。
     *
     * @return [不可空] 客户电话号码
     */
    public String getToNumber() {
        return SafeCopier.copy(toNumber);
    }

    /**
     * 返回短信接收人姓名。
     *
     * @return [不可空] 短信接收人姓名
     */
    public String getToName() {
        return SafeCopier.copy(toName);
    }

    /**
     * 返回与对象关系name，本人或对象联系人关系。
     *
     * @return [可空] 与对象关系name，本人或对象联系人关系
     */
    public String getRelationName() {
        return SafeCopier.copy(relationName);
    }

    /**
     * 返回操作员圈id。
     *
     * @return [可空] 操作员圈id
     */
    public String getUserCircleId() {
        return SafeCopier.copy(userCircleId);
    }

    /**
     * 返回操作员工作组id。
     *
     * @return [可空] 操作员工作组id
     */
    public String getUserTeamId() {
        return SafeCopier.copy(userTeamId);
    }

    /**
     * 返回操作员id。
     *
     * @return [不可空] 操作员id
     */
    public String getUserUserId() {
        return SafeCopier.copy(userUserId);
    }

    /**
     * 返回操作员姓名。
     *
     * @return [不可空] 操作员姓名
     */
    public String getUserNickname() {
        return SafeCopier.copy(userNickname);
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractNxftSubjectSmsLog.checkProperties(getTspName(), getSubjectId(), getSubjectName(), getCircleId(), getCreateTime(), getSmsContent(), getSmsType(), getSmsDesc(), getToNumber(), getToName(), getRelationName(), getUserCircleId(), getUserTeamId(), getUserUserId(), getUserNickname());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
