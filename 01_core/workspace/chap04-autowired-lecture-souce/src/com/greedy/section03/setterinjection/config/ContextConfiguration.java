package com.greedy.section03.setterinjection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.greedy.section03.setterinjection.RandomGenerator;
import com.greedy.section03.setterinjection.RandomNumberGenerator;

@Configuration
@ComponentScan(basePackages = "com.greedy.section03.setterinjection")
public class ContextConfiguration {
	
	@Bean
	public RandomGenerator randomGenerator() throws Exception {
		
		return new RandomNumberGenerator(1, 10);
	}

}
