package com.wit.fxp.nxft.domain.model.dict;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.nxft.domain.model.dict.base.AbstractMealType;

/**
 * 餐别字典对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractMealType
 */
public class MealType extends AbstractLoggingEntity<String> implements PropertyChecker {

//    /**
//     * 创建{@link MealType}对象。
//     *
//     * @param id {@code MealType}对象的ID
//     */
//    public MealType(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.mealTypeName = null;
//        this.available = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 8215466613852422501L;

    /** 2. [不可空] 餐别类型名称 */
    protected String mealTypeName;

    /** 3. [不可空] 就餐时间  24YYMM */
    protected String mealTime;

    /** 4. [不可空] 下单提前小时数 */
    protected Integer orderBefore;

    /** 5. [可空] 规则描述  例如  晚上8：00前，可点次日早餐 */
    protected String orderRuleDesc;

    /** 6. [不可空] 是否可用？ */
    protected Boolean available;

    /** 7. [可空] 备注 */
    protected String mealTypeDesc;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected MealType() {
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
    public MealType(int mark, MealType copy) {
        this(copy.getId(), copy.getMealTypeName(), copy.getMealTime(), copy.getOrderBefore(), copy.getOrderRuleDesc(), copy.getAvailable(), copy.getMealTypeDesc());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 餐别字典ID
     * @param mealTypeName [不可空] 餐别类型名称
     * @param mealTime [不可空] 就餐时间  24YYMM
     * @param orderBefore [不可空] 下单提前小时数
     * @param orderRuleDesc [可空] 规则描述  例如  晚上8：00前，可点次日早餐
     * @param available [不可空] 是否可用？
     * @param mealTypeDesc [可空] 备注
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullMealTypeBuilder")
    private MealType(String id, String mealTypeName, String mealTime, Integer orderBefore, String orderRuleDesc, Boolean available, String mealTypeDesc) {
        super(id);
        this.mealTypeName = SafeCopier.copy(mealTypeName);
        this.mealTime = SafeCopier.copy(mealTime);
        this.orderBefore = SafeCopier.copy(orderBefore);
        this.orderRuleDesc = SafeCopier.copy(orderRuleDesc);
        this.available = SafeCopier.copy(available);
        this.mealTypeDesc = SafeCopier.copy(mealTypeDesc);
    }

// ---------- getter/setter

    /**
     * 返回餐别字典ID。
     *
     * @return 餐别字典ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置餐别字典ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 餐别字典ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回餐别类型名称。
     *
     * @return [不可空] 餐别类型名称
     */
    public String getMealTypeName() {
        return SafeCopier.copy(mealTypeName);
    }

    /**
     * 返回就餐时间  24YYMM。
     *
     * @return [不可空] 就餐时间  24YYMM
     */
    public String getMealTime() {
        return SafeCopier.copy(mealTime);
    }

    /**
     * 返回下单提前小时数。
     *
     * @return [不可空] 下单提前小时数
     */
    public Integer getOrderBefore() {
        return SafeCopier.copy(orderBefore);
    }

    /**
     * 返回规则描述  例如  晚上8：00前，可点次日早餐。
     *
     * @return [可空] 规则描述  例如  晚上8：00前，可点次日早餐
     */
    public String getOrderRuleDesc() {
        return SafeCopier.copy(orderRuleDesc);
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
    public String getMealTypeDesc() {
        return SafeCopier.copy(mealTypeDesc);
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractMealType.checkProperties(getMealTypeName(), getMealTime(), getOrderBefore(), getOrderRuleDesc(), getAvailable(), getMealTypeDesc());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
