package com.netease.springbootDemo.dubbo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;
import com.netease.springbootDemo.dubbo.DubboDemoService;

//注意这个service不是spring的，是dubbo的
@Service
public class DubboDemoServiceImpl implements DubboDemoService {

	private static final Logger logger = LoggerFactory.getLogger(DubboDemoServiceImpl.class);

	@Override
	public String test() {
		logger.info("dubbo service test~~~~~~~~");
		return "hello dubbo";
	}

}
