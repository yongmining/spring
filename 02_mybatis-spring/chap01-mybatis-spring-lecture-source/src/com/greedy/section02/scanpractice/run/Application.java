package com.greedy.section02.scanpractice.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section02.scanpractice.model.service.MenuService;
import com.greedy.section02.scanpractice.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		MenuService menuService = context.getBean("menuService1", MenuService.class);
		menuService.findAllMenus().forEach(System.out::println);
		
		
		
	}

}
