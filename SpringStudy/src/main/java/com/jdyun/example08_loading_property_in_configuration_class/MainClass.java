package com.jdyun.example08_loading_property_in_configuration_class;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		{
			//Spring 4.X 방식 프로퍼티 로딩
			AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
			AdminConnection adminConnection = ctx.getBean("adminConnection", AdminConnection.class);
			
			System.out.println(adminConnection.getAdminId());
			System.out.println(adminConnection.getAdminPw());
			System.out.println(adminConnection.getSub_adminId());
			System.out.println(adminConnection.getSub_adminPw());
		}

		System.out.println("===================================");
		
		{
			//Spring 3.X 방식 프로퍼티 로딩
			AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
			AdminConnection adminConnection = ctx.getBean("adminConnection", AdminConnection.class);
			
			System.out.println(adminConnection.getAdminId());
			System.out.println(adminConnection.getAdminPw());
			System.out.println(adminConnection.getSub_adminId());
			System.out.println(adminConnection.getSub_adminPw());
		}
	}

}
