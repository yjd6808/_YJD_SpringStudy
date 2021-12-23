package com.jdyun.example07_loading_property_in_xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:example07/applicationCTX.xml");
		AdminConnection adminConnection = ctx.getBean("adminConnection", AdminConnection.class);
		
		System.out.println(adminConnection.getAdminId());
		System.out.println(adminConnection.getAdminPw());
		System.out.println(adminConnection.getSub_adminId());
		System.out.println(adminConnection.getSub_adminPw());

	}

}
