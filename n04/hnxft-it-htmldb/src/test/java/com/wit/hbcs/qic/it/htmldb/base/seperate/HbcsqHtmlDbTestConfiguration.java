package com.wit.hbcs.qic.it.htmldb.base.seperate;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.wit.fxp.it.base.htmldb.FxpHtmlDbTestConfiguration;

@EnableConfigurationProperties
@Import({FxpHtmlDbTestConfiguration.class, DataSourceProperties.class})
public class HbcsqHtmlDbTestConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(HbcsqHtmlDbTestConfiguration.class);

    @Bean(destroyMethod = "close")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.tomcat")
    public DataSource dataSource(DataSourceProperties dsp) {
        LOGGER.info("创建数据源：{}", dsp.getUrl());
        return DataSourceBuilder.create()
                .driverClassName(dsp.getDriverClassName())
                .url(dsp.getUrl())
                .username(dsp.getUsername())
                .password(dsp.getPassword())
                .build();
    }

}
