package com.greedy.section01.aop.annotation.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.section01.aop.annotation.model.dto.OrderDTO;
import com.greedy.section01.aop.annotation.model.dto.OrderMenuDTO;

@Mapper
public interface OrderMapper {
	
	/* 주문 테이블에 insert */
	int insertOrder(OrderDTO order);
	
	/* 주문별 메뉴 테이블에 insert */
	int insertOrderMenu(OrderMenuDTO orderMenu);
	
}
