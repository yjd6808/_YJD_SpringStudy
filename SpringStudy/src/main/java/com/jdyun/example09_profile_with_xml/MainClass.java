package com.jdyun.example09_profile_with_xml;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ε��� ���ؽ�Ʈ�� �Է� : ");
		String configInput = scanner.next();
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(configInput);
		ctx.load("example09/applicationCTX_dev.xml", "example09/applicationCTX_run.xml");
		ctx.refresh();
		ServerInfo serverInfo = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("[��������]");
		System.out.println("IP 	 : " + serverInfo.getIpNum());
		System.out.println("PORT : " + serverInfo.getPortNum());
	}

}
