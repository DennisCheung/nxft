package com.wit.fxp.nxft.domain.model.sis;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.nxft.domain.model.sis.base.AbstractSisServiceResource;

/**
 * 配餐服务资源对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractSisServiceResource
 */
public class SisServiceResource extends AbstractLoggingEntity<String> implements PropertyChecker {

//    /**
//     * 创建{@link SisServiceResource}对象。
//     *
//     * @param id {@code SisServiceResource}对象的ID
//     */
//    public SisServiceResource(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.circleId = null;
//        this.indicatorId = null;
//        this.indicatorName = null;
//        this.quantity = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 1945722774050867195L;

    /** 2. [不可空] 工作圈id */
    protected String circleId;

    /** 3. [不可空] 统计指标ID(常量) */
    protected String indicatorId;

    /** 4. [不可空] 统计指标名称 */
    protected String indicatorName;

    /** 5. [不可空] 数量 */
    protected Integer quantity;

    /** 6. [可空] 备注 */
    protected String dataDesc;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected SisServiceResource() {
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
    public SisServiceResource(int mark, SisServiceResource copy) {
        this(copy.getId(), copy.getCircleId(), copy.getIndicatorId(), copy.getIndicatorName(), copy.getQuantity(), copy.getDataDesc());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 配餐服务资源ID
     * @param circleId [不可空] 工作圈id
     * @param indicatorId [不可空] 统计指标ID(常量)
     * @param indicatorName [不可空] 统计指标名称
     * @param quantity [不可空] 数量
     * @param dataDesc [可空] 备注
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullSisServiceResourceBuilder")
    private SisServiceResource(String id, String circleId, String indicatorId, String indicatorName, Integer quantity, String dataDesc) {
        super(id);
        this.circleId = SafeCopier.copy(circleId);
        this.indicatorId = SafeCopier.copy(indicatorId);
        this.indicatorName = SafeCopier.copy(indicatorName);
        this.quantity = SafeCopier.copy(quantity);
        this.dataDesc = SafeCopier.copy(dataDesc);
    }

// ---------- getter/setter

    /**
     * 返回配餐服务资源ID。
     *
     * @return 配餐服务资源ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置配餐服务资源ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 配餐服务资源ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回工作圈id。
     *
     * @return [不可空] 工作圈id
     */
    public String getCircleId() {
        return SafeCopier.copy(circleId);
    }

    /**
     * 返回统计指标ID(常量)。
     *
     * @return [不可空] 统计指标ID(常量)
     */
    public String getIndicatorId() {
        return SafeCopier.copy(indicatorId);
    }

    /**
     * 返回统计指标名称。
     *
     * @return [不可空] 统计指标名称
     */
    public String getIndicatorName() {
        return SafeCopier.copy(indicatorName);
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
     * 返回备注。
     *
     * @return [可空] 备注
     */
    public String getDataDesc() {
        return SafeCopier.copy(dataDesc);
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractSisServiceResource.checkProperties(getCircleId(), getIndicatorId(), getIndicatorName(), getQuantity(), getDataDesc());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
