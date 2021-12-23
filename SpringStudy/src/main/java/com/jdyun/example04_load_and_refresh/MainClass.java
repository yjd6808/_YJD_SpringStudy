package com.jdyun.example04_load_and_refresh;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
		applicationContext.load("classpath:example04/applicationCTX.xml");	// �ε�
		applicationContext.refresh();	// �����������̳� ���� - ���ص� �ε��� ��
		Student student = applicationContext.getBean("student", Student.class);	// �����������̳� ���
		student.printInfo();
		applicationContext.close();	// �����������̳� 
	}		

}
