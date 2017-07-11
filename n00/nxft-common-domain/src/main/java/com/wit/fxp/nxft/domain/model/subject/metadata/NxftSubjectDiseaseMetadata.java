package com.wit.fxp.nxft.domain.model.subject.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.subject.NxftSubjectDisease;

// CHECKSTYLE:OFF

/**
 * 服务端[配餐对象疾病]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class NxftSubjectDiseaseMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private NxftSubjectDiseaseMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public NxftSubjectDiseaseMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[NxftSubjectDisease]元数据
     */
    public static NxftSubjectDiseaseMetadata<NxftSubjectDisease> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[NxftSubjectDisease]元数据
     */
    public static NxftSubjectDiseaseMetadata<NxftSubjectDisease> root(String rootAlias) {
        return new NxftSubjectDiseaseMetadata<NxftSubjectDisease>(NxftSubjectDisease.class, rootAlias);
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
     * @return [对象id]属性的操作符
     */
    public AlgebraicVariable<String> subjectId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "subjectId");
    }

    /**
     * @return [备注]属性的操作符
     */
    public AlgebraicVariable<String> diseaseDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "diseaseDesc");
    }
}
