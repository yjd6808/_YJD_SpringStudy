package com.jdyun.practice07;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdyun.example11_aop_xml.Student;
import com.jdyun.example11_aop_xml.Worker;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:practice07/applicationCTX.xml");
		applicationContext.getBean("professor", Professor.class).getProfessorInfo();
		applicationContext.getBean("singer", Singer.class).getSingerInfo();
	}

}
