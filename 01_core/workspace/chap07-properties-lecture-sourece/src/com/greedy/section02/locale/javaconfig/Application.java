package com.greedy.section02.locale.javaconfig;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section02.locale.javaconfig.config.ContextConfiguration;



public class Application {

	public static void main(String[] args) {
		
		/* I18N(Internationalization) : 국제화
		 * 언어, 타임존, 섬머타임 적용, 화폐, 글자 쓰기 방향 등을 해당 국가에 맞게 제공하는 것
		 * 
		 * L10N(Localization) : 현지화
		 * 현지에 문화나 풍토에 맞게 변경
		 * */
		ApplicationContext context =
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		String error404Message = context.getMessage("error.404", null, Locale.US);
		String error500Message = context.getMessage("error.500", 
				new Object[] {"jinho", new java.util.Date()},
				Locale.KOREA);
		
		System.out.println("The I18N message for error.404 : " + error404Message);
		System.out.println("The I18N message for error.500 : " + error500Message);
		
	}

}
