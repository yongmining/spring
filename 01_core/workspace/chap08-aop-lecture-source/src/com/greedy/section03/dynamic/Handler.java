package com.greedy.section03.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

	private final Student student;
	
	public Handler(Student student) {
		this.student = student;

	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		// 타겟메소드 호출 전
		System.out.println("=============== 공부가 너무 하고싶습니다 ==================");
		System.out.println("호출 대상 메소드 : " + method);
		for(Object arg : args) {
			System.out.println("전달된 인자 : " + arg);
		}
		
		method.invoke(student, args);
		
		// 타겟메소드 호출 후
		System.out.println("=============== 공부를 마치고 수면학습을 시작합니다. ===============");
		
		return proxy;
	}
	
	

}
