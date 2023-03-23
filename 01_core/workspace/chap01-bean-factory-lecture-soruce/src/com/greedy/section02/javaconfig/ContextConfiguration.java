package com.greedy.section02.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

	@Bean(name="member")
	public MemberDTO getMember() {
		
		return new MemberDTO(1, "user01", "pass01", "홍길동");
	}
}
