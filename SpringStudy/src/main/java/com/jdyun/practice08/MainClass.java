package com.jdyun.practice08;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdyun.practice07.Professor;
import com.jdyun.practice07.Singer;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:practice08/applicationCTX.xml");
		applicationContext.getBean("car", Car.class).getCarInfo();
		applicationContext.getBean("graphic", Graphic.class).getGraphicInfo();
	}

}
