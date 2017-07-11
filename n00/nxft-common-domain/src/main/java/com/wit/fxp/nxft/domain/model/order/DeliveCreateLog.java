package com.wit.fxp.nxft.domain.model.order;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.nxft.domain.model.order.base.AbstractDeliveCreateLog;

/**
 * 配送单生成日志对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractDeliveCreateLog
 */
public class DeliveCreateLog extends AbstractLoggingEntity<String> implements PropertyChecker {

//    /**
//     * 创建{@link DeliveCreateLog}对象。
//     *
//     * @param id {@code DeliveCreateLog}对象的ID
//     */
//    public DeliveCreateLog(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.mealDate = null;
//        this.mealTypeId = null;
//        this.createTime = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 4241217212394990143L;

    /** 2. [不可空] 就餐日期 */
    protected java.util.Date mealDate;

    /** 3. [不可空] 餐别ID */
    protected String mealTypeId;

    /** 4. [不可空] 创建时间 */
    protected java.util.Date createTime;

    /** 5. [可空] 备注 */
    protected String logDesc;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected DeliveCreateLog() {
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
    public DeliveCreateLog(int mark, DeliveCreateLog copy) {
        this(copy.getId(), copy.getMealDate(), copy.getMealTypeId(), copy.getCreateTime(), copy.getLogDesc());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 配送单生成日志ID
     * @param mealDate [不可空] 就餐日期
     * @param mealTypeId [不可空] 餐别ID
     * @param createTime [不可空] 创建时间
     * @param logDesc [可空] 备注
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullDeliveCreateLogBuilder")
    private DeliveCreateLog(String id, java.util.Date mealDate, String mealTypeId, java.util.Date createTime, String logDesc) {
        super(id);
        this.mealDate = SafeCopier.copy(mealDate);
        this.mealTypeId = SafeCopier.copy(mealTypeId);
        this.createTime = SafeCopier.copy(createTime);
        this.logDesc = SafeCopier.copy(logDesc);
    }

// ---------- getter/setter

    /**
     * 返回配送单生成日志ID。
     *
     * @return 配送单生成日志ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置配送单生成日志ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 配送单生成日志ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回就餐日期。
     *
     * @return [不可空] 就餐日期
     */
    public java.util.Date getMealDate() {
        return SafeCopier.copy(mealDate);
    }

    /**
     * 返回餐别ID。
     *
     * @return [不可空] 餐别ID
     */
    public String getMealTypeId() {
        return SafeCopier.copy(mealTypeId);
    }

    /**
     * 返回创建时间。
     *
     * @return [不可空] 创建时间
     */
    public java.util.Date getCreateTime() {
        return SafeCopier.copy(createTime);
    }

    /**
     * 返回备注。
     *
     * @return [可空] 备注
     */
    public String getLogDesc() {
        return SafeCopier.copy(logDesc);
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractDeliveCreateLog.checkProperties(getMealDate(), getMealTypeId(), getCreateTime(), getLogDesc());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
