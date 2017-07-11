package com.wit.fxp.nxft.domain.model.dict.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.dict.FoodProhibit;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class FoodProhibitClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private FoodProhibitClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public FoodProhibitClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[FoodProhibit]元数据
     */
    public static FoodProhibitClientMetadata<FoodProhibit> root() {
        return new FoodProhibitClientMetadata<FoodProhibit>(FoodProhibit.class);
    }

    /**
     * @return [食物禁忌代码]属性名
     */
    public String foodProhibitCode() {
        return getNode().isRoot()
                ? "foodProhibitCode"
                : getNode().getPath().toPropertyPath() + ".foodProhibitCode";
    }

    /**
     * @return [食物禁忌名称]属性名
     */
    public String foodProhibitName() {
        return getNode().isRoot()
                ? "foodProhibitName"
                : getNode().getPath().toPropertyPath() + ".foodProhibitName";
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
    public String foodProhibitDesc() {
        return getNode().isRoot()
                ? "foodProhibitDesc"
                : getNode().getPath().toPropertyPath() + ".foodProhibitDesc";
    }
}
