package com.greedy.section01.properties.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

   public static void main(String[] args) {

      ApplicationContext context =
    		  new GenericXmlApplicationContext(
    				  "com/greedy/section01/properties/xmlconfig/config/spring-context.xml");
      
      Product carpBread = context.getBean("carpBread", Product.class);
      System.out.println(carpBread);
   }

}