package com.wit.fxp.nxft.domain.model.dict.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.dict.SubjectAssistance;

// CHECKSTYLE:OFF

/**
 * 服务端[配餐对象补贴标准设置]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class SubjectAssistanceMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private SubjectAssistanceMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public SubjectAssistanceMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[SubjectAssistance]元数据
     */
    public static SubjectAssistanceMetadata<SubjectAssistance> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[SubjectAssistance]元数据
     */
    public static SubjectAssistanceMetadata<SubjectAssistance> root(String rootAlias) {
        return new SubjectAssistanceMetadata<SubjectAssistance>(SubjectAssistance.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [客户所属的工作圈id]属性的操作符
     */
    public AlgebraicVariable<String> circleId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "circleId");
    }

    /**
     * @return [对象类型ID]属性的操作符
     */
    public AlgebraicVariable<String> subjectTypeId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "subjectTypeId");
    }

    /**
     * @return [餐别类型id]属性的操作符
     */
    public AlgebraicVariable<String> mealTypeId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealTypeId");
    }

    /**
     * @return [补助模式 RADIO 比例  FEE 金额]属性的操作符
     */
    public AlgebraicVariable<String> assistanceModel() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "assistanceModel");
    }

    /**
     * @return [补助比例]属性的操作符
     */
    public AlgebraicVariable<Double> assistanceRatio() {
        return new ObjectTreeAlgebraicVariable<Double>(Double.class, getNode(), "assistanceRatio");
    }

    /**
     * @return [补助金额]属性的操作符
     */
    public AlgebraicVariable<Double> assistanceFee() {
        return new ObjectTreeAlgebraicVariable<Double>(Double.class, getNode(), "assistanceFee");
    }

    /**
     * @return [备注]属性的操作符
     */
    public AlgebraicVariable<String> assistanceDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "assistanceDesc");
    }
}
