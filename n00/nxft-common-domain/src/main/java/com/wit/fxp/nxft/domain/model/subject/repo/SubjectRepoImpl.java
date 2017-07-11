package com.wit.fxp.nxft.domain.model.subject.repo;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.benewit.criteria.DynamicWhereEnum;
import com.benewit.criteria.Order;
import com.benewit.orm.hibernate.support.WitHibernateDaoSupport;
import com.wit.fxp.domain.model.account.Account;
import com.wit.fxp.domain.model.account.AccountList;
import com.wit.fxp.domain.model.account.AccountPerson;
import com.wit.fxp.domain.model.account.metadata.AccountMetadata;
import com.wit.fxp.domain.model.circle.Application;
import com.wit.fxp.domain.model.circle.Team;
import com.wit.fxp.domain.model.circle.metadata.TeamMetadata;
import com.wit.fxp.domain.model.person.Disease;
import com.wit.fxp.domain.model.person.Person;
import com.wit.fxp.domain.model.person.metadata.DiseaseMetadata;
import com.wit.fxp.domain.model.person.metadata.PersonMetadata;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.annotation.NxftHibernateSessionFactory;
import com.wit.fxp.nxft.domain.model.dict.CircleKitchen;
import com.wit.fxp.nxft.domain.model.dict.FoodLove;
import com.wit.fxp.nxft.domain.model.dict.FoodProhibit;
import com.wit.fxp.nxft.domain.model.dict.SubjectAssistance;
import com.wit.fxp.nxft.domain.model.dict.SubjectType;
import com.wit.fxp.nxft.domain.model.dict.metadata.CircleKitchenMetadata;
import com.wit.fxp.nxft.domain.model.dict.metadata.FoodLoveMetadata;
import com.wit.fxp.nxft.domain.model.dict.metadata.FoodProhibitMetadata;
import com.wit.fxp.nxft.domain.model.dict.metadata.SubjectAssistanceMetadata;
import com.wit.fxp.nxft.domain.model.dict.metadata.SubjectTypeMetadata;
import com.wit.fxp.nxft.domain.model.meal.MealDisease;
import com.wit.fxp.nxft.domain.model.meal.MealScheday;
import com.wit.fxp.nxft.domain.model.meal.metadata.MealDiseaseMetadata;
import com.wit.fxp.nxft.domain.model.meal.metadata.MealSchedayMetadata;
import com.wit.fxp.nxft.domain.model.order.DeliveDetail;
import com.wit.fxp.nxft.domain.model.order.DeliveDetailNum;
import com.wit.fxp.nxft.domain.model.order.DeliveNote;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;
import com.wit.fxp.nxft.domain.model.order.metadata.DeliveDetailMetadata;
import com.wit.fxp.nxft.domain.model.order.metadata.DeliveNoteMetadata;
import com.wit.fxp.nxft.domain.model.order.metadata.NxftOrderMetadata;
import com.wit.fxp.nxft.domain.model.sis.SisServiceResource;
import com.wit.fxp.nxft.domain.model.sis.metadata.SisServiceResourceMetadata;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;
import com.wit.fxp.nxft.domain.model.subject.NxftSubjectSmsLog;
import com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectMetadata;

@Repository
@Transactional
public class SubjectRepoImpl extends WitHibernateDaoSupport implements SubjectRepo {

    @Autowired
    public SubjectRepoImpl(@NxftHibernateSessionFactory() SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<NxftSubject> findSubjectByQuery(String circleId, String teamid, String name, String phone, String sendType,
            int pageNum) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def("a", root.personInfo().circleId().eq(circleId))
                .def("b", name == null ? null : root.personInfo().subjectName().like("%" + name + "%"))
                .def("c", phone == null ? null : root.contactPhone().like("%" + phone + "%"))
                .def("e", sendType == null ? null : root.subjectInfo().deliveSiteId().eq(sendType))
                .select(root)
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.createInfo().createTime()))
                .setPageRange(pageNum, 8)
                .list();
    }

    @Override
    public List<NxftSubject> findMaSubjectByQuery(String circleId, String teamid, String name, String phone, boolean isOver,
            int pageNum) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root("a");
        AccountMetadata<Account> ap = AccountMetadata.root("b");
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def("gg", ap.account().personId().eq(root.personInfo().personId()))
                .def("a", root.personInfo().circleId().eq(circleId))
                .def("b", name == null ? null : root.personInfo().subjectName().like("%" + name + "%"))
                .def("c", phone == null ? null : root.contactPhone().like("%" + phone + "%"))
                .def("ff", isOver ? ap.balanceCash().lt(0.0) : ap.balanceCash().ge(0.0))
                .join(ap.getObjectTree())
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.createInfo().createTime()))
                .setPageRange(pageNum, 8)
                .list();
    }

    @Override
    public List<NxftOrder> findOrderByQuery(String circleId, String teamid, Date begin1, Date end1, Date begin2, Date end2, String name,
            String teamId, String subjectTypeId, String stateId, int pageNum) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.subjectInfo().circleId().eq(circleId))
                .def(null, begin1 == null ? null : root.createInfo().createTime().ge(begin1))
                .def(null, end1 == null ? null : root.createInfo().createTime().le(end1))
                .def(null, begin2 == null ? null : root.mealInfo().mealDate().ge(begin2))
                .def(null, end2 == null ? null : root.mealInfo().mealDate().le(end2))
                .def(null, name == null ? null : root.subjectInfo().subjectName().like("%" + name + "%"))
                .def(null, "ALL".equals(teamId) || teamId == null ? null : root.subjectInfo().deliveSiteId().eq(teamId))
                .def(null, "ALL".equals(subjectTypeId) || subjectTypeId == null ? null : root.subjectInfo().subjectTypeId().eq(subjectTypeId))
                .def(null, "ALL".equals(stateId) || stateId == null ? null : root.lastState().lastState().eq(stateId))
                .select(root)
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.createInfo().createTime()))
                .setPageRange(pageNum, 8)
                .list();
    }

    @Override
    public List<NxftSubject> findAllSubjects(String circleId, String teamId, int pageNum) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def("a", root.personInfo().circleId().eq(circleId))
                .select(root)
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.createInfo().createTime()))
                .setPageRange(pageNum, 8)
                .list();
    }

    @Override
    public List<NxftOrder> findAllOrders(String circleId, String teamId, int pageNum) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def("a", root.subjectInfo().circleId().eq(circleId))
                .select(root)
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.createInfo().createTime()))
                .setPageRange(pageNum, 8)
                .list();
    }

    @Override
    public int findOrderCountByQuery(String circleId, String teamid, Date begin1, Date end1, Date begin2, Date end2, String name,
            String teamId, String subjectTypeId, String stateId) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        Object[] count =  this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.subjectInfo().circleId().eq(circleId))
                .def(null, begin1 == null ? null : root.createInfo().createTime().ge(begin1))
                .def(null, end1 == null ? null : root.createInfo().createTime().le(end1))
                .def(null, begin2 == null ? null : root.mealInfo().mealDate().ge(begin2))
                .def(null, end2 == null ? null : root.mealInfo().mealDate().le(end2))
                .def(null, name == null ? null : root.subjectInfo().subjectName().like("%" + name + "%"))
                .def(null, "ALL".equals(teamId) || teamId == null ? null : root.subjectInfo().deliveSiteId().eq(teamId))
                .def(null, "ALL".equals(subjectTypeId) || subjectTypeId == null ? null : root.subjectInfo().subjectTypeId().eq(subjectTypeId))
                .def(null, "ALL".equals(stateId) || stateId == null ? null : root.lastState().lastState().eq(stateId))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return ((Long) count[0]).intValue();
    }

    @Override
    public int findAllOrdersCount(String circleId, String teamId) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        Object[] count =  this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def("a", root.subjectInfo().circleId().eq(circleId))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return ((Long) count[0]).intValue();
    }

    @Override
    public List<NxftSubject> findMaSubjectCountByQuery(String circleId, String teamid, String name, String phone, boolean isOver) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root("a");
        AccountMetadata<Account> ap = AccountMetadata.root("b");
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def("aa", ap.account().personId().eq(root.personInfo().personId()))
                .def("a", root.personInfo().circleId().eq(circleId))
                .def("b", name == null ? null : root.personInfo().subjectName().like("%" + name + "%"))
                .def("c", phone == null ? null : root.contactPhone().like("%" + phone + "%"))
                .def("cc", isOver ? ap.balanceCash().lt(0.0) : ap.balanceCash().ge(0.0))
                .join(ap.getObjectTree())
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public int findSubjectCountByQuery(String circleId, String teamid, String name, String phone, String sendType) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        Object[] count =  this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def("a", root.personInfo().circleId().eq(circleId))
                .def("b", name == null ? null : root.personInfo().subjectName().like("%" + name + "%"))
                .def("c", phone == null ? null : root.contactPhone().like("%" + "%"))
                .def("e", sendType == null ? null : root.subjectInfo().deliveSiteId().eq(sendType))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();

        return ((Long) count[0]).intValue();
    }

    @Override
    public int findAllSubjectsCount(String circleId, String teamId) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        Object[] count =  this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def("a", root.personInfo().circleId().eq(circleId))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return ((Long) count[0]).intValue();
    }

    @Override
    public List<SubjectType> findAllTypes() {
        SubjectTypeMetadata<SubjectType> root = SubjectTypeMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.available().eq(true))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.asc(root.subjectTypeCode()))
                .list();
    }

    @Override
    public List<Team> findTeamsByCircleId(String circleId) {
        TeamMetadata<Team> root = TeamMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.circle().id().eq(circleId))
                .def(null, root.application().id().eq(DBC.子系统.助餐点工作站.value()))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.createTime()))
                .list();
    }

    @Override
    public Person findPersonByPhone(String phone) {
        PersonMetadata<Person> root = PersonMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.relationInfo().personMobile().eq(phone))
                .where(DynamicWhereEnum.AND_ALL)
                .uniqueResult();
    }

    @Override
    public Person findPersonByIdNo(String idNo) {
        PersonMetadata<Person> root = PersonMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.basicInfo().idNo().eq(idNo))
                .where(DynamicWhereEnum.AND_ALL)
                .uniqueResult();
    }

    @Override
    public void addSubject(NxftSubject subject) {
        this.saveOrUpdate(subject);
    }

    @Override
    public List<Team> findCreateFamilyTeam(String circleId) {
        TeamMetadata<Team> root = TeamMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.circle().id().eq(circleId))
                .def(null, root.application().id().eq("CC"))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.createTime()))
                .list();
    }

    @Override
    public NxftSubject findById(String id) {
        return this.findById(NxftSubject.class, id);
    }

    @Override
    public int findSubjectByType(String circleId, String type) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        Object[] count =  this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.personInfo().circleId().eq(circleId))
                .def(null, type == null ? null : root.subjectInfo().subjectTypeName().eq(type))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return ((Long) count[0]).intValue();
    }

    @Override
    public int findSubjectByDate(String circleId, Date begin, Date end) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        Object[] count =  this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.personInfo().circleId().eq(circleId))
                .def(null, root.createInfo().createTime().ge(begin))
                .def(null, root.createInfo().createTime().le(end))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return ((Long) count[0]).intValue();
    }

    @Override
    public int findOrdersByDate(String circleId, Date begin, Date end) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        Object[] count =  this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.subjectInfo().circleId().eq(circleId))
                .def(null, root.mealInfo().mealDate().ge(begin))
                .def(null, root.mealInfo().mealDate().le(end))
                .def(null, root.lastState().lastState().noteq(DBC.助餐订单状态.已取消.getValue()))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return ((Long) count[0]).intValue();
    }

    @Override
    public NxftOrder findOrderById(String id) {
        return this.findById(NxftOrder.class, id);
    }

    @Override
    public NxftSubject findSubjectByPersonId(String personId) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def("a", root.personInfo().personId().eq(personId))
                .where(DynamicWhereEnum.AND_ALL)
                .uniqueResult();
    }

    @Override
    public MealScheday findMealScheDay(String kitTeamId, Date mealDate, String mealId, String mealTypeId) {
        MealSchedayMetadata<MealScheday> root = MealSchedayMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.kitchenTeamId().eq(kitTeamId))
                .def(null, root.mealId().eq(mealId))
                .def(null, root.mealTypeId().eq(mealTypeId))
                .def(null, root.mealDate().eq(mealDate))
                .where(DynamicWhereEnum.AND_ALL)
                .uniqueResult();
    }

    @Override
    public void addOrder(NxftOrder order) {
        this.saveOrUpdate(order);
    }

    @Override
    public CircleKitchen findKitchen(String circle) {
        CircleKitchenMetadata<CircleKitchen> root = CircleKitchenMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.circleId().eq(circle))
                .where(DynamicWhereEnum.AND_ALL)
                .uniqueResult();
    }

    @Override
    public SubjectAssistance findSa(String circleId, String subjectTypeId, String mealTypeId) {
        SubjectAssistanceMetadata<SubjectAssistance> root = SubjectAssistanceMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.circleId().eq(circleId))
                .def(null, root.subjectTypeId().eq(subjectTypeId))
                .def(null, root.mealTypeId().eq(mealTypeId))
                .where(DynamicWhereEnum.AND_ALL)
                .uniqueResult();
    }

    @Override
    public List<MealScheday> findMealBykit(String kitTeamId, String mealTypeId, Date mealDate) {
        MealSchedayMetadata<MealScheday> root = MealSchedayMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.kitchenTeamId().eq(kitTeamId))
                .def(null, root.mealDate().eq(mealDate))
                .def(null, root.mealTypeId().eq(mealTypeId))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.asc(root.mealCode()))
                .list();
    }

    @Override
    public List<SisServiceResource> findAllByCircleId(String circleId) {
        SisServiceResourceMetadata<SisServiceResource> root = SisServiceResourceMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.circleId().eq(circleId))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public Account findAccountByPersonId(String personId) {
        AccountMetadata<Account> abc = AccountMetadata.root("vvv");
        return this.newWitHibernateTemplate().createCriteria(abc.getObjectTree())
                .def(null, abc.account().personId().eq(personId))
                .where(DynamicWhereEnum.AND_ALL)
                .uniqueResult();
    }

    @Override
    public void addAccount(Account account) {
        this.saveOrUpdate(account);
    }

    @Override
    public void addAcountPerson(AccountPerson ap) {
        this.saveOrUpdate(ap);
    }

    @Override
    public List<Disease> findDiseases() {
        DiseaseMetadata<Disease> abc = DiseaseMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(abc.getObjectTree())
                .def(null, abc.available().eq(true))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public List<MealDisease> findMealDiseasesByMealId(String mealId) {
        MealDiseaseMetadata<MealDisease> abc = MealDiseaseMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(abc.getObjectTree())
                .def(null, abc.mealId().eq(mealId))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public NxftSubject findSubjectByIdNo(String idNo) {
        NxftSubjectMetadata<NxftSubject> abc = NxftSubjectMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(abc.getObjectTree())
                .def(null, abc.personInfo().idcardno().eq(idNo))
                .where(DynamicWhereEnum.AND_ALL)
                .uniqueResult();
    }

    @Override
    public NxftSubject findSubjectByPhone(String phone) {
        NxftSubjectMetadata<NxftSubject> abc = NxftSubjectMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(abc.getObjectTree())
                .def(null, abc.contactPhone().eq(phone))
                .where(DynamicWhereEnum.AND_ALL)
                .uniqueResult();
    }

    @Override
    public void deleteAccountList(AccountList list) {
        this.delete(AccountList.class, list.getId());

    }

    @Override
    public List<FoodProhibit> findHibits() {
        FoodProhibitMetadata<FoodProhibit> abc = FoodProhibitMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(abc.getObjectTree())
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public void addSmsLog(NxftSubjectSmsLog log) {
        this.saveOrUpdate(log);
    }

    @Override
    public List<FoodLove> findFoodLove() {
        FoodLoveMetadata<FoodLove> abc = FoodLoveMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(abc.getObjectTree())
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public List<DeliveDetailNum> findDeliveDetailByTime(String circleId, Date now) {
        DeliveDetailMetadata<DeliveDetail> root = DeliveDetailMetadata.root("d");
        DeliveNoteMetadata<DeliveNote> note = DeliveNoteMetadata.root("n");
        List<Object[]> list = this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.deliveNoteId().eq(note.id()))
                .def(null, note.deliveInfo().circleId().eq(circleId))
                .def(null, note.deliveInfo().mealDate().le(now))
                .join(note.getObjectTree())
                .select(note.deliveInfo().mealTypeId(), root.quantity())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .list();
        return list.stream().map(e -> {
            return DeliveDetailNum.builder()
                        ._mealTypeId____((String) e[0])
                        ._quanlity______((Integer) e[1])
                        ._build_();
        })
        .collect(Collectors.toList());
    }

    @Override
    public Application findApplicationById(String id) {
        return this.findById(Application.class, id);
    }

}
