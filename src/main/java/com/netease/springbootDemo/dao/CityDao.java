package com.netease.springbootDemo.dao;

import java.util.List;

import com.netease.springbootDemo.vo.CityVo;

public interface CityDao {

	public List<CityVo> findAll();

}