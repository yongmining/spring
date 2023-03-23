package com.greedy.section02.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
	
	public static void main(String[] args) {
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("com/greedy/section02/xmlconfig/config/spring-context.xml");
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println(beanName);
		}
	
	}
	
}
