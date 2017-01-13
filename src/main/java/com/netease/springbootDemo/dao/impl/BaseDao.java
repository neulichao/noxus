package com.netease.springbootDemo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

import com.netease.springbootDemo.dto.Page;

public class BaseDao {

	@Resource
	public SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public <T> Page<T> getPageList(Page<T> page, String listSql, String countSql, Object param) {
		return getPageList(page, listSql, countSql, param, sqlSessionTemplate);
	}

	public <T> Page<T> getPageList(Page<T> page, String listSql, String countSql, Object param,
			SqlSessionTemplate sqlSessionTemplate) {
		int skipResults = (page.getPageNo() - 1) * page.getPageSize();
		if (page.getPageNo() < 1) {
			skipResults = 0;
		}
		int maxResults = page.getPageSize();
		List<T> resultList = sqlSessionTemplate.selectList(listSql, param, new RowBounds(skipResults, maxResults));
		page.setResult(resultList);
		int totalCount = sqlSessionTemplate.selectOne(countSql, param);
		page.setTotalCount(totalCount);
		return page;
	}

}
