package com.netease.springbootDemo.cache;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CacheTest {
	private static final Logger logger = LoggerFactory.getLogger(CacheTest.class);

	@PostConstruct
	public void init() {
		logger.info("加载CacheTest类----~~~");
	}
}