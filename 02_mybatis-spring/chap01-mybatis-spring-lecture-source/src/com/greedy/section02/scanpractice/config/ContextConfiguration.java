package com.greedy.section02.scanpractice.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.greedy.section02.scanpractice")
@PropertySource("connection-info.properties")
public class ContextConfiguration {

	@Value("${oracle.dev.driver:}")
	private String driver;
	
	@Value("${oracle.dev.url:}")
	private String url;
	
	@Value("${oracle.dev.username:}")
	private String username;
	
	@Value("${oracle.dev.password:}")
	private String password;
	
	@Bean (destroyMethod="close")
	public BasicDataSource dataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDefaultAutoCommit(false);
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		
		return factoryBean.getObject();
		}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		
		return new SqlSessionTemplate(sqlSessionFactory());
		
	}
	
}
