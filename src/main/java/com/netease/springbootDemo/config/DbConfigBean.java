package com.netease.springbootDemo.config;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.filter.logging.Log4jFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;

@Configuration
@EnableTransactionManagement
public class DbConfigBean {
	@Bean(name = { "dbProperty" })
	@ConfigurationProperties(locations = { "classpath:META-INF/Druid.properties" }, prefix = "jdbc-1.druid")
	public Properties dbProperty() {
		return new Properties();
	}

	@Bean(name = { "statFilter" })
	public StatFilter getStatFilter(@Qualifier("dbProperty") Properties dbProperty) {
		System.out.println(dbProperty);
		StatFilter filter = new StatFilter();
		filter.setLogSlowSql(Boolean.parseBoolean(dbProperty.getProperty("logSlowSql")));
		filter.setSlowSqlMillis(Long.parseLong(dbProperty.getProperty("slowSqlMillis")));
		filter.setMergeSql(Boolean.parseBoolean(dbProperty.getProperty("mergeSql")));
		return filter;
	}

	@Bean(name = { "logFilter" })
	public Log4jFilter getLog4jFilter(@Qualifier("dbProperty") Properties property) {
		Log4jFilter filter = new Log4jFilter();
		filter.setDataSourceLogEnabled(Boolean.parseBoolean(property.getProperty("dataSourceLogEnabled")));
		filter.setConnectionLogEnabled(Boolean.parseBoolean(property.getProperty("connectionLogEnabled")));
		filter.setConnectionLogErrorEnabled(Boolean.parseBoolean(property.getProperty("connectionLogErrorEnabled")));
		filter.setStatementLogEnabled(Boolean.parseBoolean(property.getProperty("statementLogEnabled")));
		filter.setStatementLogErrorEnabled(Boolean.parseBoolean(property.getProperty("statementLogErrorEnabled")));
		filter.setResultSetLogEnabled(Boolean.parseBoolean(property.getProperty("resultSetLogEnabled")));
		filter.setResultSetLogErrorEnabled(Boolean.parseBoolean(property.getProperty("resultSetLogErrorEnabled")));
		return filter;
	}

	@Bean(name = { "dataSource" })
	public DruidDataSource dataSource(@Qualifier("dbProperty") Properties property,
			@Qualifier("statFilter") StatFilter statFilter, @Qualifier("logFilter") Log4jFilter log4jFilter)
			throws SQLException {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setName(property.getProperty("dsName"));
		druidDataSource.setDriverClassName(property.getProperty("driverClassName"));
		druidDataSource.setUrl(property.getProperty("url"));
		druidDataSource.setUsername(property.getProperty("user"));
		druidDataSource.setPassword(property.getProperty("password"));
		druidDataSource.setInitialSize(Integer.parseInt(property.getProperty("initialSize")));
		druidDataSource.setMinIdle(Integer.parseInt(property.getProperty("minIdle")));
		druidDataSource.setMaxActive(Integer.parseInt(property.getProperty("maxActive")));
		druidDataSource.setValidationQuery(property.getProperty("validationQuery"));
		druidDataSource.setTestOnBorrow(false);
		druidDataSource.setTestOnReturn(false);
		druidDataSource.setTestWhileIdle(true);
		druidDataSource.setTimeBetweenEvictionRunsMillis(60000L);
		druidDataSource.setMaxEvictableIdleTimeMillis(93600000L);
		druidDataSource.setPoolPreparedStatements(Boolean.parseBoolean(property.getProperty("poolPreparedStatements")));
		druidDataSource
				.setMaxOpenPreparedStatements(Integer.parseInt(property.getProperty("maxOpenPreparedStatements")));

		druidDataSource.setTimeBetweenLogStatsMillis(Long.parseLong(property.getProperty("timeBetweenLogStatsMillis")));
		List filters = Lists.newArrayList();
		filters.add(log4jFilter);
		filters.add(statFilter);
		druidDataSource.setProxyFilters(filters);
		return druidDataSource;
	}

	@Bean(name = { "sqlSessionFactory" })
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DruidDataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:sqlmap/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name = { "transactionManager" })
	public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DruidDataSource dataSource)
			throws SQLException {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = { "sqlSessionTemplate" })
	public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}