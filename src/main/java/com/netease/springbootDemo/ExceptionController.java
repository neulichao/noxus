package com.netease.springbootDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	@RequestMapping("/exception.html")
	public int index(@PathVariable String name) {
		logger.info("-----------------exception test demo-------------------}");
		return 1 / 0;
	}
}
