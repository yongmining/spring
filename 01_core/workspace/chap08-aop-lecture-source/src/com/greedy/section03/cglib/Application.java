package com.greedy.section03.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class Application {

	public static void main(String[] args) {
		
		GreedyStudent student = new GreedyStudent();
		Handler handler = new Handler(student);
		
		GreedyStudent proxy = (GreedyStudent) Enhancer.create(GreedyStudent.class, handler);
		proxy.study(20);
				
	}
}
