package com.wit.fxp.nxft.domain.model.order;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.nxft.domain.model.order.base.AbstractDeliveDetail;

/**
 * 配送单明细对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractDeliveDetail
 */
public class DeliveDetail extends AbstractLoggingEntity<String> implements PropertyChecker {

//    /**
//     * 创建{@link DeliveDetail}对象。
//     *
//     * @param id {@code DeliveDetail}对象的ID
//     */
//    public DeliveDetail(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.mealId = null;
//        this.mealCode = null;
//        this.mealName = null;
//        this.quantity = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 9215549012729220284L;

    /** 2. [不可空] 套餐id */
    protected String mealId;

    /** 3. [不可空] 套餐CODE */
    protected String mealCode;

    /** 4. [不可空] 套餐名称 */
    protected String mealName;

    /** 5. [不可空] 数量 */
    protected Integer quantity;

    /** 6. [可空] 配送单id */
    protected String deliveNoteId;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected DeliveDetail() {
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
    public DeliveDetail(int mark, DeliveDetail copy) {
        this(copy.getId(), copy.getMealId(), copy.getMealCode(), copy.getMealName(), copy.getQuantity(), copy.getDeliveNoteId());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 配送单明细ID
     * @param mealId [不可空] 套餐id
     * @param mealCode [不可空] 套餐CODE
     * @param mealName [不可空] 套餐名称
     * @param quantity [不可空] 数量
     * @param deliveNoteId [可空] 配送单id
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullDeliveDetailBuilder")
    private DeliveDetail(String id, String mealId, String mealCode, String mealName, Integer quantity, String deliveNoteId) {
        super(id);
        this.mealId = SafeCopier.copy(mealId);
        this.mealCode = SafeCopier.copy(mealCode);
        this.mealName = SafeCopier.copy(mealName);
        this.quantity = SafeCopier.copy(quantity);
        this.deliveNoteId = SafeCopier.copy(deliveNoteId);
    }

// ---------- getter/setter

    /**
     * 返回配送单明细ID。
     *
     * @return 配送单明细ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置配送单明细ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 配送单明细ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回套餐id。
     *
     * @return [不可空] 套餐id
     */
    public String getMealId() {
        return SafeCopier.copy(mealId);
    }

    /**
     * 返回套餐CODE。
     *
     * @return [不可空] 套餐CODE
     */
    public String getMealCode() {
        return SafeCopier.copy(mealCode);
    }

    /**
     * 返回套餐名称。
     *
     * @return [不可空] 套餐名称
     */
    public String getMealName() {
        return SafeCopier.copy(mealName);
    }

    /**
     * 返回数量。
     *
     * @return [不可空] 数量
     */
    public Integer getQuantity() {
        return SafeCopier.copy(quantity);
    }

    /**
     * 返回配送单id。
     *
     * @return [可空] 配送单id
     */
    public String getDeliveNoteId() {
        return SafeCopier.copy(deliveNoteId);
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractDeliveDetail.checkProperties(getMealId(), getMealCode(), getMealName(), getQuantity(), getDeliveNoteId());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
