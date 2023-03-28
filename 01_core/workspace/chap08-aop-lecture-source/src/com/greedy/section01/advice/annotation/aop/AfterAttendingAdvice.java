package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAttendingAdvice {
	
	@After("execution(* com.greedy.section01.advice.annotation..*(..))")
	public void afterAttending(JoinPoint joinPoint) {
		System.out.println("============== after attending ===============");
		System.out.println("내일도 학원에 가서 열심히 공부해야지!! 라는 마음으로 잠자리에 듭니다.");
		System.out.println("==============================================");
	}
}
