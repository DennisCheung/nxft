package com.wit.fxp.nxft.domain.model.meal.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.meal.MealSet;

// CHECKSTYLE:OFF

/**
 * 服务端[套餐字典]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class MealSetMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private MealSetMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public MealSetMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[MealSet]元数据
     */
    public static MealSetMetadata<MealSet> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[MealSet]元数据
     */
    public static MealSetMetadata<MealSet> root(String rootAlias) {
        return new MealSetMetadata<MealSet>(MealSet.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [套餐CODE]属性的操作符
     */
    public AlgebraicVariable<String> mealCode() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealCode");
    }

    /**
     * @return [套餐名称]属性的操作符
     */
    public AlgebraicVariable<String> mealName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealName");
    }

    /**
     * @return [套餐内容]属性的操作符
     */
    public AlgebraicVariable<String> mealContent() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealContent");
    }

    /**
     * @return [禁忌疾病，名称逗号分隔]属性的操作符
     */
    public AlgebraicVariable<String> tabooDisease() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "tabooDisease");
    }

    /**
     * @return [辣度]属性的操作符
     */
    public AlgebraicVariable<Integer> pepperyLevel() {
        return new ObjectTreeAlgebraicVariable<Integer>(Integer.class, getNode(), "pepperyLevel");
    }

    /**
     * @return [单价]属性的操作符
     */
    public AlgebraicVariable<Double> mealPrice() {
        return new ObjectTreeAlgebraicVariable<Double>(Double.class, getNode(), "mealPrice");
    }

    /**
     * @return [最新图片id]属性的操作符
     */
    public AlgebraicVariable<String> photoId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "photoId");
    }

    /**
     * @return [厨房圈id]属性的操作符
     */
    public AlgebraicVariable<String> kitchenCircleId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "kitchenCircleId");
    }

    /**
     * @return [是否可用？]属性的操作符
     */
    public AlgebraicVariable<Boolean> available() {
        return new ObjectTreeAlgebraicVariable<Boolean>(Boolean.class, getNode(), "available");
    }

    /**
     * @return [备注]属性的操作符
     */
    public AlgebraicVariable<String> mealDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealDesc");
    }

    /**
     * @return [厨房teamid]属性的操作符
     */
    public AlgebraicVariable<String> kitchenTeamId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "kitchenTeamId");
    }

    /**
     * 内连接、延迟加载
     *
     * @return [禁忌疾病]的元数据
     */
    public com.wit.fxp.nxft.domain.model.meal.metadata.MealDiseaseMetadata<T> mealDiseaseSet() {
        return inner_join_mealDiseaseSet();
    }

    /**
     * 内连接、延迟加载
     *
     * @return [禁忌疾病]的元数据
     */
    public com.wit.fxp.nxft.domain.model.meal.metadata.MealDiseaseMetadata<T> inner_join_mealDiseaseSet() {
        return inner_join_mealDiseaseSet("", true);
    }

    /**
     * 内连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [禁忌疾病]的元数据
     */
    public com.wit.fxp.nxft.domain.model.meal.metadata.MealDiseaseMetadata<T> inner_join_mealDiseaseSet(String alias, boolean lazyLoad) {
        return mealDiseaseSet(alias, com.benewit.ecctree.EccNodeConstant.INNER_JOIN, lazyLoad);
    }

    /**
     * 左外连接、延迟加载
     *
     * @return [禁忌疾病]的元数据
     */
    public com.wit.fxp.nxft.domain.model.meal.metadata.MealDiseaseMetadata<T> left_outer_join_mealDiseaseSet() {
        return left_outer_join_mealDiseaseSet("", true);
    }

    /**
     * 左外连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [禁忌疾病]的元数据
     */
    public com.wit.fxp.nxft.domain.model.meal.metadata.MealDiseaseMetadata<T> left_outer_join_mealDiseaseSet(String alias, boolean lazyLoad) {
        return mealDiseaseSet(alias, com.benewit.ecctree.EccNodeConstant.LEFT_OUTER_JOIN, lazyLoad);
    }

    /**
     * @param join 连接方式
     * @param lazyLoad 是否延迟加载？
     * @return [禁忌疾病]的元数据
     */
    private com.wit.fxp.nxft.domain.model.meal.metadata.MealDiseaseMetadata<T> mealDiseaseSet(String alias, String join, boolean lazyLoad) {
        String segment = getNode().getTree().getSegmentParser().formatSegment("mealDiseaseSet", alias, join, !lazyLoad);
        getNode().addPath(segment);

        return new com.wit.fxp.nxft.domain.model.meal.metadata.MealDiseaseMetadata<T>(getNode().getChild("mealDiseaseSet"));
    }
}
