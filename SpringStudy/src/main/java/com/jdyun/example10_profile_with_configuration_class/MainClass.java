package com.jdyun.example10_profile_with_configuration_class;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ε��� ���ؽ�Ʈ�� �Է� : ");
		String configInput = scanner.next();
		scanner.close();
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(configInput);
		ctx.register(ApplicationConfigDev.class);
		ctx.register(ApplicationConfigRun.class);
		ctx.refresh();
		
		ServerInfo serverInfo = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("[��������]");
		System.out.println("IP 	 : " + serverInfo.getIpNum());
		System.out.println("PORT : " + serverInfo.getPortNum());
	}
}

