package com.wit.fxp.nxft.domain.model.order.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.order.DeliveDetail;

// CHECKSTYLE:OFF

/**
 * 服务端[配送单明细]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class DeliveDetailMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private DeliveDetailMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public DeliveDetailMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[DeliveDetail]元数据
     */
    public static DeliveDetailMetadata<DeliveDetail> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[DeliveDetail]元数据
     */
    public static DeliveDetailMetadata<DeliveDetail> root(String rootAlias) {
        return new DeliveDetailMetadata<DeliveDetail>(DeliveDetail.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [套餐id]属性的操作符
     */
    public AlgebraicVariable<String> mealId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealId");
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
     * @return [数量]属性的操作符
     */
    public AlgebraicVariable<Integer> quantity() {
        return new ObjectTreeAlgebraicVariable<Integer>(Integer.class, getNode(), "quantity");
    }

    /**
     * @return [配送单id]属性的操作符
     */
    public AlgebraicVariable<String> deliveNoteId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "deliveNoteId");
    }
}
