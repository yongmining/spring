package com.greedy.section03.dynamic;

import java.lang.reflect.Proxy;

public class Application {
	
	public static void main(String[] args) {
		
		/* 프록시란?
		 * 실제 target의 기능을 수행하면서 기능을 확장하거나 추가하는 실체 객체를 의미한다.
		 * 디자인 패턴의 프록시패턴과는 유사하면서 약간 다르다.
		 * 
		 * 프록시 생성은 크게 두 가지 방식이 있다.
		 * 1. JDK Dynamic Proxy 방식
		 * 2. CGLib 방식
		 * 
		 * Aspectj 에서 사용하는 방식은 1번 방식이다.
		 * 이 방식은 리플랙션을 이용해서 proxy 클래스를 동적으로 생성해 주는 방식이다.
		 * 타겟의 인터페이스를 기준으로 proxy를 생성해준다.
		 * 타겟의 위임 코드를 InvocationHandler를 이용해 작성하게 된다.
		 * 하지만 사용자가 타겟에 대한 정보를 잘못 주입하는 경우가 발생할 수 있기 때문에
		 * 내부적으로 주입된 타겟에 대한 검증코드를 거친 후 invoke가 동작하게 된다.
		 * 
		 * 2번 방식은 동적으로 Proxy를 생성하지만, 바이트코드를 조작하여 프록시를 생성해주는 방식이다.
		 * 인터페이스 뿐 아니라 타겟의 클래스가 인터페이스를 구현하지 않아도 프록시를 생성해준다.
		 * 두 방식은 성능의 차이를 보인다. (invoke)
		 * CGLib(Code Generator Library)의 경우 처음 메소드가 호출된 당시 동적으로 타겟클래스의 바이트코드를 조작하고
		 * 그 이후부터는 변경된 코드를 재사용한다.
		 * 
		 * 따라서 매번 검증 코드를 거치는 1번 방식보다는 성능면에서는 더 빠르게 된다.
		 * 또한 리플랙션에 의한 것이 아닌 바이트코드를 조작하는 방식이기 때문에 성능면에서 더 우수한 방식이다.
		 * 
		 * CGLib 단점
		 * 1. 스프링에서 기본적으로 제공하는 방식이 아니기 때문에 별도의 의존성을 추가해서 개발해야 한다.
		 * 2. 매개변수가 없는 기본 생성자가 반드시 있어야 한다.
		 * 3. 생성된 프록시의 메소드를 호출하면 타겟 생성자가 2번 호출되는 버그가 있었다.
		 * 
		 * 스프링 4.3, 스프링부트 1.3 이후부터 문제가 개선되며 기본 core에 포함되게 되었고,
		 * 스프링에서 기본적으로 사용하는 방식이 CGLib로 변경되었다.
		 * 
		 * */
		
		Student student = new GreedyStudent();
//		student.study(10);
		Handler handler = new Handler(student);
		
		
		Student proxy = 
				(Student)Proxy.newProxyInstance(Student.class.getClassLoader(), 
						new Class[] {Student.class}, 
						handler);
		
		proxy.study(16);
	}
		
}

