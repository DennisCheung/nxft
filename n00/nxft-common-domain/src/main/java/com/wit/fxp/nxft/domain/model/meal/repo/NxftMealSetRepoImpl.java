package com.wit.fxp.nxft.domain.model.meal.repo;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.benewit.criteria.DynamicWhereEnum;
import com.benewit.criteria.Order;
import com.benewit.criteria.WitCriteria;
import com.benewit.orm.hibernate.support.WitHibernateDaoSupport;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.nxft.annotation.NxftHibernateSessionFactory;
import com.wit.fxp.nxft.domain.model.dict.CircleKitchen;
import com.wit.fxp.nxft.domain.model.dict.metadata.CircleKitchenMetadata;
import com.wit.fxp.nxft.domain.model.meal.MealScheday;
import com.wit.fxp.nxft.domain.model.meal.MealSchenote;
import com.wit.fxp.nxft.domain.model.meal.MealSet;
import com.wit.fxp.nxft.domain.model.meal.metadata.MealSchedayMetadata;
import com.wit.fxp.nxft.domain.model.meal.metadata.MealSchenoteMetadata;
import com.wit.fxp.nxft.domain.model.meal.metadata.MealSetMetadata;

@Repository
@Transactional
public class NxftMealSetRepoImpl extends WitHibernateDaoSupport implements NxftMealSetRepo {

    @Autowired
    public NxftMealSetRepoImpl(@NxftHibernateSessionFactory SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void saveMealSet(MealSet entity) {
        this.saveOrUpdate(entity);
    }

    @Override
    public String mealNo(InvocationContext ic) {
        return ic.generateId(MealSet.class);
    }

    @Override
    public List<MealSet> findMealSetList(String teamId, Integer startIndex, Integer pageSize) {
        MealSetMetadata<MealSet> root = MealSetMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.available().eq(true))
                .def(null, root.kitchenTeamId().eq(teamId))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.mealCode()))
                .setPageRange(startIndex, pageSize)
                .list();
    }

    @Override
    public Long findMealSchenoteCount(String teamId, Date beginDate, Date endDate) {
        MealSchenoteMetadata<MealSchenote> root = MealSchenoteMetadata.root();
        Object[] uniqueResult = this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def("a", root.scheInfo().kitchenTeamId().eq(teamId))
                .def("b", root.scheInfo().beginDate().ge(beginDate))
                .def("d", root.scheInfo().beginDate().le(endDate))
                .def("e", root.scheInfo().endDate().ge(beginDate))
                .def("f", root.scheInfo().endDate().le(endDate))
                .select(rowCount())
                .where("(a) and (((b) and (d)) or ((e) and (f)))")
                .rows()
                .uniqueResult();
        return uniqueResult == null ? 0L : ((Long) uniqueResult[0]);
    }

    @Override
    public List<MealSchenote> findMealSchenoteList(String teamId, Date beginDate, Date endDate, Integer startIndex, Integer pageSize) {
        MealSchenoteMetadata<MealSchenote> root = MealSchenoteMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def("a", root.scheInfo().kitchenTeamId().eq(teamId))
                .def("b", root.scheInfo().beginDate().ge(beginDate))
                .def("d", root.scheInfo().beginDate().le(endDate))
                .def("e", root.scheInfo().endDate().ge(beginDate))
                .def("f", root.scheInfo().endDate().le(endDate))
                .where("(a) and (((b) and (d)) or ((e) and (f)))")
                .orderBy(Order.desc(root.scheInfo().endDate()))
                .setPageRange(startIndex, pageSize)
                .list();
    }

    @Override
    public List<MealSet> findMealSetList(String teamId) {
        MealSetMetadata<MealSet> root = MealSetMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.available().eq(true))
                .def(null, root.kitchenTeamId().eq(teamId))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.mealCode()))
                .setMaxResults(300)
                .list();
    }

    @Override
    public List<MealSet> findMealSetList(String teamId, String searchValue) {
        MealSetMetadata<MealSet> root = MealSetMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def("a", root.available().eq(true))
                .def("b", root.kitchenTeamId().eq(teamId))
                .def("c", root.mealName().like("%" + searchValue + "%"))
                .def("d", root.mealContent().like("%" + searchValue + "%"))
                .where("(a) and (b) and ((c) or (d))")
                .orderBy(Order.desc(root.mealCode()))
                .list();
    }

    @Override
    public List<MealSet> findMealSetList(List<String> ids) {
        MealSetMetadata<MealSet> root = MealSetMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.id().in(ids))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Override
    public Long findMealSetCount(String teamId) {
        MealSetMetadata<MealSet> root = MealSetMetadata.root();
        Object[] uniqueResult = this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.available().eq(true))
                .def(null, root.kitchenTeamId().eq(teamId))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return uniqueResult == null ? 0L : ((Long) uniqueResult[0]);
    }

    @Override
    public MealSet findMealSet(String id) {
        return this.findById(MealSet.class, id);
    }

    @Override
    public Date findMaxEndDate(String teamId) {
        MealSchenoteMetadata<MealSchenote> root = MealSchenoteMetadata.root();
        Object[] uniqueResult = this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.scheInfo().kitchenTeamId().eq(teamId))
                .select(max(root.scheInfo().endDate()))
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        if (uniqueResult == null) {
            return null;
        }
        else {
            return (Date) uniqueResult[0];
        }
    }

    @Override
    public MealSchenote findLastMealSchenote(String teamId) {
        MealSchenoteMetadata<MealSchenote> rootA = MealSchenoteMetadata.root("a");
        MealSchenoteMetadata<MealSchenote> rootB = MealSchenoteMetadata.root("b");
        WitCriteria<MealSchenote> asSubselect = this.newWitHibernateTemplate().createCriteria(rootA.getObjectTree())
                .def(null, rootA.scheInfo().kitchenTeamId().eq(teamId))
                .select(max(rootA.scheInfo().endDate()))
                .where(DynamicWhereEnum.AND_ALL)
                .asSubselect();
        MealSchenote uniqueResult = this.newWitHibernateTemplate().createCriteria(rootB.getObjectTree())
                .def(null, rootB.scheInfo().kitchenTeamId().eq(teamId))
                .def(null, tuple(rootB.scheInfo().endDate()).eq(asSubselect))
                .where(DynamicWhereEnum.AND_ALL)
                .uniqueResult();
        return uniqueResult;
    }

    @Override
    public void saveMealSchenote(MealSchenote entity) {
        this.saveOrUpdate(entity);
    }

    @Override
    public MealSchenote findMealSchenoteById(String id) {
        return this.findById(MealSchenote.class, id);
    }

    @Override
    public List<MealScheday> findMealScheDay(String mealSchenoteId, Date begin, Date end, String mealTypeId) {
        MealSchedayMetadata<MealScheday> root = MealSchedayMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.schenoteId().eq(mealSchenoteId))
                .def(null, root.mealDate().between(begin, end))
                .def(null, root.mealTypeId().eq(mealTypeId))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.asc(root.mealCode()))
                .list();
    }

    @Override
    public void deleteSchenoteByid(String schenoteId) {
        MealSchenote schenote = this.findById(MealSchenote.class, schenoteId);
        if (schenote != null) {
            this.delete(schenote);
        }
    }

    @Override
    public MealSchenote findMealSchenoteByZCDGZZ(String circleId, Date weekBegin, Date weekEnd) {
        MealSchenoteMetadata<MealSchenote> root = MealSchenoteMetadata.root("s");
        CircleKitchenMetadata<CircleKitchen> ck = CircleKitchenMetadata.root("ck");
        List<MealSchenote> list = this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.scheInfo().kitchenTeamId().eq(ck.kitchenTeamId()))
                .def(null, ck.circleId().eq(circleId))
                .def(null, root.scheInfo().beginDate().ge(weekBegin))
                .def(null, root.scheInfo().endDate().le(weekEnd))
                .def(null, root.publishInfo().isPublished().eq(true))
                .join(ck.getObjectTree())
                .where(DynamicWhereEnum.AND_ALL)
                .list();
        if (list.size() >= 1) {
            return list.get(0);
        }
        return null;
    }

}
