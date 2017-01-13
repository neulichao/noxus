package com.netease.springbootDemo.service;

import java.util.List;

import com.netease.springbootDemo.vo.CityVo;

public abstract interface CityService {
	public abstract List<CityVo> findAll();
}