package com.wit.fxp.nxft.domain.model.order.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.order.DeliveCreateLog;

// CHECKSTYLE:OFF

/**
 * 服务端[配送单生成日志]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class DeliveCreateLogMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private DeliveCreateLogMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public DeliveCreateLogMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[DeliveCreateLog]元数据
     */
    public static DeliveCreateLogMetadata<DeliveCreateLog> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[DeliveCreateLog]元数据
     */
    public static DeliveCreateLogMetadata<DeliveCreateLog> root(String rootAlias) {
        return new DeliveCreateLogMetadata<DeliveCreateLog>(DeliveCreateLog.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [就餐日期]属性的操作符
     */
    public AlgebraicVariable<java.util.Date> mealDate() {
        return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, getNode(), "mealDate");
    }

    /**
     * @return [餐别ID]属性的操作符
     */
    public AlgebraicVariable<String> mealTypeId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealTypeId");
    }

    /**
     * @return [创建时间]属性的操作符
     */
    public AlgebraicVariable<java.util.Date> createTime() {
        return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, getNode(), "createTime");
    }

    /**
     * @return [备注]属性的操作符
     */
    public AlgebraicVariable<String> logDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "logDesc");
    }
}
