package com.wit.fxp.nxft.domain.model.order.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.order.NxftOrder;

// CHECKSTYLE:OFF

/**
 * 服务端[配餐订单]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class NxftOrderMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private NxftOrderMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public NxftOrderMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[NxftOrder]元数据
     */
    public static NxftOrderMetadata<NxftOrder> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[NxftOrder]元数据
     */
    public static NxftOrderMetadata<NxftOrder> root(String rootAlias) {
        return new NxftOrderMetadata<NxftOrder>(NxftOrder.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [配送单id]属性的操作符
     */
    public AlgebraicVariable<String> deliveNoteId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "deliveNoteId");
    }

    /** @return [对象信息]属性的操作符 */
    public SubjectInfoMetadata<T> subjectInfo() {
        return new SubjectInfoMetadata<T>(getNode());
    }

    /** @return [菜谱信息]属性的操作符 */
    public MealInfoMetadata<T> mealInfo() {
        return new MealInfoMetadata<T>(getNode());
    }

    /** @return [结算信息]属性的操作符 */
    public SettleInfoMetadata<T> settleInfo() {
        return new SettleInfoMetadata<T>(getNode());
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

    /** @return [完成信息]属性的操作符 */
    public CompleteInfoMetadata<T> completeInfo() {
        return new CompleteInfoMetadata<T>(getNode());
    }

    /**
     * {@link NxftOrder#getSubjectInfo() NxftOrder.subjectInfo}的元数据。
     */
    public class SubjectInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<NxftOrder.SubjectInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link SubjectInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public SubjectInfoMetadata(ObjectNode<C> node) {
            super(NxftOrder.SubjectInfo.class, node, "subjectInfo");

            node.addPath("subjectInfo");
            this.node = node.getChild("subjectInfo");
        }

        /** @return [对象id]属性的操作符 */
        public AlgebraicVariable<String> subjectId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "subjectId");
        }

        /** @return [姓名]属性的操作符 */
        public AlgebraicVariable<String> subjectName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "subjectName");
        }

        /** @return [性别id]属性的操作符 */
        public AlgebraicVariable<String> sexId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "sexId");
        }

        /** @return [性别name]属性的操作符 */
        public AlgebraicVariable<String> sexName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "sexName");
        }

        /** @return [联系电话]属性的操作符 */
        public AlgebraicVariable<String> contactPhone() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "contactPhone");
        }

        /** @return [行政区域ID]属性的操作符 */
        public AlgebraicVariable<String> regionId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "regionId");
        }

        /** @return [行政区域名称]属性的操作符 */
        public AlgebraicVariable<String> regionName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "regionName");
        }

        /** @return [详细地址]属性的操作符 */
        public AlgebraicVariable<String> address() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "address");
        }

        /** @return [对象类型id]属性的操作符 */
        public AlgebraicVariable<String> subjectTypeId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "subjectTypeId");
        }

        /** @return [对象类型名称]属性的操作符 */
        public AlgebraicVariable<String> subjectTypeName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "subjectTypeName");
        }

        /** @return [对象备注]属性的操作符 */
        public AlgebraicVariable<String> subjectDesc() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "subjectDesc");
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

        /** @return [配送地点名称 当 fdelive_type = HOME 填 faddress]属性的操作符 */
        public AlgebraicVariable<String> deliveSiteName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "deliveSiteName");
        }

        /** @return [配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name]属性的操作符 */
        public AlgebraicVariable<String> deliveAddr() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "deliveAddr");
        }

        /** @return [饭盒编号]属性的操作符 */
        public AlgebraicVariable<String> lunchBoxNo() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "lunchBoxNo");
        }

    }    // SubjectInfoMetadata

    /**
     * {@link NxftOrder#getMealInfo() NxftOrder.mealInfo}的元数据。
     */
    public class MealInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<NxftOrder.MealInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link MealInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public MealInfoMetadata(ObjectNode<C> node) {
            super(NxftOrder.MealInfo.class, node, "mealInfo");

            node.addPath("mealInfo");
            this.node = node.getChild("mealInfo");
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

        /** @return [套餐id]属性的操作符 */
        public AlgebraicVariable<String> mealId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "mealId");
        }

        /** @return [套餐CODE]属性的操作符 */
        public AlgebraicVariable<String> mealCode() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "mealCode");
        }

        /** @return [套餐名称]属性的操作符 */
        public AlgebraicVariable<String> mealName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "mealName");
        }

        /** @return [单价]属性的操作符 */
        public AlgebraicVariable<Double> mealPrice() {
            return new ObjectTreeAlgebraicVariable<Double>(Double.class, node, "mealPrice");
        }

        /** @return [备注]属性的操作符 */
        public AlgebraicVariable<String> scheduleDesc() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "scheduleDesc");
        }

        /** @return [套餐内容]属性的操作符 */
        public AlgebraicVariable<String> mealContent() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "mealContent");
        }

    }    // MealInfoMetadata

    /**
     * {@link NxftOrder#getSettleInfo() NxftOrder.settleInfo}的元数据。
     */
    public class SettleInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<NxftOrder.SettleInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link SettleInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public SettleInfoMetadata(ObjectNode<C> node) {
            super(NxftOrder.SettleInfo.class, node, "settleInfo");

            node.addPath("settleInfo");
            this.node = node.getChild("settleInfo");
        }

        /** @return [数量]属性的操作符 */
        public AlgebraicVariable<Integer> quantity() {
            return new ObjectTreeAlgebraicVariable<Integer>(Integer.class, node, "quantity");
        }

        /** @return [配送费]属性的操作符 */
        public AlgebraicVariable<Double> deliveFee() {
            return new ObjectTreeAlgebraicVariable<Double>(Double.class, node, "deliveFee");
        }

        /** @return [金额]属性的操作符 */
        public AlgebraicVariable<Double> sumTotal() {
            return new ObjectTreeAlgebraicVariable<Double>(Double.class, node, "sumTotal");
        }

        /** @return [个人自付金额]属性的操作符 */
        public AlgebraicVariable<Double> sumPayment() {
            return new ObjectTreeAlgebraicVariable<Double>(Double.class, node, "sumPayment");
        }

        /** @return [应收金额]属性的操作符 */
        public AlgebraicVariable<Double> sumReceivable() {
            return new ObjectTreeAlgebraicVariable<Double>(Double.class, node, "sumReceivable");
        }

    }    // SettleInfoMetadata

    /**
     * {@link NxftOrder#getCreateInfo() NxftOrder.createInfo}的元数据。
     */
    public class CreateInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<NxftOrder.CreateInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link CreateInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public CreateInfoMetadata(ObjectNode<C> node) {
            super(NxftOrder.CreateInfo.class, node, "createInfo");

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

        /** @return [订餐方式  坐席  助餐点]属性的操作符 */
        public AlgebraicVariable<String> createWay() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "createWay");
        }

    }    // CreateInfoMetadata

    /**
     * {@link NxftOrder#getLastState() NxftOrder.lastState}的元数据。
     */
    public class LastStateMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<NxftOrder.LastState> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link LastStateMetadata}对象。
         *
         * @param node 所属节点
         */
        public LastStateMetadata(ObjectNode<C> node) {
            super(NxftOrder.LastState.class, node, "lastState");

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
     * {@link NxftOrder#getNextNode() NxftOrder.nextNode}的元数据。
     */
    public class NextNodeMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<NxftOrder.NextNode> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link NextNodeMetadata}对象。
         *
         * @param node 所属节点
         */
        public NextNodeMetadata(ObjectNode<C> node) {
            super(NxftOrder.NextNode.class, node, "nextNode");

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
     * {@link NxftOrder#getCompleteInfo() NxftOrder.completeInfo}的元数据。
     */
    public class CompleteInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<NxftOrder.CompleteInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link CompleteInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public CompleteInfoMetadata(ObjectNode<C> node) {
            super(NxftOrder.CompleteInfo.class, node, "completeInfo");

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

        /** @return [失败原因名称  常量  客户取消]属性的操作符 */
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
