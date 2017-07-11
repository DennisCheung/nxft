package com.wit.fxp.nxft.domain.model.dict.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.dict.SubjectType;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class SubjectTypeClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private SubjectTypeClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public SubjectTypeClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[SubjectType]元数据
     */
    public static SubjectTypeClientMetadata<SubjectType> root() {
        return new SubjectTypeClientMetadata<SubjectType>(SubjectType.class);
    }

    /**
     * @return [对象类型CODE]属性名
     */
    public String subjectTypeCode() {
        return getNode().isRoot()
                ? "subjectTypeCode"
                : getNode().getPath().toPropertyPath() + ".subjectTypeCode";
    }

    /**
     * @return [对象类型名称]属性名
     */
    public String subjectTypeName() {
        return getNode().isRoot()
                ? "subjectTypeName"
                : getNode().getPath().toPropertyPath() + ".subjectTypeName";
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
    public String subjectTypeDesc() {
        return getNode().isRoot()
                ? "subjectTypeDesc"
                : getNode().getPath().toPropertyPath() + ".subjectTypeDesc";
    }
}
