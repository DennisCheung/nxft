package com.wit.fxp.nxft.domain.model.dict.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.dict.FoodLove;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class FoodLoveClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private FoodLoveClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public FoodLoveClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[FoodLove]元数据
     */
    public static FoodLoveClientMetadata<FoodLove> root() {
        return new FoodLoveClientMetadata<FoodLove>(FoodLove.class);
    }

    /**
     * @return [饮食偏好代码]属性名
     */
    public String foodLoveCode() {
        return getNode().isRoot()
                ? "foodLoveCode"
                : getNode().getPath().toPropertyPath() + ".foodLoveCode";
    }

    /**
     * @return [饮食偏好名称]属性名
     */
    public String foodLoveName() {
        return getNode().isRoot()
                ? "foodLoveName"
                : getNode().getPath().toPropertyPath() + ".foodLoveName";
    }

    /**
     * @return [是否是其他项 Y/N  其他项需手工输入备注]属性名
     */
    public String isother() {
        return getNode().isRoot()
                ? "isother"
                : getNode().getPath().toPropertyPath() + ".isother";
    }

    /**
     * @return [备注]属性名
     */
    public String foodLoveDesc() {
        return getNode().isRoot()
                ? "foodLoveDesc"
                : getNode().getPath().toPropertyPath() + ".foodLoveDesc";
    }
}
