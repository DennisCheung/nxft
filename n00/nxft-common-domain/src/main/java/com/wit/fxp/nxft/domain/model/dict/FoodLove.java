package com.wit.fxp.nxft.domain.model.dict;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.nxft.domain.model.dict.base.AbstractFoodLove;

/**
 * 饮食偏好对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractFoodLove
 */
public class FoodLove extends AbstractLoggingEntity<String> implements PropertyChecker {

//    /**
//     * 创建{@link FoodLove}对象。
//     *
//     * @param id {@code FoodLove}对象的ID
//     */
//    public FoodLove(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.foodLoveCode = null;
//        this.foodLoveName = null;
//        this.isother = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 2329409364439132770L;

    /** 2. [不可空] 饮食偏好代码 */
    protected String foodLoveCode;

    /** 3. [不可空] 饮食偏好名称 */
    protected String foodLoveName;

    /** 4. [不可空] 是否是其他项 Y/N  其他项需手工输入备注 */
    protected Boolean isother;

    /** 5. [可空] 备注 */
    protected String foodLoveDesc;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected FoodLove() {
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
    public FoodLove(int mark, FoodLove copy) {
        this(copy.getId(), copy.getFoodLoveCode(), copy.getFoodLoveName(), copy.getIsother(), copy.getFoodLoveDesc());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 饮食偏好ID
     * @param foodLoveCode [不可空] 饮食偏好代码
     * @param foodLoveName [不可空] 饮食偏好名称
     * @param isother [不可空] 是否是其他项 Y/N  其他项需手工输入备注
     * @param foodLoveDesc [可空] 备注
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullFoodLoveBuilder")
    private FoodLove(String id, String foodLoveCode, String foodLoveName, Boolean isother, String foodLoveDesc) {
        super(id);
        this.foodLoveCode = SafeCopier.copy(foodLoveCode);
        this.foodLoveName = SafeCopier.copy(foodLoveName);
        this.isother = SafeCopier.copy(isother);
        this.foodLoveDesc = SafeCopier.copy(foodLoveDesc);
    }

// ---------- getter/setter

    /**
     * 返回饮食偏好ID。
     *
     * @return 饮食偏好ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置饮食偏好ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 饮食偏好ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回饮食偏好代码。
     *
     * @return [不可空] 饮食偏好代码
     */
    public String getFoodLoveCode() {
        return SafeCopier.copy(foodLoveCode);
    }

    /**
     * 返回饮食偏好名称。
     *
     * @return [不可空] 饮食偏好名称
     */
    public String getFoodLoveName() {
        return SafeCopier.copy(foodLoveName);
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
    public String getFoodLoveDesc() {
        return SafeCopier.copy(foodLoveDesc);
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractFoodLove.checkProperties(getFoodLoveCode(), getFoodLoveName(), getIsother(), getFoodLoveDesc());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
