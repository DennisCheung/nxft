package com.wit.fxp.nxft.domain.model.sis.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.sis.SisServiceResource;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class SisServiceResourceClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private SisServiceResourceClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public SisServiceResourceClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[SisServiceResource]元数据
     */
    public static SisServiceResourceClientMetadata<SisServiceResource> root() {
        return new SisServiceResourceClientMetadata<SisServiceResource>(SisServiceResource.class);
    }

    /**
     * @return [工作圈id]属性名
     */
    public String circleId() {
        return getNode().isRoot()
                ? "circleId"
                : getNode().getPath().toPropertyPath() + ".circleId";
    }

    /**
     * @return [统计指标ID(常量)]属性名
     */
    public String indicatorId() {
        return getNode().isRoot()
                ? "indicatorId"
                : getNode().getPath().toPropertyPath() + ".indicatorId";
    }

    /**
     * @return [统计指标名称]属性名
     */
    public String indicatorName() {
        return getNode().isRoot()
                ? "indicatorName"
                : getNode().getPath().toPropertyPath() + ".indicatorName";
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
     * @return [备注]属性名
     */
    public String dataDesc() {
        return getNode().isRoot()
                ? "dataDesc"
                : getNode().getPath().toPropertyPath() + ".dataDesc";
    }
}
