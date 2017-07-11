package com.wit.fxp.nxft.domain.model.subject;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.datatype.IdAndName;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.domain.model.subject.base.AbstractNxftSubjectDisease;

/**
 * 配餐对象疾病对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractNxftSubjectDisease
 */
public class NxftSubjectDisease extends AbstractLoggingEntity<String> implements PropertyChecker {

    @lombok.experimental.BuilderCall(builderMethodName = "新建")
    public static NxftSubjectDisease newNxftSubjectDisease(InvocationContext ic, IdAndName data, String subjectId) {
        return NxftSubjectDisease.fullNxftSubjectDiseaseBuilder()
                ._id____________(ic.generateId(NxftSubjectDisease.class))
                ._diseaseId_____(data.getId())
                ._diseaseName___(data.getName())
                ._subjectId_____(subjectId)
                ._diseaseDesc___(null)
                ._build_();

    }

    public void updateName(String name) {
        this.diseaseName = name;
    }

//    /**
//     * 创建{@link NxftSubjectDisease}对象。
//     *
//     * @param id {@code NxftSubjectDisease}对象的ID
//     */
//    public NxftSubjectDisease(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.diseaseId = null;
//        this.diseaseName = null;
//        this.subjectId = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 9217747469598935555L;

    /** 2. [不可空] 疾病id */
    protected String diseaseId;

    /** 3. [不可空] 疾病名称 */
    protected String diseaseName;

    /** 4. [不可空] 对象id */
    protected String subjectId;

    /** 5. [可空] 备注 */
    protected String diseaseDesc;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected NxftSubjectDisease() {
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
    public NxftSubjectDisease(int mark, NxftSubjectDisease copy) {
        this(copy.getId(), copy.getDiseaseId(), copy.getDiseaseName(), copy.getSubjectId(), copy.getDiseaseDesc());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 配餐对象疾病ID
     * @param diseaseId [不可空] 疾病id
     * @param diseaseName [不可空] 疾病名称
     * @param subjectId [不可空] 对象id
     * @param diseaseDesc [可空] 备注
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullNxftSubjectDiseaseBuilder")
    private NxftSubjectDisease(String id, String diseaseId, String diseaseName, String subjectId, String diseaseDesc) {
        super(id);
        this.diseaseId = SafeCopier.copy(diseaseId);
        this.diseaseName = SafeCopier.copy(diseaseName);
        this.subjectId = SafeCopier.copy(subjectId);
        this.diseaseDesc = SafeCopier.copy(diseaseDesc);
    }

// ---------- getter/setter

    /**
     * 返回配餐对象疾病ID。
     *
     * @return 配餐对象疾病ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置配餐对象疾病ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 配餐对象疾病ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回疾病id。
     *
     * @return [不可空] 疾病id
     */
    public String getDiseaseId() {
        return SafeCopier.copy(diseaseId);
    }

    /**
     * 返回疾病名称。
     *
     * @return [不可空] 疾病名称
     */
    public String getDiseaseName() {
        return SafeCopier.copy(diseaseName);
    }

    /**
     * 返回对象id。
     *
     * @return [不可空] 对象id
     */
    public String getSubjectId() {
        return SafeCopier.copy(subjectId);
    }

    /**
     * 返回备注。
     *
     * @return [可空] 备注
     */
    public String getDiseaseDesc() {
        return SafeCopier.copy(diseaseDesc);
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractNxftSubjectDisease.checkProperties(getDiseaseId(), getDiseaseName(), getSubjectId(), getDiseaseDesc());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
