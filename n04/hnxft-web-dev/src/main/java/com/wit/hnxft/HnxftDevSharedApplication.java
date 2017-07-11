package com.wit.hnxft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Profile;

import com.wit.hnxft.runtime.EnableHnxftRuntime;

@Profile("shared")
@EnableHnxftRuntime
public class HnxftDevSharedApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HnxftDevSharedApplication.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("启动hbcs企业号客户端-共享开发模式。");

        // 增加参数
        String[] a = new String[args.length + 1];
        for (int i = 0; i < args.length; i++) {
            a[i] = args[i];
        }
        a[a.length - 1] = "--spring.profiles.active=dev,shared";

        SpringApplication.run(HnxftDevSharedApplication.class, a);
    }

}
