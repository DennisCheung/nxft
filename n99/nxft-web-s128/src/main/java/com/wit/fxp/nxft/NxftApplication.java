package com.wit.fxp.nxft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

@NxftWebRuntime
public class NxftApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(NxftApplication.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("启动S128暖心饭堂服务器。");
        SpringApplication.run(NxftApplication.class, args);
    }

}
