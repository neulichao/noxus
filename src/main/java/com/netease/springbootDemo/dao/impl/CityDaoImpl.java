package com.netease.springbootDemo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netease.springbootDemo.dao.CityDao;
import com.netease.springbootDemo.vo.CityVo;

@Repository
public class CityDaoImpl extends BaseDao implements CityDao {
	public List<CityVo> findAll() {
		return getSqlSessionTemplate().selectList("findAll");
	}
}