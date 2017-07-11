package com.wit.hnxft.runtime.db;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.wit.annotations.Fxp;
import com.wit.fxp.nxft.annotation.NxftHibernateSessionFactory;

/**
 * 环境配置基类。
 *
 * @author yw
 *
 */
@Configuration
public class DatabaseConfiguration implements DatabaseConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Override
    @Bean(destroyMethod = "close")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.tomcat")
    public DataSource dataSource() {
        LOGGER.info("创建数据源：{}", dataSourceProperties.getUrl());
        return DataSourceBuilder.create()
                .driverClassName(dataSourceProperties.getDriverClassName())
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .build();
    }

    @Override
    @Bean(name = {"fxp.hibernateSessionFactory", "nxft.hibernateSessionFactory"})
    @Fxp
    @NxftHibernateSessionFactory
    public SessionFactory sessionFactory() throws Exception {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());

        String[] locations = {"classpath*:/com/wit/**/domain/**/*.hbm.xml"};
        for (String location : locations) {
            Resource[] wtpdMappingResources = applicationContext.getResources(location);
            for (Resource resource : wtpdMappingResources) {
                builder.addInputStream(resource.getInputStream());
            }
        }

        // 添加通过注解定义的实体对象
        String[] packages = packagesToScan();
        if (packages != null) {
            builder.scanPackages(packages);
        }

        builder.setProperty("hibernate.dialect", org.hibernate.dialect.H2Dialect.class.getName());
        builder.setProperty("hibernate.default_batch_fetch_size", "64");
        builder.setInterceptor(hibernateLogginInterceptor());

        return builder.buildSessionFactory();
    }

    @Bean
    @Primary
    public HibernateTransactionManager transactionManager() throws Exception {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory());
        return txManager;
    }

//  @Bean
//  public PersistenceExceptionTranslationPostProcessor exceptionTransalation() {
//      return new PersistenceExceptionTranslationPostProcessor();
//  }

    @Bean
    public HibernateLoggingInterceptor hibernateLogginInterceptor() {
        return new HibernateLoggingInterceptor();
    }

    protected String[] packagesToScan() {
        return new String[] {
            "com.wit.hnxft",
            "com.wit.fxp"
        };
    }

}
