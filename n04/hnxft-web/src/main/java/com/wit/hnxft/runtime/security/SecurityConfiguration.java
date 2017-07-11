package com.wit.hnxft.runtime.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfiguration {

    @Autowired private DataSource dataSource;

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .eraseCredentials(false)
        .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select fuser_id as username, fpassword as password, '1' as enabled from fxp.p_user where fuser_id = ?")
                .authoritiesByUsernameQuery("select fuser_id as username, 'USER' as authorities from fxp.p_user where fuser_id = ?");
    }

    @Bean
    public UserDetailsService userDetailServiceBean(AuthenticationManagerBuilder auth) {
        return auth.getDefaultUserDetailsService();
    }

//    /**
//     * 开放地址，不受Spring Security保护。
//     *
//     * @author yw
//     *
//     */
//    @Configuration
//    @Order(1)
//    public static class PublicWebSecurityConfigurer extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                .csrf().disable()
//                .headers()
//                    .disable()
//                .antMatcher("/public/**")
//                .authorizeRequests()
//                    .anyRequest().permitAll();
//        }
//
//    }

    /**
     * 默认安全性。
     *
     * @author yw
     *
     */
    @Configuration
    @Order(1)
    public static class DefaultWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .csrf().disable()
                .headers().disable()
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .and()
                .logout()
                    .permitAll();
        }

    }

}
