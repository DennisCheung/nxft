// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.order.base;

import com.benewit.core.utils.SafeCopier;

/**
 * 配送单工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String deliveNoteId 配送单ID
 * 2. [不可空] String circleId 客户所属的工作圈id
 * 3. [不可空] String deliveType 配送方式  助餐点 SITE  到户上门  HOME
 * 4. [不可空] String deliveSiteId 配送地点id
 * 5. [不可空] String deliveSiteName 配送地点名称  当 fdelive_type = HOME 填 faddress
 * 5.1. [不可空] String deliveAddr 配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name
 * 5.2. [可空] String contactPerson 联系人
 * 5.3. [可空] String contactMobile 联系手机
 * 6. [不可空] String kitchenCircleId 厨房圈id
 * 6.1. [不可空] String kitchenTeamId 厨房teamid
 * 7. [不可空] java.util.Date mealDate 就餐日期
 * 8. [不可空] Integer week 周几
 * 9. [不可空] String mealTypeId 餐别ID
 * 10. [不可空] String mealTypeName 餐别名称
 * 11. [不可空] Integer quantity 数量
 * 12. [不可空] String quantityDesc 数量描述
 * 13. [不可空] java.util.Date createTime 创建时间
 * 16. [不可空] String createUserId 创建操作员id
 * 17. [不可空] String createUserName 创建操作员姓名
 * 18. [不可空] String lastState 最后状态，完成时ID
 * 19. [不可空] java.util.Date lastTime 最新完成时间
 * 20. [不可空] String lastUserId 最新完成操作员id
 * 21. [不可空] String lastNickname 最新完成操作员name
 * 22. [可空] String lastDesc 流程备注，如为退单，填退单原因。
 * 23. [可空] String nextNodeId 下一环节 常量，和环节状态、备注同时更新
 * 24. [可空] String nextNodeContent 下一环节工作内容
 * 25. [不可空] Boolean isComplete 是否已完成？  Y/N
 * 26. [可空] String completeState 完成状态  SUCCESS  成功  FAIL 失败（取消）
 * 27. [可空] String failReasonName 失败原因名称  常量  客户取消、改派
 * 28. [可空] java.util.Date completeTime 完成时间
 * 29. [可空] String completeUserId 完成操作员工号id
 * 30. [可空] String completeNickname 完成操作员姓名
 * 31. [可空] String completeDesc 完成备注
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-order/java/domain/com/wit/fxp/nxft/domain/model/order/base/DeliveNote.html">DeliveNote代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractDeliveNote {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(_DeliveInfo deliveInfo, _CreateInfo createInfo, _LastState lastState, _NextNode nextNode, _CompleteInfo completeInfo) {

        if (deliveInfo != null) {
            checkComponentProperties("DeliveNote#deliveInfo", deliveInfo);
        }

        if (createInfo != null) {
            checkComponentProperties("DeliveNote#createInfo", createInfo);
        }

        if (lastState != null) {
            checkComponentProperties("DeliveNote#lastState", lastState);
        }

        if (nextNode != null) {
            checkComponentProperties("DeliveNote#nextNode", nextNode);
        }

        if (completeInfo != null) {
            checkComponentProperties("DeliveNote#completeInfo", completeInfo);
        }
    }

    /**
     * 检查[配送信息]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param deliveInfo 配送信息
     */
    private static void checkComponentProperties(String compPropertyName, _DeliveInfo deliveInfo) {

        if (deliveInfo.getCircleId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[circleId(客户所属的工作圈id)]属性不能为空。");
        }

        if (deliveInfo.getCircleId() != null && deliveInfo.getCircleId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[circleId(客户所属的工作圈id)]属性超长，最大允许32，实际为" + deliveInfo.getCircleId().length() + "。");
        }

        if (deliveInfo.getDeliveType() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveType(配送方式  助餐点 SITE  到户上门  HOME)]属性不能为空。");
        }

        if (deliveInfo.getDeliveType() != null && deliveInfo.getDeliveType().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveType(配送方式  助餐点 SITE  到户上门  HOME)]属性超长，最大允许30，实际为" + deliveInfo.getDeliveType().length() + "。");
        }

        if (deliveInfo.getDeliveSiteId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveSiteId(配送地点id)]属性不能为空。");
        }

        if (deliveInfo.getDeliveSiteId() != null && deliveInfo.getDeliveSiteId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveSiteId(配送地点id)]属性超长，最大允许32，实际为" + deliveInfo.getDeliveSiteId().length() + "。");
        }

        if (deliveInfo.getDeliveSiteName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveSiteName(配送地点名称  当 fdelive_type = HOME 填 faddress)]属性不能为空。");
        }

        if (deliveInfo.getDeliveSiteName() != null && deliveInfo.getDeliveSiteName().length() > 40) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveSiteName(配送地点名称  当 fdelive_type = HOME 填 faddress)]属性超长，最大允许40，实际为" + deliveInfo.getDeliveSiteName().length() + "。");
        }

        if (deliveInfo.getKitchenCircleId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[kitchenCircleId(厨房圈id)]属性不能为空。");
        }

        if (deliveInfo.getKitchenCircleId() != null && deliveInfo.getKitchenCircleId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[kitchenCircleId(厨房圈id)]属性超长，最大允许32，实际为" + deliveInfo.getKitchenCircleId().length() + "。");
        }

        if (deliveInfo.getKitchenTeamId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[kitchenTeamId(厨房teamid)]属性不能为空。");
        }

        if (deliveInfo.getKitchenTeamId() != null && deliveInfo.getKitchenTeamId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[kitchenTeamId(厨房teamid)]属性超长，最大允许32，实际为" + deliveInfo.getKitchenTeamId().length() + "。");
        }

        if (deliveInfo.getMealDate() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealDate(就餐日期)]属性不能为空。");
        }

        if (deliveInfo.getWeek() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[week(周几)]属性不能为空。");
        }

        if (deliveInfo.getMealTypeId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealTypeId(餐别ID)]属性不能为空。");
        }

        if (deliveInfo.getMealTypeId() != null && deliveInfo.getMealTypeId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealTypeId(餐别ID)]属性超长，最大允许32，实际为" + deliveInfo.getMealTypeId().length() + "。");
        }

        if (deliveInfo.getMealTypeName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealTypeName(餐别名称)]属性不能为空。");
        }

        if (deliveInfo.getMealTypeName() != null && deliveInfo.getMealTypeName().length() > 40) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealTypeName(餐别名称)]属性超长，最大允许40，实际为" + deliveInfo.getMealTypeName().length() + "。");
        }

        if (deliveInfo.getQuantity() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[quantity(数量)]属性不能为空。");
        }

        if (deliveInfo.getQuantityDesc() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[quantityDesc(数量描述)]属性不能为空。");
        }

        if (deliveInfo.getQuantityDesc() != null && deliveInfo.getQuantityDesc().length() > 300) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[quantityDesc(数量描述)]属性超长，最大允许300，实际为" + deliveInfo.getQuantityDesc().length() + "。");
        }

        if (deliveInfo.getDeliveAddr() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveAddr(配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name)]属性不能为空。");
        }

        if (deliveInfo.getDeliveAddr() != null && deliveInfo.getDeliveAddr().length() > 100) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveAddr(配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name)]属性超长，最大允许100，实际为" + deliveInfo.getDeliveAddr().length() + "。");
        }

        if (deliveInfo.getContactPerson() != null && deliveInfo.getContactPerson().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[contactPerson(联系人)]属性超长，最大允许30，实际为" + deliveInfo.getContactPerson().length() + "。");
        }

        if (deliveInfo.getContactMobile() != null && deliveInfo.getContactMobile().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[contactMobile(联系手机)]属性超长，最大允许30，实际为" + deliveInfo.getContactMobile().length() + "。");
        }
    }

    /**
     * 检查[创建信息]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param createInfo 创建信息
     */
    private static void checkComponentProperties(String compPropertyName, _CreateInfo createInfo) {

        if (createInfo.getCreateTime() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createTime(创建时间)]属性不能为空。");
        }

        if (createInfo.getCreateUserId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createUserId(创建操作员id)]属性不能为空。");
        }

        if (createInfo.getCreateUserId() != null && createInfo.getCreateUserId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createUserId(创建操作员id)]属性超长，最大允许32，实际为" + createInfo.getCreateUserId().length() + "。");
        }

        if (createInfo.getCreateUserName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createUserName(创建操作员姓名)]属性不能为空。");
        }

        if (createInfo.getCreateUserName() != null && createInfo.getCreateUserName().length() > 50) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createUserName(创建操作员姓名)]属性超长，最大允许50，实际为" + createInfo.getCreateUserName().length() + "。");
        }
    }

    /**
     * 检查[上次状态]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param lastState 上次状态
     */
    private static void checkComponentProperties(String compPropertyName, _LastState lastState) {

        if (lastState.getLastState() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastState(最后状态，完成时ID)]属性不能为空。");
        }

        if (lastState.getLastState() != null && lastState.getLastState().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastState(最后状态，完成时ID)]属性超长，最大允许30，实际为" + lastState.getLastState().length() + "。");
        }

        if (lastState.getLastTime() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastTime(最新完成时间)]属性不能为空。");
        }

        if (lastState.getLastUserId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastUserId(最新完成操作员id)]属性不能为空。");
        }

        if (lastState.getLastUserId() != null && lastState.getLastUserId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastUserId(最新完成操作员id)]属性超长，最大允许32，实际为" + lastState.getLastUserId().length() + "。");
        }

        if (lastState.getLastNickname() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastNickname(最新完成操作员name)]属性不能为空。");
        }

        if (lastState.getLastNickname() != null && lastState.getLastNickname().length() > 40) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastNickname(最新完成操作员name)]属性超长，最大允许40，实际为" + lastState.getLastNickname().length() + "。");
        }

        if (lastState.getLastDesc() != null && lastState.getLastDesc().length() > 256) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastDesc(流程备注，如为退单，填退单原因。)]属性超长，最大允许256，实际为" + lastState.getLastDesc().length() + "。");
        }
    }

    /**
     * 检查[下一环节]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param nextNode 下一环节
     */
    private static void checkComponentProperties(String compPropertyName, _NextNode nextNode) {

        if (nextNode.getNextNodeId() != null && nextNode.getNextNodeId().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[nextNodeId(下一环节 常量，和环节状态、备注同时更新)]属性超长，最大允许30，实际为" + nextNode.getNextNodeId().length() + "。");
        }

        if (nextNode.getNextNodeContent() != null && nextNode.getNextNodeContent().length() > 300) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[nextNodeContent(下一环节工作内容)]属性超长，最大允许300，实际为" + nextNode.getNextNodeContent().length() + "。");
        }
    }

    /**
     * 检查[完成情况]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param completeInfo 完成情况
     */
    private static void checkComponentProperties(String compPropertyName, _CompleteInfo completeInfo) {

        if (completeInfo.getIsComplete() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[isComplete(是否已完成？  Y/N)]属性不能为空。");
        }

        if (completeInfo.getCompleteState() != null && completeInfo.getCompleteState().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[completeState(完成状态  SUCCESS  成功  FAIL 失败（取消）)]属性超长，最大允许30，实际为" + completeInfo.getCompleteState().length() + "。");
        }

        if (completeInfo.getFailReasonName() != null && completeInfo.getFailReasonName().length() > 50) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[failReasonName(失败原因名称  常量  客户取消、改派)]属性超长，最大允许50，实际为" + completeInfo.getFailReasonName().length() + "。");
        }

        if (completeInfo.getCompleteUserId() != null && completeInfo.getCompleteUserId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[completeUserId(完成操作员工号id)]属性超长，最大允许32，实际为" + completeInfo.getCompleteUserId().length() + "。");
        }

        if (completeInfo.getCompleteNickname() != null && completeInfo.getCompleteNickname().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[completeNickname(完成操作员姓名)]属性超长，最大允许30，实际为" + completeInfo.getCompleteNickname().length() + "。");
        }

        if (completeInfo.getCompleteDesc() != null && completeInfo.getCompleteDesc().length() > 256) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[completeDesc(完成备注)]属性超长，最大允许256，实际为" + completeInfo.getCompleteDesc().length() + "。");
        }
    }

    // ---------- _DeliveInfo组件定义
    /**
     * [组件类] 配送信息。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _DeliveInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 客户所属的工作圈id */
        protected final String circleId;

        /** [不可空] 配送方式  助餐点 SITE  到户上门  HOME */
        protected final String deliveType;

        /** [不可空] 配送地点id */
        protected final String deliveSiteId;

        /** [不可空] 配送地点名称  当 fdelive_type = HOME 填 faddress */
        protected final String deliveSiteName;

        /** [不可空] 厨房圈id */
        protected final String kitchenCircleId;

        /** [不可空] 厨房teamid */
        protected final String kitchenTeamId;

        /** [不可空] 就餐日期 */
        protected final java.util.Date mealDate;

        /** [不可空] 周几 */
        protected final Integer week;

        /** [不可空] 餐别ID */
        protected final String mealTypeId;

        /** [不可空] 餐别名称 */
        protected final String mealTypeName;

        /** [不可空] 数量 */
        protected final Integer quantity;

        /** [不可空] 数量描述 */
        protected final String quantityDesc;

        /** [不可空] 配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name */
        protected final String deliveAddr;

        /** [可空] 联系人 */
        protected final String contactPerson;

        /** [可空] 联系手机 */
        protected final String contactMobile;

        // _DeliveInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _DeliveInfo() {
            circleId = null;
            deliveType = null;
            deliveSiteId = null;
            deliveSiteName = null;
            kitchenCircleId = null;
            kitchenTeamId = null;
            mealDate = null;
            week = null;
            mealTypeId = null;
            mealTypeName = null;
            quantity = null;
            quantityDesc = null;
            deliveAddr = null;
            contactPerson = null;
            contactMobile = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _DeliveInfo(_DeliveInfo copy) {
            this( copy.circleId, copy.deliveType, copy.deliveSiteId, copy.deliveSiteName, copy.kitchenCircleId, copy.kitchenTeamId, copy.mealDate, copy.week, copy.mealTypeId, copy.mealTypeName, copy.quantity, copy.quantityDesc, copy.deliveAddr, copy.contactPerson, copy.contactMobile);
        }

        /**
         * 完整构造函数。
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
        protected _DeliveInfo(String circleId, String deliveType, String deliveSiteId, String deliveSiteName, String kitchenCircleId, String kitchenTeamId, java.util.Date mealDate, Integer week, String mealTypeId, String mealTypeName, Integer quantity, String quantityDesc, String deliveAddr, String contactPerson, String contactMobile) {
            this.circleId = SafeCopier.copy(circleId);
            this.deliveType = SafeCopier.copy(deliveType);
            this.deliveSiteId = SafeCopier.copy(deliveSiteId);
            this.deliveSiteName = SafeCopier.copy(deliveSiteName);
            this.kitchenCircleId = SafeCopier.copy(kitchenCircleId);
            this.kitchenTeamId = SafeCopier.copy(kitchenTeamId);
            this.mealDate = SafeCopier.copy(mealDate);
            this.week = SafeCopier.copy(week);
            this.mealTypeId = SafeCopier.copy(mealTypeId);
            this.mealTypeName = SafeCopier.copy(mealTypeName);
            this.quantity = SafeCopier.copy(quantity);
            this.quantityDesc = SafeCopier.copy(quantityDesc);
            this.deliveAddr = SafeCopier.copy(deliveAddr);
            this.contactPerson = SafeCopier.copy(contactPerson);
            this.contactMobile = SafeCopier.copy(contactMobile);
        }


        // _DeliveInfo属性的getter/setter


        /** @return [不可空] 客户所属的工作圈id */
        public String getCircleId() {
            return SafeCopier.copy(circleId);
        }

        /** @return [不可空] 配送方式  助餐点 SITE  到户上门  HOME */
        public String getDeliveType() {
            return SafeCopier.copy(deliveType);
        }

        /** @return [不可空] 配送地点id */
        public String getDeliveSiteId() {
            return SafeCopier.copy(deliveSiteId);
        }

        /** @return [不可空] 配送地点名称  当 fdelive_type = HOME 填 faddress */
        public String getDeliveSiteName() {
            return SafeCopier.copy(deliveSiteName);
        }

        /** @return [不可空] 厨房圈id */
        public String getKitchenCircleId() {
            return SafeCopier.copy(kitchenCircleId);
        }

        /** @return [不可空] 厨房teamid */
        public String getKitchenTeamId() {
            return SafeCopier.copy(kitchenTeamId);
        }

        /** @return [不可空] 就餐日期 */
        public java.util.Date getMealDate() {
            return SafeCopier.copy(mealDate);
        }

        /** @return [不可空] 周几 */
        public Integer getWeek() {
            return SafeCopier.copy(week);
        }

        /** @return [不可空] 餐别ID */
        public String getMealTypeId() {
            return SafeCopier.copy(mealTypeId);
        }

        /** @return [不可空] 餐别名称 */
        public String getMealTypeName() {
            return SafeCopier.copy(mealTypeName);
        }

        /** @return [不可空] 数量 */
        public Integer getQuantity() {
            return SafeCopier.copy(quantity);
        }

        /** @return [不可空] 数量描述 */
        public String getQuantityDesc() {
            return SafeCopier.copy(quantityDesc);
        }

        /** @return [不可空] 配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name */
        public String getDeliveAddr() {
            return SafeCopier.copy(deliveAddr);
        }

        /** @return [可空] 联系人 */
        public String getContactPerson() {
            return SafeCopier.copy(contactPerson);
        }

        /** @return [可空] 联系手机 */
        public String getContactMobile() {
            return SafeCopier.copy(contactMobile);
        }

        // _DeliveInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(circleId);
            builder.append(deliveType);
            builder.append(deliveSiteId);
            builder.append(deliveSiteName);
            builder.append(kitchenCircleId);
            builder.append(kitchenTeamId);
            builder.append(mealDate);
            builder.append(week);
            builder.append(mealTypeId);
            builder.append(mealTypeName);
            builder.append(quantity);
            builder.append(quantityDesc);
            builder.append(deliveAddr);
            builder.append(contactPerson);
            builder.append(contactMobile);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _DeliveInfo other = (_DeliveInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(circleId, other.circleId);
            builder.append(deliveType, other.deliveType);
            builder.append(deliveSiteId, other.deliveSiteId);
            builder.append(deliveSiteName, other.deliveSiteName);
            builder.append(kitchenCircleId, other.kitchenCircleId);
            builder.append(kitchenTeamId, other.kitchenTeamId);
            builder.append(mealDate, other.mealDate);
            builder.append(week, other.week);
            builder.append(mealTypeId, other.mealTypeId);
            builder.append(mealTypeName, other.mealTypeName);
            builder.append(quantity, other.quantity);
            builder.append(quantityDesc, other.quantityDesc);
            builder.append(deliveAddr, other.deliveAddr);
            builder.append(contactPerson, other.contactPerson);
            builder.append(contactMobile, other.contactMobile);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("circleId", circleId);
            builder.append("deliveType", deliveType);
            builder.append("deliveSiteId", deliveSiteId);
            builder.append("deliveSiteName", deliveSiteName);
            builder.append("kitchenCircleId", kitchenCircleId);
            builder.append("kitchenTeamId", kitchenTeamId);
            builder.append("mealDate", mealDate);
            builder.append("week", week);
            builder.append("mealTypeId", mealTypeId);
            builder.append("mealTypeName", mealTypeName);
            builder.append("quantity", quantity);
            builder.append("quantityDesc", quantityDesc);
            builder.append("deliveAddr", deliveAddr);
            builder.append("contactPerson", contactPerson);
            builder.append("contactMobile", contactMobile);
            return builder.toString();
        }

    }    // _DeliveInfo

    // ---------- _CreateInfo组件定义
    /**
     * [组件类] 创建新。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _CreateInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 创建时间 */
        protected final java.util.Date createTime;

        /** [不可空] 创建操作员id */
        protected final String createUserId;

        /** [不可空] 创建操作员姓名 */
        protected final String createUserName;

        // _CreateInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _CreateInfo() {
            createTime = null;
            createUserId = null;
            createUserName = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _CreateInfo(_CreateInfo copy) {
            this( copy.createTime, copy.createUserId, copy.createUserName);
        }

        /**
         * 完整构造函数。
         *
         * @param createTime [不可空] 创建时间
         * @param createUserId [不可空] 创建操作员id
         * @param createUserName [不可空] 创建操作员姓名
         */
        protected _CreateInfo(java.util.Date createTime, String createUserId, String createUserName) {
            this.createTime = SafeCopier.copy(createTime);
            this.createUserId = SafeCopier.copy(createUserId);
            this.createUserName = SafeCopier.copy(createUserName);
        }


        // _CreateInfo属性的getter/setter


        /** @return [不可空] 创建时间 */
        public java.util.Date getCreateTime() {
            return SafeCopier.copy(createTime);
        }

        /** @return [不可空] 创建操作员id */
        public String getCreateUserId() {
            return SafeCopier.copy(createUserId);
        }

        /** @return [不可空] 创建操作员姓名 */
        public String getCreateUserName() {
            return SafeCopier.copy(createUserName);
        }

        // _CreateInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(createTime);
            builder.append(createUserId);
            builder.append(createUserName);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _CreateInfo other = (_CreateInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(createTime, other.createTime);
            builder.append(createUserId, other.createUserId);
            builder.append(createUserName, other.createUserName);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("createTime", createTime);
            builder.append("createUserId", createUserId);
            builder.append("createUserName", createUserName);
            return builder.toString();
        }

    }    // _CreateInfo

    // ---------- _LastState组件定义
    /**
     * [组件类] 上次状态。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _LastState extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 最后状态，完成时ID */
        protected final String lastState;

        /** [不可空] 最新完成时间 */
        protected final java.util.Date lastTime;

        /** [不可空] 最新完成操作员id */
        protected final String lastUserId;

        /** [不可空] 最新完成操作员name */
        protected final String lastNickname;

        /** [可空] 流程备注，如为退单，填退单原因。 */
        protected final String lastDesc;

        // _LastState的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _LastState() {
            lastState = null;
            lastTime = null;
            lastUserId = null;
            lastNickname = null;
            lastDesc = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _LastState(_LastState copy) {
            this( copy.lastState, copy.lastTime, copy.lastUserId, copy.lastNickname, copy.lastDesc);
        }

        /**
         * 完整构造函数。
         *
         * @param lastState [不可空] 最后状态，完成时ID
         * @param lastTime [不可空] 最新完成时间
         * @param lastUserId [不可空] 最新完成操作员id
         * @param lastNickname [不可空] 最新完成操作员name
         * @param lastDesc [可空] 流程备注，如为退单，填退单原因。
         */
        protected _LastState(String lastState, java.util.Date lastTime, String lastUserId, String lastNickname, String lastDesc) {
            this.lastState = SafeCopier.copy(lastState);
            this.lastTime = SafeCopier.copy(lastTime);
            this.lastUserId = SafeCopier.copy(lastUserId);
            this.lastNickname = SafeCopier.copy(lastNickname);
            this.lastDesc = SafeCopier.copy(lastDesc);
        }


        // _LastState属性的getter/setter


        /** @return [不可空] 最后状态，完成时ID */
        public String getLastState() {
            return SafeCopier.copy(lastState);
        }

        /** @return [不可空] 最新完成时间 */
        public java.util.Date getLastTime() {
            return SafeCopier.copy(lastTime);
        }

        /** @return [不可空] 最新完成操作员id */
        public String getLastUserId() {
            return SafeCopier.copy(lastUserId);
        }

        /** @return [不可空] 最新完成操作员name */
        public String getLastNickname() {
            return SafeCopier.copy(lastNickname);
        }

        /** @return [可空] 流程备注，如为退单，填退单原因。 */
        public String getLastDesc() {
            return SafeCopier.copy(lastDesc);
        }

        // _LastState组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(lastState);
            builder.append(lastTime);
            builder.append(lastUserId);
            builder.append(lastNickname);
            builder.append(lastDesc);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _LastState other = (_LastState) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(lastState, other.lastState);
            builder.append(lastTime, other.lastTime);
            builder.append(lastUserId, other.lastUserId);
            builder.append(lastNickname, other.lastNickname);
            builder.append(lastDesc, other.lastDesc);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("lastState", lastState);
            builder.append("lastTime", lastTime);
            builder.append("lastUserId", lastUserId);
            builder.append("lastNickname", lastNickname);
            builder.append("lastDesc", lastDesc);
            return builder.toString();
        }

    }    // _LastState

    // ---------- _NextNode组件定义
    /**
     * [组件类] 下一环节。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _NextNode extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [可空] 下一环节 常量，和环节状态、备注同时更新 */
        protected final String nextNodeId;

        /** [可空] 下一环节工作内容 */
        protected final String nextNodeContent;

        // _NextNode的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _NextNode() {
            nextNodeId = null;
            nextNodeContent = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _NextNode(_NextNode copy) {
            this( copy.nextNodeId, copy.nextNodeContent);
        }

        /**
         * 完整构造函数。
         *
         * @param nextNodeId [可空] 下一环节 常量，和环节状态、备注同时更新
         * @param nextNodeContent [可空] 下一环节工作内容
         */
        protected _NextNode(String nextNodeId, String nextNodeContent) {
            this.nextNodeId = SafeCopier.copy(nextNodeId);
            this.nextNodeContent = SafeCopier.copy(nextNodeContent);
        }


        // _NextNode属性的getter/setter


        /** @return [可空] 下一环节 常量，和环节状态、备注同时更新 */
        public String getNextNodeId() {
            return SafeCopier.copy(nextNodeId);
        }

        /** @return [可空] 下一环节工作内容 */
        public String getNextNodeContent() {
            return SafeCopier.copy(nextNodeContent);
        }

        // _NextNode组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(nextNodeId);
            builder.append(nextNodeContent);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _NextNode other = (_NextNode) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(nextNodeId, other.nextNodeId);
            builder.append(nextNodeContent, other.nextNodeContent);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("nextNodeId", nextNodeId);
            builder.append("nextNodeContent", nextNodeContent);
            return builder.toString();
        }

    }    // _NextNode

    // ---------- _CompleteInfo组件定义
    /**
     * [组件类] 完成情况。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _CompleteInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 是否已完成？  Y/N */
        protected final Boolean isComplete;

        /** [可空] 完成状态  SUCCESS  成功  FAIL 失败（取消） */
        protected final String completeState;

        /** [可空] 失败原因名称  常量  客户取消、改派 */
        protected final String failReasonName;

        /** [可空] 完成时间 */
        protected final java.util.Date completeTime;

        /** [可空] 完成操作员工号id */
        protected final String completeUserId;

        /** [可空] 完成操作员姓名 */
        protected final String completeNickname;

        /** [可空] 完成备注 */
        protected final String completeDesc;

        // _CompleteInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _CompleteInfo() {
            isComplete = false;
            completeState = null;
            failReasonName = null;
            completeTime = null;
            completeUserId = null;
            completeNickname = null;
            completeDesc = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _CompleteInfo(_CompleteInfo copy) {
            this( copy.isComplete, copy.completeState, copy.failReasonName, copy.completeTime, copy.completeUserId, copy.completeNickname, copy.completeDesc);
        }

        /**
         * 完整构造函数。
         *
         * @param isComplete [不可空] 是否已完成？  Y/N
         * @param completeState [可空] 完成状态  SUCCESS  成功  FAIL 失败（取消）
         * @param failReasonName [可空] 失败原因名称  常量  客户取消、改派
         * @param completeTime [可空] 完成时间
         * @param completeUserId [可空] 完成操作员工号id
         * @param completeNickname [可空] 完成操作员姓名
         * @param completeDesc [可空] 完成备注
         */
        protected _CompleteInfo(Boolean isComplete, String completeState, String failReasonName, java.util.Date completeTime, String completeUserId, String completeNickname, String completeDesc) {
            this.isComplete = SafeCopier.copy(isComplete);
            this.completeState = SafeCopier.copy(completeState);
            this.failReasonName = SafeCopier.copy(failReasonName);
            this.completeTime = SafeCopier.copy(completeTime);
            this.completeUserId = SafeCopier.copy(completeUserId);
            this.completeNickname = SafeCopier.copy(completeNickname);
            this.completeDesc = SafeCopier.copy(completeDesc);
        }


        // _CompleteInfo属性的getter/setter


        /** @return [不可空] 是否已完成？  Y/N */
        public Boolean getIsComplete() {
            return SafeCopier.copy(isComplete);
        }

        /** @return [可空] 完成状态  SUCCESS  成功  FAIL 失败（取消） */
        public String getCompleteState() {
            return SafeCopier.copy(completeState);
        }

        /** @return [可空] 失败原因名称  常量  客户取消、改派 */
        public String getFailReasonName() {
            return SafeCopier.copy(failReasonName);
        }

        /** @return [可空] 完成时间 */
        public java.util.Date getCompleteTime() {
            return SafeCopier.copy(completeTime);
        }

        /** @return [可空] 完成操作员工号id */
        public String getCompleteUserId() {
            return SafeCopier.copy(completeUserId);
        }

        /** @return [可空] 完成操作员姓名 */
        public String getCompleteNickname() {
            return SafeCopier.copy(completeNickname);
        }

        /** @return [可空] 完成备注 */
        public String getCompleteDesc() {
            return SafeCopier.copy(completeDesc);
        }

        // _CompleteInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(isComplete);
            builder.append(completeState);
            builder.append(failReasonName);
            builder.append(completeTime);
            builder.append(completeUserId);
            builder.append(completeNickname);
            builder.append(completeDesc);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _CompleteInfo other = (_CompleteInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(isComplete, other.isComplete);
            builder.append(completeState, other.completeState);
            builder.append(failReasonName, other.failReasonName);
            builder.append(completeTime, other.completeTime);
            builder.append(completeUserId, other.completeUserId);
            builder.append(completeNickname, other.completeNickname);
            builder.append(completeDesc, other.completeDesc);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("isComplete", isComplete);
            builder.append("completeState", completeState);
            builder.append("failReasonName", failReasonName);
            builder.append("completeTime", completeTime);
            builder.append("completeUserId", completeUserId);
            builder.append("completeNickname", completeNickname);
            builder.append("completeDesc", completeDesc);
            return builder.toString();
        }

    }    // _CompleteInfo

}
