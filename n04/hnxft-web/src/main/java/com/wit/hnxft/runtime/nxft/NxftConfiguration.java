package com.wit.hnxft.runtime.nxft;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.wit.fxp.nxft.domain.NxftDomainRoot;

@Configuration
@ComponentScan(basePackageClasses = NxftDomainRoot.class)
public class NxftConfiguration {

}
