package com.netease.springbootDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.springbootDemo.dao.CityDao;
import com.netease.springbootDemo.service.CityService;
import com.netease.springbootDemo.vo.CityVo;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;

	public List<CityVo> findAll() {
		return this.cityDao.findAll();
	}
}