package com.jdyun.practice5;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(scanner.next());
		ctx.load("classpath:practice5/mysqlCTX.xml");
		ctx.load("classpath:practice5/oracleCTX.xml");
		ctx.refresh();
		ctx.getBean("dbInfo", DBInfo.class).print();
	}
}
