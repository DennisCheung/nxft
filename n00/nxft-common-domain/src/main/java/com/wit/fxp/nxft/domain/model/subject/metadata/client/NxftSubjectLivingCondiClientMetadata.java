package com.wit.fxp.nxft.domain.model.subject.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.subject.NxftSubjectLivingCondi;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class NxftSubjectLivingCondiClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private NxftSubjectLivingCondiClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public NxftSubjectLivingCondiClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[NxftSubjectLivingCondi]元数据
     */
    public static NxftSubjectLivingCondiClientMetadata<NxftSubjectLivingCondi> root() {
        return new NxftSubjectLivingCondiClientMetadata<NxftSubjectLivingCondi>(NxftSubjectLivingCondi.class);
    }

    /**
     * @return [居住情况ID]属性名
     */
    public String livingCondiId() {
        return getNode().isRoot()
                ? "livingCondiId"
                : getNode().getPath().toPropertyPath() + ".livingCondiId";
    }

    /**
     * @return [居住情况名称]属性名
     */
    public String livingCondiName() {
        return getNode().isRoot()
                ? "livingCondiName"
                : getNode().getPath().toPropertyPath() + ".livingCondiName";
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
     * @return [对象id]属性名
     */
    public String subjectId() {
        return getNode().isRoot()
                ? "subjectId"
                : getNode().getPath().toPropertyPath() + ".subjectId";
    }

    /**
     * @return [备注]属性名
     */
    public String livingCondiDesc() {
        return getNode().isRoot()
                ? "livingCondiDesc"
                : getNode().getPath().toPropertyPath() + ".livingCondiDesc";
    }
}
