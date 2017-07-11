package com.wit.fxp.nxft.domain.model.dict.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.dict.SubjectAssistance;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class SubjectAssistanceClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private SubjectAssistanceClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public SubjectAssistanceClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[SubjectAssistance]元数据
     */
    public static SubjectAssistanceClientMetadata<SubjectAssistance> root() {
        return new SubjectAssistanceClientMetadata<SubjectAssistance>(SubjectAssistance.class);
    }

    /**
     * @return [客户所属的工作圈id]属性名
     */
    public String circleId() {
        return getNode().isRoot()
                ? "circleId"
                : getNode().getPath().toPropertyPath() + ".circleId";
    }

    /**
     * @return [对象类型ID]属性名
     */
    public String subjectTypeId() {
        return getNode().isRoot()
                ? "subjectTypeId"
                : getNode().getPath().toPropertyPath() + ".subjectTypeId";
    }

    /**
     * @return [餐别类型id]属性名
     */
    public String mealTypeId() {
        return getNode().isRoot()
                ? "mealTypeId"
                : getNode().getPath().toPropertyPath() + ".mealTypeId";
    }

    /**
     * @return [补助模式 RADIO 比例  FEE 金额]属性名
     */
    public String assistanceModel() {
        return getNode().isRoot()
                ? "assistanceModel"
                : getNode().getPath().toPropertyPath() + ".assistanceModel";
    }

    /**
     * @return [补助比例]属性名
     */
    public String assistanceRatio() {
        return getNode().isRoot()
                ? "assistanceRatio"
                : getNode().getPath().toPropertyPath() + ".assistanceRatio";
    }

    /**
     * @return [补助金额]属性名
     */
    public String assistanceFee() {
        return getNode().isRoot()
                ? "assistanceFee"
                : getNode().getPath().toPropertyPath() + ".assistanceFee";
    }

    /**
     * @return [备注]属性名
     */
    public String assistanceDesc() {
        return getNode().isRoot()
                ? "assistanceDesc"
                : getNode().getPath().toPropertyPath() + ".assistanceDesc";
    }
}
