package com.greedy.section02.locale.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ContextConfiguration {

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		
		/* 접속하는 세션의 로케일에 따라 자동 재로딩하는 용도의 MessageSource 구현체 */
		ReloadableResourceBundleMessageSource messageSource =
				new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasename("message");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(10);
		
		return messageSource;
	}
}
