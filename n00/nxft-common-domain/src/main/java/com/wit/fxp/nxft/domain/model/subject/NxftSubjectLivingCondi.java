package com.wit.fxp.nxft.domain.model.subject;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.datatype.IdAndName;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.domain.model.subject.base.AbstractNxftSubjectLivingCondi;

/**
 * 配餐对象居住情况对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractNxftSubjectLivingCondi
 */
public class NxftSubjectLivingCondi extends AbstractLoggingEntity<String> implements PropertyChecker {

    @lombok.experimental.BuilderCall(builderMethodName = "新建")
    public static NxftSubjectLivingCondi newNxftSubjectLivingCondi(InvocationContext ic, IdAndName data, String subjectId) {
        return NxftSubjectLivingCondi.fullNxftSubjectLivingCondiBuilder()
                ._id________________(ic.generateId(NxftSubjectLivingCondi.class))
                ._livingCondiId_____(data.getId())
                ._livingCondiName___(data.getName())
                ._isother___________(false)
                ._subjectId_________(subjectId)
                ._livingCondiDesc___(null)
                ._build_();

    }

//    /**
//     * 创建{@link NxftSubjectLivingCondi}对象。
//     *
//     * @param id {@code NxftSubjectLivingCondi}对象的ID
//     */
//    public NxftSubjectLivingCondi(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.livingCondiId = null;
//        this.livingCondiName = null;
//        this.isother = null;
//        this.subjectId = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 7236748599397821617L;

    /** 2. [不可空] 居住情况ID */
    protected String livingCondiId;

    /** 3. [不可空] 居住情况名称 */
    protected String livingCondiName;

    /** 4. [不可空] 是否是其他项 Y/N  其他项需手工输入备注 */
    protected Boolean isother;

    /** 5. [不可空] 对象id */
    protected String subjectId;

    /** 6. [可空] 备注 */
    protected String livingCondiDesc;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected NxftSubjectLivingCondi() {
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
    public NxftSubjectLivingCondi(int mark, NxftSubjectLivingCondi copy) {
        this(copy.getId(), copy.getLivingCondiId(), copy.getLivingCondiName(), copy.getIsother(), copy.getSubjectId(), copy.getLivingCondiDesc());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 配餐对象居住情况ID
     * @param livingCondiId [不可空] 居住情况ID
     * @param livingCondiName [不可空] 居住情况名称
     * @param isother [不可空] 是否是其他项 Y/N  其他项需手工输入备注
     * @param subjectId [不可空] 对象id
     * @param livingCondiDesc [可空] 备注
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullNxftSubjectLivingCondiBuilder")
    private NxftSubjectLivingCondi(String id, String livingCondiId, String livingCondiName, Boolean isother, String subjectId, String livingCondiDesc) {
        super(id);
        this.livingCondiId = SafeCopier.copy(livingCondiId);
        this.livingCondiName = SafeCopier.copy(livingCondiName);
        this.isother = SafeCopier.copy(isother);
        this.subjectId = SafeCopier.copy(subjectId);
        this.livingCondiDesc = SafeCopier.copy(livingCondiDesc);
    }

// ---------- getter/setter

    /**
     * 返回配餐对象居住情况ID。
     *
     * @return 配餐对象居住情况ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置配餐对象居住情况ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 配餐对象居住情况ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回居住情况ID。
     *
     * @return [不可空] 居住情况ID
     */
    public String getLivingCondiId() {
        return SafeCopier.copy(livingCondiId);
    }

    /**
     * 返回居住情况名称。
     *
     * @return [不可空] 居住情况名称
     */
    public String getLivingCondiName() {
        return SafeCopier.copy(livingCondiName);
    }

    /**
     * 返回是否是其他项 Y/N  其他项需手工输入备注。
     *
     * @return [不可空] 是否是其他项 Y/N  其他项需手工输入备注
     */
    public Boolean getIsother() {
        return SafeCopier.copy(isother);
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
    public String getLivingCondiDesc() {
        return SafeCopier.copy(livingCondiDesc);
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractNxftSubjectLivingCondi.checkProperties(getLivingCondiId(), getLivingCondiName(), getIsother(), getSubjectId(), getLivingCondiDesc());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
