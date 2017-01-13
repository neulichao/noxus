package com.netease.springbootDemo.dao;

import java.util.List;

import com.netease.springbootDemo.vo.CityVo;

public abstract interface CityDao {
	public abstract List<CityVo> findAll();
}