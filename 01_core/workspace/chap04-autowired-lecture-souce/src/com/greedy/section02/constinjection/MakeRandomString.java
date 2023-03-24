package com.greedy.section02.constinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeRandomString {
   
   private final RandomGenerator random;
   /* 생성자 주입의 장점
    * 1. 필드에 final 키워드 사용이 가능해진다. 안정성있는 코드 작성
    * 2. 스프링 컨테이너와 결합도가 낮기 때문에 테스트하기 좋다. (스프링 설정 없이 테스트코드를 작성할 수 있다.)
    * 3. 필드 주입이 간단하긴 하지만 단일 책임의 원칙 관점에서 볼 때 좋지 않다.
    *      많은 필드주입이 일어난다는 이야기는 해당 객체가 너무 많은 책임을 가지고 있다는 의미를 가진다.
    *      생성자주입은 느낌사응로 이걸 방지할 수 있다. (리팩토링의 지표가 됨)
    * 4. 순환참조 방지 (필드 주입이나 세터 주입은 메소드 실행 시점에 알 수 있지만, 생성자주입은 애플리케이션 실행 시점에 알 수 있다.)
    * */
   
   
   
     public MakeRandomString() { random = null; }
    
   /* @Autowired는 스프링 2.5버전에 추가되었다.
    * 4.3 이후부터 생성자 주입 시 생성자가 한 개 뿐이라면
    * 해당 생성자에 @Autowired 어노테이션을 생략해도 자동으로 주입해준다.
    * 이러한 생랼 가능한 방식이 테스트코드를 스프링에 의논하지 않고 작성할 수 있도록 해준다.*/
   @Autowired
   public MakeRandomString(RandomGenerator random) {
      this.random = random;
   }
   
   public String getRandomLengthString() {
      
      StringBuilder sb = new StringBuilder();
      
      int randomNumber = random.getRandomNumber();
      for(int i = random.getStartNum(); i <= randomNumber; i++) {
         sb.append("*");
      }
      
      return sb.toString();
   }
}