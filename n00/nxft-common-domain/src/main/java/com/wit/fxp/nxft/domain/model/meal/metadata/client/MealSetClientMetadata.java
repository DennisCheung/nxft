package com.wit.fxp.nxft.domain.model.meal.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.meal.MealSet;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class MealSetClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private MealSetClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public MealSetClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[MealSet]元数据
     */
    public static MealSetClientMetadata<MealSet> root() {
        return new MealSetClientMetadata<MealSet>(MealSet.class);
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
     * @return [禁忌疾病，名称逗号分隔]属性名
     */
    public String tabooDisease() {
        return getNode().isRoot()
                ? "tabooDisease"
                : getNode().getPath().toPropertyPath() + ".tabooDisease";
    }

    /**
     * @return [辣度]属性名
     */
    public String pepperyLevel() {
        return getNode().isRoot()
                ? "pepperyLevel"
                : getNode().getPath().toPropertyPath() + ".pepperyLevel";
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
     * @return [最新图片id]属性名
     */
    public String photoId() {
        return getNode().isRoot()
                ? "photoId"
                : getNode().getPath().toPropertyPath() + ".photoId";
    }

    /**
     * @return [厨房圈id]属性名
     */
    public String kitchenCircleId() {
        return getNode().isRoot()
                ? "kitchenCircleId"
                : getNode().getPath().toPropertyPath() + ".kitchenCircleId";
    }

    /**
     * @return [是否可用？]属性名
     */
    public String available() {
        return getNode().isRoot()
                ? "available"
                : getNode().getPath().toPropertyPath() + ".available";
    }

    /**
     * @return [备注]属性名
     */
    public String mealDesc() {
        return getNode().isRoot()
                ? "mealDesc"
                : getNode().getPath().toPropertyPath() + ".mealDesc";
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
     * @return [禁忌疾病]对象的客户端元数据
     */
    public com.wit.fxp.nxft.domain.model.meal.metadata.client.MealDiseaseClientMetadata<T> mealDiseaseSet() {
        getNode().addPath("mealDiseaseSet");

        return new com.wit.fxp.nxft.domain.model.meal.metadata.client.MealDiseaseClientMetadata<T>(this.getObjectTree(), getNode().getChild("mealDiseaseSet"));
    }
}
