package com.wit.fxp.nxft.ui;

import java.lang.annotation.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.wit.fxp.ui.presenter.VaadinPresenter;

/**
 * 用户进入系统时自动创建其{@link com.wit.fxp.sc.ui.session.ScUserContext 会话}。
 *
 * @author zqx
 *
 */
@UIScope
@SpringComponent
public class NxftKitchenViewChangeListener implements ViewChangeListener {

    private static final long serialVersionUID = -3421503745025331503L;

    private final ApplicationContext applicationContext;

    @Autowired
    public NxftKitchenViewChangeListener(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public boolean beforeViewChange(ViewChangeEvent event) {
        preGetPresenter(event.getViewName(), UIScope.class);
        preGetPresenter(event.getViewName(), VaadinSessionScope.class);

        return true;
    }

    @Override
    public void afterViewChange(ViewChangeEvent event) {

    }

    /**
     * 提前获取View对应的Presenter对象。
     *
     * @param viewName 视图名
     * @param annotationType Presenter所带的注解类型
     */
    private void preGetPresenter(String viewName, Class<? extends Annotation> annotationType) {
        String[] beanNames = applicationContext.getBeanNamesForAnnotation(annotationType);
        for (String beanName : beanNames) {
            VaadinPresenter annotation = applicationContext.findAnnotationOnBean(beanName, VaadinPresenter.class);
            if (annotation != null && viewName.equals(annotation.viewName())) {
                applicationContext.getBean(beanName);
            }
        }
    }
}
