package com.netease.springbootDemo.filterDemo;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FilterExcludeDemo {
	private static final Logger logger = LoggerFactory.getLogger(FilterExcludeDemo.class);

	@PostConstruct
	public void init() {
		logger.info("加载FilterExcludeDemo类----~~~");
	}
}