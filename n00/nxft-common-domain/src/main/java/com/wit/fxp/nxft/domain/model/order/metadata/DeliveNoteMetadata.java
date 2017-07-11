package com.wit.fxp.nxft.domain.model.order.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.order.DeliveNote;

// CHECKSTYLE:OFF

/**
 * 服务端[配送单]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class DeliveNoteMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private DeliveNoteMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public DeliveNoteMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[DeliveNote]元数据
     */
    public static DeliveNoteMetadata<DeliveNote> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[DeliveNote]元数据
     */
    public static DeliveNoteMetadata<DeliveNote> root(String rootAlias) {
        return new DeliveNoteMetadata<DeliveNote>(DeliveNote.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /** @return [配送信息]属性的操作符 */
    public DeliveInfoMetadata<T> deliveInfo() {
        return new DeliveInfoMetadata<T>(getNode());
    }

    /** @return [创建信息]属性的操作符 */
    public CreateInfoMetadata<T> createInfo() {
        return new CreateInfoMetadata<T>(getNode());
    }

    /** @return [上次状态]属性的操作符 */
    public LastStateMetadata<T> lastState() {
        return new LastStateMetadata<T>(getNode());
    }

    /** @return [下一环节]属性的操作符 */
    public NextNodeMetadata<T> nextNode() {
        return new NextNodeMetadata<T>(getNode());
    }

    /** @return [完成情况]属性的操作符 */
    public CompleteInfoMetadata<T> completeInfo() {
        return new CompleteInfoMetadata<T>(getNode());
    }

    /**
     * 内连接、延迟加载
     *
     * @return [配送详情]的元数据
     */
    public com.wit.fxp.nxft.domain.model.order.metadata.DeliveDetailMetadata<T> deliveDetailSet() {
        return inner_join_deliveDetailSet();
    }

    /**
     * 内连接、延迟加载
     *
     * @return [配送详情]的元数据
     */
    public com.wit.fxp.nxft.domain.model.order.metadata.DeliveDetailMetadata<T> inner_join_deliveDetailSet() {
        return inner_join_deliveDetailSet("", true);
    }

    /**
     * 内连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [配送详情]的元数据
     */
    public com.wit.fxp.nxft.domain.model.order.metadata.DeliveDetailMetadata<T> inner_join_deliveDetailSet(String alias, boolean lazyLoad) {
        return deliveDetailSet(alias, com.benewit.ecctree.EccNodeConstant.INNER_JOIN, lazyLoad);
    }

    /**
     * 左外连接、延迟加载
     *
     * @return [配送详情]的元数据
     */
    public com.wit.fxp.nxft.domain.model.order.metadata.DeliveDetailMetadata<T> left_outer_join_deliveDetailSet() {
        return left_outer_join_deliveDetailSet("", true);
    }

    /**
     * 左外连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [配送详情]的元数据
     */
    public com.wit.fxp.nxft.domain.model.order.metadata.DeliveDetailMetadata<T> left_outer_join_deliveDetailSet(String alias, boolean lazyLoad) {
        return deliveDetailSet(alias, com.benewit.ecctree.EccNodeConstant.LEFT_OUTER_JOIN, lazyLoad);
    }

    /**
     * @param join 连接方式
     * @param lazyLoad 是否延迟加载？
     * @return [配送详情]的元数据
     */
    private com.wit.fxp.nxft.domain.model.order.metadata.DeliveDetailMetadata<T> deliveDetailSet(String alias, String join, boolean lazyLoad) {
        String segment = getNode().getTree().getSegmentParser().formatSegment("deliveDetailSet", alias, join, !lazyLoad);
        getNode().addPath(segment);

        return new com.wit.fxp.nxft.domain.model.order.metadata.DeliveDetailMetadata<T>(getNode().getChild("deliveDetailSet"));
    }

    /**
     * 内连接、延迟加载
     *
     * @return [订单]的元数据
     */
    public com.wit.fxp.nxft.domain.model.order.metadata.NxftOrderMetadata<T> nxftOrderSet() {
        return inner_join_nxftOrderSet();
    }

    /**
     * 内连接、延迟加载
     *
     * @return [订单]的元数据
     */
    public com.wit.fxp.nxft.domain.model.order.metadata.NxftOrderMetadata<T> inner_join_nxftOrderSet() {
        return inner_join_nxftOrderSet("", true);
    }

    /**
     * 内连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [订单]的元数据
     */
    public com.wit.fxp.nxft.domain.model.order.metadata.NxftOrderMetadata<T> inner_join_nxftOrderSet(String alias, boolean lazyLoad) {
        return nxftOrderSet(alias, com.benewit.ecctree.EccNodeConstant.INNER_JOIN, lazyLoad);
    }

    /**
     * 左外连接、延迟加载
     *
     * @return [订单]的元数据
     */
    public com.wit.fxp.nxft.domain.model.order.metadata.NxftOrderMetadata<T> left_outer_join_nxftOrderSet() {
        return left_outer_join_nxftOrderSet("", true);
    }

    /**
     * 左外连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [订单]的元数据
     */
    public com.wit.fxp.nxft.domain.model.order.metadata.NxftOrderMetadata<T> left_outer_join_nxftOrderSet(String alias, boolean lazyLoad) {
        return nxftOrderSet(alias, com.benewit.ecctree.EccNodeConstant.LEFT_OUTER_JOIN, lazyLoad);
    }

    /**
     * @param join 连接方式
     * @param lazyLoad 是否延迟加载？
     * @return [订单]的元数据
     */
    private com.wit.fxp.nxft.domain.model.order.metadata.NxftOrderMetadata<T> nxftOrderSet(String alias, String join, boolean lazyLoad) {
        String segment = getNode().getTree().getSegmentParser().formatSegment("nxftOrderSet", alias, join, !lazyLoad);
        getNode().addPath(segment);

        return new com.wit.fxp.nxft.domain.model.order.metadata.NxftOrderMetadata<T>(getNode().getChild("nxftOrderSet"));
    }

    /**
     * {@link DeliveNote#getDeliveInfo() DeliveNote.deliveInfo}的元数据。
     */
    public class DeliveInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<DeliveNote.DeliveInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link DeliveInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public DeliveInfoMetadata(ObjectNode<C> node) {
            super(DeliveNote.DeliveInfo.class, node, "deliveInfo");

            node.addPath("deliveInfo");
            this.node = node.getChild("deliveInfo");
        }

        /** @return [客户所属的工作圈id]属性的操作符 */
        public AlgebraicVariable<String> circleId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "circleId");
        }

        /** @return [配送方式  助餐点 SITE  到户上门  HOME]属性的操作符 */
        public AlgebraicVariable<String> deliveType() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "deliveType");
        }

        /** @return [配送地点id]属性的操作符 */
        public AlgebraicVariable<String> deliveSiteId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "deliveSiteId");
        }

        /** @return [配送地点名称  当 fdelive_type = HOME 填 faddress]属性的操作符 */
        public AlgebraicVariable<String> deliveSiteName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "deliveSiteName");
        }

        /** @return [厨房圈id]属性的操作符 */
        public AlgebraicVariable<String> kitchenCircleId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "kitchenCircleId");
        }

        /** @return [厨房teamid]属性的操作符 */
        public AlgebraicVariable<String> kitchenTeamId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "kitchenTeamId");
        }

        /** @return [就餐日期]属性的操作符 */
        public AlgebraicVariable<java.util.Date> mealDate() {
            return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, node, "mealDate");
        }

        /** @return [周几]属性的操作符 */
        public AlgebraicVariable<Integer> week() {
            return new ObjectTreeAlgebraicVariable<Integer>(Integer.class, node, "week");
        }

        /** @return [餐别ID]属性的操作符 */
        public AlgebraicVariable<String> mealTypeId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "mealTypeId");
        }

        /** @return [餐别名称]属性的操作符 */
        public AlgebraicVariable<String> mealTypeName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "mealTypeName");
        }

        /** @return [数量]属性的操作符 */
        public AlgebraicVariable<Integer> quantity() {
            return new ObjectTreeAlgebraicVariable<Integer>(Integer.class, node, "quantity");
        }

        /** @return [数量描述]属性的操作符 */
        public AlgebraicVariable<String> quantityDesc() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "quantityDesc");
        }

        /** @return [配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name]属性的操作符 */
        public AlgebraicVariable<String> deliveAddr() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "deliveAddr");
        }

        /** @return [联系人]属性的操作符 */
        public AlgebraicVariable<String> contactPerson() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "contactPerson");
        }

        /** @return [联系手机]属性的操作符 */
        public AlgebraicVariable<String> contactMobile() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "contactMobile");
        }

    }    // DeliveInfoMetadata

    /**
     * {@link DeliveNote#getCreateInfo() DeliveNote.createInfo}的元数据。
     */
    public class CreateInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<DeliveNote.CreateInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link CreateInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public CreateInfoMetadata(ObjectNode<C> node) {
            super(DeliveNote.CreateInfo.class, node, "createInfo");

            node.addPath("createInfo");
            this.node = node.getChild("createInfo");
        }

        /** @return [创建时间]属性的操作符 */
        public AlgebraicVariable<java.util.Date> createTime() {
            return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, node, "createTime");
        }

        /** @return [创建操作员id]属性的操作符 */
        public AlgebraicVariable<String> createUserId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "createUserId");
        }

        /** @return [创建操作员姓名]属性的操作符 */
        public AlgebraicVariable<String> createUserName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "createUserName");
        }

    }    // CreateInfoMetadata

    /**
     * {@link DeliveNote#getLastState() DeliveNote.lastState}的元数据。
     */
    public class LastStateMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<DeliveNote.LastState> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link LastStateMetadata}对象。
         *
         * @param node 所属节点
         */
        public LastStateMetadata(ObjectNode<C> node) {
            super(DeliveNote.LastState.class, node, "lastState");

            node.addPath("lastState");
            this.node = node.getChild("lastState");
        }

        /** @return [最后状态，完成时ID]属性的操作符 */
        public AlgebraicVariable<String> lastState() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "lastState");
        }

        /** @return [最新完成时间]属性的操作符 */
        public AlgebraicVariable<java.util.Date> lastTime() {
            return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, node, "lastTime");
        }

        /** @return [最新完成操作员id]属性的操作符 */
        public AlgebraicVariable<String> lastUserId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "lastUserId");
        }

        /** @return [最新完成操作员name]属性的操作符 */
        public AlgebraicVariable<String> lastNickname() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "lastNickname");
        }

        /** @return [流程备注，如为退单，填退单原因。]属性的操作符 */
        public AlgebraicVariable<String> lastDesc() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "lastDesc");
        }

    }    // LastStateMetadata

    /**
     * {@link DeliveNote#getNextNode() DeliveNote.nextNode}的元数据。
     */
    public class NextNodeMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<DeliveNote.NextNode> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link NextNodeMetadata}对象。
         *
         * @param node 所属节点
         */
        public NextNodeMetadata(ObjectNode<C> node) {
            super(DeliveNote.NextNode.class, node, "nextNode");

            node.addPath("nextNode");
            this.node = node.getChild("nextNode");
        }

        /** @return [下一环节 常量，和环节状态、备注同时更新]属性的操作符 */
        public AlgebraicVariable<String> nextNodeId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "nextNodeId");
        }

        /** @return [下一环节工作内容]属性的操作符 */
        public AlgebraicVariable<String> nextNodeContent() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "nextNodeContent");
        }

    }    // NextNodeMetadata

    /**
     * {@link DeliveNote#getCompleteInfo() DeliveNote.completeInfo}的元数据。
     */
    public class CompleteInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<DeliveNote.CompleteInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link CompleteInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public CompleteInfoMetadata(ObjectNode<C> node) {
            super(DeliveNote.CompleteInfo.class, node, "completeInfo");

            node.addPath("completeInfo");
            this.node = node.getChild("completeInfo");
        }

        /** @return [是否已完成？  Y/N]属性的操作符 */
        public AlgebraicVariable<Boolean> isComplete() {
            return new ObjectTreeAlgebraicVariable<Boolean>(Boolean.class, node, "isComplete");
        }

        /** @return [完成状态  SUCCESS  成功  FAIL 失败（取消）]属性的操作符 */
        public AlgebraicVariable<String> completeState() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "completeState");
        }

        /** @return [失败原因名称  常量  客户取消、改派]属性的操作符 */
        public AlgebraicVariable<String> failReasonName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "failReasonName");
        }

        /** @return [完成时间]属性的操作符 */
        public AlgebraicVariable<java.util.Date> completeTime() {
            return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, node, "completeTime");
        }

        /** @return [完成操作员工号id]属性的操作符 */
        public AlgebraicVariable<String> completeUserId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "completeUserId");
        }

        /** @return [完成操作员姓名]属性的操作符 */
        public AlgebraicVariable<String> completeNickname() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "completeNickname");
        }

        /** @return [完成备注]属性的操作符 */
        public AlgebraicVariable<String> completeDesc() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "completeDesc");
        }

    }    // CompleteInfoMetadata
}
