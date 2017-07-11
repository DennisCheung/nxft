package com.wit.fxp.nxft.env;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "nxft.delive")
@Data
public class CompoundCreateConfigure {

    private Boolean handCreateVisiable;

    private Integer createDays;

}
