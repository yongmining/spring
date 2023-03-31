package com.greedy.section01.aop.annotation.run;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.aop.annotation.config.ContextConfiguration;
import com.greedy.section01.aop.annotation.model.dto.OrderDTO;
import com.greedy.section01.aop.annotation.model.dto.OrderMenuDTO;
import com.greedy.section01.aop.annotation.model.service.OrderService;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		System.out.println(context);
		
		Scanner sc = new Scanner(System.in);
		
		List<OrderMenuDTO> orderMenuList = new ArrayList<>();
		orderMenu:
		do {
			System.out.println("=========== 트렉젝션 레스토랑 음식 주문 서비스===============");
			System.out.print("어떤 메뉴를 주문하시곘습니까? (코드 입력) : ");
			int menuCode = sc.nextInt();
			System.out.print("주문 수량을 입력해주세요 : ");
			int amount = sc.nextInt();
			System.out.print("다른 메뉴를 추가로 주문하시겠습니까?(Y/N) : ");
			sc.nextLine();
			char contineeYN = sc.nextLine().toUpperCase().charAt(0);
			
			OrderMenuDTO orderMenu = new OrderMenuDTO();
			orderMenu.setMenuCode(menuCode);
			orderMenu.setAmount(amount);
			
			orderMenuList.add(orderMenu);
			
			switch(contineeYN) {
				case 'Y' : break;
				default : break orderMenu;
				
			}
		} while(true);
		
//		System.out.println(orderMenuList);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		
		OrderDTO order = new OrderDTO();
		order.setDate(dateFormat.format(new java.util.Date(System.currentTimeMillis())));
		order.setTime(timeFormat.format(new java.util.Date(System.currentTimeMillis())));
		order.setMenuList(orderMenuList);
		
		OrderService orderService = context.getBean("orderService", OrderService.class);
		orderService.registOrder(order);
		
		System.out.println("메뉴 주문에 성공하셨습니다.");		
	}
}
