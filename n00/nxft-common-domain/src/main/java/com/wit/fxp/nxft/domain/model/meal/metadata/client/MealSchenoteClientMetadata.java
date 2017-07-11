package com.wit.fxp.nxft.domain.model.meal.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.meal.MealSchenote;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class MealSchenoteClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private MealSchenoteClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public MealSchenoteClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[MealSchenote]元数据
     */
    public static MealSchenoteClientMetadata<MealSchenote> root() {
        return new MealSchenoteClientMetadata<MealSchenote>(MealSchenote.class);
    }

    /**
     * @return [排班信息]属性的操作符。
     */
    public ScheInfoClientMetadata<T> scheInfo() {
        getNode().addPath("scheInfo");

        return new ScheInfoClientMetadata<T>(getObjectTree(), getNode().getChild("scheInfo"));
    }

    /**
     * @return [创建信息]属性的操作符。
     */
    public CreateInfoClientMetadata<T> createInfo() {
        getNode().addPath("createInfo");

        return new CreateInfoClientMetadata<T>(getObjectTree(), getNode().getChild("createInfo"));
    }

    /**
     * @return [发布信息]属性的操作符。
     */
    public PublishInfoClientMetadata<T> publishInfo() {
        getNode().addPath("publishInfo");

        return new PublishInfoClientMetadata<T>(getObjectTree(), getNode().getChild("publishInfo"));
    }

    /**
     * @return [周菜谱详情]对象的客户端元数据
     */
    public com.wit.fxp.nxft.domain.model.meal.metadata.client.MealSchedayClientMetadata<T> mealSchedaySet() {
        getNode().addPath("mealSchedaySet");

        return new com.wit.fxp.nxft.domain.model.meal.metadata.client.MealSchedayClientMetadata<T>(this.getObjectTree(), getNode().getChild("mealSchedaySet"));
    }

    /**
     * {@link MealSchenote#getScheInfo() MealSchenote.scheInfo}的元数据。
     */
    public static class ScheInfoClientMetadata<T extends Entity> extends com.benewit.entity.metadata.client.AbstractClientMetadata<T> {

        /**
         * 创建{@link ScheInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public ScheInfoClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
            super(ot, node);
        }

        /**
         * @return [排班单备注]的属性名。
         */
        public String schenoteDesc() {
            return getNode().getPath().toPropertyPath() + ".schenoteDesc";
        }

        /**
         * @return [厨房圈id]的属性名。
         */
        public String kitchenCircleId() {
            return getNode().getPath().toPropertyPath() + ".kitchenCircleId";
        }

        /**
         * @return [排班起始日期=上周期终止日期 + 1]的属性名。
         */
        public String beginDate() {
            return getNode().getPath().toPropertyPath() + ".beginDate";
        }

        /**
         * @return [厨房teamid]的属性名。
         */
        public String kitchenTeamId() {
            return getNode().getPath().toPropertyPath() + ".kitchenTeamId";
        }

        /**
         * @return [排班终止日期]的属性名。
         */
        public String endDate() {
            return getNode().getPath().toPropertyPath() + ".endDate";
        }

        /**
         * @return [排班周期模式 WEEK 周 MONTH 月]的属性名。
         */
        public String periodModel() {
            return getNode().getPath().toPropertyPath() + ".periodModel";
        }

    }    // ScheInfoMetadata

    /**
     * {@link MealSchenote#getCreateInfo() MealSchenote.createInfo}的元数据。
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
         * @return [创建工号id]的属性名。
         */
        public String createUserId() {
            return getNode().getPath().toPropertyPath() + ".createUserId";
        }

        /**
         * @return [创建姓名]的属性名。
         */
        public String createNickname() {
            return getNode().getPath().toPropertyPath() + ".createNickname";
        }

    }    // CreateInfoMetadata

    /**
     * {@link MealSchenote#getPublishInfo() MealSchenote.publishInfo}的元数据。
     */
    public static class PublishInfoClientMetadata<T extends Entity> extends com.benewit.entity.metadata.client.AbstractClientMetadata<T> {

        /**
         * 创建{@link PublishInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public PublishInfoClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
            super(ot, node);
        }

        /**
         * @return [是否已发布？ Y/N]的属性名。
         */
        public String isPublished() {
            return getNode().getPath().toPropertyPath() + ".isPublished";
        }

        /**
         * @return [发布时间]的属性名。
         */
        public String publishTime() {
            return getNode().getPath().toPropertyPath() + ".publishTime";
        }

        /**
         * @return [发布工号id]的属性名。
         */
        public String publishUserId() {
            return getNode().getPath().toPropertyPath() + ".publishUserId";
        }

        /**
         * @return [发布姓名]的属性名。
         */
        public String publishNickname() {
            return getNode().getPath().toPropertyPath() + ".publishNickname";
        }

    }    // PublishInfoMetadata
}
