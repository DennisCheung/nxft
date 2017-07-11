package com.wit.fxp.nxft.domain.model.subject.repo;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.benewit.criteria.DynamicWhereEnum;
import com.benewit.criteria.Order;
import com.benewit.orm.hibernate.support.WitHibernateDaoSupport;
import com.wit.fxp.nxft.annotation.NxftHibernateSessionFactory;
import com.wit.fxp.nxft.domain.model.dict.repo.NxftSubjectTypeRepo;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;
import com.wit.fxp.nxft.domain.model.subject.metadata.NxftSubjectMetadata;

@Transactional
@Repository
public class NxftSubjectRepoImpl extends WitHibernateDaoSupport implements NxftSubjectRepo {

    @Autowired NxftSubjectTypeRepo nxftSubjectTypeRepo;

    @Override
    public NxftSubject findNxftSubject(String circleId, String personId) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.personInfo().circleId().eq(circleId))
                .def(null, root.personInfo().personId().eq(personId))
                .where(DynamicWhereEnum.AND_ALL)
                .uniqueResult();
    }

    @Override
    public NxftSubject findNxftSubjectByTeam(String teamId, String personId) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.personInfo().personId().eq(personId))
                .def(null, root.subjectInfo().deliveSiteId().eq(teamId))
                .where(DynamicWhereEnum.AND_ALL)
                .uniqueResult();
    }

    @Override
    public List<NxftSubject> findNxftSubjectByTeamId(String teamId) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.subjectInfo().deliveSiteId().eq(teamId))
                .where(DynamicWhereEnum.AND_ALL)
                .list();
    }

    @Autowired
    public NxftSubjectRepoImpl(@NxftHibernateSessionFactory SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public int newCreateSubjectInDate(String teamId, Date begin, Date end) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        Object[] result =  this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.createInfo().createTime().ge(begin))
                .def(null, root.createInfo().createTime().le(end))
                .def(null, root.subjectInfo().deliveSiteId().eq(teamId))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return result == null || result[0] == null ? 0 : ((Long) result[0]).intValue();
    }

    @Override
    public int subjectCountInType(String teamId, String typeCode) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        Object[] result =  this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, typeCode == null ? null : root.subjectInfo().subjectTypeId().eq(typeCode))
                .def(null, root.subjectInfo().deliveSiteId().eq(teamId))
                .select(rowCount())
                .where(DynamicWhereEnum.AND_ALL)
                .rows()
                .uniqueResult();
        return result == null || result[0] == null ? 0 : ((Long) result[0]).intValue();
    }

    @Override
    public List<NxftSubject> findSubjectListByTeamId(String teamId) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.subjectInfo().deliveSiteId().eq(teamId))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.personInfo().subjectName()))
                .list();
    }

    @Override
    public List<NxftSubject> findSubjectListByCircleid(String teamId, Integer startIndex, Integer pageSize) {
        NxftSubjectMetadata<NxftSubject> root = NxftSubjectMetadata.root();
        return this.newWitHibernateTemplate().createCriteria(root.getObjectTree())
                .def(null, root.subjectInfo().deliveSiteId().eq(teamId))
                .where(DynamicWhereEnum.AND_ALL)
                .orderBy(Order.desc(root.createInfo().createTime()))
                .setPageRange(startIndex, pageSize)
                .list();
    }

}
