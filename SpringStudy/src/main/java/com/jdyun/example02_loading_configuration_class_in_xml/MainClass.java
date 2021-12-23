package com.jdyun.example02_loading_configuration_class_in_xml;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:example02/applicationCTX.xml");
		Student student1 = applicationContext.getBean("student1", Student.class);
		student1.printInfo();
		Student student2 = applicationContext.getBean("student2", Student.class);
		student2.printInfo();
	}

}
