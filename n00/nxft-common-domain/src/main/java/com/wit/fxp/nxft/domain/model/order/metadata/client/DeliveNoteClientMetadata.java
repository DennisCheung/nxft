package com.wit.fxp.nxft.domain.model.order.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.order.DeliveNote;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class DeliveNoteClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private DeliveNoteClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public DeliveNoteClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[DeliveNote]元数据
     */
    public static DeliveNoteClientMetadata<DeliveNote> root() {
        return new DeliveNoteClientMetadata<DeliveNote>(DeliveNote.class);
    }

    /**
     * @return [配送信息]属性的操作符。
     */
    public DeliveInfoClientMetadata<T> deliveInfo() {
        getNode().addPath("deliveInfo");

        return new DeliveInfoClientMetadata<T>(getObjectTree(), getNode().getChild("deliveInfo"));
    }

    /**
     * @return [创建信息]属性的操作符。
     */
    public CreateInfoClientMetadata<T> createInfo() {
        getNode().addPath("createInfo");

        return new CreateInfoClientMetadata<T>(getObjectTree(), getNode().getChild("createInfo"));
    }

    /**
     * @return [上次状态]属性的操作符。
     */
    public LastStateClientMetadata<T> lastState() {
        getNode().addPath("lastState");

        return new LastStateClientMetadata<T>(getObjectTree(), getNode().getChild("lastState"));
    }

    /**
     * @return [下一环节]属性的操作符。
     */
    public NextNodeClientMetadata<T> nextNode() {
        getNode().addPath("nextNode");

        return new NextNodeClientMetadata<T>(getObjectTree(), getNode().getChild("nextNode"));
    }

    /**
     * @return [完成情况]属性的操作符。
     */
    public CompleteInfoClientMetadata<T> completeInfo() {
        getNode().addPath("completeInfo");

        return new CompleteInfoClientMetadata<T>(getObjectTree(), getNode().getChild("completeInfo"));
    }

    /**
     * @return [配送详情]对象的客户端元数据
     */
    public com.wit.fxp.nxft.domain.model.order.metadata.client.DeliveDetailClientMetadata<T> deliveDetailSet() {
        getNode().addPath("deliveDetailSet");

        return new com.wit.fxp.nxft.domain.model.order.metadata.client.DeliveDetailClientMetadata<T>(this.getObjectTree(), getNode().getChild("deliveDetailSet"));
    }

    /**
     * @return [订单]对象的客户端元数据
     */
    public com.wit.fxp.nxft.domain.model.order.metadata.client.NxftOrderClientMetadata<T> nxftOrderSet() {
        getNode().addPath("nxftOrderSet");

        return new com.wit.fxp.nxft.domain.model.order.metadata.client.NxftOrderClientMetadata<T>(this.getObjectTree(), getNode().getChild("nxftOrderSet"));
    }

    /**
     * {@link DeliveNote#getDeliveInfo() DeliveNote.deliveInfo}的元数据。
     */
    public static class DeliveInfoClientMetadata<T extends Entity> extends com.benewit.entity.metadata.client.AbstractClientMetadata<T> {

        /**
         * 创建{@link DeliveInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public DeliveInfoClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
            super(ot, node);
        }

        /**
         * @return [客户所属的工作圈id]的属性名。
         */
        public String circleId() {
            return getNode().getPath().toPropertyPath() + ".circleId";
        }

        /**
         * @return [配送方式  助餐点 SITE  到户上门  HOME]的属性名。
         */
        public String deliveType() {
            return getNode().getPath().toPropertyPath() + ".deliveType";
        }

        /**
         * @return [配送地点id]的属性名。
         */
        public String deliveSiteId() {
            return getNode().getPath().toPropertyPath() + ".deliveSiteId";
        }

        /**
         * @return [配送地点名称  当 fdelive_type = HOME 填 faddress]的属性名。
         */
        public String deliveSiteName() {
            return getNode().getPath().toPropertyPath() + ".deliveSiteName";
        }

        /**
         * @return [厨房圈id]的属性名。
         */
        public String kitchenCircleId() {
            return getNode().getPath().toPropertyPath() + ".kitchenCircleId";
        }

        /**
         * @return [厨房teamid]的属性名。
         */
        public String kitchenTeamId() {
            return getNode().getPath().toPropertyPath() + ".kitchenTeamId";
        }

        /**
         * @return [就餐日期]的属性名。
         */
        public String mealDate() {
            return getNode().getPath().toPropertyPath() + ".mealDate";
        }

        /**
         * @return [周几]的属性名。
         */
        public String week() {
            return getNode().getPath().toPropertyPath() + ".week";
        }

        /**
         * @return [餐别ID]的属性名。
         */
        public String mealTypeId() {
            return getNode().getPath().toPropertyPath() + ".mealTypeId";
        }

        /**
         * @return [餐别名称]的属性名。
         */
        public String mealTypeName() {
            return getNode().getPath().toPropertyPath() + ".mealTypeName";
        }

        /**
         * @return [数量]的属性名。
         */
        public String quantity() {
            return getNode().getPath().toPropertyPath() + ".quantity";
        }

        /**
         * @return [数量描述]的属性名。
         */
        public String quantityDesc() {
            return getNode().getPath().toPropertyPath() + ".quantityDesc";
        }

        /**
         * @return [配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name]的属性名。
         */
        public String deliveAddr() {
            return getNode().getPath().toPropertyPath() + ".deliveAddr";
        }

        /**
         * @return [联系人]的属性名。
         */
        public String contactPerson() {
            return getNode().getPath().toPropertyPath() + ".contactPerson";
        }

        /**
         * @return [联系手机]的属性名。
         */
        public String contactMobile() {
            return getNode().getPath().toPropertyPath() + ".contactMobile";
        }

    }    // DeliveInfoMetadata

    /**
     * {@link DeliveNote#getCreateInfo() DeliveNote.createInfo}的元数据。
     */
    public static class CreateInfoClientMetadata<T extends Entity> extends com.benewit.entity.metadata.client.AbstractClientMetadata<T> {

        /**
         * 创建{@link CreateInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public CreateInfoClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
            super(ot, node);
        }

        /**
         * @return [创建时间]的属性名。
         */
        public String createTime() {
            return getNode().getPath().toPropertyPath() + ".createTime";
        }

        /**
         * @return [创建操作员id]的属性名。
         */
        public String createUserId() {
            return getNode().getPath().toPropertyPath() + ".createUserId";
        }

        /**
         * @return [创建操作员姓名]的属性名。
         */
        public String createUserName() {
            return getNode().getPath().toPropertyPath() + ".createUserName";
        }

    }    // CreateInfoMetadata

    /**
     * {@link DeliveNote#getLastState() DeliveNote.lastState}的元数据。
     */
    public static class LastStateClientMetadata<T extends Entity> extends com.benewit.entity.metadata.client.AbstractClientMetadata<T> {

        /**
         * 创建{@link LastStateMetadata}对象。
         *
         * @param node 所属节点
         */
        public LastStateClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
            super(ot, node);
        }

        /**
         * @return [最后状态，完成时ID]的属性名。
         */
        public String lastState() {
            return getNode().getPath().toPropertyPath() + ".lastState";
        }

        /**
         * @return [最新完成时间]的属性名。
         */
        public String lastTime() {
            return getNode().getPath().toPropertyPath() + ".lastTime";
        }

        /**
         * @return [最新完成操作员id]的属性名。
         */
        public String lastUserId() {
            return getNode().getPath().toPropertyPath() + ".lastUserId";
        }

        /**
         * @return [最新完成操作员name]的属性名。
         */
        public String lastNickname() {
            return getNode().getPath().toPropertyPath() + ".lastNickname";
        }

        /**
         * @return [流程备注，如为退单，填退单原因。]的属性名。
         */
        public String lastDesc() {
            return getNode().getPath().toPropertyPath() + ".lastDesc";
        }

    }    // LastStateMetadata

    /**
     * {@link DeliveNote#getNextNode() DeliveNote.nextNode}的元数据。
     */
    public static class NextNodeClientMetadata<T extends Entity> extends com.benewit.entity.metadata.client.AbstractClientMetadata<T> {

        /**
         * 创建{@link NextNodeMetadata}对象。
         *
         * @param node 所属节点
         */
        public NextNodeClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
            super(ot, node);
        }

        /**
         * @return [下一环节 常量，和环节状态、备注同时更新]的属性名。
         */
        public String nextNodeId() {
            return getNode().getPath().toPropertyPath() + ".nextNodeId";
        }

        /**
         * @return [下一环节工作内容]的属性名。
         */
        public String nextNodeContent() {
            return getNode().getPath().toPropertyPath() + ".nextNodeContent";
        }

    }    // NextNodeMetadata

    /**
     * {@link DeliveNote#getCompleteInfo() DeliveNote.completeInfo}的元数据。
     */
    public static class CompleteInfoClientMetadata<T extends Entity> extends com.benewit.entity.metadata.client.AbstractClientMetadata<T> {

        /**
         * 创建{@link CompleteInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public CompleteInfoClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
            super(ot, node);
        }

        /**
         * @return [是否已完成？  Y/N]的属性名。
         */
        public String isComplete() {
            return getNode().getPath().toPropertyPath() + ".isComplete";
        }

        /**
         * @return [完成状态  SUCCESS  成功  FAIL 失败（取消）]的属性名。
         */
        public String completeState() {
            return getNode().getPath().toPropertyPath() + ".completeState";
        }

        /**
         * @return [失败原因名称  常量  客户取消、改派]的属性名。
         */
        public String failReasonName() {
            return getNode().getPath().toPropertyPath() + ".failReasonName";
        }

        /**
         * @return [完成时间]的属性名。
         */
        public String completeTime() {
            return getNode().getPath().toPropertyPath() + ".completeTime";
        }

        /**
         * @return [完成操作员工号id]的属性名。
         */
        public String completeUserId() {
            return getNode().getPath().toPropertyPath() + ".completeUserId";
        }

        /**
         * @return [完成操作员姓名]的属性名。
         */
        public String completeNickname() {
            return getNode().getPath().toPropertyPath() + ".completeNickname";
        }

        /**
         * @return [完成备注]的属性名。
         */
        public String completeDesc() {
            return getNode().getPath().toPropertyPath() + ".completeDesc";
        }

    }    // CompleteInfoMetadata
}
