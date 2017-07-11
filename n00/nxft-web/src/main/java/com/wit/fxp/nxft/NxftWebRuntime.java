package com.wit.fxp.nxft;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.wit.fxp.EnableFxp;

/**
 * 定义Nxft WEB系统的运行环境。
 *
 * @author yw
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited

@Configuration
@Order(0)
@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})

@EnableFxp
@EnableConfigurationProperties
public @interface NxftWebRuntime {

}
