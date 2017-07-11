package com.wit.hnxft.runtime.db;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;

/**
 * 环境配置器接口。本接口的作用有二，一是明确定义了需要做哪些配置，二是屏蔽了环境的不确定性。
 *
 * @author yw
 *
 */
public interface DatabaseConfigurer {

    @Bean
    DataSource dataSource();

    /**
     * Hibernate会话工厂。
     *
     * @return
     */
    @Bean
    SessionFactory sessionFactory() throws Exception;

}
