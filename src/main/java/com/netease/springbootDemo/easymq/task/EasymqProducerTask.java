package com.netease.springbootDemo.easymq.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.netease.lottery.easymq.common.exception.MqBussinessException;
import com.netease.lottery.easymq.common.exception.MqWapperException;
import com.netease.lottery.easymq.producer.EasyMQProducer;
import com.netease.lottery.easymq.producer.EasyMQProducerFactory;

@Component
@EnableScheduling
public class EasymqProducerTask {

	private static final Logger logger = LoggerFactory.getLogger(EasymqProducerTask.class);

	// 每20秒执行一次
	@Scheduled(cron = "0/20 * * * * ?")
	public void testProducer() {
		EasyMQProducer producer = EasyMQProducerFactory.getProducer();
		try {
			//producer.sendMsg("topic20161116", "order10", "order10detail");
			logger.info("begin producer some messages~~~~~");
			long begin = System.currentTimeMillis();
			for (int i = 10; i <= 14; i++) {
				producer.sendMsgOrderly("topic20161119", i + "", i + "detail", "onlyyou");
			}
			logger.info("send,taking {} ms", (System.currentTimeMillis() - begin));
		} catch (MqWapperException e) {
			logger.error("easymq producer MqWapperException", e);
		} catch (MqBussinessException e) {
			logger.error("easymq producer MqBussinessException", e);
		}
	}

}
