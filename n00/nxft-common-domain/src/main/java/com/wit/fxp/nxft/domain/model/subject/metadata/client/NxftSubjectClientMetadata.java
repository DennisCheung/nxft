package com.wit.fxp.nxft.domain.model.subject.metadata.client;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.client.AbstractEntityClientMetadata;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.ObjectTree;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;

// CHECKSTYLE:OFF

/**
 * 客户端元数据，用于获取非叶子节点。通常在Facade中调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0
 *
 * @param <T>
 */
public class NxftSubjectClientMetadata<T extends Entity> extends AbstractEntityClientMetadata<T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmdc.template
     */

    // constructor
    private NxftSubjectClientMetadata(Class<T> rootClass) {
        super(rootClass);
    }

    // constructor
    public NxftSubjectClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
        super(ot, node);
    }

    /**
     * 创建客户端的根元数据
     *
     * @return 作为根的[NxftSubject]元数据
     */
    public static NxftSubjectClientMetadata<NxftSubject> root() {
        return new NxftSubjectClientMetadata<NxftSubject>(NxftSubject.class);
    }

    /**
     * @return [联系电话]属性名
     */
    public String contactPhone() {
        return getNode().isRoot()
                ? "contactPhone"
                : getNode().getPath().toPropertyPath() + ".contactPhone";
    }

    /**
     * @return [行政区域ID]属性名
     */
    public String regionId() {
        return getNode().isRoot()
                ? "regionId"
                : getNode().getPath().toPropertyPath() + ".regionId";
    }

    /**
     * @return [行政区域名称]属性名
     */
    public String regionName() {
        return getNode().isRoot()
                ? "regionName"
                : getNode().getPath().toPropertyPath() + ".regionName";
    }

    /**
     * @return [详细地址]属性名
     */
    public String address() {
        return getNode().isRoot()
                ? "address"
                : getNode().getPath().toPropertyPath() + ".address";
    }

    /**
     * @return [是否本地户籍（本镇）Y/N]属性名
     */
    public String isNative() {
        return getNode().isRoot()
                ? "isNative"
                : getNode().getPath().toPropertyPath() + ".isNative";
    }

    /**
     * @return [居住情况，多选，用逗号分隔]属性名
     */
    public String livingCondiName() {
        return getNode().isRoot()
                ? "livingCondiName"
                : getNode().getPath().toPropertyPath() + ".livingCondiName";
    }

    /**
     * @return [联系人关系ID]属性名
     */
    public String familyRelationId() {
        return getNode().isRoot()
                ? "familyRelationId"
                : getNode().getPath().toPropertyPath() + ".familyRelationId";
    }

    /**
     * @return [联系人关系name]属性名
     */
    public String familyRelationName() {
        return getNode().isRoot()
                ? "familyRelationName"
                : getNode().getPath().toPropertyPath() + ".familyRelationName";
    }

    /**
     * @return [是否属于政府扶助类型]属性名
     */
    public String isGovHelp() {
        return getNode().isRoot()
                ? "isGovHelp"
                : getNode().getPath().toPropertyPath() + ".isGovHelp";
    }

    /**
     * @return [政府扶助类型id]属性名
     */
    public String govHelpId() {
        return getNode().isRoot()
                ? "govHelpId"
                : getNode().getPath().toPropertyPath() + ".govHelpId";
    }

    /**
     * @return [政府扶助类型中文名称]属性名
     */
    public String govHelpName() {
        return getNode().isRoot()
                ? "govHelpName"
                : getNode().getPath().toPropertyPath() + ".govHelpName";
    }

    /**
     * @return [是否有食物过敏]属性名
     */
    public String haveFoodAllergy() {
        return getNode().isRoot()
                ? "haveFoodAllergy"
                : getNode().getPath().toPropertyPath() + ".haveFoodAllergy";
    }

    /**
     * @return [食物过敏]属性名
     */
    public String foodAllergy() {
        return getNode().isRoot()
                ? "foodAllergy"
                : getNode().getPath().toPropertyPath() + ".foodAllergy";
    }

    /**
     * @return [对象食物禁忌，名称逗号分隔]属性名
     */
    public String subjectFoodProhibit() {
        return getNode().isRoot()
                ? "subjectFoodProhibit"
                : getNode().getPath().toPropertyPath() + ".subjectFoodProhibit";
    }

    /**
     * @return [客户信息]属性的操作符。
     */
    public PersonInfoClientMetadata<T> personInfo() {
        getNode().addPath("personInfo");

        return new PersonInfoClientMetadata<T>(getObjectTree(), getNode().getChild("personInfo"));
    }

    /**
     * @return [客户扩展信息]属性的操作符。
     */
    public SubjectInfoClientMetadata<T> subjectInfo() {
        getNode().addPath("subjectInfo");

        return new SubjectInfoClientMetadata<T>(getObjectTree(), getNode().getChild("subjectInfo"));
    }

    /**
     * @return [创建信息]属性的操作符。
     */
    public CreateInfoClientMetadata<T> createInfo() {
        getNode().addPath("createInfo");

        return new CreateInfoClientMetadata<T>(getObjectTree(), getNode().getChild("createInfo"));
    }

    /**
     * @return [注销信息]属性的操作符。
     */
    public CancelInfoClientMetadata<T> cancelInfo() {
        getNode().addPath("cancelInfo");

        return new CancelInfoClientMetadata<T>(getObjectTree(), getNode().getChild("cancelInfo"));
    }

    /**
     * @return [对象常见病]对象的客户端元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.client.NxftSubjectDiseaseClientMetadata<T> nxftSubjectDiseaseSet() {
        getNode().addPath("nxftSubjectDiseaseSet");

        return new com.wit.fxp.nxft.domain.model.subject.metadata.client.NxftSubjectDiseaseClientMetadata<T>(this.getObjectTree(), getNode().getChild("nxftSubjectDiseaseSet"));
    }

    /**
     * @return [客户禁忌食物集合]对象的客户端元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.client.NxftSubjectFoodProhibitClientMetadata<T> nxftSubjectFoodProhibitSet() {
        getNode().addPath("nxftSubjectFoodProhibitSet");

        return new com.wit.fxp.nxft.domain.model.subject.metadata.client.NxftSubjectFoodProhibitClientMetadata<T>(this.getObjectTree(), getNode().getChild("nxftSubjectFoodProhibitSet"));
    }

    /**
     * @return [客户居住情况集合]对象的客户端元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.client.NxftSubjectLivingCondiClientMetadata<T> nxftSubjectLivingCondiSet() {
        getNode().addPath("nxftSubjectLivingCondiSet");

        return new com.wit.fxp.nxft.domain.model.subject.metadata.client.NxftSubjectLivingCondiClientMetadata<T>(this.getObjectTree(), getNode().getChild("nxftSubjectLivingCondiSet"));
    }

    /**
     * {@link NxftSubject#getPersonInfo() NxftSubject.personInfo}的元数据。
     */
    public static class PersonInfoClientMetadata<T extends Entity> extends com.benewit.entity.metadata.client.AbstractClientMetadata<T> {

        /**
         * 创建{@link PersonInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public PersonInfoClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
            super(ot, node);
        }

        /**
         * @return [客户ID]的属性名。
         */
        public String personId() {
            return getNode().getPath().toPropertyPath() + ".personId";
        }

        /**
         * @return [姓名]的属性名。
         */
        public String subjectName() {
            return getNode().getPath().toPropertyPath() + ".subjectName";
        }

        /**
         * @return [性别id     fxp.p_sex 字典]的属性名。
         */
        public String sexId() {
            return getNode().getPath().toPropertyPath() + ".sexId";
        }

        /**
         * @return [性别name]的属性名。
         */
        public String sexName() {
            return getNode().getPath().toPropertyPath() + ".sexName";
        }

        /**
         * @return [证件类别id]的属性名。
         */
        public String idtypeId() {
            return getNode().getPath().toPropertyPath() + ".idtypeId";
        }

        /**
         * @return [证件类别中文]的属性名。
         */
        public String idtypeName() {
            return getNode().getPath().toPropertyPath() + ".idtypeName";
        }

        /**
         * @return [身份证号]的属性名。
         */
        public String idcardno() {
            return getNode().getPath().toPropertyPath() + ".idcardno";
        }

        /**
         * @return [出生日期]的属性名。
         */
        public String birthDate() {
            return getNode().getPath().toPropertyPath() + ".birthDate";
        }

        /**
         * @return [对象饮食偏好id]的属性名。
         */
        public String subjectFoodLoveId() {
            return getNode().getPath().toPropertyPath() + ".subjectFoodLoveId";
        }

        /**
         * @return [对象饮食偏好name]的属性名。
         */
        public String subjectFoodLoveName() {
            return getNode().getPath().toPropertyPath() + ".subjectFoodLoveName";
        }

        /**
         * @return [客户所属的工作圈id]的属性名。
         */
        public String circleId() {
            return getNode().getPath().toPropertyPath() + ".circleId";
        }

        /**
         * @return [进餐是否协助]的属性名。
         */
        public String isMealHelp() {
            return getNode().getPath().toPropertyPath() + ".isMealHelp";
        }

    }    // PersonInfoMetadata

    /**
     * {@link NxftSubject#getSubjectInfo() NxftSubject.subjectInfo}的元数据。
     */
    public static class SubjectInfoClientMetadata<T extends Entity> extends com.benewit.entity.metadata.client.AbstractClientMetadata<T> {

        /**
         * 创建{@link SubjectInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public SubjectInfoClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
            super(ot, node);
        }

        /**
         * @return [联系人姓名]的属性名。
         */
        public String relationName() {
            return getNode().getPath().toPropertyPath() + ".relationName";
        }

        /**
         * @return [联系人电话]的属性名。
         */
        public String relationPhone() {
            return getNode().getPath().toPropertyPath() + ".relationPhone";
        }

        /**
         * @return [对象类型id]的属性名。
         */
        public String subjectTypeId() {
            return getNode().getPath().toPropertyPath() + ".subjectTypeId";
        }

        /**
         * @return [对象类型中文名称]的属性名。
         */
        public String subjectTypeName() {
            return getNode().getPath().toPropertyPath() + ".subjectTypeName";
        }

        /**
         * @return [对象备注]的属性名。
         */
        public String subjectDesc() {
            return getNode().getPath().toPropertyPath() + ".subjectDesc";
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
         * @return [配送地点名称]的属性名。
         */
        public String deliveSiteName() {
            return getNode().getPath().toPropertyPath() + ".deliveSiteName";
        }

        /**
         * @return [配餐透支额度]的属性名。
         */
        public String overdraft() {
            return getNode().getPath().toPropertyPath() + ".overdraft";
        }

        /**
         * @return [对象所患疾病，名称逗号分隔]的属性名。
         */
        public String subjectDisease() {
            return getNode().getPath().toPropertyPath() + ".subjectDisease";
        }

        /**
         * @return [饭盒编号]的属性名。
         */
        public String lunchBoxNo() {
            return getNode().getPath().toPropertyPath() + ".lunchBoxNo";
        }

    }    // SubjectInfoMetadata

    /**
     * {@link NxftSubject#getCreateInfo() NxftSubject.createInfo}的元数据。
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
         * @return [创建工作圈id]的属性名。
         */
        public String createCircleId() {
            return getNode().getPath().toPropertyPath() + ".createCircleId";
        }

        /**
         * @return [创建工作组id]的属性名。
         */
        public String createTeamId() {
            return getNode().getPath().toPropertyPath() + ".createTeamId";
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
     * {@link NxftSubject#getCancelInfo() NxftSubject.cancelInfo}的元数据。
     */
    public static class CancelInfoClientMetadata<T extends Entity> extends com.benewit.entity.metadata.client.AbstractClientMetadata<T> {

        /**
         * 创建{@link CancelInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public CancelInfoClientMetadata(ObjectTree<T> ot, ObjectNode<T> node) {
            super(ot, node);
        }

        /**
         * @return [是否被注销]的属性名。
         */
        public String isCancel() {
            return getNode().getPath().toPropertyPath() + ".isCancel";
        }

        /**
         * @return [注销原因]的属性名。
         */
        public String cancelReason() {
            return getNode().getPath().toPropertyPath() + ".cancelReason";
        }

        /**
         * @return [注销机器时间]的属性名。
         */
        public String cancelDate() {
            return getNode().getPath().toPropertyPath() + ".cancelDate";
        }

        /**
         * @return [注销操作员id]的属性名。
         */
        public String cancelUserId() {
            return getNode().getPath().toPropertyPath() + ".cancelUserId";
        }

        /**
         * @return [注销操作员姓名]的属性名。
         */
        public String cancelUserName() {
            return getNode().getPath().toPropertyPath() + ".cancelUserName";
        }

    }    // CancelInfoMetadata
}
