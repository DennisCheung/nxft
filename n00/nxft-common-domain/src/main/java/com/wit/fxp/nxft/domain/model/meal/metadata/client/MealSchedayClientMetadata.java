package com.wit.fxp.nxft.domain.model.meal.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.meal.MealScheday;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class MealSchedayClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private MealSchedayClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public MealSchedayClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[MealScheday]元数据
     */
    public static MealSchedayClientMetadata<MealScheday> root() {
        return new MealSchedayClientMetadata<MealScheday>(MealScheday.class);
    }

    /**
     * @return [厨房工作圈id]属性名
     */
    public String kitchenCircleId() {
        return getNode().isRoot()
                ? "kitchenCircleId"
                : getNode().getPath().toPropertyPath() + ".kitchenCircleId";
    }

    /**
     * @return [厨房teamid]属性名
     */
    public String kitchenTeamId() {
        return getNode().isRoot()
                ? "kitchenTeamId"
                : getNode().getPath().toPropertyPath() + ".kitchenTeamId";
    }

    /**
     * @return [排班单id]属性名
     */
    public String schenoteId() {
        return getNode().isRoot()
                ? "schenoteId"
                : getNode().getPath().toPropertyPath() + ".schenoteId";
    }

    /**
     * @return [就餐日期]属性名
     */
    public String mealDate() {
        return getNode().isRoot()
                ? "mealDate"
                : getNode().getPath().toPropertyPath() + ".mealDate";
    }

    /**
     * @return [周几]属性名
     */
    public String week() {
        return getNode().isRoot()
                ? "week"
                : getNode().getPath().toPropertyPath() + ".week";
    }

    /**
     * @return [餐别ID]属性名
     */
    public String mealTypeId() {
        return getNode().isRoot()
                ? "mealTypeId"
                : getNode().getPath().toPropertyPath() + ".mealTypeId";
    }

    /**
     * @return [餐别名称]属性名
     */
    public String mealTypeName() {
        return getNode().isRoot()
                ? "mealTypeName"
                : getNode().getPath().toPropertyPath() + ".mealTypeName";
    }

    /**
     * @return [套餐id]属性名
     */
    public String mealId() {
        return getNode().isRoot()
                ? "mealId"
                : getNode().getPath().toPropertyPath() + ".mealId";
    }

    /**
     * @return [套餐CODE]属性名
     */
    public String mealCode() {
        return getNode().isRoot()
                ? "mealCode"
                : getNode().getPath().toPropertyPath() + ".mealCode";
    }

    /**
     * @return [套餐名称]属性名
     */
    public String mealName() {
        return getNode().isRoot()
                ? "mealName"
                : getNode().getPath().toPropertyPath() + ".mealName";
    }

    /**
     * @return [套餐内容]属性名
     */
    public String mealContent() {
        return getNode().isRoot()
                ? "mealContent"
                : getNode().getPath().toPropertyPath() + ".mealContent";
    }

    /**
     * @return [单价]属性名
     */
    public String mealPrice() {
        return getNode().isRoot()
                ? "mealPrice"
                : getNode().getPath().toPropertyPath() + ".mealPrice";
    }

    /**
     * @return [备注]属性名
     */
    public String scheduleDesc() {
        return getNode().isRoot()
                ? "scheduleDesc"
                : getNode().getPath().toPropertyPath() + ".scheduleDesc";
    }

    /**
     * @return [是否已发布？ Y/N]属性名
     */
    public String isPublished() {
        return getNode().isRoot()
                ? "isPublished"
                : getNode().getPath().toPropertyPath() + ".isPublished";
    }
}
