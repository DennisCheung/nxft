package com.wit.fxp.nxft.domain.model.order.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.benewit.criteria.DynamicWhereEnum;
import com.benewit.criteria.Order;
import com.benewit.expression.algebra.LogicAtomic;
import com.benewit.orm.hibernate.support.WitHibernateDaoSupport;
import com.wit.fxp.domain.model.account.Account;
import com.wit.fxp.domain.model.account.AccountList;
import com.wit.fxp.domain.model.account.AccountPerson;
import com.wit.fxp.domain.model.account.metadata.AccountMetadata;
import com.wit.fxp.domain.model.account.metadata.AccountPersonMetadata;
import com.wit.fxp.domain.model.circle.Circle;
import com.wit.fxp.domain.model.circle.Team;
import com.wit.fxp.domain.model.circle.metadata.TeamMetadata;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.annotation.NxftHibernateSessionFactory;
import com.wit.fxp.nxft.domain.model.dict.CircleKitchen;
import com.wit.fxp.nxft.domain.model.dict.metadata.CircleKitchenMetadata;
import com.wit.fxp.nxft.domain.model.order.DeliveCreateLog;
import com.wit.fxp.nxft.domain.model.order.DeliveDetail;
import com.wit.fxp.nxft.domain.model.order.DeliveDetailNum;
import com.wit.fxp.nxft.domain.model.order.DeliveNote;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;
import com.wit.fxp.nxft.domain.model.order.metadata.DeliveCreateLogMetadata;
import com.wit.fxp.nxft.domain.model.order.metadata.DeliveDetailMetadata;
import com.wit.fxp.nxft.domain.model.order.metadata.DeliveNoteMetadata;
import com.wit.fxp.nxft.domain.model.order.metadata.NxftOrderMetadata;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;
import com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectMetadata;

@Transactional
@Repository
public class NxftDeliveRepoImpl extends WitHibernateDaoSupport implements NxftDeliveRepo {

    @Autowired
    public NxftDeliveRepoImpl(@NxftHibernateSessionFactory SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<NxftOrder> findUnDeliveOrder(String mealTypeId, Date beginDate, Date endDate) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.mealInfo().mealTypeId().eq(mealTypeId))
                .def(null, root.mealInfo().mealDate().between(beginDate, endDate))
                .def(null, root.deliveNoteId().isNull())
                .def(null, root.lastState().lastState().eq(DBC.助餐订单状态.已派单.getValue()))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public List<NxftOrder> findUnDeliveOrder(String teamId, String mealTypeId, Date beginDate, Date endDate) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.mealInfo().kitchenTeamId().eq(teamId))
                .def(null, root.mealInfo().mealTypeId().eq(mealTypeId))
                .def(null, root.mealInfo().mealDate().between(beginDate, endDate))
                .def(null, root.deliveNoteId().isNull())
                .def(null, root.lastState().lastState().eq(DBC.助餐订单状态.已派单.getValue()))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public void saveDeliveNote(DeliveNote entity) {
        this.saveOrUpdate(entity);
    }

    @Override
    public void saveDeliveDetail(DeliveDetail entity) {
        this.saveOrUpdate(entity);
    }

    @Override
    public List<NxftOrder> findOrderDetail(String teamId, Date orderCreateB, Date orderCreateE, Date mealTimeB, Date mealTimeE, String subjectName,
            String orderState, String deliveSiteId, String subjectType, Integer startIndex, Integer pageSize) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        List<Order> orders = new ArrayList<>();
        if (orderCreateB != null && orderCreateE != null) {
            Order desc = Order.desc(root.createInfo().createTime());
            orders.add(desc);
        }
        orders.add(Order.asc(root.mealInfo().mealDate()));
        orders.add(Order.asc(root.mealInfo().mealTypeId()));
        orders.add(Order.asc(root.subjectInfo().subjectName()));
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.mealInfo().kitchenTeamId().eq(teamId))
                .def(null, orderCreateB == null ? null : root.createInfo().createTime().ge(orderCreateB))
                .def(null, orderCreateE == null ? null : root.createInfo().createTime().lt(orderCreateE))
                .def(null, mealTimeB == null ? null : root.mealInfo().mealDate().ge(mealTimeB))
                .def(null, mealTimeE == null ? null : root.mealInfo().mealDate().lt(mealTimeE))
                .def(null, subjectName == null ? null : root.subjectInfo().subjectName().like(subjectName + "%"))
                .def(null, orderState == null ? null : root.lastState().lastState().eq(orderState))
                .def(null, deliveSiteId == null ? null : root.subjectInfo().deliveSiteId().eq(deliveSiteId))
                .def(null, subjectType == null ? null : root.subjectInfo().subjectTypeId().eq(subjectType))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(orders)
                .setPageRange(startIndex, pageSize)
                .list();
    }

    @Override
    public Long findOrderDetailCount(String teamId, Date orderCreateB, Date orderCreateE, Date mealTimeB, Date mealTimeE, String subjectName,
            String orderState, String deliveSiteId, String subjectType) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        Object[] uniqueResult = this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.mealInfo().kitchenTeamId().eq(teamId))
                .def(null, orderCreateB == null ? null : root.createInfo().createTime().ge(orderCreateB))
                .def(null, orderCreateE == null ? null : root.createInfo().createTime().lt(orderCreateE))
                .def(null, mealTimeB == null ? null : root.mealInfo().mealDate().ge(mealTimeB))
                .def(null, mealTimeE == null ? null : root.mealInfo().mealDate().lt(mealTimeE))
                .def(null, subjectName == null ? null : root.subjectInfo().subjectName().like(subjectName + "%"))
                .def(null, orderState == null ? null : root.lastState().lastState().eq(orderState))
                .def(null, deliveSiteId == null ? null : root.subjectInfo().deliveSiteId().eq(deliveSiteId))
                .def(null, subjectType == null ? null : root.subjectInfo().subjectTypeId().eq(subjectType))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return uniqueResult == null ? 0L : (Long) uniqueResult[0];
    }

    @Override
    public List<DeliveCreateLog> findDeliveCreateLog(Date beginDate, Date endDate, String mealTypeId) {
        DeliveCreateLogMetadata<DeliveCreateLog> root = DeliveCreateLogMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.mealDate().between(beginDate, endDate))
                .def(null, root.mealTypeId().eq(mealTypeId))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public void saveDeliveCreateLog(DeliveCreateLog entity) {
        this.saveOrUpdate(entity);
    }

    @Override
    public Account findAccountBySubjectId(String subjectId) {
        AccountMetadata<Account> root = AccountMetadata.root("acc");
        NxftSubjectMetadata<NxftSubject> s = NxftSubjectMetadata.root("s");
        AccountPersonMetadata<AccountPerson> ap = AccountPersonMetadata.root("ap");
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, s.id().eq(subjectId))
                .def(null, s.personInfo().personId().eq(ap.personId()))
                .def(null, ap.id().eq(root.id()))
                .join(s.getObjectTree(), ap.getObjectTree())
                .where(DynamicWhereEnum.AND_ALL)
                .uniqueResult();
    }

    @Override
    public void saveAccountList(AccountList entity) {
        this.saveOrUpdate(entity);
    }

    @Override
    public Circle getCircleByKitchen(String kitchenId) {
        return this.findById(Circle.class, kitchenId);
    }

    @Override
    public Long findDeliveNoteCount(String teamId, Date mealDateBegin, Date mealDateEnd, String state, String mealTypeId) {
        DeliveNoteMetadata<DeliveNote> root = DeliveNoteMetadata.root();
        Object[] uniqueResult = this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.deliveInfo().kitchenTeamId().eq(teamId))
                .def(null, root.deliveInfo().mealDate().between(mealDateBegin, mealDateEnd))
                .def(null, root.lastState().lastState().eq(state))
                .def(null, mealTypeId == null ? null : root.deliveInfo().mealTypeId().eq(mealTypeId))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return uniqueResult == null ? 0L : (Long) uniqueResult[0];
    }

    @Override
    public List<DeliveNote> findDeliveNote(String teamId, Date mealDateBegin, Date mealDateEnd, String state, String mealTypeId) {
        DeliveNoteMetadata<DeliveNote> root = DeliveNoteMetadata.root();
        LogicAtomic<String> la;
        if (DBC.配送订单状态.已接单.value().equals(state)) {
            la = root.lastState().lastState().eq(DBC.配送订单状态.已接单.value());
        }
        else {
            la = root.lastState().lastState().noteq(DBC.配送订单状态.已接单.value());
        }
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.deliveInfo().kitchenTeamId().eq(teamId))
                .def(null, root.deliveInfo().mealDate().between(mealDateBegin, mealDateEnd))
                .def(null, la)
                .def(null, mealTypeId == null ? null : root.deliveInfo().mealTypeId().eq(mealTypeId))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.asc(root.id()))
                .list();
    }

    @Override
    public DeliveNote findDeliveNoteById(String id) {
        return this.findById(DeliveNote.class, id);
    }

    @Override
    public List<NxftOrder> findNxftOrderByDeliveNoteId(String deliveNoteId) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.deliveNoteId().eq(deliveNoteId))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public List<NxftOrder> findNxftOrder(String teamId, Date begin, Date end) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.mealInfo().kitchenTeamId().eq(teamId))
                .def(null, root.mealInfo().mealDate().between(begin, end))
                .def(null, root.lastState().lastState().noteq(DBC.助餐订单状态.已取消.getValue()))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public List<DeliveDetailNum> findDeliveDetailByTime(String teamId, Date begin, Date end) {
        DeliveDetailMetadata<DeliveDetail> root = DeliveDetailMetadata.root("d");
        DeliveNoteMetadata<DeliveNote> note = DeliveNoteMetadata.root("n");
        List<Object[]> list = this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.deliveNoteId().eq(note.id()))
                .def(null, note.deliveInfo().kitchenTeamId().eq(teamId))
                .def(null, note.deliveInfo().mealDate().between(begin, end))
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
    public NxftOrder findNxftOrderById(String orderId) {
        return this.findById(NxftOrder.class, orderId);
    }

    @Override
    public List<DeliveNote> findDeliveNote(String teamId, Date mealDateBegin, Date mealDateEnd, String state) {
        DeliveNoteMetadata<DeliveNote> root = DeliveNoteMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.deliveInfo().deliveSiteId().eq(teamId))
                .def(null, root.deliveInfo().mealDate().between(mealDateBegin, mealDateEnd))
                .def(null, root.lastState().lastState().eq(state))
                .def(null, root.deliveInfo().deliveType().eq(com.wit.fxp.nxft.DBC.配送方式.助餐点.value()))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.deliveInfo().mealDate()))
                .list();
    }

    @Override
    public List<DeliveDetail> findDeliveDetailByDeliveId(String deliveId) {
        DeliveDetailMetadata<DeliveDetail> root = DeliveDetailMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.deliveNoteId().eq(deliveId))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public List<Team> findDeliveSiteByKitchenTeamId(String kitchenTeamId) {
        TeamMetadata<Team> root = TeamMetadata.root("t");
        CircleKitchenMetadata<CircleKitchen> chen = CircleKitchenMetadata.root("c");
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, chen.kitchenTeamId().eq(kitchenTeamId))
                .def(null, chen.circleId().eq(root.circle().id()))
                .def(null, root.application().id().eq(DBC.子系统.助餐点工作站.value()))
                .join(chen.getObjectTree())
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.createTime()))
                .list();
    }

}
