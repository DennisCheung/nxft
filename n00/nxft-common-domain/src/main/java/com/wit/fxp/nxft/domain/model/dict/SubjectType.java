package com.wit.fxp.nxft.domain.model.dict;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.nxft.domain.model.dict.base.AbstractSubjectType;

/**
 * 配餐对象类型字典对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractSubjectType
 */
public class SubjectType extends AbstractLoggingEntity<String> implements PropertyChecker {

//    /**
//     * 创建{@link SubjectType}对象。
//     *
//     * @param id {@code SubjectType}对象的ID
//     */
//    public SubjectType(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.subjectTypeCode = null;
//        this.subjectTypeName = null;
//        this.available = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 1216260780335258977L;

    /** 2. [不可空] 对象类型CODE */
    protected String subjectTypeCode;

    /** 3. [不可空] 对象类型名称 */
    protected String subjectTypeName;

    /** 4. [不可空] 是否可用？ */
    protected Boolean available;

    /** 5. [可空] 备注 */
    protected String subjectTypeDesc;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected SubjectType() {
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
    public SubjectType(int mark, SubjectType copy) {
        this(copy.getId(), copy.getSubjectTypeCode(), copy.getSubjectTypeName(), copy.getAvailable(), copy.getSubjectTypeDesc());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 配餐对象类型字典ID
     * @param subjectTypeCode [不可空] 对象类型CODE
     * @param subjectTypeName [不可空] 对象类型名称
     * @param available [不可空] 是否可用？
     * @param subjectTypeDesc [可空] 备注
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullSubjectTypeBuilder")
    private SubjectType(String id, String subjectTypeCode, String subjectTypeName, Boolean available, String subjectTypeDesc) {
        super(id);
        this.subjectTypeCode = SafeCopier.copy(subjectTypeCode);
        this.subjectTypeName = SafeCopier.copy(subjectTypeName);
        this.available = SafeCopier.copy(available);
        this.subjectTypeDesc = SafeCopier.copy(subjectTypeDesc);
    }

// ---------- getter/setter

    /**
     * 返回配餐对象类型字典ID。
     *
     * @return 配餐对象类型字典ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置配餐对象类型字典ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 配餐对象类型字典ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回对象类型CODE。
     *
     * @return [不可空] 对象类型CODE
     */
    public String getSubjectTypeCode() {
        return SafeCopier.copy(subjectTypeCode);
    }

    /**
     * 返回对象类型名称。
     *
     * @return [不可空] 对象类型名称
     */
    public String getSubjectTypeName() {
        return SafeCopier.copy(subjectTypeName);
    }

    /**
     * 返回是否可用？。
     *
     * @return [不可空] 是否可用？
     */
    public Boolean getAvailable() {
        return SafeCopier.copy(available);
    }

    /**
     * 返回备注。
     *
     * @return [可空] 备注
     */
    public String getSubjectTypeDesc() {
        return SafeCopier.copy(subjectTypeDesc);
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractSubjectType.checkProperties(getSubjectTypeCode(), getSubjectTypeName(), getAvailable(), getSubjectTypeDesc());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
