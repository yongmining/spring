package com.greedy.section02.mapperscan.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.greedy.section02.mapperscan", annotationClass = Mapper.class)
public class MyBatisConfiguration {

}
