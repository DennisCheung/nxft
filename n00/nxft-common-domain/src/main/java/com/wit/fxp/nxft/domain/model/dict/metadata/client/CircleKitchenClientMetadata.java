package com.wit.fxp.nxft.domain.model.dict.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.dict.CircleKitchen;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class CircleKitchenClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private CircleKitchenClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public CircleKitchenClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[CircleKitchen]元数据
     */
    public static CircleKitchenClientMetadata<CircleKitchen> root() {
        return new CircleKitchenClientMetadata<CircleKitchen>(CircleKitchen.class);
    }

    /**
     * @return [所属的工作圈id]属性名
     */
    public String circleId() {
        return getNode().isRoot()
                ? "circleId"
                : getNode().getPath().toPropertyPath() + ".circleId";
    }

    /**
     * @return [厨房圈id]属性名
     */
    public String kitchenCircleId() {
        return getNode().isRoot()
                ? "kitchenCircleId"
                : getNode().getPath().toPropertyPath() + ".kitchenCircleId";
    }

    /**
     * @return [配送费]属性名
     */
    public String deliveFee() {
        return getNode().isRoot()
                ? "deliveFee"
                : getNode().getPath().toPropertyPath() + ".deliveFee";
    }

    /**
     * @return [备注]属性名
     */
    public String kitchenDesc() {
        return getNode().isRoot()
                ? "kitchenDesc"
                : getNode().getPath().toPropertyPath() + ".kitchenDesc";
    }

    /**
     * @return [厨房teamid]属性名
     */
    public String kitchenTeamId() {
        return getNode().isRoot()
                ? "kitchenTeamId"
                : getNode().getPath().toPropertyPath() + ".kitchenTeamId";
    }
}
