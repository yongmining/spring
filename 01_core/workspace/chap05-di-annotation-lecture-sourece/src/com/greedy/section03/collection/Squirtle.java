package com.greedy.section03.collection;

import org.springframework.stereotype.Component;

@Component
public class Squirtle implements Pokemon {

	@Override
	public void attack() {
		
		System.out.println("꼬북이가 공격을 합니다! 받아라! 물대로~~~~~");
		
	}

}
