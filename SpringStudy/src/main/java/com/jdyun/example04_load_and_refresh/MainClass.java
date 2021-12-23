package com.jdyun.example04_load_and_refresh;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
		applicationContext.load("classpath:example04/applicationCTX.xml");	// 로딩
		applicationContext.refresh();	// 스프링컨테이너 설정 - 안해도 로딩은 됨
		Student student = applicationContext.getBean("student", Student.class);	// 스프링컨테이너 사용
		student.printInfo();
		applicationContext.close();	// 스프링컨테이너 
	}		

}
