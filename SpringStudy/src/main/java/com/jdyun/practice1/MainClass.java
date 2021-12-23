package com.jdyun.practice1;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext applicationContext1 = new GenericXmlApplicationContext("classpath:practice1/employeeCTX.xml");
		ApplicationContext applicationContext2 = new GenericXmlApplicationContext("classpath:practice1/employeeCTX2.xml");
		
		Employee employee1 = applicationContext1.getBean("employee1", Employee.class);
		
		System.out.println(employee1.getName());
		System.out.println(employee1.getPay());
		System.out.println(employee1.getCards());
		System.out.println("===========================================");

		EmployeeInfo employeeInfo = applicationContext1.getBean("employeeInfo1", EmployeeInfo.class);
		Employee employee2 = employeeInfo.getEmployee();
		
		System.out.println(employee2.getName());
		System.out.println(employee2.getPay());
		System.out.println(employee2.getCards());
		
		System.out.println("===========================================");
		
		Employee employee3 = applicationContext2.getBean("employee3", Employee.class);
		
		System.out.println(employee3.getName());
		System.out.println(employee3.getPay());
		System.out.println(employee3.getCards());
	}

}
