package com.greedy.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		/* IoC(제어의 역전) 컨테이너
		 * 스프링에서 IoC 컨테이너를 구현하기 위해 BeanFactory 인터페이스를 정의하였다.
		 * BeanFactory란?
		 * 스프링 컨테이너의 최상위 컨테이너이며, ApplicationContext와 함께 스프링 컨테이너라고 한다.
		 * Bean의 생성과 설정, 관리, 조립 등의 역할을 맡고 있다.
		 * */

		ApplicationContext context = 
				new GenericXmlApplicationContext("com/greedy/section01/xmlconfig/spring-context.xml");
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println(beanName);
		}

		
//		MemberDTO member = (MemberDTO) context.getBean("member");
//		MemberDTO member = context.getBean(MemberDTO.class);
		MemberDTO member = context.getBean("member", MemberDTO.class);
		
		System.out.println(member);
	}

}
