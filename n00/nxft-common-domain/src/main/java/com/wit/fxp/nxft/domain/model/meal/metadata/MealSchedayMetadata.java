package com.wit.fxp.nxft.domain.model.meal.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.meal.MealScheday;

// CHECKSTYLE:OFF

/**
 * 服务端[每天菜谱]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class MealSchedayMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private MealSchedayMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public MealSchedayMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[MealScheday]元数据
     */
    public static MealSchedayMetadata<MealScheday> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[MealScheday]元数据
     */
    public static MealSchedayMetadata<MealScheday> root(String rootAlias) {
        return new MealSchedayMetadata<MealScheday>(MealScheday.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [厨房工作圈id]属性的操作符
     */
    public AlgebraicVariable<String> kitchenCircleId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "kitchenCircleId");
    }

    /**
     * @return [厨房teamid]属性的操作符
     */
    public AlgebraicVariable<String> kitchenTeamId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "kitchenTeamId");
    }

    /**
     * @return [排班单id]属性的操作符
     */
    public AlgebraicVariable<String> schenoteId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "schenoteId");
    }

    /**
     * @return [就餐日期]属性的操作符
     */
    public AlgebraicVariable<java.util.Date> mealDate() {
        return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, getNode(), "mealDate");
    }

    /**
     * @return [周几]属性的操作符
     */
    public AlgebraicVariable<Integer> week() {
        return new ObjectTreeAlgebraicVariable<Integer>(Integer.class, getNode(), "week");
    }

    /**
     * @return [餐别ID]属性的操作符
     */
    public AlgebraicVariable<String> mealTypeId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealTypeId");
    }

    /**
     * @return [餐别名称]属性的操作符
     */
    public AlgebraicVariable<String> mealTypeName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealTypeName");
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
     * @return [套餐内容]属性的操作符
     */
    public AlgebraicVariable<String> mealContent() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "mealContent");
    }

    /**
     * @return [单价]属性的操作符
     */
    public AlgebraicVariable<Double> mealPrice() {
        return new ObjectTreeAlgebraicVariable<Double>(Double.class, getNode(), "mealPrice");
    }

    /**
     * @return [备注]属性的操作符
     */
    public AlgebraicVariable<String> scheduleDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "scheduleDesc");
    }

    /**
     * @return [是否已发布？ Y/N]属性的操作符
     */
    public AlgebraicVariable<Boolean> isPublished() {
        return new ObjectTreeAlgebraicVariable<Boolean>(Boolean.class, getNode(), "isPublished");
    }
}
