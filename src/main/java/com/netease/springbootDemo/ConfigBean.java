package com.netease.springbootDemo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/** 
* @author bjchenyuan
* @version 2016年9月28日 下午5:37:40
*/
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.netease.springbootDemo")
@PropertySource("classpath:META-INF/test.properties")
public class ConfigBean {

}
