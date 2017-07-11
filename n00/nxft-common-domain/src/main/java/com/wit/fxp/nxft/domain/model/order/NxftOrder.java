package com.wit.fxp.nxft.domain.model.order;

import java.util.Date;

import com.benewit.core.utils.SafeCopier;
import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.PropertyChecker;
import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.domain.model.meal.MealScheday;
import com.wit.fxp.nxft.domain.model.order.base.AbstractNxftOrder;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;

/**
 * 配餐订单对象。
 *
 * <p>
 *
 * @author <请修改为您的名字>
 * @see AbstractNxftOrder
 */
public class NxftOrder extends AbstractLoggingEntity<String> implements PropertyChecker {

    @lombok.experimental.BuilderCall(builderMethodName = "新建")
    public static NxftOrder newNxftOrder(InvocationContext ic, Actor actor, NxftSubject subject, MealScheday day, OrderMoney money,
            String type) {
        return NxftOrder.fullNxftOrderBuilder()
                ._id____________(ic.generateBillNumber("NXFT_ORDER_ID"))
                ._deliveNoteId__(null)
                ._subjectInfo___(NxftOrder.SubjectInfo.fullBuilder()
                        ._subjectId_________(subject.getId())
                        ._subjectName_______(subject.getPersonInfo().getSubjectName())
                        ._sexId_____________(subject.getPersonInfo().getSexId())
                        ._sexName___________(subject.getPersonInfo().getSexName())
                        ._contactPhone______(subject.getContactPhone())
                        ._regionId__________(subject.getRegionId())
                        ._regionName________(subject.getRegionName())
                        ._address___________(subject.getAddress())
                        ._subjectTypeId_____(subject.getSubjectInfo().getSubjectTypeId())
                        ._subjectTypeName___(subject.getSubjectInfo().getSubjectTypeName())
                        ._subjectDesc_______(subject.getSubjectInfo().getSubjectDesc())
                        ._circleId__________(subject.getPersonInfo().getCircleId())
                        ._deliveType________(subject.getSubjectInfo().getDeliveType())
                        ._deliveSiteId______(subject.getSubjectInfo().getDeliveSiteId())
                        ._deliveSiteName____(subject.getSubjectInfo().getDeliveSiteName())
                        ._deliveAddr________(subject.getSubjectInfo().getDeliveType().equals("SITE") ? subject.getSubjectInfo().getDeliveSiteName()
                                : subject.getAddress())
                        ._lunchBoxNo________(subject.getSubjectInfo().getLunchBoxNo())
                        ._build_())
                ._mealInfo______(NxftOrder.MealInfo.fullBuilder()
                        ._kitchenCircleId___(day.getKitchenCircleId())
                        ._kitchenTeamId_____(day.getKitchenTeamId())
                        ._mealDate__________(day.getMealDate())
                        ._week______________(day.getWeek())
                        ._mealTypeId________(day.getMealTypeId())
                        ._mealTypeName______(day.getMealTypeName())
                        ._mealId____________(day.getMealId())
                        ._mealCode__________(day.getMealCode())
                        ._mealName__________(day.getMealName())
                        ._mealPrice_________(day.getMealPrice())
                        ._scheduleDesc______(day.getScheduleDesc())
                        ._mealContent_______(day.getMealContent())
                        ._build_())
                ._settleInfo____(NxftOrder.SettleInfo.fullBuilder()
                        ._quantity______(money.getQuantity())
                        ._deliveFee_____(money.getDeliveFee())
                        ._sumTotal______(money.getSumTotal())
                        ._sumPayment____(money.getSumPayment())
                        ._sumReceivable_(money.getSumReceivable())
                        ._build_())
                ._createInfo____(NxftOrder.CreateInfo.fullBuilder()
                        ._createTime________(ic.now())
                        ._createUserId______(actor.getUser().getId())
                        ._createUserName____(actor.getUser().getBasicInfo().getNickname())
                        ._createWay_________(type.equals("1") ? "坐席" : "助餐点")
                        ._build_())
                ._lastState_____(NxftOrder.LastState.fullBuilder()
                        ._lastState_____(DBC.助餐订单状态.初始.getValue())
                        ._lastTime______(ic.now())
                        ._lastUserId____(actor.getUser().getId())
                        ._lastNickname__(actor.getUser().getBasicInfo().getNickname())
                        ._lastDesc______(null)
                        ._build_())
                ._nextNode______(null)
                ._completeInfo__(NxftOrder.CompleteInfo.EMPTY)
                ._build_();

    }

    public NxftOrder.LastState step(Actor at,
            DBC.助餐订单状态 state, String data, NextNode nextAction, DBC.助餐订单动作 actionValue, Date time) {
        lastState = NxftOrder.LastState.fullBuilder()
                ._lastState_____(state.getValue())
                ._lastTime______(time)
                ._lastUserId____(at.getUser().getId())
                ._lastNickname__(at.getUser().getBasicInfo().getNickname())
                ._lastDesc______(data)
                ._build_();

        if (nextAction == null) {
            nextNode = NextNode.EMPTY;
//            this.completeInfo = CompleteInfo.完成(at, state, data, null, time);
        }
        else {
            nextNode = nextAction;
        }

        return lastState;
    }

    public void 取消(InvocationContext ic, Actor actor) {
        this.lastState = this.lastState.取消(ic, actor);
        this.completeInfo = this.completeInfo.取消(ic, actor);
    }

    public void 发放(InvocationContext ic, Actor actor) {
        this.lastState = this.lastState.发放(ic, actor);
        this.completeInfo = this.completeInfo.发放(ic, actor);
        this.nextNode = NxftOrder.NextNode.EMPTY;
    }

    @lombok.experimental.BuilderCall(builderMethodName = "配送")
    public void delive(String deliveNoteId, NxftOrder.LastState lastState, NxftOrder.NextNode nextNode) {
        this.deliveNoteId = deliveNoteId;
        this.lastState = lastState;
        this.nextNode = nextNode;
    }

    @lombok.experimental.BuilderCall(builderMethodName = "配送成功")
    public void delive(NxftOrder.LastState lastState, NxftOrder.NextNode nextNode, NxftOrder.CompleteInfo complateInfo) {
        this.lastState = lastState;
        this.nextNode = nextNode;
        this.completeInfo = complateInfo;
    }

    @lombok.experimental.BuilderCall(builderMethodName = "助餐点进行确认")
    public void comfirmDeliver(String deliveNoteId, NxftOrder.LastState lastState, NxftOrder.NextNode nextNode) {
        this.deliveNoteId = deliveNoteId;
        this.lastState = lastState;
        this.nextNode = nextNode;
        this.completeInfo = NxftOrder.CompleteInfo.EMPTY;
    }

//    /**
//     * 创建{@link NxftOrder}对象。
//     *
//     * @param id {@code NxftOrder}对象的ID
//     */
//    public NxftOrder(String id) {
//        this();
//        this.id = id;
//
//        // 初始化
//    }

    // ---------- NxftOrder.__SubjectInfo组件定义
    /**
     * [组件类] 对象信息。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class SubjectInfo extends AbstractNxftOrder._SubjectInfo {

        public static final SubjectInfo EMPTY = new SubjectInfo();

        // BEGIN>>>@$^*!#%&SubjectInfo
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        SubjectInfo() {
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
         * @param subjectId [不可空] 对象id
         * @param subjectName [不可空] 姓名
         * @param sexId [不可空] 性别id
         * @param sexName [不可空] 性别name
         * @param contactPhone [不可空] 联系电话
         * @param regionId [不可空] 行政区域ID
         * @param regionName [不可空] 行政区域名称
         * @param address [可空] 详细地址
         * @param subjectTypeId [不可空] 对象类型id
         * @param subjectTypeName [不可空] 对象类型名称
         * @param subjectDesc [可空] 对象备注
         * @param circleId [不可空] 客户所属的工作圈id
         * @param deliveType [不可空] 配送方式  助餐点 SITE  到户上门  HOME
         * @param deliveSiteId [不可空] 配送地点id
         * @param deliveSiteName [不可空] 配送地点名称 当 fdelive_type = HOME 填 faddress
         * @param deliveAddr [不可空] 配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name
         * @param lunchBoxNo [可空] 饭盒编号
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public SubjectInfo(String subjectId, String subjectName, String sexId, String sexName, String contactPhone, String regionId, String regionName, String address, String subjectTypeId, String subjectTypeName, String subjectDesc, String circleId, String deliveType, String deliveSiteId, String deliveSiteName, String deliveAddr, String lunchBoxNo) {
            super(subjectId, subjectName, sexId, sexName, contactPhone, regionId, regionName, address, subjectTypeId, subjectTypeName, subjectDesc, circleId, deliveType, deliveSiteId, deliveSiteName, deliveAddr, lunchBoxNo);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@SubjectInfo

    }   // SubjectInfo

    // ---------- NxftOrder.__MealInfo组件定义
    /**
     * [组件类] 菜谱信息。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class MealInfo extends AbstractNxftOrder._MealInfo {

        public static final MealInfo EMPTY = new MealInfo();

        public LastState 取消(InvocationContext ic, Actor actor) {
            return LastState.fullBuilder()
                    ._lastState_____("已取消")
                    ._lastTime______(ic.now())
                    ._lastUserId____(actor.getUser().getId())
                    ._lastNickname__(actor.getUser().getBasicInfo().getNickname())
                    ._lastDesc______(null)
                    ._build_();
        }

        // BEGIN>>>@$^*!#%&MealInfo
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        MealInfo() {
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
         * @param kitchenCircleId [不可空] 厨房圈id
         * @param kitchenTeamId [不可空] 厨房teamid
         * @param mealDate [不可空] 就餐日期
         * @param week [不可空] 周几
         * @param mealTypeId [不可空] 餐别ID
         * @param mealTypeName [不可空] 餐别名称
         * @param mealId [不可空] 套餐id
         * @param mealCode [不可空] 套餐CODE
         * @param mealName [不可空] 套餐名称
         * @param mealPrice [不可空] 单价
         * @param scheduleDesc [可空] 备注
         * @param mealContent [可空] 套餐内容
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public MealInfo(String kitchenCircleId, String kitchenTeamId, java.util.Date mealDate, Integer week, String mealTypeId, String mealTypeName, String mealId, String mealCode, String mealName, Double mealPrice, String scheduleDesc, String mealContent) {
            super(kitchenCircleId, kitchenTeamId, mealDate, week, mealTypeId, mealTypeName, mealId, mealCode, mealName, mealPrice, scheduleDesc, mealContent);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@MealInfo

    }   // MealInfo

    // ---------- NxftOrder.__SettleInfo组件定义
    /**
     * [组件类] 结算信息。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class SettleInfo extends AbstractNxftOrder._SettleInfo {

        public static final SettleInfo EMPTY = new SettleInfo();

        // BEGIN>>>@$^*!#%&SettleInfo
        // CHECKSTYLE:OFF
        // @formatter:off
        private static final long serialVersionUID = 1L;

        /** 默认构造函数，Hibernate需要这个构造函数。 */
        SettleInfo() {
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
         * @param quantity [不可空] 数量
         * @param deliveFee [不可空] 配送费
         * @param sumTotal [不可空] 金额
         * @param sumPayment [不可空] 个人自付金额
         * @param sumReceivable [不可空] 应收金额
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public SettleInfo(Integer quantity, Double deliveFee, Double sumTotal, Double sumPayment, Double sumReceivable) {
            super(quantity, deliveFee, sumTotal, sumPayment, sumReceivable);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@SettleInfo

    }   // SettleInfo

    // ---------- NxftOrder.__CreateInfo组件定义
    /**
     * [组件类] 创建信息。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class CreateInfo extends AbstractNxftOrder._CreateInfo {

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
         * @param createWay [不可空] 订餐方式  坐席  助餐点
         */
        @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullBuilder")
        public CreateInfo(java.util.Date createTime, String createUserId, String createUserName, String createWay) {
            super(createTime, createUserId, createUserName, createWay);
        }
        // @formatter:on
        // CHECKSTYLE:ON
        // END<<<&%#!*^$@CreateInfo

    }   // CreateInfo

    // ---------- NxftOrder.__LastState组件定义
    /**
     * [组件类] 上次状态。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class LastState extends AbstractNxftOrder._LastState {

        public static final LastState EMPTY = new LastState();

        public LastState 取消(InvocationContext ic, Actor actor) {
            return LastState.fullBuilder()
                    ._lastState_____("已取消")
                    ._lastTime______(ic.now())
                    ._lastUserId____(actor.getUser().getId())
                    ._lastNickname__(actor.getUser().getBasicInfo().getNickname())
                    ._lastDesc______(null)
                    ._build_();
        }

        public LastState 发放(InvocationContext ic, Actor actor) {
            return LastState.fullBuilder()
                    ._lastState_____("已发放")
                    ._lastTime______(ic.now())
                    ._lastUserId____(actor.getUser().getId())
                    ._lastNickname__(actor.getUser().getBasicInfo().getNickname())
                    ._lastDesc______(null)
                    ._build_();
        }

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

    // ---------- NxftOrder.__NextNode组件定义
    /**
     * [组件类] 下一环节。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class NextNode extends AbstractNxftOrder._NextNode {

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
        // END<<<&%#!*^$@NextNode

    }   // NextNode

    // ---------- NxftOrder.__CompleteInfo组件定义
    /**
     * [组件类] 完成信息。
     *
     * <p>除实体关系字段外，本类型被设计为不可变类（Immutable）。
     *
     * @author <请修改为您的名字>
     */
    public static class CompleteInfo extends AbstractNxftOrder._CompleteInfo {

        public static final CompleteInfo EMPTY = new CompleteInfo();

        public CompleteInfo 取消(InvocationContext ic, Actor actor) {
            return CompleteInfo.fullBuilder()
                    ._isComplete________(true)
                    ._completeState_____("FAIL")
                    ._failReasonName____("取消订单")
                    ._completeTime______(ic.now())
                    ._completeUserId____(actor.getUser().getId())
                    ._completeNickname__(actor.getUser().getBasicInfo().getNickname())
                    ._completeDesc______(null)
                    ._build_();
        }

        public CompleteInfo 发放(InvocationContext ic, Actor actor) {
            return CompleteInfo.fullBuilder()
                    ._isComplete________(true)
                    ._completeState_____("SUCCESS")
                    ._failReasonName____(null)
                    ._completeTime______(ic.now())
                    ._completeUserId____(actor.getUser().getId())
                    ._completeNickname__(actor.getUser().getBasicInfo().getNickname())
                    ._completeDesc______(null)
                    ._build_();
        }

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
         * @param failReasonName [可空] 失败原因名称  常量  客户取消
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

    private static final long serialVersionUID = 6229261321964864274L;

    /** 33. [可空] 配送单id */
    protected String deliveNoteId;

    /** [组件] 对象信息 */
    private NxftOrder.SubjectInfo subjectInfo;

    /** [组件] 菜谱信息 */
    private NxftOrder.MealInfo mealInfo;

    /** [组件] 结算信息 */
    private NxftOrder.SettleInfo settleInfo;

    /** [组件] 创建信息 */
    private NxftOrder.CreateInfo createInfo;

    /** [组件] 上次状态 */
    private NxftOrder.LastState lastState;

    /** [组件] 下一环节 */
    private NxftOrder.NextNode nextNode;

    /** [组件] 完成信息 */
    private NxftOrder.CompleteInfo completeInfo;

    /**
     * 默认构造函数，Hibernate需要这个构造函数。
     *
     * @deprecated 请勿使用本构造函数，本构造函数仅供Hibernate使用
     */
    @Deprecated
    protected NxftOrder() {
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
    public NxftOrder(int mark, NxftOrder copy) {
        this(copy.getId(), copy.getDeliveNoteId(), copy.getSubjectInfo(), copy.getMealInfo(), copy.getSettleInfo(), copy.getCreateInfo(), copy.getLastState(), copy.getNextNode(), copy.getCompleteInfo());
    }

    /**
     * 除一对多集合型实体关系字段外的构造函数。
     *
     * @param id 配餐订单ID
     * @param deliveNoteId [可空] 配送单id
     * @param subjectInfo 对象信息
     * @param mealInfo 菜谱信息
     * @param settleInfo 结算信息
     * @param createInfo 创建信息
     * @param lastState 上次状态
     * @param nextNode 下一环节
     * @param completeInfo 完成信息
     */
    @lombok.experimental.BuilderCall(builderClassName = "FullBuilder", builderMethodName = "fullNxftOrderBuilder")
    private NxftOrder(String id, String deliveNoteId, NxftOrder.SubjectInfo subjectInfo, NxftOrder.MealInfo mealInfo, NxftOrder.SettleInfo settleInfo, NxftOrder.CreateInfo createInfo, NxftOrder.LastState lastState, NxftOrder.NextNode nextNode, NxftOrder.CompleteInfo completeInfo) {
        super(id);
        this.deliveNoteId = SafeCopier.copy(deliveNoteId);
        this.subjectInfo = subjectInfo;
        this.mealInfo = mealInfo;
        this.settleInfo = settleInfo;
        this.createInfo = createInfo;
        this.lastState = lastState;
        this.nextNode = nextNode;
        this.completeInfo = completeInfo;
    }

// ---------- getter/setter

    /**
     * 返回配餐订单ID。
     *
     * @return 配餐订单ID
     */
    public String getId() {
        return SafeCopier.copy(id);
    }

    /**
     * 设置配餐订单ID。本方法仅供hibernate属性注入时使用
     *
     * @param id 配餐订单ID
     */
    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = SafeCopier.copy(id);
    }

    /**
     * 返回配送单id。
     *
     * @return [可空] 配送单id
     */
    public String getDeliveNoteId() {
        return SafeCopier.copy(deliveNoteId);
    }

    /**
     * 返回对象信息[组件]。
     *
     * @return 对象信息
     */
    public NxftOrder.SubjectInfo getSubjectInfo() {
        return subjectInfo == null ? NxftOrder.SubjectInfo.EMPTY : subjectInfo;
    }

    /**
     * 返回菜谱信息[组件]。
     *
     * @return 菜谱信息
     */
    public NxftOrder.MealInfo getMealInfo() {
        return mealInfo == null ? NxftOrder.MealInfo.EMPTY : mealInfo;
    }

    /**
     * 返回结算信息[组件]。
     *
     * @return 结算信息
     */
    public NxftOrder.SettleInfo getSettleInfo() {
        return settleInfo == null ? NxftOrder.SettleInfo.EMPTY : settleInfo;
    }

    /**
     * 返回创建信息[组件]。
     *
     * @return 创建信息
     */
    public NxftOrder.CreateInfo getCreateInfo() {
        return createInfo == null ? NxftOrder.CreateInfo.EMPTY : createInfo;
    }

    /**
     * 返回上次状态[组件]。
     *
     * @return 上次状态
     */
    public NxftOrder.LastState getLastState() {
        return lastState == null ? NxftOrder.LastState.EMPTY : lastState;
    }

    /**
     * 返回下一环节[组件]。
     *
     * @return 下一环节
     */
    public NxftOrder.NextNode getNextNode() {
        return nextNode == null ? NxftOrder.NextNode.EMPTY : nextNode;
    }

    /**
     * 返回完成信息[组件]。
     *
     * @return 完成信息
     */
    public NxftOrder.CompleteInfo getCompleteInfo() {
        return completeInfo == null ? NxftOrder.CompleteInfo.EMPTY : completeInfo;
    }

    /**
     * 各属性的长度、非空检查。
     */
    @Override
    public void checkProperties() {
        AbstractNxftOrder.checkProperties(getDeliveNoteId(), getSubjectInfo(), getMealInfo(), getSettleInfo(), getCreateInfo(), getLastState(), getNextNode(), getCompleteInfo());
    }
    // @formatter:on
    // CHECKSTYLE:ON
    // END<<<&%#!*^$@1
}
