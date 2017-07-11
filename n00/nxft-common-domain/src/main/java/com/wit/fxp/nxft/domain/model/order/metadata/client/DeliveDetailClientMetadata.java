package com.wit.fxp.nxft.domain.model.order.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.order.DeliveDetail;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class DeliveDetailClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private DeliveDetailClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public DeliveDetailClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[DeliveDetail]元数据
     */
    public static DeliveDetailClientMetadata<DeliveDetail> root() {
        return new DeliveDetailClientMetadata<DeliveDetail>(DeliveDetail.class);
    }

    /**
     * @return [套餐id]属性名
     */
    public String mealId() {
        return getNode().isRoot()
                ? "mealId"
                : getNode().getPath().toPropertyPath() + ".mealId";
    }

    /**
     * @return [套餐CODE]属性名
     */
    public String mealCode() {
        return getNode().isRoot()
                ? "mealCode"
                : getNode().getPath().toPropertyPath() + ".mealCode";
    }

    /**
     * @return [套餐名称]属性名
     */
    public String mealName() {
        return getNode().isRoot()
                ? "mealName"
                : getNode().getPath().toPropertyPath() + ".mealName";
    }

    /**
     * @return [数量]属性名
     */
    public String quantity() {
        return getNode().isRoot()
                ? "quantity"
                : getNode().getPath().toPropertyPath() + ".quantity";
    }

    /**
     * @return [配送单id]属性名
     */
    public String deliveNoteId() {
        return getNode().isRoot()
                ? "deliveNoteId"
                : getNode().getPath().toPropertyPath() + ".deliveNoteId";
    }
}
