package com.greedy.section02.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Pikachu implements Pokemon{

	@Override
	public void attack() {
		
		System.out.println("피카츄가 공격을 합니다! 백만볼트~ 찌직~");
		
	}

}
