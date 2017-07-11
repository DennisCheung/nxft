package com.wit.fxp.nxft.config.tomcat;

import java.io.File;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(TomcatConfiguration.class);

    /**
     * 定制Tomcat。
     *
     * <ul>
     * <li>如果nxft-web为目录则设置{@code documentRoot}为{@code nxft-web/target/classes}。
     * </ul>
     *
     * @return
     */
    @Bean
    public EmbeddedServletContainerCustomizer nxftEmbeddedServletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {

            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                setDocumentRoot(container);
            }

        };
    }

    /**
     * 判断nxft-web是jar包还是解开的目录，如果是目录则设置{@code documentRoot}为{@code nxft-web/target/classes}。
     *
     * @return
     */
    private void setDocumentRoot(ConfigurableEmbeddedServletContainer container) {
        // nxft-web里任意一个类
        Class<?> clazz = TomcatConfiguration.class;

        URL url = clazz.getResource(clazz.getSimpleName() + ".class");
        if ("file".equals(url.getProtocol())) {
            String path = url.getPath();

            // 把nxft-web替换为nxft-themes
            int index = path.lastIndexOf("/nxft-web/");
            path = path.substring(0, index) + "/nxft-themes/" + path.substring(index + "/nxft-web/".length());
            path = path.replace("/n00", "");

            // 截取到target
            path = path.substring(1, path.length() - clazz.getName().length() - ".class".length() - 1);

            try {
                File docRootFile = new File(path).getCanonicalFile();
                LOGGER.info("设置WEB应用根路径为：{}", docRootFile.getAbsolutePath());
                container.setDocumentRoot(docRootFile);
            }
            catch (Exception ex) {
                throw new RuntimeException("目录不存在：" + path, ex);
            }
        }
    }

}
