package com.greedy.section02.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Application {

   public static void main(String[] args) {

      /* 리플렉션이란?
       * 컴파일된 자바 코드에서 역으로 클래스를 불러와 메소드 및 필드 정보를 구해오는 방법으로
       * 반사, 투영 이라는 의미를 가진다.
       * 리플렉션은 JVM에서 실행되는 애플리케이션의 런타임 동작을 검사하거나 수정할 수 있는 기능이 필요한 경우 사용한다.
       * 스프링 프레임워크, 마이바티스, 하이버네이트 등의 프레임워크에서 주로 사용한다.
       * 
       * reflection은 강력한 도구이지만 무분별하게 사용해서는 안된다.
       * 1. 오버헤드 발생 : 성능 저하를 발생할 수 있기 대문에 성능에 민감한 애플리케이션에서는 사용하지 않는다.
       * 2. 캡슐화 저해 : private로 설정한 member에 접근이 간으하기 때문에 코드 기능이 저하된다.
       * */

      Class class1 = Account.class;
      System.out.println("class1 : " + class1);

      Class class2 = new Account().getClass();
      System.out.println("class2 : " + class2);

      try {
         Class class3 = Class.forName("com.greedy.section02.reflection.Account");
         System.out.println("class3 : " + class3);

         Class class4 = Class.forName("[D");
         System.out.println("class4 : " + class4);
         Class class5 = double[].class;
         System.out.println("class5 : " + class5);

         double[] drr = new double[3];
         System.out.println(drr);

         String[] srr = new String[3];
         System.out.println(srr);

         Class class6 = Class.forName("[Ljava.lang.String;");
         System.out.println("class6 : " + class6);
         Class class7 = String[].class;
         System.out.println("class7 : " + class7);

      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }

      //   double d = 1.0;
      //   Class class8 = d.getClass()

      Class class8 = Double.TYPE;
      System.out.println("class8 : " + class8);

      Class class9 = Void.TYPE;
      System.out.println("class9 : " + class9);

      Class superClass = class1.getSuperclass();
      System.out.println("superClass : " + superClass);

      Field[] fields = Account.class.getDeclaredFields();
      for(Field field : fields) {
         System.out.println(field);
         System.out.println("modifiers : " + Modifier.toString(field.getModifiers()));
         System.out.println("type : " + field.getType());
         System.out.println("name : " + field.getName());
      }

      Constructor[] constructors = Account.class.getConstructors();
      for(Constructor constructor : constructors) {
         System.out.println("name : " + constructor.getName());

         Class[] params = constructor.getParameterTypes();
         constructor.getParameterTypes();
         for(Class param : params) {
            System.out.println("paramType : " + param.getTypeName());
         }   
      }
      
      try {
         Account acc = (Account) constructors[0].newInstance("20", "110-223-123456", "1234", 10000);
         System.out.println(acc.getBalance());

      } catch (InstantiationException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      } catch (IllegalArgumentException e) {
         e.printStackTrace();
      } catch (InvocationTargetException e) {
         e.printStackTrace();
      }
      
      Method[] methods = Account.class.getMethods();
      Method getBalanceMethod = null;
      for(Method method : methods) {
         System.out.println(method);
         
         if("getBalance".equals(method.getName())) {
            getBalanceMethod = method;
         }
      }
      try {
         System.out.println(getBalanceMethod.invoke(((Account) constructors[2].newInstance()),null));
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      } catch (IllegalArgumentException e) {
         e.printStackTrace();
      } catch (InvocationTargetException e) {
         e.printStackTrace();
      } catch (InstantiationException e) {
         e.printStackTrace();
      }
   }


}