package com.wit.fxp.nxft.domain.model.subject.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.subject.NxftSubjectSmsLog;

// CHECKSTYLE:OFF

/**
 * 服务端[暖心饭堂对象短信日志]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class NxftSubjectSmsLogMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private NxftSubjectSmsLogMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public NxftSubjectSmsLogMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[NxftSubjectSmsLog]元数据
     */
    public static NxftSubjectSmsLogMetadata<NxftSubjectSmsLog> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[NxftSubjectSmsLog]元数据
     */
    public static NxftSubjectSmsLogMetadata<NxftSubjectSmsLog> root(String rootAlias) {
        return new NxftSubjectSmsLogMetadata<NxftSubjectSmsLog>(NxftSubjectSmsLog.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [通讯服务商如：云之讯、容联 协同通讯]属性的操作符
     */
    public AlgebraicVariable<String> tspName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "tspName");
    }

    /**
     * @return [监测对象ID]属性的操作符
     */
    public AlgebraicVariable<String> subjectId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "subjectId");
    }

    /**
     * @return [对象姓名]属性的操作符
     */
    public AlgebraicVariable<String> subjectName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "subjectName");
    }

    /**
     * @return [客户所属的工作圈id]属性的操作符
     */
    public AlgebraicVariable<String> circleId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "circleId");
    }

    /**
     * @return [创建时间]属性的操作符
     */
    public AlgebraicVariable<java.util.Date> createTime() {
        return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, getNode(), "createTime");
    }

    /**
     * @return [短信内容]属性的操作符
     */
    public AlgebraicVariable<String> smsContent() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "smsContent");
    }

    /**
     * @return [短信类型  TEXT  文字短信  VOICE  语音短信]属性的操作符
     */
    public AlgebraicVariable<String> smsType() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "smsType");
    }

    /**
     * @return [业务说明,如 坐席订餐、助餐点订餐]属性的操作符
     */
    public AlgebraicVariable<String> smsDesc() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "smsDesc");
    }

    /**
     * @return [客户电话号码]属性的操作符
     */
    public AlgebraicVariable<String> toNumber() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "toNumber");
    }

    /**
     * @return [短信接收人姓名]属性的操作符
     */
    public AlgebraicVariable<String> toName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "toName");
    }

    /**
     * @return [与对象关系name，本人或对象联系人关系]属性的操作符
     */
    public AlgebraicVariable<String> relationName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "relationName");
    }

    /**
     * @return [操作员圈id]属性的操作符
     */
    public AlgebraicVariable<String> userCircleId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "userCircleId");
    }

    /**
     * @return [操作员工作组id]属性的操作符
     */
    public AlgebraicVariable<String> userTeamId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "userTeamId");
    }

    /**
     * @return [操作员id]属性的操作符
     */
    public AlgebraicVariable<String> userUserId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "userUserId");
    }

    /**
     * @return [操作员姓名]属性的操作符
     */
    public AlgebraicVariable<String> userNickname() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "userNickname");
    }
}
