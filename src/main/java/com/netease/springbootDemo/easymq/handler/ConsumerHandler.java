package com.netease.springbootDemo.easymq.handler;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netease.lottery.easymq.consumer.bean.MessageBean;
import com.netease.lottery.easymq.consumer.handler.EasyMQRecMsgHandler;
import com.netease.lottery.easymq.consumer.handler.annotation.EasyMQConsumerMeta;

@EasyMQConsumerMeta(topic = "topic20161119", group = "group1")
public class ConsumerHandler implements EasyMQRecMsgHandler {

	private static final Logger logger = LoggerFactory.getLogger(ConsumerHandler.class);

	private volatile static AtomicInteger count = new AtomicInteger(0);

	@Override
	public void handle(List<MessageBean> msg) throws Exception {

		for (MessageBean message : msg) {
			int nowCount = count.incrementAndGet();
			int keyInt = Integer.parseInt(message.getKey());
			logger.info("group1 PaySuccessMQHandler" + message);
			logger.info("group1 key:" + message.getKey());
			logger.info("group1 message:" + message.getMessage());
			logger.info("nowCount:{}", nowCount);
			if (keyInt % 3 == 0) {
				logger.info("" + new Date());
				throw new RuntimeException();
			}
		}

	}
}
