package com.greedy.section01.properties.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.properties.javaconfig.config.ContextConfiguration;

public class Application {

   public static void main(String[] args) {

      ApplicationContext context =
            new AnnotationConfigApplicationContext(ContextConfiguration.class);
      
      Product carpBread = context.getBean("carpBread", Product.class);
      System.out.println(carpBread);
      
      Product milk = context.getBean("milk", Product.class);
      System.out.println(milk);
      
      Product water = context.getBean("water", Product.class);
      System.out.println(water);
   }

}