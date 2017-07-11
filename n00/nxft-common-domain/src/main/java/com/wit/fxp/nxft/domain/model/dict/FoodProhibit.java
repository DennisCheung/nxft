package com.wit.fxp.nxft.domain.model.dict;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.nxft.domain.model.dict.base.AbstractFoodProhibit;

/**
 * 食物禁忌对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractFoodProhibit
 */
public class FoodProhibit extends AbstractLoggingEntity<String> implements PropertyChecker {

//    /**
//     * 创建{@link FoodProhibit}对象。
//     *
//     * @param id {@code FoodProhibit}对象的ID
//     */
//    public FoodProhibit(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.foodProhibitCode = null;
//        this.foodProhibitName = null;
//        this.isother = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 9212389729516023954L;

    /** 2. [不可空] 食物禁忌代码 */
    protected String foodProhibitCode;

    /** 3. [不可空] 食物禁忌名称 */
    protected String foodProhibitName;

    /** 4. [不可空] 是否是其他项 Y/N  其他项需手工输入备注 */
    protected Boolean isother;

    /** 5. [可空] 备注 */
    protected String foodProhibitDesc;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected FoodProhibit() {
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
    public FoodProhibit(int mark, FoodProhibit copy) {
        this(copy.getId(), copy.getFoodProhibitCode(), copy.getFoodProhibitName(), copy.getIsother(), copy.getFoodProhibitDesc());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 食物禁忌ID
     * @param foodProhibitCode [不可空] 食物禁忌代码
     * @param foodProhibitName [不可空] 食物禁忌名称
     * @param isother [不可空] 是否是其他项 Y/N  其他项需手工输入备注
     * @param foodProhibitDesc [可空] 备注
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullFoodProhibitBuilder")
    private FoodProhibit(String id, String foodProhibitCode, String foodProhibitName, Boolean isother, String foodProhibitDesc) {
        super(id);
        this.foodProhibitCode = SafeCopier.copy(foodProhibitCode);
        this.foodProhibitName = SafeCopier.copy(foodProhibitName);
        this.isother = SafeCopier.copy(isother);
        this.foodProhibitDesc = SafeCopier.copy(foodProhibitDesc);
    }

// ---------- getter/setter

    /**
     * 返回食物禁忌ID。
     *
     * @return 食物禁忌ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置食物禁忌ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 食物禁忌ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回食物禁忌代码。
     *
     * @return [不可空] 食物禁忌代码
     */
    public String getFoodProhibitCode() {
        return SafeCopier.copy(foodProhibitCode);
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
        AbstractFoodProhibit.checkProperties(getFoodProhibitCode(), getFoodProhibitName(), getIsother(), getFoodProhibitDesc());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
