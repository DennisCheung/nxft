package com.wit.fxp.nxft.domain.model.meal;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.nxft.domain.model.meal.base.AbstractMealScheday;

/**
 * 每天菜谱对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractMealScheday
 */
public class MealScheday extends AbstractLoggingEntity<String> implements PropertyChecker {

    public void publish() {
        this.isPublished = true;
    }

    public void returnPublish() {
        this.isPublished = false;
    }

//    /**
//     * 创建{@link MealScheday}对象。
//     *
//     * @param id {@code MealScheday}对象的ID
//     */
//    public MealScheday(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.kitchenId = null;
//        this.schenoteId = null;
//        this.mealDate = null;
//        this.week = null;
//        this.mealTypeId = null;
//        this.mealTypeName = null;
//        this.mealId = null;
//        this.mealCode = null;
//        this.mealName = null;
//        this.mealPrice = null;
//        this.isPublished = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 2401860350593698859L;

    /** 2. [不可空] 厨房工作圈id */
    protected String kitchenCircleId;

    /** 2.1. [不可空] 厨房teamid */
    protected String kitchenTeamId;

    /** 3. [不可空] 排班单id */
    protected String schenoteId;

    /** 4. [不可空] 就餐日期 */
    protected java.util.Date mealDate;

    /** 5. [不可空] 周几 */
    protected Integer week;

    /** 6. [不可空] 餐别ID */
    protected String mealTypeId;

    /** 7. [不可空] 餐别名称 */
    protected String mealTypeName;

    /** 8. [不可空] 套餐id */
    protected String mealId;

    /** 9. [不可空] 套餐CODE */
    protected String mealCode;

    /** 10. [不可空] 套餐名称 */
    protected String mealName;

    /** 11. [可空] 套餐内容 */
    protected String mealContent;

    /** 12. [不可空] 单价 */
    protected Double mealPrice;

    /** 13. [可空] 备注 */
    protected String scheduleDesc;

    /** 14. [不可空] 是否已发布？ Y/N */
    protected Boolean isPublished;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected MealScheday() {
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
    public MealScheday(int mark, MealScheday copy) {
        this(copy.getId(), copy.getKitchenCircleId(), copy.getKitchenTeamId(), copy.getSchenoteId(), copy.getMealDate(), copy.getWeek(), copy.getMealTypeId(), copy.getMealTypeName(), copy.getMealId(), copy.getMealCode(), copy.getMealName(), copy.getMealContent(), copy.getMealPrice(), copy.getScheduleDesc(), copy.getIsPublished());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 每天菜谱ID
     * @param kitchenCircleId [不可空] 厨房工作圈id
     * @param kitchenTeamId [不可空] 厨房teamid
     * @param schenoteId [不可空] 排班单id
     * @param mealDate [不可空] 就餐日期
     * @param week [不可空] 周几
     * @param mealTypeId [不可空] 餐别ID
     * @param mealTypeName [不可空] 餐别名称
     * @param mealId [不可空] 套餐id
     * @param mealCode [不可空] 套餐CODE
     * @param mealName [不可空] 套餐名称
     * @param mealContent [可空] 套餐内容
     * @param mealPrice [不可空] 单价
     * @param scheduleDesc [可空] 备注
     * @param isPublished [不可空] 是否已发布？ Y/N
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullMealSchedayBuilder")
    private MealScheday(String id, String kitchenCircleId, String kitchenTeamId, String schenoteId, java.util.Date mealDate, Integer week, String mealTypeId, String mealTypeName, String mealId, String mealCode, String mealName, String mealContent, Double mealPrice, String scheduleDesc, Boolean isPublished) {
        super(id);
        this.kitchenCircleId = SafeCopier.copy(kitchenCircleId);
        this.kitchenTeamId = SafeCopier.copy(kitchenTeamId);
        this.schenoteId = SafeCopier.copy(schenoteId);
        this.mealDate = SafeCopier.copy(mealDate);
        this.week = SafeCopier.copy(week);
        this.mealTypeId = SafeCopier.copy(mealTypeId);
        this.mealTypeName = SafeCopier.copy(mealTypeName);
        this.mealId = SafeCopier.copy(mealId);
        this.mealCode = SafeCopier.copy(mealCode);
        this.mealName = SafeCopier.copy(mealName);
        this.mealContent = SafeCopier.copy(mealContent);
        this.mealPrice = SafeCopier.copy(mealPrice);
        this.scheduleDesc = SafeCopier.copy(scheduleDesc);
        this.isPublished = SafeCopier.copy(isPublished);
    }

// ---------- getter/setter

    /**
     * 返回每天菜谱ID。
     *
     * @return 每天菜谱ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置每天菜谱ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 每天菜谱ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回厨房工作圈id。
     *
     * @return [不可空] 厨房工作圈id
     */
    public String getKitchenCircleId() {
        return SafeCopier.copy(kitchenCircleId);
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
     * 返回排班单id。
     *
     * @return [不可空] 排班单id
     */
    public String getSchenoteId() {
        return SafeCopier.copy(schenoteId);
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
     * 返回周几。
     *
     * @return [不可空] 周几
     */
    public Integer getWeek() {
        return SafeCopier.copy(week);
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
     * 返回餐别名称。
     *
     * @return [不可空] 餐别名称
     */
    public String getMealTypeName() {
        return SafeCopier.copy(mealTypeName);
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
     * 返回套餐内容。
     *
     * @return [可空] 套餐内容
     */
    public String getMealContent() {
        return SafeCopier.copy(mealContent);
    }

    /**
     * 返回单价。
     *
     * @return [不可空] 单价
     */
    public Double getMealPrice() {
        return SafeCopier.copy(mealPrice);
    }

    /**
     * 返回备注。
     *
     * @return [可空] 备注
     */
    public String getScheduleDesc() {
        return SafeCopier.copy(scheduleDesc);
    }

    /**
     * 返回是否已发布？ Y/N。
     *
     * @return [不可空] 是否已发布？ Y/N
     */
    public Boolean getIsPublished() {
        return SafeCopier.copy(isPublished);
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractMealScheday.checkProperties(getKitchenCircleId(), getKitchenTeamId(), getSchenoteId(), getMealDate(), getWeek(), getMealTypeId(), getMealTypeName(), getMealId(), getMealCode(), getMealName(), getMealContent(), getMealPrice(), getScheduleDesc(), getIsPublished());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
