package com.wit.fxp.nxft.domain.model.subject.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.subject.NxftSubjectLivingCondi;

// CHECKSTYLE:OFF

/**
 * 服务端[配餐对象居住情况]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class NxftSubjectLivingCondiMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private NxftSubjectLivingCondiMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public NxftSubjectLivingCondiMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[NxftSubjectLivingCondi]元数据
     */
    public static NxftSubjectLivingCondiMetadata<NxftSubjectLivingCondi> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[NxftSubjectLivingCondi]元数据
     */
    public static NxftSubjectLivingCondiMetadata<NxftSubjectLivingCondi> root(String rootAlias) {
        return new NxftSubjectLivingCondiMetadata<NxftSubjectLivingCondi>(NxftSubjectLivingCondi.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [居住情况ID]属性的操作符
     */
    public AlgebraicVariable<String> livingCondiId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "livingCondiId");
    }

    /**
     * @return [居住情况名称]属性的操作符
     */
    public AlgebraicVariable<String> livingCondiName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "livingCondiName");
    }

    /**
     * @return [是否是其他项 Y/N  其他项需手工输入备注]属性的操作符
     */
    public AlgebraicVariable<Boolean> isother() {
        return new ObjectTreeAlgebraicVariable<Boolean>(Boolean.class, getNode(), "isother");
    }

    /**
     * @return [对象id]属性的操作符
     */
    public AlgebraicVariable<String> subjectId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "subjectId");
    }

    /**
     * @return [备注]属性的操作符
     */
    public AlgebraicVariable<String> livingCondiDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "livingCondiDesc");
    }
}
