package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.greedy.section01.advice.annotation.AchievementResult;

@Aspect
@Component
public class AfterReturningAttendingAdvice {

	@AfterReturning(pointcut = "execution(* com.greedy.section01.advice.annotation..*(..))"
			, returning = "result")
	public void afterReturningAttending(JoinPoint joinPoint, Object result) {
		
		System.out.println("============= after returning attending =================");
		System.out.println("보람찬! 하루일을! 끝마치고서~~ 두 다리 쭉펴면 고향의 안방~~!!");
		System.out.println("=========================================================");
		
		double employeementRate = ((AchievementResult) result).getEmployeementRate();
		double percent = employeementRate / 1000.0 * 100;
		System.out.println("증가된 취업율 : " + percent + "%" );

		((AchievementResult) result).setEmployeementRate(percent);
		
		System.out.println("=====================================================");
	}
}
