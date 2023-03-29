package com.greedy.section01.connection.xmlconfig;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.greedy.section01.connection.javaconfig.MenuDTO;
import com.greedy.section01.connection.javaconfig.MenuService;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new GenericXmlApplicationContext("com/greedy/section01/connection/xmlconfig/spring-context.xml");

		MenuService menuService = context.getBean("menuService", MenuService.class);
		List<MenuDTO> menus = menuService.findAllMenus();
		for(MenuDTO menu : menus) {
			System.out.println(menu);
		}
	}

}
