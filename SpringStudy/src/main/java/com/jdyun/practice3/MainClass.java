package com.jdyun.practice3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {

	public static void main(String[] args) throws Exception {
		System.out.println("[수동으로 프로퍼티 로딩]");
		ApplicationContext ctx = new GenericXmlApplicationContext();
		Environment env = ctx.getEnvironment();
		ConfigurableApplicationContext confCtx = (ConfigurableApplicationContext)ctx; // 설정가능한 컨텍스트로 다운캐스팅
		ConfigurableEnvironment confEnv = (ConfigurableEnvironment)env; 			  // 설정가능한 환경으로 다운캐스팅
		
		MutablePropertySources propertySources = confEnv.getPropertySources();
		
		// 예외처리를 위해 throws 추가
		propertySources.addLast(new ResourcePropertySource("classpath:practice3/db.properties"));
		System.out.println(confEnv.getProperty("emp.id"));
		System.out.println(confEnv.getProperty("emp.pw")); 	
		
		// =================================================
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		gCtx.load("classpath:practice3/applicationCTX.xml");
		gCtx.refresh();
		EmpConnection empConn = gCtx.getBean("empConnection", EmpConnection.class);
		System.out.println(empConn.getEmpId());
		System.out.println(empConn.getEmpPw());
	}
}
