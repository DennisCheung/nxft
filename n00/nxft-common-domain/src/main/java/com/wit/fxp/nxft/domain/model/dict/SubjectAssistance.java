package com.wit.fxp.nxft.domain.model.dict;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.nxft.domain.model.dict.base.AbstractSubjectAssistance;

/**
 * 配餐对象补贴标准设置对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractSubjectAssistance
 */
public class SubjectAssistance extends AbstractLoggingEntity<String> implements PropertyChecker {

    public Double 补助(Double sum) {
        switch (this.assistanceModel) {
        case "RADIO":
            return sum * this.assistanceRatio;
        case "FEE":
            return this.assistanceFee;
        default:
            return 0.0;
        }
    }

//    /**
//     * 创建{@link SubjectAssistance}对象。
//     *
//     * @param id {@code SubjectAssistance}对象的ID
//     */
//    public SubjectAssistance(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.circleId = null;
//        this.subjectTypeId = null;
//        this.mealTypeId = null;
//        this.assistanceModel = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 4308522276109312746L;

    /** 2. [不可空] 客户所属的工作圈id */
    protected String circleId;

    /** 3. [不可空] 对象类型ID */
    protected String subjectTypeId;

    /** 4. [不可空] 餐别类型id */
    protected String mealTypeId;

    /** 5. [不可空] 补助模式 RADIO 比例  FEE 金额 */
    protected String assistanceModel;

    /** 6. [可空] 补助比例 */
    protected Double assistanceRatio;

    /** 7. [可空] 补助金额 */
    protected Double assistanceFee;

    /** 8. [可空] 备注 */
    protected String assistanceDesc;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected SubjectAssistance() {
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
    public SubjectAssistance(int mark, SubjectAssistance copy) {
        this(copy.getId(), copy.getCircleId(), copy.getSubjectTypeId(), copy.getMealTypeId(), copy.getAssistanceModel(), copy.getAssistanceRatio(), copy.getAssistanceFee(), copy.getAssistanceDesc());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 配餐对象补贴标准设置ID
     * @param circleId [不可空] 客户所属的工作圈id
     * @param subjectTypeId [不可空] 对象类型ID
     * @param mealTypeId [不可空] 餐别类型id
     * @param assistanceModel [不可空] 补助模式 RADIO 比例  FEE 金额
     * @param assistanceRatio [可空] 补助比例
     * @param assistanceFee [可空] 补助金额
     * @param assistanceDesc [可空] 备注
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullSubjectAssistanceBuilder")
    private SubjectAssistance(String id, String circleId, String subjectTypeId, String mealTypeId, String assistanceModel, Double assistanceRatio, Double assistanceFee, String assistanceDesc) {
        super(id);
        this.circleId = SafeCopier.copy(circleId);
        this.subjectTypeId = SafeCopier.copy(subjectTypeId);
        this.mealTypeId = SafeCopier.copy(mealTypeId);
        this.assistanceModel = SafeCopier.copy(assistanceModel);
        this.assistanceRatio = SafeCopier.copy(assistanceRatio);
        this.assistanceFee = SafeCopier.copy(assistanceFee);
        this.assistanceDesc = SafeCopier.copy(assistanceDesc);
    }

// ---------- getter/setter

    /**
     * 返回配餐对象补贴标准设置ID。
     *
     * @return 配餐对象补贴标准设置ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置配餐对象补贴标准设置ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 配餐对象补贴标准设置ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
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
     * 返回对象类型ID。
     *
     * @return [不可空] 对象类型ID
     */
    public String getSubjectTypeId() {
        return SafeCopier.copy(subjectTypeId);
    }

    /**
     * 返回餐别类型id。
     *
     * @return [不可空] 餐别类型id
     */
    public String getMealTypeId() {
        return SafeCopier.copy(mealTypeId);
    }

    /**
     * 返回补助模式 RADIO 比例  FEE 金额。
     *
     * @return [不可空] 补助模式 RADIO 比例  FEE 金额
     */
    public String getAssistanceModel() {
        return SafeCopier.copy(assistanceModel);
    }

    /**
     * 返回补助比例。
     *
     * @return [可空] 补助比例
     */
    public Double getAssistanceRatio() {
        return SafeCopier.copy(assistanceRatio);
    }

    /**
     * 返回补助金额。
     *
     * @return [可空] 补助金额
     */
    public Double getAssistanceFee() {
        return SafeCopier.copy(assistanceFee);
    }

    /**
     * 返回备注。
     *
     * @return [可空] 备注
     */
    public String getAssistanceDesc() {
        return SafeCopier.copy(assistanceDesc);
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractSubjectAssistance.checkProperties(getCircleId(), getSubjectTypeId(), getMealTypeId(), getAssistanceModel(), getAssistanceRatio(), getAssistanceFee(), getAssistanceDesc());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
