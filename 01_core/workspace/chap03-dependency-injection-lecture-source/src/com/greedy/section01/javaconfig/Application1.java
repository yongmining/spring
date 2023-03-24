package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration1;

public class Application1 {

   public static void main(String[] args) {

      ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration1.class);
      
      Member member = context.getBean(Member.class);
      System.out.println(member);
      
      System.out.println(member.getPersonalAccount().getBalance());
      System.out.println(member.getPersonalAccount().deposit(1000000));
      System.out.println(member.getPersonalAccount().getBalance());
      System.out.println(member.getPersonalAccount().withDraw(500000));
      System.out.println(member.getPersonalAccount().getBalance());
      
   }

}