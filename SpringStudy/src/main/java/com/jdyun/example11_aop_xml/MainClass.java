package com.jdyun.example11_aop_xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:example11/applicationCTX.xml");
		applicationContext.getBean("student", Student.class).getStudentInfo();
		applicationContext.getBean("worker", Worker.class).getWorkerInfo();
	}
}
