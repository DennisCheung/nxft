package com.wit.fxp.nxft.domain.model.meal.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.meal.MealSchenote;

// CHECKSTYLE:OFF

/**
 * 服务端[菜谱安排单]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class MealSchenoteMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private MealSchenoteMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public MealSchenoteMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[MealSchenote]元数据
     */
    public static MealSchenoteMetadata<MealSchenote> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[MealSchenote]元数据
     */
    public static MealSchenoteMetadata<MealSchenote> root(String rootAlias) {
        return new MealSchenoteMetadata<MealSchenote>(MealSchenote.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /** @return [排班信息]属性的操作符 */
    public ScheInfoMetadata<T> scheInfo() {
        return new ScheInfoMetadata<T>(getNode());
    }

    /** @return [创建信息]属性的操作符 */
    public CreateInfoMetadata<T> createInfo() {
        return new CreateInfoMetadata<T>(getNode());
    }

    /** @return [发布信息]属性的操作符 */
    public PublishInfoMetadata<T> publishInfo() {
        return new PublishInfoMetadata<T>(getNode());
    }

    /**
     * 内连接、延迟加载
     *
     * @return [周菜谱详情]的元数据
     */
    public com.wit.fxp.nxft.domain.model.meal.metadata.MealSchedayMetadata<T> mealSchedaySet() {
        return inner_join_mealSchedaySet();
    }

    /**
     * 内连接、延迟加载
     *
     * @return [周菜谱详情]的元数据
     */
    public com.wit.fxp.nxft.domain.model.meal.metadata.MealSchedayMetadata<T> inner_join_mealSchedaySet() {
        return inner_join_mealSchedaySet("", true);
    }

    /**
     * 内连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [周菜谱详情]的元数据
     */
    public com.wit.fxp.nxft.domain.model.meal.metadata.MealSchedayMetadata<T> inner_join_mealSchedaySet(String alias, boolean lazyLoad) {
        return mealSchedaySet(alias, com.benewit.ecctree.EccNodeConstant.INNER_JOIN, lazyLoad);
    }

    /**
     * 左外连接、延迟加载
     *
     * @return [周菜谱详情]的元数据
     */
    public com.wit.fxp.nxft.domain.model.meal.metadata.MealSchedayMetadata<T> left_outer_join_mealSchedaySet() {
        return left_outer_join_mealSchedaySet("", true);
    }

    /**
     * 左外连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [周菜谱详情]的元数据
     */
    public com.wit.fxp.nxft.domain.model.meal.metadata.MealSchedayMetadata<T> left_outer_join_mealSchedaySet(String alias, boolean lazyLoad) {
        return mealSchedaySet(alias, com.benewit.ecctree.EccNodeConstant.LEFT_OUTER_JOIN, lazyLoad);
    }

    /**
     * @param join 连接方式
     * @param lazyLoad 是否延迟加载？
     * @return [周菜谱详情]的元数据
     */
    private com.wit.fxp.nxft.domain.model.meal.metadata.MealSchedayMetadata<T> mealSchedaySet(String alias, String join, boolean lazyLoad) {
        String segment = getNode().getTree().getSegmentParser().formatSegment("mealSchedaySet", alias, join, !lazyLoad);
        getNode().addPath(segment);

        return new com.wit.fxp.nxft.domain.model.meal.metadata.MealSchedayMetadata<T>(getNode().getChild("mealSchedaySet"));
    }

    /**
     * {@link MealSchenote#getScheInfo() MealSchenote.scheInfo}的元数据。
     */
    public class ScheInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<MealSchenote.ScheInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link ScheInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public ScheInfoMetadata(ObjectNode<C> node) {
            super(MealSchenote.ScheInfo.class, node, "scheInfo");

            node.addPath("scheInfo");
            this.node = node.getChild("scheInfo");
        }

        /** @return [排班单备注]属性的操作符 */
        public AlgebraicVariable<String> schenoteDesc() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "schenoteDesc");
        }

        /** @return [厨房圈id]属性的操作符 */
        public AlgebraicVariable<String> kitchenCircleId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "kitchenCircleId");
        }

        /** @return [排班起始日期=上周期终止日期 + 1]属性的操作符 */
        public AlgebraicVariable<java.util.Date> beginDate() {
            return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, node, "beginDate");
        }

        /** @return [厨房teamid]属性的操作符 */
        public AlgebraicVariable<String> kitchenTeamId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "kitchenTeamId");
        }

        /** @return [排班终止日期]属性的操作符 */
        public AlgebraicVariable<java.util.Date> endDate() {
            return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, node, "endDate");
        }

        /** @return [排班周期模式 WEEK 周 MONTH 月]属性的操作符 */
        public AlgebraicVariable<String> periodModel() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "periodModel");
        }

    }    // ScheInfoMetadata

    /**
     * {@link MealSchenote#getCreateInfo() MealSchenote.createInfo}的元数据。
     */
    public class CreateInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<MealSchenote.CreateInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link CreateInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public CreateInfoMetadata(ObjectNode<C> node) {
            super(MealSchenote.CreateInfo.class, node, "createInfo");

            node.addPath("createInfo");
            this.node = node.getChild("createInfo");
        }

        /** @return [创建时间]属性的操作符 */
        public AlgebraicVariable<java.util.Date> createTime() {
            return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, node, "createTime");
        }

        /** @return [创建工号id]属性的操作符 */
        public AlgebraicVariable<String> createUserId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "createUserId");
        }

        /** @return [创建姓名]属性的操作符 */
        public AlgebraicVariable<String> createNickname() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "createNickname");
        }

    }    // CreateInfoMetadata

    /**
     * {@link MealSchenote#getPublishInfo() MealSchenote.publishInfo}的元数据。
     */
    public class PublishInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<MealSchenote.PublishInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link PublishInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public PublishInfoMetadata(ObjectNode<C> node) {
            super(MealSchenote.PublishInfo.class, node, "publishInfo");

            node.addPath("publishInfo");
            this.node = node.getChild("publishInfo");
        }

        /** @return [是否已发布？ Y/N]属性的操作符 */
        public AlgebraicVariable<Boolean> isPublished() {
            return new ObjectTreeAlgebraicVariable<Boolean>(Boolean.class, node, "isPublished");
        }

        /** @return [发布时间]属性的操作符 */
        public AlgebraicVariable<java.util.Date> publishTime() {
            return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, node, "publishTime");
        }

        /** @return [发布工号id]属性的操作符 */
        public AlgebraicVariable<String> publishUserId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "publishUserId");
        }

        /** @return [发布姓名]属性的操作符 */
        public AlgebraicVariable<String> publishNickname() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "publishNickname");
        }

    }    // PublishInfoMetadata
}
