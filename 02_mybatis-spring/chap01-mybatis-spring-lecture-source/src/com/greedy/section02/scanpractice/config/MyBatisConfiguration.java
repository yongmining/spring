package com.greedy.section02.scanpractice.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.greedy.section02.scanpractice", annotationClass = Mapper.class)
public class MyBatisConfiguration {

	
}
