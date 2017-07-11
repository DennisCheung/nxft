package com.wit.fxp.nxft.domain.model.sis.checker;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HibernateSisCheckerRepoImpl implements SisCheckerRepo {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerrepoimpl.template
     */

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateSisCheckerRepoImpl(@Qualifier("nxft.hibernateSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void findSisServiceResource() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.sis.SisServiceResource");
        q.setMaxResults(1);
        q.getResultList();
    }

}
