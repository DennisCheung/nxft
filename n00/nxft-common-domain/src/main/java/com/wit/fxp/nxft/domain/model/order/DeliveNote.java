package com.wit.fxp.nxft.domain.model.order;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.nxft.domain.model.order.base.AbstractDeliveNote;

/**
 * 配送单对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractDeliveNote
 */
public class DeliveNote extends AbstractLoggingEntity<String> implements PropertyChecker {

    @lombok.experimental.BuilderCall(builderMethodName = "新增详情")
    public void addDeliveDetail(DeliveDetail detail) {
        this.deliveDetailSet.add(detail);
    }

    @lombok.experimental.BuilderCall(builderMethodName = "配送")
    public void deliveNote(DeliveNote.LastState lastState, DeliveNote.NextNode nextNode, DeliveNote.CompleteInfo completeInfo) {
        this.lastState = lastState;
        this.completeInfo = completeInfo;
        this.nextNode = nextNode;
    }

    @lombok.experimental.BuilderCall(builderMethodName = "确认")
    public void comfirm(DeliveNote.LastState lastState, DeliveNote.CompleteInfo completeInfo, DeliveNote.NextNode nextNode) {
        this.lastState = lastState;
        this.nextNode = nextNode;
        this.completeInfo = completeInfo;
    }

//    /**
//     * 创建{@link DeliveNote}对象。
//     *
//     * @param id {@code DeliveNote}对象的ID
//     */
//    public DeliveNote(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//    }

    // ---------- DeliveNote.__DeliveInfo组件定义
    /**
     * [组件类] 配送信息。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class DeliveInfo extends AbstractDeliveNote._DeliveInfo {

        public static final DeliveInfo EMPTY = new DeliveInfo();

        // BEGIN>>>@$^*!#%&DeliveInfo
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        DeliveInfo() {
            super();
        }

        /**
         * 完整构造函数。除实体关系字段（如果有的话）外，其它字段按不可变类设计，具体请参见父类说明。
         *
         * <ul>
         * <li>对于基本字段，如果是可变类则拷贝，否则直接引用。</li>
         * <li>对于组件字段，直接引用。</li>
         * <li>对于实体字段，直接引用</li>
         * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
         * </ul>
         *
         * @param circleId [不可空] 客户所属的工作圈id
         * @param deliveType [不可空] 配送方式  助餐点 SITE  到户上门  HOME
         * @param deliveSiteId [不可空] 配送地点id
         * @param deliveSiteName [不可空] 配送地点名称  当 fdelive_type = HOME 填 faddress
         * @param kitchenCircleId [不可空] 厨房圈id
         * @param kitchenTeamId [不可空] 厨房teamid
         * @param mealDate [不可空] 就餐日期
         * @param week [不可空] 周几
         * @param mealTypeId [不可空] 餐别ID
         * @param mealTypeName [不可空] 餐别名称
         * @param quantity [不可空] 数量
         * @param quantityDesc [不可空] 数量描述
         * @param deliveAddr [不可空] 配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name
         * @param contactPerson [可空] 联系人
         * @param contactMobile [可空] 联系手机
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public DeliveInfo(String circleId, String deliveType, String deliveSiteId, String deliveSiteName, String kitchenCircleId, String kitchenTeamId, java.util.Date mealDate, Integer week, String mealTypeId, String mealTypeName, Integer quantity, String quantityDesc, String deliveAddr, String contactPerson, String contactMobile) {
            super(circleId, deliveType, deliveSiteId, deliveSiteName, kitchenCircleId, kitchenTeamId, mealDate, week, mealTypeId, mealTypeName, quantity, quantityDesc, deliveAddr, contactPerson, contactMobile);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@DeliveInfo

    }   // DeliveInfo

    // ---------- DeliveNote.__CreateInfo组件定义
    /**
     * [组件类] 创建新。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class CreateInfo extends AbstractDeliveNote._CreateInfo {

        public static final CreateInfo EMPTY = new CreateInfo();

        // BEGIN>>>@$^*!#%&CreateInfo
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        CreateInfo() {
            super();
        }

        /**
         * 完整构造函数。除实体关系字段（如果有的话）外，其它字段按不可变类设计，具体请参见父类说明。
         *
         * <ul>
         * <li>对于基本字段，如果是可变类则拷贝，否则直接引用。</li>
         * <li>对于组件字段，直接引用。</li>
         * <li>对于实体字段，直接引用</li>
         * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
         * </ul>
         *
         * @param createTime [不可空] 创建时间
         * @param createUserId [不可空] 创建操作员id
         * @param createUserName [不可空] 创建操作员姓名
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public CreateInfo(java.util.Date createTime, String createUserId, String createUserName) {
            super(createTime, createUserId, createUserName);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@CreateInfo

    }   // CreateInfo

    // ---------- DeliveNote.__LastState组件定义
    /**
     * [组件类] 上次状态。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class LastState extends AbstractDeliveNote._LastState {

        public static final LastState EMPTY = new LastState();

        // BEGIN>>>@$^*!#%&LastState
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        LastState() {
            super();
        }

        /**
         * 完整构造函数。除实体关系字段（如果有的话）外，其它字段按不可变类设计，具体请参见父类说明。
         *
         * <ul>
         * <li>对于基本字段，如果是可变类则拷贝，否则直接引用。</li>
         * <li>对于组件字段，直接引用。</li>
         * <li>对于实体字段，直接引用</li>
         * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
         * </ul>
         *
         * @param lastState [不可空] 最后状态，完成时ID
         * @param lastTime [不可空] 最新完成时间
         * @param lastUserId [不可空] 最新完成操作员id
         * @param lastNickname [不可空] 最新完成操作员name
         * @param lastDesc [可空] 流程备注，如为退单，填退单原因。
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public LastState(String lastState, java.util.Date lastTime, String lastUserId, String lastNickname, String lastDesc) {
            super(lastState, lastTime, lastUserId, lastNickname, lastDesc);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@LastState

    }   // LastState

    // ---------- DeliveNote.__NextNodea组件定义
    /**
     * [组件类] 下一环节。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class NextNode extends AbstractDeliveNote._NextNode {

        public static final NextNode EMPTY = new NextNode();

        // BEGIN>>>@$^*!#%&NextNode
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        NextNode() {
            super();
        }

        /**
         * 完整构造函数。除实体关系字段（如果有的话）外，其它字段按不可变类设计，具体请参见父类说明。
         *
         * <ul>
         * <li>对于基本字段，如果是可变类则拷贝，否则直接引用。</li>
         * <li>对于组件字段，直接引用。</li>
         * <li>对于实体字段，直接引用</li>
         * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
         * </ul>
         *
         * @param nextNodeId [可空] 下一环节 常量，和环节状态、备注同时更新
         * @param nextNodeContent [可空] 下一环节工作内容
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public NextNode(String nextNodeId, String nextNodeContent) {
            super(nextNodeId, nextNodeContent);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@NextNodea

    }   // NextNodea

    // ---------- DeliveNote.__CompleteInfo组件定义
    /**
     * [组件类] 完成情况。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class CompleteInfo extends AbstractDeliveNote._CompleteInfo {

        public static final CompleteInfo EMPTY = new CompleteInfo();

        // BEGIN>>>@$^*!#%&CompleteInfo
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        CompleteInfo() {
            super();
        }

        /**
         * 完整构造函数。除实体关系字段（如果有的话）外，其它字段按不可变类设计，具体请参见父类说明。
         *
         * <ul>
         * <li>对于基本字段，如果是可变类则拷贝，否则直接引用。</li>
         * <li>对于组件字段，直接引用。</li>
         * <li>对于实体字段，直接引用</li>
         * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
         * </ul>
         *
         * @param isComplete [不可空] 是否已完成？  Y/N
         * @param completeState [可空] 完成状态  SUCCESS  成功  FAIL 失败（取消）
         * @param failReasonName [可空] 失败原因名称  常量  客户取消、改派
         * @param completeTime [可空] 完成时间
         * @param completeUserId [可空] 完成操作员工号id
         * @param completeNickname [可空] 完成操作员姓名
         * @param completeDesc [可空] 完成备注
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public CompleteInfo(Boolean isComplete, String completeState, String failReasonName, java.util.Date completeTime, String completeUserId, String completeNickname, String completeDesc) {
            super(isComplete, completeState, failReasonName, completeTime, completeUserId, completeNickname, completeDesc);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@CompleteInfo

    }   // CompleteInfo

    //
    // BEGIN>>>@$^*!#%&1
    // CHECKSTYLE:OFF
    // @formatter:off
    // ---------- BEGIN和END之间的代码由代码生成器自动生成，请勿在此手写代码，下次生成将被覆盖。

    private static final long serialVersionUID = 3817793693763726365L;

    /** [组件] 配送信息 */
    private DeliveNote.DeliveInfo deliveInfo;

    /** [组件] 创建信息 */
    private DeliveNote.CreateInfo createInfo;

    /** [组件] 上次状态 */
    private DeliveNote.LastState lastState;

    /** [组件] 下一环节 */
    private DeliveNote.NextNode nextNode;

    /** [组件] 完成情况 */
    private DeliveNote.CompleteInfo completeInfo;

    /** [实体集合] 配送详情 */
    private java.util.Set<com.wit.fxp.nxft.domain.model.order.DeliveDetail> deliveDetailSet =
            new java.util.HashSet<com.wit.fxp.nxft.domain.model.order.DeliveDetail>();

    /** [实体集合] 订单 */
    private java.util.Set<com.wit.fxp.nxft.domain.model.order.NxftOrder> nxftOrderSet =
            new java.util.HashSet<com.wit.fxp.nxft.domain.model.order.NxftOrder>();

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected DeliveNote() {
        super();
    }

    /**
     * 拷贝构造函数。
     *
     * <ul>
     * <li>对于组件字段，直接引用。</li>
     * <li>对于实体字段，直接引用</li>
     * <li>对于实体集合字段，直接引用，但其{@code get}方法返回不可修改的集合类。</li>
     * </ul>
     *
     * @param mark 本参数暂没用到
     * @param copy 准备从中拷贝其属性的同类型对象
     */
    public DeliveNote(int mark, DeliveNote copy) {
        this(copy.getId(), copy.getDeliveInfo(), copy.getCreateInfo(), copy.getLastState(), copy.getNextNode(), copy.getCompleteInfo());
        deliveDetailSet = copy.internalGetDeliveDetailSet();
        nxftOrderSet = copy.internalGetNxftOrderSet();
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 配送单ID
     * @param deliveInfo 配送信息
     * @param createInfo 创建信息
     * @param lastState 上次状态
     * @param nextNode 下一环节
     * @param completeInfo 完成情况
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullDeliveNoteBuilder")
    private DeliveNote(String id, DeliveNote.DeliveInfo deliveInfo, DeliveNote.CreateInfo createInfo, DeliveNote.LastState lastState, DeliveNote.NextNode nextNode, DeliveNote.CompleteInfo completeInfo) {
        super(id);
        this.deliveInfo = deliveInfo;
        this.createInfo = createInfo;
        this.lastState = lastState;
        this.nextNode = nextNode;
        this.completeInfo = completeInfo;
    }

// ---------- getter/setter

    /**
     * 返回配送单ID。
     *
     * @return 配送单ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置配送单ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 配送单ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回配送信息[组件]。
     *
     * @return 配送信息
     */
    public DeliveNote.DeliveInfo getDeliveInfo() {
        return deliveInfo == null ? DeliveNote.DeliveInfo.EMPTY : deliveInfo;
    }

    /**
     * 返回创建信息[组件]。
     *
     * @return 创建信息
     */
    public DeliveNote.CreateInfo getCreateInfo() {
        return createInfo == null ? DeliveNote.CreateInfo.EMPTY : createInfo;
    }

    /**
     * 返回上次状态[组件]。
     *
     * @return 上次状态
     */
    public DeliveNote.LastState getLastState() {
        return lastState == null ? DeliveNote.LastState.EMPTY : lastState;
    }

    /**
     * 返回下一环节[组件]。
     *
     * @return 下一环节
     */
    public DeliveNote.NextNode getNextNode() {
        return nextNode == null ? DeliveNote.NextNode.EMPTY : nextNode;
    }

    /**
     * 返回完成情况[组件]。
     *
     * @return 完成情况
     */
    public DeliveNote.CompleteInfo getCompleteInfo() {
        return completeInfo == null ? DeliveNote.CompleteInfo.EMPTY : completeInfo;
    }

    /**
     * 返回配送详情[实体集合]。
     *
     * @return [不可修改集合类{@link java.util.Collections#unmodifiableSet}] 配送详情
     */
    public java.util.Set<com.wit.fxp.nxft.domain.model.order.DeliveDetail> getDeliveDetailSet() {
        if (deliveDetailSet == null) {
            return java.util.Collections.emptySet();
        }
        else {
            return java.util.Collections.unmodifiableSet(deliveDetailSet);
        }
    }

    /**
     * 返回配送详情[实体集合]，本方法供内部使用。
     *
     * @return 配送详情
     */
    private java.util.Set<com.wit.fxp.nxft.domain.model.order.DeliveDetail> internalGetDeliveDetailSet() {
        return deliveDetailSet;
    }

    /**
     * 返回订单[实体集合]。
     *
     * @return [不可修改集合类{@link java.util.Collections#unmodifiableSet}] 订单
     */
    public java.util.Set<com.wit.fxp.nxft.domain.model.order.NxftOrder> getNxftOrderSet() {
        if (nxftOrderSet == null) {
            return java.util.Collections.emptySet();
        }
        else {
            return java.util.Collections.unmodifiableSet(nxftOrderSet);
        }
    }

    /**
     * 返回订单[实体集合]，本方法供内部使用。
     *
     * @return 订单
     */
    private java.util.Set<com.wit.fxp.nxft.domain.model.order.NxftOrder> internalGetNxftOrderSet() {
        return nxftOrderSet;
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractDeliveNote.checkProperties(getDeliveInfo(), getCreateInfo(), getLastState(), getNextNode(), getCompleteInfo());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
