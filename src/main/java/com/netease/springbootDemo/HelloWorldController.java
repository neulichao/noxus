package com.netease.springbootDemo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netease.springbootDemo.service.CityService;
import com.netease.springbootDemo.vo.CityVo;

/**
 * Hello world!
 *
 */
@RestController
public class HelloWorldController {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@Autowired
	private CityService cityService;

	@RequestMapping("/index/{name}")
	public String index(@PathVariable String name) {
		if (null == name) {
			name = "boy";
		}
		logger.info("name={}", name);
		return "hello world" + name;
	}

	@RequestMapping("/city/findAll.html")
	public String findCity() {
		List<CityVo> cityList = cityService.findAll();
		logger.info("cityList:{}", cityList);
		return cityList.toString();
	}

}
