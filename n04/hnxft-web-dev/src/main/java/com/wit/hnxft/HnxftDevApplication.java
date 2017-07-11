package com.wit.hnxft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Profile;

import com.wit.hnxft.runtime.EnableHnxftRuntime;

@Profile("indep")
@EnableHnxftRuntime
public class HnxftDevApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HnxftDevApplication.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("启动暖心饭堂Hnxft客户端-独立开发模式。");

        // 增加参数
        String[] a = new String[args.length + 1];
        for (int i = 0; i < args.length; i++) {
            a[i] = args[i];
        }
        a[a.length - 1] = "--spring.profiles.active=dev,indep";

        SpringApplication.run(HnxftDevApplication.class, a);
    }

}
