package com.netease.springbootDemo.easymq;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netease.lottery.easymq.consumer.EasyMQConsumerManager;

@Component
public class ConsumerBean {

	private static final Logger logger = LoggerFactory.getLogger(ConsumerBean.class);

	@PostConstruct
	public void init() {
		logger.info("easyMq consumer start~~~~");
		EasyMQConsumerManager.init();
	}

}
