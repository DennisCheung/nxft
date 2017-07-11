package com.wit.fxp.nxft.domain.model.dict.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.dict.SubjectType;

// CHECKSTYLE:OFF

/**
 * 服务端[配餐对象类型字典]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class SubjectTypeMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private SubjectTypeMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public SubjectTypeMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[SubjectType]元数据
     */
    public static SubjectTypeMetadata<SubjectType> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[SubjectType]元数据
     */
    public static SubjectTypeMetadata<SubjectType> root(String rootAlias) {
        return new SubjectTypeMetadata<SubjectType>(SubjectType.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [对象类型CODE]属性的操作符
     */
    public AlgebraicVariable<String> subjectTypeCode() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "subjectTypeCode");
    }

    /**
     * @return [对象类型名称]属性的操作符
     */
    public AlgebraicVariable<String> subjectTypeName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "subjectTypeName");
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
    public AlgebraicVariable<String> subjectTypeDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "subjectTypeDesc");
    }
}
