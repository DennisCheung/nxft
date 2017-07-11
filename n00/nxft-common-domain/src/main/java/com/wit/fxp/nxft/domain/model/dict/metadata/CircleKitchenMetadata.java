package com.wit.fxp.nxft.domain.model.dict.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.dict.CircleKitchen;

// CHECKSTYLE:OFF

/**
 * 服务端[工作圈厨房签约]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class CircleKitchenMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private CircleKitchenMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public CircleKitchenMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[CircleKitchen]元数据
     */
    public static CircleKitchenMetadata<CircleKitchen> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[CircleKitchen]元数据
     */
    public static CircleKitchenMetadata<CircleKitchen> root(String rootAlias) {
        return new CircleKitchenMetadata<CircleKitchen>(CircleKitchen.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [所属的工作圈id]属性的操作符
     */
    public AlgebraicVariable<String> circleId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "circleId");
    }

    /**
     * @return [厨房圈id]属性的操作符
     */
    public AlgebraicVariable<String> kitchenCircleId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "kitchenCircleId");
    }

    /**
     * @return [配送费]属性的操作符
     */
    public AlgebraicVariable<Double> deliveFee() {
        return new ObjectTreeAlgebraicVariable<Double>(Double.class, getNode(), "deliveFee");
    }

    /**
     * @return [备注]属性的操作符
     */
    public AlgebraicVariable<String> kitchenDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "kitchenDesc");
    }

    /**
     * @return [厨房teamid]属性的操作符
     */
    public AlgebraicVariable<String> kitchenTeamId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "kitchenTeamId");
    }
}
