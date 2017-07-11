package com.wit.hnxft.runtime.nxft;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.wit.fxp.nxft.impl.NxftImplRoot;

@Configuration
@ComponentScan(basePackageClasses = NxftImplRoot.class)
public class NxftImplConfiguration {

}
