package com.wit.fxp.nxft.domain.model.order.checker;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HibernateOrderCheckerRepoImpl implements OrderCheckerRepo {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerrepoimpl.template
     */

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateOrderCheckerRepoImpl(@Qualifier("nxft.hibernateSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void findDeliveCreateLog() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.order.DeliveCreateLog");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findDeliveDetail() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.order.DeliveDetail");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findDeliveNote() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.order.DeliveNote");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findNxftOrder() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.order.NxftOrder");
        q.setMaxResults(1);
        q.getResultList();
    }

}
