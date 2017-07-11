package com.wit.fxp.nxft.domain.model.dict.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.dict.FoodLove;

// CHECKSTYLE:OFF

/**
 * 服务端[饮食偏好]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class FoodLoveMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private FoodLoveMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public FoodLoveMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[FoodLove]元数据
     */
    public static FoodLoveMetadata<FoodLove> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[FoodLove]元数据
     */
    public static FoodLoveMetadata<FoodLove> root(String rootAlias) {
        return new FoodLoveMetadata<FoodLove>(FoodLove.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [饮食偏好代码]属性的操作符
     */
    public AlgebraicVariable<String> foodLoveCode() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "foodLoveCode");
    }

    /**
     * @return [饮食偏好名称]属性的操作符
     */
    public AlgebraicVariable<String> foodLoveName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "foodLoveName");
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
    public AlgebraicVariable<String> foodLoveDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "foodLoveDesc");
    }
}
