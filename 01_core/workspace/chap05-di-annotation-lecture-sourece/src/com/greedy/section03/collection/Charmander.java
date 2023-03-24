package com.greedy.section03.collection;

import org.springframework.stereotype.Component;

@Component
public class Charmander implements Pokemon{

	@Override
	public void attack() {
		
		System.out.println("파이리가 공격을 합니다! 받아라 퐈이어~~~~~!");
		
	}
	
}
