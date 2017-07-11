package com.wit.hnxft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import com.wit.hnxft.runtime.EnableHnxftRuntime;

@EnableHnxftRuntime
public class HnxftApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HnxftApplication.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("启动暖心饭堂-助餐点数据墙-客户端-生产模式。");
        SpringApplication.run(HnxftApplication.class, args);
    }

}
