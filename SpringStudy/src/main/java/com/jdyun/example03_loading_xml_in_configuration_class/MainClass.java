package com.jdyun.example03_loading_xml_in_configuration_class;

import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student student1 = applicationContext.getBean("student1", Student.class);
		student1.printInfo();
		Student student2 = applicationContext.getBean("student2", Student.class);
		student2.printInfo();
	}

}
