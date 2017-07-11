package com.wit.fxp.nxft.domain.model.subject.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.subject.NxftSubjectSmsLog;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class NxftSubjectSmsLogClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private NxftSubjectSmsLogClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public NxftSubjectSmsLogClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[NxftSubjectSmsLog]元数据
     */
    public static NxftSubjectSmsLogClientMetadata<NxftSubjectSmsLog> root() {
        return new NxftSubjectSmsLogClientMetadata<NxftSubjectSmsLog>(NxftSubjectSmsLog.class);
    }

    /**
     * @return [通讯服务商如：云之讯、容联 协同通讯]属性名
     */
    public String tspName() {
        return getNode().isRoot()
                ? "tspName"
                : getNode().getPath().toPropertyPath() + ".tspName";
    }

    /**
     * @return [监测对象ID]属性名
     */
    public String subjectId() {
        return getNode().isRoot()
                ? "subjectId"
                : getNode().getPath().toPropertyPath() + ".subjectId";
    }

    /**
     * @return [对象姓名]属性名
     */
    public String subjectName() {
        return getNode().isRoot()
                ? "subjectName"
                : getNode().getPath().toPropertyPath() + ".subjectName";
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
     * @return [创建时间]属性名
     */
    public String createTime() {
        return getNode().isRoot()
                ? "createTime"
                : getNode().getPath().toPropertyPath() + ".createTime";
    }

    /**
     * @return [短信内容]属性名
     */
    public String smsContent() {
        return getNode().isRoot()
                ? "smsContent"
                : getNode().getPath().toPropertyPath() + ".smsContent";
    }

    /**
     * @return [短信类型  TEXT  文字短信  VOICE  语音短信]属性名
     */
    public String smsType() {
        return getNode().isRoot()
                ? "smsType"
                : getNode().getPath().toPropertyPath() + ".smsType";
    }

    /**
     * @return [业务说明,如 坐席订餐、助餐点订餐]属性名
     */
    public String smsDesc() {
        return getNode().isRoot()
                ? "smsDesc"
                : getNode().getPath().toPropertyPath() + ".smsDesc";
    }

    /**
     * @return [客户电话号码]属性名
     */
    public String toNumber() {
        return getNode().isRoot()
                ? "toNumber"
                : getNode().getPath().toPropertyPath() + ".toNumber";
    }

    /**
     * @return [短信接收人姓名]属性名
     */
    public String toName() {
        return getNode().isRoot()
                ? "toName"
                : getNode().getPath().toPropertyPath() + ".toName";
    }

    /**
     * @return [与对象关系name，本人或对象联系人关系]属性名
     */
    public String relationName() {
        return getNode().isRoot()
                ? "relationName"
                : getNode().getPath().toPropertyPath() + ".relationName";
    }

    /**
     * @return [操作员圈id]属性名
     */
    public String userCircleId() {
        return getNode().isRoot()
                ? "userCircleId"
                : getNode().getPath().toPropertyPath() + ".userCircleId";
    }

    /**
     * @return [操作员工作组id]属性名
     */
    public String userTeamId() {
        return getNode().isRoot()
                ? "userTeamId"
                : getNode().getPath().toPropertyPath() + ".userTeamId";
    }

    /**
     * @return [操作员id]属性名
     */
    public String userUserId() {
        return getNode().isRoot()
                ? "userUserId"
                : getNode().getPath().toPropertyPath() + ".userUserId";
    }

    /**
     * @return [操作员姓名]属性名
     */
    public String userNickname() {
        return getNode().isRoot()
                ? "userNickname"
                : getNode().getPath().toPropertyPath() + ".userNickname";
    }
}
