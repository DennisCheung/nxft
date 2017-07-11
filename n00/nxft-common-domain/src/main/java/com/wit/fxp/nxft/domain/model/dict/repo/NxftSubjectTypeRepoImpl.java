package com.wit.fxp.nxft.domain.model.dict.repo;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.benewit.criteria.DynamicWhereEnum;
import com.benewit.criteria.Order;
import com.benewit.orm.hibernate.support.WitHibernateDaoSupport;
import com.wit.fxp.nxft.annotation.NxftHibernateSessionFactory;
import com.wit.fxp.nxft.domain.model.dict.SubjectType;
import com.wit.fxp.nxft.domain.model.dict.metadata.SubjectTypeMetadata;

@Transactional
@Repository
public class NxftSubjectTypeRepoImpl extends WitHibernateDaoSupport implements NxftSubjectTypeRepo {

    @Autowired
    public NxftSubjectTypeRepoImpl(@NxftHibernateSessionFactory SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<SubjectType> findSubjectTypeList() {
        SubjectTypeMetadata<SubjectType> root = SubjectTypeMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.available().eq(true))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.asc(root.subjectTypeCode()))
                .list();
    }

}
