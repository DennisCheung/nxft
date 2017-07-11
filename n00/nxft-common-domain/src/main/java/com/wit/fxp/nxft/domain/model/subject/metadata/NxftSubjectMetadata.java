package com.wit.fxp.nxft.domain.model.subject.metadata;

import com.benewit.entity.Entity;
import com.benewit.entity.metadata.AbstractEntityMetadata;
import com.benewit.expression.algebra.AlgebraicVariable;
import com.benewit.objecttree.ObjectNode;
import com.benewit.objecttree.support.ObjectTreeAlgebraicVariable;

import com.wit.fxp.nxft.domain.model.subject.NxftSubject;

// CHECKSTYLE:OFF

/**
 * 服务端[配餐对象]元数据。通常在Logic或Repository层调用。
 *
 * @author Benewit Code Generator V1.0
 * @since 1.0

 * @param <T>
 */
public class NxftSubjectMetadata<T extends Entity> extends AbstractEntityMetadata<String, T> {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-entdomainmd.template
     */

    // constructor
    private NxftSubjectMetadata(Class<T> rootClass, String rootAlias) {
        super(rootClass, rootAlias);
    }

    // constructor
    public NxftSubjectMetadata(ObjectNode<T> node) {
        super(node);
    }

    /**
     * 创建服务端的根元数据，其根节点别名为{@code root}。若要用其它别名请调用
     * {@link #root(String)}方法。
     *
     * @return 作为根的[NxftSubject]元数据
     */
    public static NxftSubjectMetadata<NxftSubject> root() {
        return root("root");
    }

    /**
     * 创建服务端的根元数据。
     *
     * @param rootAlias 根节点的别名
     * @return 作为根的[NxftSubject]元数据
     */
    public static NxftSubjectMetadata<NxftSubject> root(String rootAlias) {
        return new NxftSubjectMetadata<NxftSubject>(NxftSubject.class, rootAlias);
    }

    /**
     * @return [id]属性的操作符
     */
    @Override
    public AlgebraicVariable<String> id() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "id");
    }

    /**
     * @return [联系电话]属性的操作符
     */
    public AlgebraicVariable<String> contactPhone() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "contactPhone");
    }

    /**
     * @return [行政区域ID]属性的操作符
     */
    public AlgebraicVariable<String> regionId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "regionId");
    }

    /**
     * @return [行政区域名称]属性的操作符
     */
    public AlgebraicVariable<String> regionName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "regionName");
    }

    /**
     * @return [详细地址]属性的操作符
     */
    public AlgebraicVariable<String> address() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "address");
    }

    /**
     * @return [是否本地户籍（本镇）Y/N]属性的操作符
     */
    public AlgebraicVariable<Boolean> isNative() {
        return new ObjectTreeAlgebraicVariable<Boolean>(Boolean.class, getNode(), "isNative");
    }

    /**
     * @return [居住情况，多选，用逗号分隔]属性的操作符
     */
    public AlgebraicVariable<String> livingCondiName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "livingCondiName");
    }

    /**
     * @return [联系人关系ID]属性的操作符
     */
    public AlgebraicVariable<String> familyRelationId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "familyRelationId");
    }

    /**
     * @return [联系人关系name]属性的操作符
     */
    public AlgebraicVariable<String> familyRelationName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "familyRelationName");
    }

    /**
     * @return [是否属于政府扶助类型]属性的操作符
     */
    public AlgebraicVariable<Boolean> isGovHelp() {
        return new ObjectTreeAlgebraicVariable<Boolean>(Boolean.class, getNode(), "isGovHelp");
    }

    /**
     * @return [政府扶助类型id]属性的操作符
     */
    public AlgebraicVariable<String> govHelpId() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "govHelpId");
    }

    /**
     * @return [政府扶助类型中文名称]属性的操作符
     */
    public AlgebraicVariable<String> govHelpName() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "govHelpName");
    }

    /**
     * @return [是否有食物过敏]属性的操作符
     */
    public AlgebraicVariable<Boolean> haveFoodAllergy() {
        return new ObjectTreeAlgebraicVariable<Boolean>(Boolean.class, getNode(), "haveFoodAllergy");
    }

    /**
     * @return [食物过敏]属性的操作符
     */
    public AlgebraicVariable<String> foodAllergy() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "foodAllergy");
    }

    /**
     * @return [对象食物禁忌，名称逗号分隔]属性的操作符
     */
    public AlgebraicVariable<String> subjectFoodProhibit() {
        return new ObjectTreeAlgebraicVariable<String>(String.class, getNode(), "subjectFoodProhibit");
    }

    /** @return [客户信息]属性的操作符 */
    public PersonInfoMetadata<T> personInfo() {
        return new PersonInfoMetadata<T>(getNode());
    }

    /** @return [客户扩展信息]属性的操作符 */
    public SubjectInfoMetadata<T> subjectInfo() {
        return new SubjectInfoMetadata<T>(getNode());
    }

    /** @return [创建信息]属性的操作符 */
    public CreateInfoMetadata<T> createInfo() {
        return new CreateInfoMetadata<T>(getNode());
    }

    /** @return [注销信息]属性的操作符 */
    public CancelInfoMetadata<T> cancelInfo() {
        return new CancelInfoMetadata<T>(getNode());
    }

    /**
     * 内连接、延迟加载
     *
     * @return [对象常见病]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectDiseaseMetadata<T> nxftSubjectDiseaseSet() {
        return inner_join_nxftSubjectDiseaseSet();
    }

    /**
     * 内连接、延迟加载
     *
     * @return [对象常见病]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectDiseaseMetadata<T> inner_join_nxftSubjectDiseaseSet() {
        return inner_join_nxftSubjectDiseaseSet("", true);
    }

    /**
     * 内连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [对象常见病]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectDiseaseMetadata<T> inner_join_nxftSubjectDiseaseSet(String alias, boolean lazyLoad) {
        return nxftSubjectDiseaseSet(alias, com.benewit.ecctree.EccNodeConstant.INNER_JOIN, lazyLoad);
    }

    /**
     * 左外连接、延迟加载
     *
     * @return [对象常见病]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectDiseaseMetadata<T> left_outer_join_nxftSubjectDiseaseSet() {
        return left_outer_join_nxftSubjectDiseaseSet("", true);
    }

    /**
     * 左外连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [对象常见病]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectDiseaseMetadata<T> left_outer_join_nxftSubjectDiseaseSet(String alias, boolean lazyLoad) {
        return nxftSubjectDiseaseSet(alias, com.benewit.ecctree.EccNodeConstant.LEFT_OUTER_JOIN, lazyLoad);
    }

    /**
     * @param join 连接方式
     * @param lazyLoad 是否延迟加载？
     * @return [对象常见病]的元数据
     */
    private com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectDiseaseMetadata<T> nxftSubjectDiseaseSet(String alias, String join, boolean lazyLoad) {
        String segment = getNode().getTree().getSegmentParser().formatSegment("nxftSubjectDiseaseSet", alias, join, !lazyLoad);
        getNode().addPath(segment);

        return new com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectDiseaseMetadata<T>(getNode().getChild("nxftSubjectDiseaseSet"));
    }

    /**
     * 内连接、延迟加载
     *
     * @return [客户禁忌食物集合]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectFoodProhibitMetadata<T> nxftSubjectFoodProhibitSet() {
        return inner_join_nxftSubjectFoodProhibitSet();
    }

    /**
     * 内连接、延迟加载
     *
     * @return [客户禁忌食物集合]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectFoodProhibitMetadata<T> inner_join_nxftSubjectFoodProhibitSet() {
        return inner_join_nxftSubjectFoodProhibitSet("", true);
    }

    /**
     * 内连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [客户禁忌食物集合]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectFoodProhibitMetadata<T> inner_join_nxftSubjectFoodProhibitSet(String alias, boolean lazyLoad) {
        return nxftSubjectFoodProhibitSet(alias, com.benewit.ecctree.EccNodeConstant.INNER_JOIN, lazyLoad);
    }

    /**
     * 左外连接、延迟加载
     *
     * @return [客户禁忌食物集合]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectFoodProhibitMetadata<T> left_outer_join_nxftSubjectFoodProhibitSet() {
        return left_outer_join_nxftSubjectFoodProhibitSet("", true);
    }

    /**
     * 左外连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [客户禁忌食物集合]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectFoodProhibitMetadata<T> left_outer_join_nxftSubjectFoodProhibitSet(String alias, boolean lazyLoad) {
        return nxftSubjectFoodProhibitSet(alias, com.benewit.ecctree.EccNodeConstant.LEFT_OUTER_JOIN, lazyLoad);
    }

    /**
     * @param join 连接方式
     * @param lazyLoad 是否延迟加载？
     * @return [客户禁忌食物集合]的元数据
     */
    private com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectFoodProhibitMetadata<T> nxftSubjectFoodProhibitSet(String alias, String join, boolean lazyLoad) {
        String segment = getNode().getTree().getSegmentParser().formatSegment("nxftSubjectFoodProhibitSet", alias, join, !lazyLoad);
        getNode().addPath(segment);

        return new com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectFoodProhibitMetadata<T>(getNode().getChild("nxftSubjectFoodProhibitSet"));
    }

    /**
     * 内连接、延迟加载
     *
     * @return [客户居住情况集合]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectLivingCondiMetadata<T> nxftSubjectLivingCondiSet() {
        return inner_join_nxftSubjectLivingCondiSet();
    }

    /**
     * 内连接、延迟加载
     *
     * @return [客户居住情况集合]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectLivingCondiMetadata<T> inner_join_nxftSubjectLivingCondiSet() {
        return inner_join_nxftSubjectLivingCondiSet("", true);
    }

    /**
     * 内连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [客户居住情况集合]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectLivingCondiMetadata<T> inner_join_nxftSubjectLivingCondiSet(String alias, boolean lazyLoad) {
        return nxftSubjectLivingCondiSet(alias, com.benewit.ecctree.EccNodeConstant.INNER_JOIN, lazyLoad);
    }

    /**
     * 左外连接、延迟加载
     *
     * @return [客户居住情况集合]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectLivingCondiMetadata<T> left_outer_join_nxftSubjectLivingCondiSet() {
        return left_outer_join_nxftSubjectLivingCondiSet("", true);
    }

    /**
     * 左外连接，并指定是否延迟加载
     *
     * @param lazyLoad 是否延迟加载？
     * @return [客户居住情况集合]的元数据
     */
    public com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectLivingCondiMetadata<T> left_outer_join_nxftSubjectLivingCondiSet(String alias, boolean lazyLoad) {
        return nxftSubjectLivingCondiSet(alias, com.benewit.ecctree.EccNodeConstant.LEFT_OUTER_JOIN, lazyLoad);
    }

    /**
     * @param join 连接方式
     * @param lazyLoad 是否延迟加载？
     * @return [客户居住情况集合]的元数据
     */
    private com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectLivingCondiMetadata<T> nxftSubjectLivingCondiSet(String alias, String join, boolean lazyLoad) {
        String segment = getNode().getTree().getSegmentParser().formatSegment("nxftSubjectLivingCondiSet", alias, join, !lazyLoad);
        getNode().addPath(segment);

        return new com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectLivingCondiMetadata<T>(getNode().getChild("nxftSubjectLivingCondiSet"));
    }

    /**
     * {@link NxftSubject#getPersonInfo() NxftSubject.personInfo}的元数据。
     */
    public class PersonInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<NxftSubject.PersonInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link PersonInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public PersonInfoMetadata(ObjectNode<C> node) {
            super(NxftSubject.PersonInfo.class, node, "personInfo");

            node.addPath("personInfo");
            this.node = node.getChild("personInfo");
        }

        /** @return [客户ID]属性的操作符 */
        public AlgebraicVariable<String> personId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "personId");
        }

        /** @return [姓名]属性的操作符 */
        public AlgebraicVariable<String> subjectName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "subjectName");
        }

        /** @return [性别id     fxp.p_sex 字典]属性的操作符 */
        public AlgebraicVariable<String> sexId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "sexId");
        }

        /** @return [性别name]属性的操作符 */
        public AlgebraicVariable<String> sexName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "sexName");
        }

        /** @return [证件类别id]属性的操作符 */
        public AlgebraicVariable<String> idtypeId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "idtypeId");
        }

        /** @return [证件类别中文]属性的操作符 */
        public AlgebraicVariable<String> idtypeName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "idtypeName");
        }

        /** @return [身份证号]属性的操作符 */
        public AlgebraicVariable<String> idcardno() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "idcardno");
        }

        /** @return [出生日期]属性的操作符 */
        public AlgebraicVariable<java.util.Date> birthDate() {
            return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, node, "birthDate");
        }

        /** @return [对象饮食偏好id]属性的操作符 */
        public AlgebraicVariable<String> subjectFoodLoveId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "subjectFoodLoveId");
        }

        /** @return [对象饮食偏好name]属性的操作符 */
        public AlgebraicVariable<String> subjectFoodLoveName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "subjectFoodLoveName");
        }

        /** @return [客户所属的工作圈id]属性的操作符 */
        public AlgebraicVariable<String> circleId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "circleId");
        }

        /** @return [进餐是否协助]属性的操作符 */
        public AlgebraicVariable<Boolean> isMealHelp() {
            return new ObjectTreeAlgebraicVariable<Boolean>(Boolean.class, node, "isMealHelp");
        }

    }    // PersonInfoMetadata

    /**
     * {@link NxftSubject#getSubjectInfo() NxftSubject.subjectInfo}的元数据。
     */
    public class SubjectInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<NxftSubject.SubjectInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link SubjectInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public SubjectInfoMetadata(ObjectNode<C> node) {
            super(NxftSubject.SubjectInfo.class, node, "subjectInfo");

            node.addPath("subjectInfo");
            this.node = node.getChild("subjectInfo");
        }

        /** @return [联系人姓名]属性的操作符 */
        public AlgebraicVariable<String> relationName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "relationName");
        }

        /** @return [联系人电话]属性的操作符 */
        public AlgebraicVariable<String> relationPhone() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "relationPhone");
        }

        /** @return [对象类型id]属性的操作符 */
        public AlgebraicVariable<String> subjectTypeId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "subjectTypeId");
        }

        /** @return [对象类型中文名称]属性的操作符 */
        public AlgebraicVariable<String> subjectTypeName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "subjectTypeName");
        }

        /** @return [对象备注]属性的操作符 */
        public AlgebraicVariable<String> subjectDesc() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "subjectDesc");
        }

        /** @return [配送方式  助餐点 SITE  到户上门  HOME]属性的操作符 */
        public AlgebraicVariable<String> deliveType() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "deliveType");
        }

        /** @return [配送地点id]属性的操作符 */
        public AlgebraicVariable<String> deliveSiteId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "deliveSiteId");
        }

        /** @return [配送地点名称]属性的操作符 */
        public AlgebraicVariable<String> deliveSiteName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "deliveSiteName");
        }

        /** @return [配餐透支额度]属性的操作符 */
        public AlgebraicVariable<Double> overdraft() {
            return new ObjectTreeAlgebraicVariable<Double>(Double.class, node, "overdraft");
        }

        /** @return [对象所患疾病，名称逗号分隔]属性的操作符 */
        public AlgebraicVariable<String> subjectDisease() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "subjectDisease");
        }

        /** @return [饭盒编号]属性的操作符 */
        public AlgebraicVariable<String> lunchBoxNo() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "lunchBoxNo");
        }

    }    // SubjectInfoMetadata

    /**
     * {@link NxftSubject#getCreateInfo() NxftSubject.createInfo}的元数据。
     */
    public class CreateInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<NxftSubject.CreateInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link CreateInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public CreateInfoMetadata(ObjectNode<C> node) {
            super(NxftSubject.CreateInfo.class, node, "createInfo");

            node.addPath("createInfo");
            this.node = node.getChild("createInfo");
        }

        /** @return [创建时间]属性的操作符 */
        public AlgebraicVariable<java.util.Date> createTime() {
            return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, node, "createTime");
        }

        /** @return [创建工作圈id]属性的操作符 */
        public AlgebraicVariable<String> createCircleId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "createCircleId");
        }

        /** @return [创建工作组id]属性的操作符 */
        public AlgebraicVariable<String> createTeamId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "createTeamId");
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
     * {@link NxftSubject#getCancelInfo() NxftSubject.cancelInfo}的元数据。
     */
    public class CancelInfoMetadata<C extends Entity> extends ObjectTreeAlgebraicVariable<NxftSubject.CancelInfo> {

        private final ObjectNode<C> node;

        /**
         * 创建{@link CancelInfoMetadata}对象。
         *
         * @param node 所属节点
         */
        public CancelInfoMetadata(ObjectNode<C> node) {
            super(NxftSubject.CancelInfo.class, node, "cancelInfo");

            node.addPath("cancelInfo");
            this.node = node.getChild("cancelInfo");
        }

        /** @return [是否被注销]属性的操作符 */
        public AlgebraicVariable<Boolean> isCancel() {
            return new ObjectTreeAlgebraicVariable<Boolean>(Boolean.class, node, "isCancel");
        }

        /** @return [注销原因]属性的操作符 */
        public AlgebraicVariable<String> cancelReason() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "cancelReason");
        }

        /** @return [注销机器时间]属性的操作符 */
        public AlgebraicVariable<java.util.Date> cancelDate() {
            return new ObjectTreeAlgebraicVariable<java.util.Date>(java.util.Date.class, node, "cancelDate");
        }

        /** @return [注销操作员id]属性的操作符 */
        public AlgebraicVariable<String> cancelUserId() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "cancelUserId");
        }

        /** @return [注销操作员姓名]属性的操作符 */
        public AlgebraicVariable<String> cancelUserName() {
            return new ObjectTreeAlgebraicVariable<String>(String.class, node, "cancelUserName");
        }

    }    // CancelInfoMetadata
}
