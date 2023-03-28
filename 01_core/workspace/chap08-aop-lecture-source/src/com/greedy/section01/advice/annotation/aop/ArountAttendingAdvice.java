package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.greedy.section01.advice.annotation.GreedyStudent;

@Aspect
@Component
public class ArountAttendingAdvice {
	
	@Around("execution(* com.greedy.section01.advice.annotation..*(..))")
	public Object arountAttending(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("======= around attending before =======");
		System.out.println("오늘도 학원에 가서 열심히 공부해야지! 라는 마음으로 아침 일찍 일어납니다.");
		System.out.println("=======================================");
		
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		//원본 조인포인트 호출
		Object result = joinPoint.proceed();
		
		stopwatch.stop();
		
		System.out.println("======= around attending after =======");
		System.out.println("열심히 공부했으니 퇴실카드를 찍는다.");
		
		if(joinPoint.getTarget() instanceof GreedyStudent) {
			System.out.println("수업이 끝나도 끝난게 아닙니다. 자율적으로 스터디를 진행합니다.");
		}
		
		System.out.println("총 공부 소요 시간 : " + stopwatch.getTotalTimeMillis() + "(ms)");
		System.out.println("======================================");
		
		return result;
	}
}
