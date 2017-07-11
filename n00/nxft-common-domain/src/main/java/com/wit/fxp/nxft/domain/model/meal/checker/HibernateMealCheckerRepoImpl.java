package com.wit.fxp.nxft.domain.model.meal.checker;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HibernateMealCheckerRepoImpl implements MealCheckerRepo {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerrepoimpl.template
     */

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateMealCheckerRepoImpl(@Qualifier("nxft.hibernateSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void findMealScheday() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.meal.MealScheday");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findMealSchenote() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.meal.MealSchenote");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findMealSet() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.meal.MealSet");
        q.setMaxResults(1);
        q.getResultList();
    }

}
