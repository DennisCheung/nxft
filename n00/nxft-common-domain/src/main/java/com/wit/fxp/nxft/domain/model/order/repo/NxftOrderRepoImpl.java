package com.wit.fxp.nxft.domain.model.order.repo;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.benewit.criteria.DynamicWhereEnum;
import com.benewit.criteria.Order;
import com.benewit.orm.hibernate.support.WitHibernateDaoSupport;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.annotation.NxftHibernateSessionFactory;
import com.wit.fxp.nxft.domain.model.order.DeliveNote;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;
import com.wit.fxp.nxft.domain.model.order.metadata.DeliveNoteMetadata;
import com.wit.fxp.nxft.domain.model.order.metadata.NxftOrderMetadata;

@Transactional
@Repository
public class NxftOrderRepoImpl extends WitHibernateDaoSupport implements NxftOrderRepo {

    @Autowired
    public NxftOrderRepoImpl(@NxftHibernateSessionFactory SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public int findOrderCountByTeamId(String teamId, Date beginTime, Date endTime) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        Object[] result =  this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.mealInfo().mealDate().ge(beginTime))
                .def(null, root.mealInfo().mealDate().le(endTime))
                .def(null, root.subjectInfo().deliveSiteId().eq(teamId))
                .def(null, root.lastState().lastState().noteq(DBC.助餐订单状态.已取消.getValue()))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return result == null || result[0] == null ? 0 : ((Long) result[0]).intValue();
    }

    @Override
    public NxftOrder findNxftOrder(String subjectId, Date mealDate, String mealTypeId, String mealId) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def("a", root.subjectInfo().subjectId().eq(subjectId))
                .def("b", root.lastState().lastState().eq("已派单"))
                .def("c", root.lastState().lastState().eq("已接单"))
                .def("d", root.lastState().lastState().eq("已配送"))
                .def("e", root.mealInfo().mealDate().eq(mealDate))
                .def("f", root.mealInfo().mealTypeId().eq(mealTypeId))
                .def("g", root.mealInfo().mealId().eq(mealId))
                .where("(a) and ( (b) or (c) or (d) ) and (e) and (f) and (g)")
                .uniqueResult();
    }

    @Override
    public List<NxftOrder> findNxftOrderByTeamIdAndSubjectId(String teamId, String subjectId) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.subjectInfo().deliveSiteId().eq(teamId))
                .def(null, root.subjectInfo().subjectId().eq(subjectId))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.mealInfo().mealDate()), Order.desc(root.mealInfo().mealCode()))
                .list();
    }

    @Override
    public int findOrderDetailNum(String teamId, String subjectId, Date begin, Date end) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        Object[] uniqueResult = this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.subjectInfo().deliveSiteId().eq(teamId))
                .def(null, root.subjectInfo().subjectId().eq(subjectId))
                .def(null, root.createInfo().createTime().between(begin, end))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return uniqueResult == null ? 0 : ((Long) uniqueResult[0]).intValue();
    }

    @Override
    public List<NxftOrder> findOrderDeatil(String teamId, String subjectId, Date begin, Date end, Integer startIndex, Integer pageSize) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.subjectInfo().deliveSiteId().eq(teamId))
                .def(null, root.subjectInfo().subjectId().eq(subjectId))
                .def(null, root.createInfo().createTime().between(begin, end))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.createInfo().createTime()), Order.asc(root.mealInfo().mealTypeId()))
                .setPageRange(startIndex, pageSize)
                .list();
    }

    @Override
    public List<NxftOrder> findOrderDeatil(String teamId, String subjectId, Date begin, Date end) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.subjectInfo().deliveSiteId().eq(teamId))
                .def(null, root.subjectInfo().subjectId().eq(subjectId))
                .def(null, root.createInfo().createTime().between(begin, end))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.createInfo().createTime()), Order.asc(root.mealInfo().mealTypeId()))
                .list();
    }

    @Override
    public List<NxftOrder> findNxftOrderList(String teamId, Date time, String mealTypeId) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.subjectInfo().deliveSiteId().eq(teamId))
                .def(null, root.mealInfo().mealTypeId().eq(mealTypeId))
                .def(null, root.mealInfo().mealDate().eq(time))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public int findNxftOrderListNum(String teamId, Date time, String mealTypeId) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        Object[] uniqueResult = this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.subjectInfo().deliveSiteId().eq(teamId))
                .def(null, root.mealInfo().mealTypeId().eq(mealTypeId))
                .def(null, root.mealInfo().mealDate().eq(time))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return uniqueResult == null ? 0 : ((Long) uniqueResult[0]).intValue();
    }

    @Override
    public NxftOrder findById(String orderId) {
        return this.findById(NxftOrder.class, orderId);
    }

    @Override
    public List<NxftOrder> findNxftOrderListByDate(String teamId, Date date, String mealTypeId) {
        NxftOrderMetadata<NxftOrder> nxftOrder = NxftOrderMetadata.root("nxftOrder");
        DeliveNoteMetadata<DeliveNote> deliveNote = DeliveNoteMetadata.root("DeliveNote");
        return this.newWitHibernateTemplate().createCriteria(nxftOrder.getObjectTree())
                .def(null, nxftOrder.deliveNoteId().eq(deliveNote.id()))
                .def(null, nxftOrder.mealInfo().mealDate().eq(date))
                .def(null, mealTypeId.equals("0") ? null : nxftOrder.mealInfo().mealTypeId().eq(mealTypeId))
                .def(null, nxftOrder.subjectInfo().deliveSiteId().eq(teamId))
                .def(null, deliveNote.lastState().lastState().eq(com.wit.fxp.nxft.DBC.配送订单状态.已送达.value()))
                .def(null, deliveNote.deliveInfo().deliveType().eq(com.wit.fxp.nxft.DBC.配送方式.助餐点.value()))
                .join(deliveNote.getObjectTree())
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public List<NxftOrder> findNxftOrderByDeliverId(String deliverId) {
        NxftOrderMetadata<NxftOrder> root = NxftOrderMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.deliveNoteId().eq(deliverId))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

}
