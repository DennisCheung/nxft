package com.wit.fxp.nxft.domain.model.meal.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.meal.MealDisease;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class MealDiseaseClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private MealDiseaseClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public MealDiseaseClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[MealDisease]元数据
     */
    public static MealDiseaseClientMetadata<MealDisease> root() {
        return new MealDiseaseClientMetadata<MealDisease>(MealDisease.class);
    }

    /**
     * @return [疾病id]属性名
     */
    public String diseaseId() {
        return getNode().isRoot()
                ? "diseaseId"
                : getNode().getPath().toPropertyPath() + ".diseaseId";
    }

    /**
     * @return [疾病名称]属性名
     */
    public String diseaseName() {
        return getNode().isRoot()
                ? "diseaseName"
                : getNode().getPath().toPropertyPath() + ".diseaseName";
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
     * @return [备注]属性名
     */
    public String diseaseDesc() {
        return getNode().isRoot()
                ? "diseaseDesc"
                : getNode().getPath().toPropertyPath() + ".diseaseDesc";
    }
}
