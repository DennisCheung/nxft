package com.wit.hnxft.runtime.db;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.benewit.entity.AbstractLoggingEntity;
import com.benewit.entity.Logging;
import com.benewit.entity.PropertyChecker;

/**
 * 通过Hibernate的Interceptor接口实现实体日志功能，即{@link com.wisetop.wtp.core.entity.AbstractLoggingEntity}
 * 定义的六个log属性。
 *
 * @author ibm t42
 * @since 1.0
 */
public class HibernateLoggingInterceptor extends EmptyInterceptor {

    private static final long serialVersionUID = 5205915125383613952L;

    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateLoggingInterceptor.class);

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("\n\nHibernate In Action:\nonSave: " + entity + "\n");
        }

        if (entity instanceof PropertyChecker) {
            ((PropertyChecker) entity).checkProperties();
        }

        if (entity instanceof Logging) {
            String userId = getUserId();
            Date now = new Date();

            AbstractLoggingEntity<?> e = (AbstractLoggingEntity<?>) entity;
            e.onCreate(userId, now);

            for (int i = 0; i < propertyNames.length; i++) {
                if ("logInfo".equals(propertyNames[i])) {
                    state[i] = e.getLogInfo();
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("\n\nHibernate In Action:\nonDelete: entity" + entity + "\n");
        }
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("\n\nHibernate In Action:\nonFlushDirty: entity = " + entity + "\n");
        }

        if (entity instanceof PropertyChecker) {
            ((PropertyChecker) entity).checkProperties();
        }

        if (entity instanceof Logging) {
            String userId = getUserId();
            Date now = new Date();

            AbstractLoggingEntity<?> e = (AbstractLoggingEntity<?>) entity;
            e.onUpdate(userId, now);

            for (int i = 0; i < propertyNames.length; i++) {
                if ("logInfo".equals(propertyNames[i])) {
                    currentState[i] = e.getLogInfo();
                }
            }

            return true;
        }
        return false;
    }

    private String getUserId() {
        return "未知用户";
    }

}
