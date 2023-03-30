package com.greedy.section02.mapperscan.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section02.mapperscan.config.ContextConfiguration;
import com.greedy.section02.mapperscan.model.service.MenuService;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		
		
		MenuService menuService = context.getBean("menuService2", MenuService.class);
		menuService.findAllMenus().forEach(System.out::println);
	}

}
