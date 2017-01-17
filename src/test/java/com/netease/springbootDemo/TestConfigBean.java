package com.netease.springbootDemo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.netease.springbootDemo.config.ConfigBean;

@Configuration
@EnableAutoConfiguration(exclude = ConfigBean.class)
@ComponentScan(basePackages = { "com.netease.springbootDemo.dao", "com.netease.springbootDemo.config" }, excludeFilters = { @Filter(type = FilterType.ASSIGNABLE_TYPE, value = { ConfigBean.class }) })
public class TestConfigBean {

}
