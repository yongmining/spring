package com.greedy.section01.fieldinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		

		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.greedy.section01.fieldinjection");
	
		BookService bookService = context.getBean("bookService", BookService.class);
		
//		bookService.findAllBooks().forEach(System.out::println);
		
		for(BookDTO b : bookService.findAllBooks()) {
			System.out.println(b);
		}
	}

}
