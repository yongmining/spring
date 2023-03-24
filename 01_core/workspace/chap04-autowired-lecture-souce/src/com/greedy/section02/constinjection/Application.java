package com.greedy.section02.constinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section02.constinjection.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		MakeRandomString randomString = context.getBean(MakeRandomString.class);
		
		System.out.println(randomString.getRandomLengthString());
	}

}
