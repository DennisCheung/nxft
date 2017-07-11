package com.wit.fxp.nxft.domain.model.dict;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.nxft.domain.model.dict.base.AbstractCircleKitchen;

/**
 * 工作圈厨房签约对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractCircleKitchen
 */
public class CircleKitchen extends AbstractLoggingEntity<String> implements PropertyChecker {

//    /**
//     * 创建{@link CircleKitchen}对象。
//     *
//     * @param id {@code CircleKitchen}对象的ID
//     */
//    public CircleKitchen(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.circleId = null;
//        this.kitchenId = null;
//        this.deliveFee = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 4543132982667875109L;

    /** 2. [不可空] 所属的工作圈id */
    protected String circleId;

    /** 3. [不可空] 厨房圈id */
    protected String kitchenCircleId;

    /** 4. [不可空] 配送费 */
    protected Double deliveFee;

    /** 5. [可空] 备注 */
    protected String kitchenDesc;

    /** 13. [不可空] 厨房teamid */
    protected String kitchenTeamId;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected CircleKitchen() {
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
    public CircleKitchen(int mark, CircleKitchen copy) {
        this(copy.getId(), copy.getCircleId(), copy.getKitchenCircleId(), copy.getDeliveFee(), copy.getKitchenDesc(), copy.getKitchenTeamId());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 工作圈厨房签约ID
     * @param circleId [不可空] 所属的工作圈id
     * @param kitchenCircleId [不可空] 厨房圈id
     * @param deliveFee [不可空] 配送费
     * @param kitchenDesc [可空] 备注
     * @param kitchenTeamId [不可空] 厨房teamid
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullCircleKitchenBuilder")
    private CircleKitchen(String id, String circleId, String kitchenCircleId, Double deliveFee, String kitchenDesc, String kitchenTeamId) {
        super(id);
        this.circleId = SafeCopier.copy(circleId);
        this.kitchenCircleId = SafeCopier.copy(kitchenCircleId);
        this.deliveFee = SafeCopier.copy(deliveFee);
        this.kitchenDesc = SafeCopier.copy(kitchenDesc);
        this.kitchenTeamId = SafeCopier.copy(kitchenTeamId);
    }

// ---------- getter/setter

    /**
     * 返回工作圈厨房签约ID。
     *
     * @return 工作圈厨房签约ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置工作圈厨房签约ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 工作圈厨房签约ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回所属的工作圈id。
     *
     * @return [不可空] 所属的工作圈id
     */
    public String getCircleId() {
        return SafeCopier.copy(circleId);
    }

    /**
     * 返回厨房圈id。
     *
     * @return [不可空] 厨房圈id
     */
    public String getKitchenCircleId() {
        return SafeCopier.copy(kitchenCircleId);
    }

    /**
     * 返回配送费。
     *
     * @return [不可空] 配送费
     */
    public Double getDeliveFee() {
        return SafeCopier.copy(deliveFee);
    }

    /**
     * 返回备注。
     *
     * @return [可空] 备注
     */
    public String getKitchenDesc() {
        return SafeCopier.copy(kitchenDesc);
    }

    /**
     * 返回厨房teamid。
     *
     * @return [不可空] 厨房teamid
     */
    public String getKitchenTeamId() {
        return SafeCopier.copy(kitchenTeamId);
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractCircleKitchen.checkProperties(getCircleId(), getKitchenCircleId(), getDeliveFee(), getKitchenDesc(), getKitchenTeamId());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
