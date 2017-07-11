package com.wit.fxp.nxft.domain.model.meal.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.meal.MealDisease;

// CHECKSTYLE:OFF

/**
 * 服务端[套餐禁忌疾病]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class MealDiseaseMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private MealDiseaseMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public MealDiseaseMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[MealDisease]元数据
     */
    public static MealDiseaseMetadata<MealDisease> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[MealDisease]元数据
     */
    public static MealDiseaseMetadata<MealDisease> root(String rootAlias) {
        return new MealDiseaseMetadata<MealDisease>(MealDisease.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [疾病id]属性的操作符
     */
    public AlgebraicVariable<String> diseaseId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "diseaseId");
    }

    /**
     * @return [疾病名称]属性的操作符
     */
    public AlgebraicVariable<String> diseaseName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "diseaseName");
    }

    /**
     * @return [套餐id]属性的操作符
     */
    public AlgebraicVariable<String> mealId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealId");
    }

    /**
     * @return [备注]属性的操作符
     */
    public AlgebraicVariable<String> diseaseDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "diseaseDesc");
    }
}
