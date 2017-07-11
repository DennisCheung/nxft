package com.wit.fxp.nxft.domain.model.subject.checker;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HibernateSubjectCheckerRepoImpl implements SubjectCheckerRepo {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerrepoimpl.template
     */

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateSubjectCheckerRepoImpl(@Qualifier("nxft.hibernateSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void findNxftSubject() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.subject.NxftSubject");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findNxftSubjectDisease() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.subject.NxftSubjectDisease");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findNxftSubjectFoodProhibit() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.subject.NxftSubjectFoodProhibit");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findNxftSubjectLivingCondi() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.subject.NxftSubjectLivingCondi");
        q.setMaxResults(1);
        q.getResultList();
    }

    @Override
    @Transactional
    public void findNxftSubjectSmsLog() {
        Query<?> q = this.sessionFactory.getCurrentSession().createQuery("from com.wit.fxp.nxft.domain.model.subject.NxftSubjectSmsLog");
        q.setMaxResults(1);
        q.getResultList();
    }

}
