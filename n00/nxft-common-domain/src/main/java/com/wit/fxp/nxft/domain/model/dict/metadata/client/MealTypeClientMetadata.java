package com.wit.fxp.nxft.domain.model.dict.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.dict.MealType;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class MealTypeClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private MealTypeClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public MealTypeClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[MealType]元数据
     */
    public static MealTypeClientMetadata<MealType> root() {
        return new MealTypeClientMetadata<MealType>(MealType.class);
    }

    /**
     * @return [餐别类型名称]属性名
     */
    public String mealTypeName() {
        return getNode().isRoot()
                ? "mealTypeName"
                : getNode().getPath().toPropertyPath() + ".mealTypeName";
    }

    /**
     * @return [就餐时间  24YYMM]属性名
     */
    public String mealTime() {
        return getNode().isRoot()
                ? "mealTime"
                : getNode().getPath().toPropertyPath() + ".mealTime";
    }

    /**
     * @return [下单提前小时数]属性名
     */
    public String orderBefore() {
        return getNode().isRoot()
                ? "orderBefore"
                : getNode().getPath().toPropertyPath() + ".orderBefore";
    }

    /**
     * @return [规则描述  例如  晚上8：00前，可点次日早餐]属性名
     */
    public String orderRuleDesc() {
        return getNode().isRoot()
                ? "orderRuleDesc"
                : getNode().getPath().toPropertyPath() + ".orderRuleDesc";
    }

    /**
     * @return [是否可用？]属性名
     */
    public String available() {
        return getNode().isRoot()
                ? "available"
                : getNode().getPath().toPropertyPath() + ".available";
    }

    /**
     * @return [备注]属性名
     */
    public String mealTypeDesc() {
        return getNode().isRoot()
                ? "mealTypeDesc"
                : getNode().getPath().toPropertyPath() + ".mealTypeDesc";
    }
}
