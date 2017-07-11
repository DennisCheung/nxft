package com.wit.fxp.nxft.domain.model.dict.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.dict.FoodProhibit;

// CHECKSTYLE:OFF

/**
 * 服务端[食物禁忌]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class FoodProhibitMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private FoodProhibitMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public FoodProhibitMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[FoodProhibit]元数据
     */
    public static FoodProhibitMetadata<FoodProhibit> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[FoodProhibit]元数据
     */
    public static FoodProhibitMetadata<FoodProhibit> root(String rootAlias) {
        return new FoodProhibitMetadata<FoodProhibit>(FoodProhibit.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [食物禁忌代码]属性的操作符
     */
    public AlgebraicVariable<String> foodProhibitCode() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "foodProhibitCode");
    }

    /**
     * @return [食物禁忌名称]属性的操作符
     */
    public AlgebraicVariable<String> foodProhibitName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "foodProhibitName");
    }

    /**
     * @return [是否是其他项 Y/N  其他项需手工输入备注]属性的操作符
     */
    public AlgebraicVariable<Boolean> isother() {
        return new ObjectTreeAlgebraicVariable<Boolean>(Boolean.class, getNode(), "isother");
    }

    /**
     * @return [备注]属性的操作符
     */
    public AlgebraicVariable<String> foodProhibitDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "foodProhibitDesc");
    }
}
