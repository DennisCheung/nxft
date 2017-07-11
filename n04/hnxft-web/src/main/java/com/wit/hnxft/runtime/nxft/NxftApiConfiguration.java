package com.wit.hnxft.runtime.nxft;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.wit.fxp.nxft.app.NxftApiRoot;

@Configuration
@ComponentScan(basePackageClasses = NxftApiRoot.class)
public class NxftApiConfiguration {

}
