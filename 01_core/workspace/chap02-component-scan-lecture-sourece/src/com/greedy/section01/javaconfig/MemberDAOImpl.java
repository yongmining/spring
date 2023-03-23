package com.greedy.section01.javaconfig;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

/* @Component : 스프링에서 관리되는 객체(bean)임을 표시하기 위해 사용하는 가장 기본적인 어노테이션이다.
 * @Controller : WebMVC에서 사용되는 어노테이션으로 @RequestMapping 어노테이션 등은 @Controller 내에서 작성 가능하다.
 * @Service : 비지니스 로직이 작성된 클래스에서 사용한다. 추가적인 기능은 없지만 제공할 가능성이 있으니 명시하는게 좋다.
 * @Repository : 예외로 포착하여 DataAccessException으로 변환하여 다시 발생시켜주는 기능을 한다.
 * */
@Repository(value="memberDAO")
public class MemberDAOImpl implements MemberDAO {

	private final Map<Integer, MemberDTO> memberMap;
	
	public MemberDAOImpl() {
		memberMap = new HashMap<>();
		
		memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
		memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
	}
	
	@Override
	public MemberDTO selectMember(int sequence) {
		
		return memberMap.get(sequence);
	}

	@Override
	public boolean insertMember(MemberDTO newMember) {
		
		int before = memberMap.size();
		
		memberMap.put(newMember.getSequence(), newMember);
		
		int after = memberMap.size();
		
		return after > before? true : false;
	}
	
	

}
