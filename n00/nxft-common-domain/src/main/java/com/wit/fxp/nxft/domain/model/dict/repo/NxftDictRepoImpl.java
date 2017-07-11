package com.wit.fxp.nxft.domain.model.dict.repo;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.benewit.criteria.DynamicWhereEnum;
import com.benewit.criteria.Order;
import com.benewit.orm.hibernate.support.WitHibernateDaoSupport;
import com.wit.fxp.domain.model.circle.Team;
import com.wit.fxp.domain.model.person.Disease;
import com.wit.fxp.domain.model.person.metadata.DiseaseMetadata;
import com.wit.fxp.nxft.annotation.NxftHibernateSessionFactory;
import com.wit.fxp.nxft.domain.model.dict.CircleKitchen;
import com.wit.fxp.nxft.domain.model.dict.MealType;
import com.wit.fxp.nxft.domain.model.dict.metadata.CircleKitchenMetadata;
import com.wit.fxp.nxft.domain.model.dict.metadata.MealTypeMetadata;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;

@Repository
@Transactional
public class NxftDictRepoImpl extends WitHibernateDaoSupport implements NxftDictRepo {

    @Autowired
    public NxftDictRepoImpl(@NxftHibernateSessionFactory SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public CircleKitchen getCircleKitchen(String circleId) {
        // 个人觉得可以有多个签约厨房
        CircleKitchenMetadata<CircleKitchen> root = CircleKitchenMetadata.root();
        List<CircleKitchen> list = this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.circleId().eq(circleId))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
        if (list.size() >= 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<MealType> findAllMealType() {
        MealTypeMetadata<MealType> root = MealTypeMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.available().eq(true))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.asc(root.id()))
                .list();
    }

    @Override
    public List<Disease> findHbcDisease() {
        DiseaseMetadata<Disease> root = DiseaseMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.available().eq(true))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.asc(root.diseaseCode()))
                .list();
    }

    @Override
    public Team findTeamById(String teamId) {
        return this.findById(Team.class, teamId);
    }

    @Override
    public NxftSubject findSubjectById(String subjectId) {
        return this.findById(NxftSubject.class, subjectId);
    }

}
