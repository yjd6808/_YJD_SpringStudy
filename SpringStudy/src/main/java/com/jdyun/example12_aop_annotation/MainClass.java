package com.jdyun.example12_aop_annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:example12/applicationCTX.xml");
		applicationContext.getBean("student", Student.class).getStudentInfo();
		applicationContext.getBean("worker", Worker.class).getWorkerInfo();
	}
}
