package com.greedy.section01.aop.annotation.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.greedy.section01.aop.annotation", annotationClass = Mapper.class)
public class MyBatisConfiguration {

}
