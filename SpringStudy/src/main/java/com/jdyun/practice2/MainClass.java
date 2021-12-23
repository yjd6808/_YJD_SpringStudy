package com.jdyun.practice2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new GenericXmlApplicationContext(
				"classpath:practice2/singerCTX.xml",
				"classpath:practice2/singerCTX2.xml");
		
		applicationContext.getBean("singer1", Singer.class).printInfo();
		applicationContext.getBean("singerInfo1", SingerInfo.class).getSinger().printInfo();
		applicationContext.getBean("singer3", Singer.class).printInfo();
	}
}
