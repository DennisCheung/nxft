package com.wit.fxp.nxft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@NxftWebRuntime
public class NxftDevApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(NxftDevApplication.class);

    @Autowired ApplicationContext applicationContext;

    public static void main(String[] args) throws Exception {
        LOGGER.info("启动暖心饭堂开发服务器。");

        // TODO 配置为Security、Root和WebMvc三个Spring容器
        SpringApplicationBuilder builder = new SpringApplicationBuilder(NxftDevApplication.class);
        builder.build().run(args);
    }

}
