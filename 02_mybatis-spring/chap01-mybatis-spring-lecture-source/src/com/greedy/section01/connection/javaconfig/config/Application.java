package com.greedy.section01.connection.javaconfig.config;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.connection.javaconfig.ContextConfiguration;
import com.greedy.section01.connection.javaconfig.MenuDTO;
import com.greedy.section01.connection.javaconfig.MenuService;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext(ContextConfiguration.class);

		MenuService menuService = context.getBean("menuService", MenuService.class);
		List<MenuDTO> menus = menuService.findAllMenus();
		for(MenuDTO menu : menus) {
			System.out.println(menu);
		}
	}

}
