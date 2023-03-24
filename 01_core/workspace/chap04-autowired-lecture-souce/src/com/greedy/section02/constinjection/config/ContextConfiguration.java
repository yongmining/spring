package com.greedy.section02.constinjection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.greedy.section02.constinjection.RandomGenerator;
import com.greedy.section02.constinjection.RandomNumberGenerator;

@Configuration
@ComponentScan(basePackages = "com.greedy.section02.constinjection")
public class ContextConfiguration {
	
	@Bean
	public RandomGenerator randomGenerator() throws Exception {
		
		return new RandomNumberGenerator(1, 10);
	}

}
