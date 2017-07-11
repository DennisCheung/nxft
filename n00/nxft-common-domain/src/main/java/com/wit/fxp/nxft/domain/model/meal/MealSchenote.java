package com.wit.fxp.nxft.domain.model.meal;

import java.util.List;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.domain.datatype.IdAndObject;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.domain.model.meal.base.AbstractMealSchenote;
import com.wit.utils.CollectionUtils;

/**
 * 菜谱安排单对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractMealSchenote
 */
public class MealSchenote extends AbstractLoggingEntity<String> implements PropertyChecker {

    // 更新周菜谱每日详情
    public void updateMealScheDays(List<IdAndObject<String, MealScheDayData>> days, InvocationContext ic) {
        CollectionUtils.<MealScheday, IdAndObject<String, MealScheDayData>>mergeInvoker()
                ._target____(this.mealSchedaySet)
                ._source____(days)
                ._comp______((a, b) -> {
                    return a.getMealId().equals(b.getObject().getMealId()) && a.getMealTypeId().equals(b.getObject().getMealTypeId())
                            && a.getWeek().equals(b.getObject().getWeek());
                })
                ._createNew_(b -> {
                    return MealScheday.fullMealSchedayBuilder()
                            ._id________________(ic.generateId(MealScheday.class))
                            ._kitchenCircleId___(this.getScheInfo().getKitchenCircleId())
                            ._kitchenTeamId_____(this.getScheInfo().getKitchenTeamId())
                            ._schenoteId________(this.getId())
                            ._mealDate__________(b.getObject().getMealDate())
                            ._week______________(b.getObject().getWeek())
                            ._mealTypeId________(b.getObject().getMealTypeId())
                            ._mealTypeName______(b.getObject().getMealTypeName())
                            ._mealId____________(b.getObject().getMealId())
                            ._mealCode__________(b.getObject().getMealCode())
                            ._mealName__________(b.getObject().getMealName())
                            ._mealContent_______(b.getObject().getMealContent())
                            ._mealPrice_________(b.getObject().getMealPrice())
                            ._scheduleDesc______(b.getObject().getScheduleDesc())
                            ._isPublished_______(false)
                            ._build_();
                })
                ._invoke_();
    }

    @lombok.experimental.BuilderCall(builderMethodName = "发布")
    public void publish(MealSchenote.PublishInfo publishInfo) {
        this.publishInfo = publishInfo;
    }

    public void returnPublish() {
        this.publishInfo = MealSchenote.PublishInfo.EMPTY;
    }

//    /**
//     * 创建{@link MealSchenote}对象。
//     *
//     * @param id {@code MealSchenote}对象的ID
//     */
//    public MealSchenote(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//    }

    // ---------- MealSchenote.__ScheInfo组件定义
    /**
     * [组件类] 排班信息。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class ScheInfo extends AbstractMealSchenote._ScheInfo {

        public static final ScheInfo EMPTY = new ScheInfo();

        // BEGIN>>>@$^*!#%&ScheInfo
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        ScheInfo() {
            super();
        }

        /**
         * 完整构造函数。除实体关系字段（如果有的话）外，其它字段按不可变类设计，具体请参见父类说明。
         *
         * <ul>
         * <li>对于基本字段，如果是可变类则拷贝，否则直接引用。</li>
         * <li>对于组件字段，直接引用。</li>
         * <li>对于实体字段，直接引用</li>
         * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
         * </ul>
         *
         * @param schenoteDesc [可空] 排班单备注
         * @param kitchenCircleId [不可空] 厨房圈id
         * @param beginDate [不可空] 排班起始日期=上周期终止日期 + 1
         * @param kitchenTeamId [不可空] 厨房teamid
         * @param endDate [不可空] 排班终止日期
         * @param periodModel [不可空] 排班周期模式 WEEK 周 MONTH 月
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public ScheInfo(String schenoteDesc, String kitchenCircleId, java.util.Date beginDate, String kitchenTeamId, java.util.Date endDate, String periodModel) {
            super(schenoteDesc, kitchenCircleId, beginDate, kitchenTeamId, endDate, periodModel);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@ScheInfo

    }   // ScheInfo

    // ---------- MealSchenote.__CreateInfo组件定义
    /**
     * [组件类] 创建信息。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class CreateInfo extends AbstractMealSchenote._CreateInfo {

        public static final CreateInfo EMPTY = new CreateInfo();

        // BEGIN>>>@$^*!#%&CreateInfo
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        CreateInfo() {
            super();
        }

        /**
         * 完整构造函数。除实体关系字段（如果有的话）外，其它字段按不可变类设计，具体请参见父类说明。
         *
         * <ul>
         * <li>对于基本字段，如果是可变类则拷贝，否则直接引用。</li>
         * <li>对于组件字段，直接引用。</li>
         * <li>对于实体字段，直接引用</li>
         * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
         * </ul>
         *
         * @param createTime [不可空] 创建时间
         * @param createUserId [不可空] 创建工号id
         * @param createNickname [不可空] 创建姓名
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public CreateInfo(java.util.Date createTime, String createUserId, String createNickname) {
            super(createTime, createUserId, createNickname);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@CreateInfo

    }   // CreateInfo

    // ---------- MealSchenote.__PublishInfo组件定义
    /**
     * [组件类] 发布信息。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class PublishInfo extends AbstractMealSchenote._PublishInfo {

        public static final PublishInfo EMPTY = new PublishInfo();

        // BEGIN>>>@$^*!#%&PublishInfo
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        PublishInfo() {
            super();
        }

        /**
         * 完整构造函数。除实体关系字段（如果有的话）外，其它字段按不可变类设计，具体请参见父类说明。
         *
         * <ul>
         * <li>对于基本字段，如果是可变类则拷贝，否则直接引用。</li>
         * <li>对于组件字段，直接引用。</li>
         * <li>对于实体字段，直接引用</li>
         * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
         * </ul>
         *
         * @param isPublished [不可空] 是否已发布？ Y/N
         * @param publishTime [可空] 发布时间
         * @param publishUserId [可空] 发布工号id
         * @param publishNickname [可空] 发布姓名
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public PublishInfo(Boolean isPublished, java.util.Date publishTime, String publishUserId, String publishNickname) {
            super(isPublished, publishTime, publishUserId, publishNickname);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@PublishInfo

    }   // PublishInfo

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 5009219651896758247L;

    /** [组件] 排班信息 */
    private MealSchenote.ScheInfo scheInfo;

    /** [组件] 创建信息 */
    private MealSchenote.CreateInfo createInfo;

    /** [组件] 发布信息 */
    private MealSchenote.PublishInfo publishInfo;

    /** [实体集合] 周菜谱详情 */
    private java.util.Set<com.wit.fxp.nxft.domain.model.meal.MealScheday> mealSchedaySet =
            new java.util.HashSet<com.wit.fxp.nxft.domain.model.meal.MealScheday>();

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected MealSchenote() {
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
    public MealSchenote(int mark, MealSchenote copy) {
        this(copy.getId(), copy.getScheInfo(), copy.getCreateInfo(), copy.getPublishInfo());
        mealSchedaySet = copy.internalGetMealSchedaySet();
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 菜谱安排单ID
     * @param scheInfo 排班信息
     * @param createInfo 创建信息
     * @param publishInfo 发布信息
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullMealSchenoteBuilder")
    private MealSchenote(String id, MealSchenote.ScheInfo scheInfo, MealSchenote.CreateInfo createInfo, MealSchenote.PublishInfo publishInfo) {
        super(id);
        this.scheInfo = scheInfo;
        this.createInfo = createInfo;
        this.publishInfo = publishInfo;
    }

// ---------- getter/setter

    /**
     * 返回菜谱安排单ID。
     *
     * @return 菜谱安排单ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置菜谱安排单ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 菜谱安排单ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回排班信息[组件]。
     *
     * @return 排班信息
     */
    public MealSchenote.ScheInfo getScheInfo() {
        return scheInfo == null ? MealSchenote.ScheInfo.EMPTY : scheInfo;
    }

    /**
     * 返回创建信息[组件]。
     *
     * @return 创建信息
     */
    public MealSchenote.CreateInfo getCreateInfo() {
        return createInfo == null ? MealSchenote.CreateInfo.EMPTY : createInfo;
    }

    /**
     * 返回发布信息[组件]。
     *
     * @return 发布信息
     */
    public MealSchenote.PublishInfo getPublishInfo() {
        return publishInfo == null ? MealSchenote.PublishInfo.EMPTY : publishInfo;
    }

    /**
     * 返回周菜谱详情[实体集合]。
     *
     * @return [不可修改集合类{@link java.util.Collections#unmodifiableSet}] 周菜谱详情
     */
    public java.util.Set<com.wit.fxp.nxft.domain.model.meal.MealScheday> getMealSchedaySet() {
        if (mealSchedaySet == null) {
            return java.util.Collections.emptySet();
        }
        else {
            return java.util.Collections.unmodifiableSet(mealSchedaySet);
        }
    }

    /**
     * 返回周菜谱详情[实体集合]，本方法供内部使用。
     *
     * @return 周菜谱详情
     */
    private java.util.Set<com.wit.fxp.nxft.domain.model.meal.MealScheday> internalGetMealSchedaySet() {
        return mealSchedaySet;
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractMealSchenote.checkProperties(getScheInfo(), getCreateInfo(), getPublishInfo());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
