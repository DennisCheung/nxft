// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.meal.base;

import com.benewit.core.utils.SafeCopier;

/**
 * 菜谱安排单工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String schenoteId 排班单id
 * 2. [可空] String schenoteDesc 排班单备注
 * 3. [不可空] String kitchenCircleId 厨房圈id
 * 3.1. [不可空] String kitchenTeamId 厨房teamid
 * 4. [不可空] java.util.Date beginDate 排班起始日期=上周期终止日期 + 1
 * 5. [不可空] java.util.Date endDate 排班终止日期
 * 6. [不可空] String periodModel 排班周期模式 WEEK 周 MONTH 月
 * 7. [不可空] java.util.Date createTime 创建时间
 * 8. [不可空] String createUserId 创建工号id
 * 9. [不可空] String createNickname 创建姓名
 * 10. [不可空] Boolean isPublished 是否已发布？ Y/N
 * 11. [可空] java.util.Date publishTime 发布时间
 * 12. [可空] String publishUserId 发布工号id
 * 13. [可空] String publishNickname 发布姓名
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-meal/java/domain/com/wit/fxp/nxft/domain/model/meal/base/MealSchenote.html">MealSchenote代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractMealSchenote {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(_ScheInfo scheInfo, _CreateInfo createInfo, _PublishInfo publishInfo) {

        if (scheInfo != null) {
            checkComponentProperties("MealSchenote#scheInfo", scheInfo);
        }

        if (createInfo != null) {
            checkComponentProperties("MealSchenote#createInfo", createInfo);
        }

        if (publishInfo != null) {
            checkComponentProperties("MealSchenote#publishInfo", publishInfo);
        }
    }

    /**
     * 检查[排班信息]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param scheInfo 排班信息
     */
    private static void checkComponentProperties(String compPropertyName, _ScheInfo scheInfo) {

        if (scheInfo.getSchenoteDesc() != null && scheInfo.getSchenoteDesc().length() > 256) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[schenoteDesc(排班单备注)]属性超长，最大允许256，实际为" + scheInfo.getSchenoteDesc().length() + "。");
        }

        if (scheInfo.getKitchenCircleId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[kitchenCircleId(厨房圈id)]属性不能为空。");
        }

        if (scheInfo.getKitchenCircleId() != null && scheInfo.getKitchenCircleId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[kitchenCircleId(厨房圈id)]属性超长，最大允许32，实际为" + scheInfo.getKitchenCircleId().length() + "。");
        }

        if (scheInfo.getBeginDate() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[beginDate(排班起始日期=上周期终止日期 + 1)]属性不能为空。");
        }

        if (scheInfo.getKitchenTeamId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[kitchenTeamId(厨房teamid)]属性不能为空。");
        }

        if (scheInfo.getKitchenTeamId() != null && scheInfo.getKitchenTeamId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[kitchenTeamId(厨房teamid)]属性超长，最大允许32，实际为" + scheInfo.getKitchenTeamId().length() + "。");
        }

        if (scheInfo.getEndDate() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[endDate(排班终止日期)]属性不能为空。");
        }

        if (scheInfo.getPeriodModel() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[periodModel(排班周期模式 WEEK 周 MONTH 月)]属性不能为空。");
        }

        if (scheInfo.getPeriodModel() != null && scheInfo.getPeriodModel().length() > 20) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[periodModel(排班周期模式 WEEK 周 MONTH 月)]属性超长，最大允许20，实际为" + scheInfo.getPeriodModel().length() + "。");
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
            throw new RuntimeException("[" + compPropertyName + "]组件的[createUserId(创建工号id)]属性不能为空。");
        }

        if (createInfo.getCreateUserId() != null && createInfo.getCreateUserId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createUserId(创建工号id)]属性超长，最大允许32，实际为" + createInfo.getCreateUserId().length() + "。");
        }

        if (createInfo.getCreateNickname() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createNickname(创建姓名)]属性不能为空。");
        }

        if (createInfo.getCreateNickname() != null && createInfo.getCreateNickname().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createNickname(创建姓名)]属性超长，最大允许30，实际为" + createInfo.getCreateNickname().length() + "。");
        }
    }

    /**
     * 检查[发布信息]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param publishInfo 发布信息
     */
    private static void checkComponentProperties(String compPropertyName, _PublishInfo publishInfo) {

        if (publishInfo.getIsPublished() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[isPublished(是否已发布？ Y/N)]属性不能为空。");
        }

        if (publishInfo.getPublishUserId() != null && publishInfo.getPublishUserId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[publishUserId(发布工号id)]属性超长，最大允许32，实际为" + publishInfo.getPublishUserId().length() + "。");
        }

        if (publishInfo.getPublishNickname() != null && publishInfo.getPublishNickname().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[publishNickname(发布姓名)]属性超长，最大允许30，实际为" + publishInfo.getPublishNickname().length() + "。");
        }
    }

    // ---------- _ScheInfo组件定义
    /**
     * [组件类] 排班信息。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _ScheInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [可空] 排班单备注 */
        protected final String schenoteDesc;

        /** [不可空] 厨房圈id */
        protected final String kitchenCircleId;

        /** [不可空] 排班起始日期=上周期终止日期 + 1 */
        protected final java.util.Date beginDate;

        /** [不可空] 厨房teamid */
        protected final String kitchenTeamId;

        /** [不可空] 排班终止日期 */
        protected final java.util.Date endDate;

        /** [不可空] 排班周期模式 WEEK 周 MONTH 月 */
        protected final String periodModel;

        // _ScheInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _ScheInfo() {
            schenoteDesc = null;
            kitchenCircleId = null;
            beginDate = null;
            kitchenTeamId = null;
            endDate = null;
            periodModel = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _ScheInfo(_ScheInfo copy) {
            this( copy.schenoteDesc, copy.kitchenCircleId, copy.beginDate, copy.kitchenTeamId, copy.endDate, copy.periodModel);
        }

        /**
         * 完整构造函数。
         *
         * @param schenoteDesc [可空] 排班单备注
         * @param kitchenCircleId [不可空] 厨房圈id
         * @param beginDate [不可空] 排班起始日期=上周期终止日期 + 1
         * @param kitchenTeamId [不可空] 厨房teamid
         * @param endDate [不可空] 排班终止日期
         * @param periodModel [不可空] 排班周期模式 WEEK 周 MONTH 月
         */
        protected _ScheInfo(String schenoteDesc, String kitchenCircleId, java.util.Date beginDate, String kitchenTeamId, java.util.Date endDate, String periodModel) {
            this.schenoteDesc = SafeCopier.copy(schenoteDesc);
            this.kitchenCircleId = SafeCopier.copy(kitchenCircleId);
            this.beginDate = SafeCopier.copy(beginDate);
            this.kitchenTeamId = SafeCopier.copy(kitchenTeamId);
            this.endDate = SafeCopier.copy(endDate);
            this.periodModel = SafeCopier.copy(periodModel);
        }


        // _ScheInfo属性的getter/setter


        /** @return [可空] 排班单备注 */
        public String getSchenoteDesc() {
            return SafeCopier.copy(schenoteDesc);
        }

        /** @return [不可空] 厨房圈id */
        public String getKitchenCircleId() {
            return SafeCopier.copy(kitchenCircleId);
        }

        /** @return [不可空] 排班起始日期=上周期终止日期 + 1 */
        public java.util.Date getBeginDate() {
            return SafeCopier.copy(beginDate);
        }

        /** @return [不可空] 厨房teamid */
        public String getKitchenTeamId() {
            return SafeCopier.copy(kitchenTeamId);
        }

        /** @return [不可空] 排班终止日期 */
        public java.util.Date getEndDate() {
            return SafeCopier.copy(endDate);
        }

        /** @return [不可空] 排班周期模式 WEEK 周 MONTH 月 */
        public String getPeriodModel() {
            return SafeCopier.copy(periodModel);
        }

        // _ScheInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(schenoteDesc);
            builder.append(kitchenCircleId);
            builder.append(beginDate);
            builder.append(kitchenTeamId);
            builder.append(endDate);
            builder.append(periodModel);
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

            _ScheInfo other = (_ScheInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(schenoteDesc, other.schenoteDesc);
            builder.append(kitchenCircleId, other.kitchenCircleId);
            builder.append(beginDate, other.beginDate);
            builder.append(kitchenTeamId, other.kitchenTeamId);
            builder.append(endDate, other.endDate);
            builder.append(periodModel, other.periodModel);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("schenoteDesc", schenoteDesc);
            builder.append("kitchenCircleId", kitchenCircleId);
            builder.append("beginDate", beginDate);
            builder.append("kitchenTeamId", kitchenTeamId);
            builder.append("endDate", endDate);
            builder.append("periodModel", periodModel);
            return builder.toString();
        }

    }    // _ScheInfo

    // ---------- _CreateInfo组件定义
    /**
     * [组件类] 创建信息。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _CreateInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 创建时间 */
        protected final java.util.Date createTime;

        /** [不可空] 创建工号id */
        protected final String createUserId;

        /** [不可空] 创建姓名 */
        protected final String createNickname;

        // _CreateInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _CreateInfo() {
            createTime = null;
            createUserId = null;
            createNickname = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _CreateInfo(_CreateInfo copy) {
            this( copy.createTime, copy.createUserId, copy.createNickname);
        }

        /**
         * 完整构造函数。
         *
         * @param createTime [不可空] 创建时间
         * @param createUserId [不可空] 创建工号id
         * @param createNickname [不可空] 创建姓名
         */
        protected _CreateInfo(java.util.Date createTime, String createUserId, String createNickname) {
            this.createTime = SafeCopier.copy(createTime);
            this.createUserId = SafeCopier.copy(createUserId);
            this.createNickname = SafeCopier.copy(createNickname);
        }


        // _CreateInfo属性的getter/setter


        /** @return [不可空] 创建时间 */
        public java.util.Date getCreateTime() {
            return SafeCopier.copy(createTime);
        }

        /** @return [不可空] 创建工号id */
        public String getCreateUserId() {
            return SafeCopier.copy(createUserId);
        }

        /** @return [不可空] 创建姓名 */
        public String getCreateNickname() {
            return SafeCopier.copy(createNickname);
        }

        // _CreateInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(createTime);
            builder.append(createUserId);
            builder.append(createNickname);
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
            builder.append(createNickname, other.createNickname);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("createTime", createTime);
            builder.append("createUserId", createUserId);
            builder.append("createNickname", createNickname);
            return builder.toString();
        }

    }    // _CreateInfo

    // ---------- _PublishInfo组件定义
    /**
     * [组件类] 发布信息。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _PublishInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 是否已发布？ Y/N */
        protected final Boolean isPublished;

        /** [可空] 发布时间 */
        protected final java.util.Date publishTime;

        /** [可空] 发布工号id */
        protected final String publishUserId;

        /** [可空] 发布姓名 */
        protected final String publishNickname;

        // _PublishInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _PublishInfo() {
            isPublished = false;
            publishTime = null;
            publishUserId = null;
            publishNickname = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _PublishInfo(_PublishInfo copy) {
            this( copy.isPublished, copy.publishTime, copy.publishUserId, copy.publishNickname);
        }

        /**
         * 完整构造函数。
         *
         * @param isPublished [不可空] 是否已发布？ Y/N
         * @param publishTime [可空] 发布时间
         * @param publishUserId [可空] 发布工号id
         * @param publishNickname [可空] 发布姓名
         */
        protected _PublishInfo(Boolean isPublished, java.util.Date publishTime, String publishUserId, String publishNickname) {
            this.isPublished = SafeCopier.copy(isPublished);
            this.publishTime = SafeCopier.copy(publishTime);
            this.publishUserId = SafeCopier.copy(publishUserId);
            this.publishNickname = SafeCopier.copy(publishNickname);
        }


        // _PublishInfo属性的getter/setter


        /** @return [不可空] 是否已发布？ Y/N */
        public Boolean getIsPublished() {
            return SafeCopier.copy(isPublished);
        }

        /** @return [可空] 发布时间 */
        public java.util.Date getPublishTime() {
            return SafeCopier.copy(publishTime);
        }

        /** @return [可空] 发布工号id */
        public String getPublishUserId() {
            return SafeCopier.copy(publishUserId);
        }

        /** @return [可空] 发布姓名 */
        public String getPublishNickname() {
            return SafeCopier.copy(publishNickname);
        }

        // _PublishInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(isPublished);
            builder.append(publishTime);
            builder.append(publishUserId);
            builder.append(publishNickname);
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

            _PublishInfo other = (_PublishInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(isPublished, other.isPublished);
            builder.append(publishTime, other.publishTime);
            builder.append(publishUserId, other.publishUserId);
            builder.append(publishNickname, other.publishNickname);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("isPublished", isPublished);
            builder.append("publishTime", publishTime);
            builder.append("publishUserId", publishUserId);
            builder.append("publishNickname", publishNickname);
            return builder.toString();
        }

    }    // _PublishInfo

}
