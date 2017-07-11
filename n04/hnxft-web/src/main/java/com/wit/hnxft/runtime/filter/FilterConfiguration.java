package com.wit.hnxft.runtime.filter;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.RequestContextFilter;

/**
 * 配置Servlet Filter，其执行顺序为：
 *
 * <ul>
 * <li>wit requestContextFilter</li>
 * <li>wit logFilter</li>
 * <li>spring security</li>
 * </ul>
 *
 * @author yw
 *
 */
@Configuration
public class FilterConfiguration {

    private static final int REQUEST_CONTEXT_FILTER_ORDER = SecurityProperties.DEFAULT_FILTER_ORDER + 100;
    private static final int LOG_FILTER_ORDER = REQUEST_CONTEXT_FILTER_ORDER + 10;

    // requestContextFilter

    @Bean
    public RequestContextFilter fxpRequestContextFilter() {
        return new RequestContextFilter();
    }

    @Bean
    public FilterRegistrationBean fxpRequestContextFilterRegistration(RequestContextFilter filter) {
        FilterRegistrationBean reg = new FilterRegistrationBean(filter);
        reg.addUrlPatterns("/*");
        reg.setOrder(REQUEST_CONTEXT_FILTER_ORDER);
        return reg;
    }

    // logFilter

    @Bean
    public LogFilter logFilter() {
        return new LogFilter();
    }

    @Bean
    public FilterRegistrationBean logFilterRegistration(LogFilter filter) {
        FilterRegistrationBean reg = new FilterRegistrationBean(filter);
        reg.addUrlPatterns("/*");
        reg.setOrder(LOG_FILTER_ORDER);
        return reg;
    }

}
