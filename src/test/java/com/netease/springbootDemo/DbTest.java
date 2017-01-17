package com.netease.springbootDemo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.netease.springbootDemo.dao.CityDao;
import com.netease.springbootDemo.vo.CityVo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfigBean.class)
public class DbTest {

	@Autowired
	private CityDao cityDao;

	@Test
	public void testFindAll() {
		List<CityVo> vos = cityDao.findAll();
		System.out.println(vos);
	}

}
