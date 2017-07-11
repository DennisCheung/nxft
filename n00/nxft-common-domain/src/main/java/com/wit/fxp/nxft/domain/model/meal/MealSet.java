package com.wit.fxp.nxft.domain.model.meal;

import java.util.List;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.domain.datatype.IdAndObject;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.domain.model.meal.base.AbstractMealSet;
import com.wit.utils.CollectionUtils;

/**
 * 套餐字典对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractMealSet
 */
public class MealSet extends AbstractLoggingEntity<String> implements PropertyChecker {

    /**
     * 获取套餐内容
     * @return
     */
    public String getContent() {
        return this.getMealContent();
    }

    @lombok.experimental.BuilderCall(builderMethodName = "更新")
    public void updateMealSet(String mealSetCode, String mealName, String mealContent, Integer pepperyLevel, Double mealPrice, String mealDesc) {
        this.mealCode = mealSetCode;
        this.mealName = mealName;
        this.mealContent = mealContent;
        this.pepperyLevel = pepperyLevel;
        this.mealPrice = mealPrice;
        this.mealDesc = mealDesc;
    }

    public void updateMealDisease(List<IdAndObject<String, AddMealDiseaseData>> idAndObjects, InvocationContext ic) {
        CollectionUtils.<MealDisease, IdAndObject<String, AddMealDiseaseData>>mergeInvoker()
        ._target____(this.mealDiseaseSet)
        ._source____(idAndObjects)
        ._comp______((a, b) -> {
            return a.getDiseaseId().equals(b.getObject().getDiseaseId());
        })
        ._createNew_(b -> {
            return MealDisease.fullMealDiseaseBuilder()
                    ._id____________(ic.generateId(MealDisease.class))
                    ._diseaseId_____(b.getObject().getDiseaseId())
                    ._diseaseName___(b.getObject().getDiseaseName())
                    ._mealId________(this.getId())
                    ._diseaseDesc___(b.getObject().getDiseaseDesc())
                    ._build_();
        })
            ._invoke_();
    }

//    /**
//     * 创建{@link MealSet}对象。
//     *
//     * @param id {@code MealSet}对象的ID
//     */
//    public MealSet(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//        this.mealCode = null;
//        this.mealName = null;
//        this.mealContent = null;
//        this.mealPrice = null;
//        this.kitchenId = null;
//        this.available = null;
//    }

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 9165656830449032183L;

    /** 2. [不可空] 套餐CODE */
    protected String mealCode;

    /** 3. [不可空] 套餐名称 */
    protected String mealName;

    /** 4. [不可空] 套餐内容 */
    protected String mealContent;

    /** 5. [可空] 禁忌疾病，名称逗号分隔 */
    protected String tabooDisease;

    /** 6. [可空] 辣度 */
    protected Integer pepperyLevel;

    /** 7. [不可空] 单价 */
    protected Double mealPrice;

    /** 8. [可空] 最新图片id */
    protected String photoId;

    /** 9. [不可空] 厨房圈id */
    protected String kitchenCircleId;

    /** 10. [不可空] 是否可用？ */
    protected Boolean available;

    /** 11. [可空] 备注 */
    protected String mealDesc;

    /** 19. [不可空] 厨房teamid */
    protected String kitchenTeamId;

    /** [实体集合] 禁忌疾病 */
    private java.util.Set<com.wit.fxp.nxft.domain.model.meal.MealDisease> mealDiseaseSet =
            new java.util.HashSet<com.wit.fxp.nxft.domain.model.meal.MealDisease>();

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected MealSet() {
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
    public MealSet(int mark, MealSet copy) {
        this(copy.getId(), copy.getMealCode(), copy.getMealName(), copy.getMealContent(), copy.getTabooDisease(), copy.getPepperyLevel(), copy.getMealPrice(), copy.getPhotoId(), copy.getKitchenCircleId(), copy.getAvailable(), copy.getMealDesc(), copy.getKitchenTeamId());
        mealDiseaseSet = copy.internalGetMealDiseaseSet();
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 套餐字典ID
     * @param mealCode [不可空] 套餐CODE
     * @param mealName [不可空] 套餐名称
     * @param mealContent [不可空] 套餐内容
     * @param tabooDisease [可空] 禁忌疾病，名称逗号分隔
     * @param pepperyLevel [可空] 辣度
     * @param mealPrice [不可空] 单价
     * @param photoId [可空] 最新图片id
     * @param kitchenCircleId [不可空] 厨房圈id
     * @param available [不可空] 是否可用？
     * @param mealDesc [可空] 备注
     * @param kitchenTeamId [不可空] 厨房teamid
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullMealSetBuilder")
    private MealSet(String id, String mealCode, String mealName, String mealContent, String tabooDisease, Integer pepperyLevel, Double mealPrice, String photoId, String kitchenCircleId, Boolean available, String mealDesc, String kitchenTeamId) {
        super(id);
        this.mealCode = SafeCopier.copy(mealCode);
        this.mealName = SafeCopier.copy(mealName);
        this.mealContent = SafeCopier.copy(mealContent);
        this.tabooDisease = SafeCopier.copy(tabooDisease);
        this.pepperyLevel = SafeCopier.copy(pepperyLevel);
        this.mealPrice = SafeCopier.copy(mealPrice);
        this.photoId = SafeCopier.copy(photoId);
        this.kitchenCircleId = SafeCopier.copy(kitchenCircleId);
        this.available = SafeCopier.copy(available);
        this.mealDesc = SafeCopier.copy(mealDesc);
        this.kitchenTeamId = SafeCopier.copy(kitchenTeamId);
    }

// ---------- getter/setter

    /**
     * 返回套餐字典ID。
     *
     * @return 套餐字典ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置套餐字典ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 套餐字典ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
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
     * @return [不可空] 套餐内容
     */
    public String getMealContent() {
        return SafeCopier.copy(mealContent);
    }

    /**
     * 返回禁忌疾病，名称逗号分隔。
     *
     * @return [可空] 禁忌疾病，名称逗号分隔
     */
    public String getTabooDisease() {
        return SafeCopier.copy(tabooDisease);
    }

    /**
     * 返回辣度。
     *
     * @return [可空] 辣度
     */
    public Integer getPepperyLevel() {
        return SafeCopier.copy(pepperyLevel);
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
     * 返回最新图片id。
     *
     * @return [可空] 最新图片id
     */
    public String getPhotoId() {
        return SafeCopier.copy(photoId);
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
    public String getMealDesc() {
        return SafeCopier.copy(mealDesc);
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
     * 返回禁忌疾病[实体集合]。
     *
     * @return [不可修改集合类{@link java.util.Collections#unmodifiableSet}] 禁忌疾病
     */
    public java.util.Set<com.wit.fxp.nxft.domain.model.meal.MealDisease> getMealDiseaseSet() {
        if (mealDiseaseSet == null) {
            return java.util.Collections.emptySet();
        }
        else {
            return java.util.Collections.unmodifiableSet(mealDiseaseSet);
        }
    }

    /**
     * 返回禁忌疾病[实体集合]，本方法供内部使用。
     *
     * @return 禁忌疾病
     */
    private java.util.Set<com.wit.fxp.nxft.domain.model.meal.MealDisease> internalGetMealDiseaseSet() {
        return mealDiseaseSet;
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractMealSet.checkProperties(getMealCode(), getMealName(), getMealContent(), getTabooDisease(), getPepperyLevel(), getMealPrice(), getPhotoId(), getKitchenCircleId(), getAvailable(), getMealDesc(), getKitchenTeamId());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
