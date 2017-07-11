package com.wit.fxp.nxft.schedule.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "nxft.dex.job")
@Data
public class CompoundMealJobConfigure {

    private String jobUserid;

    private String jobNickname;

}
