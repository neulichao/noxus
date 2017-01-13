package com.netease.springbootDemo;

import org.springframework.boot.SpringApplication;

import com.netease.springbootDemo.config.ConfigBean;

public class MainDemo {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication();
		app.run(ConfigBean.class, args);
	}

}
