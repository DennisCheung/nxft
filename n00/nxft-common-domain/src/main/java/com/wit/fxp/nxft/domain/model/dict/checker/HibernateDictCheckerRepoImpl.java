package com.wit.fxp.nxft.domain.model.dict.checker;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HibernateDictCheckerRepoImpl implements DictCheckerRepo {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerrepoimpl.template
     */

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateDictCheckerRepoImpl(@Qualifier("nxft.hibernateSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void findCircleKitchen() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.dict.CircleKitchen");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findFoodLove() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.dict.FoodLove");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findFoodProhibit() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.dict.FoodProhibit");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findMealType() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.dict.MealType");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findSubjectAssistance() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.dict.SubjectAssistance");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findSubjectType() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.dict.SubjectType");
        q.setMaxResults(1);
        q.getResultList();
    }

}
