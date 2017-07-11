package com.wit.fxp.nxft.ui;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 本注解表示系统的MainPresenter。设计本注解的目的是为了解除{@code ScUI}和{@code ScMainPresenter}之间的双向依赖关系。
 *
 * @author zqx
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.FIELD})
@Documented
@Qualifier
public @interface NxftMealMainPresenterBean {

}
