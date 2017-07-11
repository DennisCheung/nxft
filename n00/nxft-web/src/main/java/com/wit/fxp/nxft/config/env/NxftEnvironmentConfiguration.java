package com.wit.fxp.nxft.config.env;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wit.annotations.Fxp;
import com.wit.fxp.config.env.FxpEnvironmentConfiguration;
import com.wit.fxp.nxft.annotation.NxftHibernateSessionFactory;

/**
 * nxft环境配置基类。
 *
 * @author yw
 *
 */
@Configuration
public class NxftEnvironmentConfiguration extends FxpEnvironmentConfiguration {

    @Override
    @Bean(name = {"fxp.hibernateSessionFactory", "nxft.hibernateSessionFactory"})
    @Fxp
    @NxftHibernateSessionFactory
    public SessionFactory sessionFactory() throws Exception {
        return super.sessionFactory();
    }

    @Override
    public String[] packagesToScan() {
        return new String[] {
                "com.wit.fxp"
        };
    }

}
