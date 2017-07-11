package com.wit.hnxft.runtime;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wit.annotations.BeanOverrideBeanFactoryProcessor;

@Configuration
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
@Import({BeanOverrideBeanFactoryProcessor.class})
public class HnxftRuntimeConfiguration {

}
