package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAttendingAdvice {
	
	@Before("execution(* com.greedy.section01.advice.annotation..*(..))")
	public void beforeAttending(JoinPoint joinPoint) {
		System.out.println("============== brfore attending ================");
		System.out.println("오늘도 신나게 등원해서 입실 카드를 찍는다.");
		System.out.println("수강생 타입 : " + joinPoint.getTarget().getClass());
		System.out.println("수강생의 행위 : " + joinPoint.getSignature());
		System.out.println("행위 요약 : " + joinPoint.getSignature().getName());
		System.out.println("수강생의 열정 : " + joinPoint.getArgs()[0]);
		System.out.println("================================================");
		
		
	}

}
