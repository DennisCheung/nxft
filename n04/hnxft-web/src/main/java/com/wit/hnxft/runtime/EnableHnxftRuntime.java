package com.wit.hnxft.runtime;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;

import com.wit.fxp.domain.EnableFxpDomain;
import com.wit.fxp.impl.tsp.EnableTspImpl;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited

@Order(0)
@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
@EnableConfigurationProperties
@EnableFxpDomain
@EnableTspImpl
@Import(HnxftRuntimeConfiguration.class)
public @interface EnableHnxftRuntime {

}
