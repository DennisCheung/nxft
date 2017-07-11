package com.wit.fxp.nxft.env;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "printreport")
@Data
public class Nxft02Properties {

    /**
     * 打印根目录
     */
    private String rootUrl;

    private String nxftUrl;
}
