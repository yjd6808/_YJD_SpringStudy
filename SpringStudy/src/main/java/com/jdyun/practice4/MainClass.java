package com.jdyun.practice4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:practice4/applicationCTX.xml");
		DBCoonnection dbConnection =  ctx.getBean("dbConnection", DBCoonnection.class);
		
		System.out.println("mssql.id : " + dbConnection.getMssqlId());
		System.out.println("mssql.pw : " + dbConnection.getMssqlPw());
		System.out.println("mysql.id : " + dbConnection.getMysqlId());
		System.out.println("mysql.pw : " + dbConnection.getMysqlPw());
	}
}
