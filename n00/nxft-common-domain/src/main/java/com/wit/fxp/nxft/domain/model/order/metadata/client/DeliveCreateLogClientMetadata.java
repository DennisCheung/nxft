package com.wit.fxp.nxft.domain.model.order.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.order.DeliveCreateLog;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class DeliveCreateLogClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private DeliveCreateLogClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public DeliveCreateLogClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[DeliveCreateLog]元数据
     */
    public static DeliveCreateLogClientMetadata<DeliveCreateLog> root() {
        return new DeliveCreateLogClientMetadata<DeliveCreateLog>(DeliveCreateLog.class);
    }

    /**
     * @return [就餐日期]属性名
     */
    public String mealDate() {
        return getNode().isRoot()
                ? "mealDate"
                : getNode().getPath().toPropertyPath() + ".mealDate";
    }

    /**
     * @return [餐别ID]属性名
     */
    public String mealTypeId() {
        return getNode().isRoot()
                ? "mealTypeId"
                : getNode().getPath().toPropertyPath() + ".mealTypeId";
    }

    /**
     * @return [创建时间]属性名
     */
    public String createTime() {
        return getNode().isRoot()
                ? "createTime"
                : getNode().getPath().toPropertyPath() + ".createTime";
    }

    /**
     * @return [备注]属性名
     */
    public String logDesc() {
        return getNode().isRoot()
                ? "logDesc"
                : getNode().getPath().toPropertyPath() + ".logDesc";
    }
}
