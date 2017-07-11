package com.wit.fxp.nxft.domain.model.dict.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.dict.MealType;

// CHECKSTYLE:OFF

/**
 * 服务端[餐别字典]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class MealTypeMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private MealTypeMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public MealTypeMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[MealType]元数据
     */
    public static MealTypeMetadata<MealType> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[MealType]元数据
     */
    public static MealTypeMetadata<MealType> root(String rootAlias) {
        return new MealTypeMetadata<MealType>(MealType.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [餐别类型名称]属性的操作符
     */
    public AlgebraicVariable<String> mealTypeName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealTypeName");
    }

    /**
     * @return [就餐时间  24YYMM]属性的操作符
     */
    public AlgebraicVariable<String> mealTime() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealTime");
    }

    /**
     * @return [下单提前小时数]属性的操作符
     */
    public AlgebraicVariable<Integer> orderBefore() {
        return new ObjectTreeAlgebraicVariable<Integer>(Integer.class, getNode(), "orderBefore");
    }

    /**
     * @return [规则描述  例如  晚上8：00前，可点次日早餐]属性的操作符
     */
    public AlgebraicVariable<String> orderRuleDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "orderRuleDesc");
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
    public AlgebraicVariable<String> mealTypeDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealTypeDesc");
    }
}
