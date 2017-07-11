package com.wit.hnxft.runtime.db;

import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.EntityType;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wit.annotations.Fxp;

@Service
public class DatabaseChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseChecker.class);

    private final SessionFactory sessionFactory;

    public DatabaseChecker(@Fxp SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void checkDatabase() {
        LOGGER.info("检查数据库表结构与对象模型是否一致...");

        int[] count = new int[] {0};

        Set<EntityType<?>> entities = ((EntityManagerFactory) sessionFactory).getMetamodel().getEntities();
        entities.forEach(e -> {
            String hql = "from " + e.getJavaType().getName();
            LOGGER.info("检查实体({}/{})：{}", ++count[0], entities.size(), e.getJavaType().getName());

            Query<?> q = this.sessionFactory.getCurrentSession().createQuery(hql);
            q.setMaxResults(1);
            q.getResultList();
        });

        LOGGER.info("检查数据库表结构与对象模型是否一致...通过！共找到{}个实体对象", entities.size());
    }

}
