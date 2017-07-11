package com.wit.fxp.nxft.domain.model.sis.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.sis.SisServiceResource;

// CHECKSTYLE:OFF

/**
 * 服务端[配餐服务资源]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class SisServiceResourceMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private SisServiceResourceMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public SisServiceResourceMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[SisServiceResource]元数据
     */
    public static SisServiceResourceMetadata<SisServiceResource> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[SisServiceResource]元数据
     */
    public static SisServiceResourceMetadata<SisServiceResource> root(String rootAlias) {
        return new SisServiceResourceMetadata<SisServiceResource>(SisServiceResource.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [工作圈id]属性的操作符
     */
    public AlgebraicVariable<String> circleId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "circleId");
    }

    /**
     * @return [统计指标ID(常量)]属性的操作符
     */
    public AlgebraicVariable<String> indicatorId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "indicatorId");
    }

    /**
     * @return [统计指标名称]属性的操作符
     */
    public AlgebraicVariable<String> indicatorName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "indicatorName");
    }

    /**
     * @return [数量]属性的操作符
     */
    public AlgebraicVariable<Integer> quantity() {
        return new ObjectTreeAlgebraicVariable<Integer>(Integer.class, getNode(), "quantity");
    }

    /**
     * @return [备注]属性的操作符
     */
    public AlgebraicVariable<String> dataDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "dataDesc");
    }
}
