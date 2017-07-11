package com.wit.hnxft.runtime.tomcat;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfiguration {

    /**
     * 定制Tomcat。
     *
     * @return
     */
    @Bean
    public EmbeddedServletContainerCustomizer sfEmbeddedServletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {

            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
            }

        };
    }

}
