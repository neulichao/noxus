package com.netease.springbootDemo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.netease.springbootDemo" }, excludeFilters = { @Filter(type = FilterType.REGEX, pattern = { "com.netease.springbootDemo.filterDemo..*" }) })
public class ConfigBean {

}