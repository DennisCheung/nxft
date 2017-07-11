package com.wit.fxp.nxft.domain.model.subject;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.datatype.IdAndName;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.domain.model.subject.base.AbstractNxftSubjectFoodProhibit;

/**
 * 配餐对象食物禁忌对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractNxftSubjectFoodProhibit
 */
public class NxftSubjectFoodProhibit extends AbstractLoggingEntity<String> implements PropertyChecker {

    @lombok.experimental.BuilderCall(builderMethodName = "新建")
    public static NxftSubjectFoodProhibit newNxftSubjectFoodProhibit(InvocationContext ic, IdAndName data, String subjectId) {
        return NxftSubjectFoodProhibit.fullNxftSubjectFoodProhibitBuilder()
                ._id________________(ic.generateId(NxftSubjectFoodProhibit.class))
                ._foodProhibitId____(data.getId())
                ._foodProhibitName__(data.getName())
                ._isother___________(false)
                ._subjectId_________(subjectId)
                ._foodProhibitDesc__(null)
                ._build_();

    }

    public void updateName(String name) {
        this.foodProhibitName = name;
    }

//    /**
//     * 创建{@link NxftSubjectFoodProhibit}对象。
//     *
//     * @param id {@code NxftSubjectFoodProhibit}对象的ID
//     */
//    public NxftSubjectFoodProhibit(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.foodProhibitId = null;
//        this.foodProhibitName = null;
//        this.isother = null;
//        this.subjectId = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 8951743154995954112L;

    /** 2. [不可空] 食物禁忌id */
    protected String foodProhibitId;

    /** 3. [不可空] 食物禁忌名称 */
    protected String foodProhibitName;

    /** 4. [不可空] 是否是其他项 Y/N  其他项需手工输入备注 */
    protected Boolean isother;

    /** 5. [不可空] 对象id */
    protected String subjectId;

    /** 6. [可空] 备注 */
    protected String foodProhibitDesc;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected NxftSubjectFoodProhibit() {
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
    public NxftSubjectFoodProhibit(int mark, NxftSubjectFoodProhibit copy) {
        this(copy.getId(), copy.getFoodProhibitId(), copy.getFoodProhibitName(), copy.getIsother(), copy.getSubjectId(), copy.getFoodProhibitDesc());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 配餐对象食物禁忌ID
     * @param foodProhibitId [不可空] 食物禁忌id
     * @param foodProhibitName [不可空] 食物禁忌名称
     * @param isother [不可空] 是否是其他项 Y/N  其他项需手工输入备注
     * @param subjectId [不可空] 对象id
     * @param foodProhibitDesc [可空] 备注
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullNxftSubjectFoodProhibitBuilder")
    private NxftSubjectFoodProhibit(String id, String foodProhibitId, String foodProhibitName, Boolean isother, String subjectId, String foodProhibitDesc) {
        super(id);
        this.foodProhibitId = SafeCopier.copy(foodProhibitId);
        this.foodProhibitName = SafeCopier.copy(foodProhibitName);
        this.isother = SafeCopier.copy(isother);
        this.subjectId = SafeCopier.copy(subjectId);
        this.foodProhibitDesc = SafeCopier.copy(foodProhibitDesc);
    }

// ---------- getter/setter

    /**
     * 返回配餐对象食物禁忌ID。
     *
     * @return 配餐对象食物禁忌ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置配餐对象食物禁忌ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 配餐对象食物禁忌ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回食物禁忌id。
     *
     * @return [不可空] 食物禁忌id
     */
    public String getFoodProhibitId() {
        return SafeCopier.copy(foodProhibitId);
    }

    /**
     * 返回食物禁忌名称。
     *
     * @return [不可空] 食物禁忌名称
     */
    public String getFoodProhibitName() {
        return SafeCopier.copy(foodProhibitName);
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
    public String getFoodProhibitDesc() {
        return SafeCopier.copy(foodProhibitDesc);
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractNxftSubjectFoodProhibit.checkProperties(getFoodProhibitId(), getFoodProhibitName(), getIsother(), getSubjectId(), getFoodProhibitDesc());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
