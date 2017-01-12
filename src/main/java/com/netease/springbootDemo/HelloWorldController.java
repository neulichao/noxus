package com.netease.springbootDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
public class HelloWorldController
{
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@RequestMapping("/index/{name}")
	public String index(@PathVariable String name)
	{
		if (null == name)
		{
			name = "boy";
		}
		logger.info("name={}", name);
		return "hello world" + name;
	}
}
