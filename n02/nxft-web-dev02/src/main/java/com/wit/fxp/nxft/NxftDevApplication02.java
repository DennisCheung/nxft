package com.wit.fxp.nxft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@NxftWebRuntime
public class NxftDevApplication02 {

    private static final Logger LOGGER = LoggerFactory.getLogger(NxftDevApplication02.class);

    @Autowired ApplicationContext applicationContext;

    public static void main(String[] args) throws Exception {
        LOGGER.info("启动02号暖心饭堂服务器。");

        // TODO 配置为Security、Root和WebMvc三个Spring容器
        SpringApplicationBuilder builder = new SpringApplicationBuilder(NxftDevApplication02.class);
        builder.build().run(args);
    }

}
