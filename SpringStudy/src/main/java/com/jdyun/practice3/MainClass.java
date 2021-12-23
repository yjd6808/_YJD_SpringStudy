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
		System.out.println("[�������� ������Ƽ �ε�]");
		ApplicationContext ctx = new GenericXmlApplicationContext();
		Environment env = ctx.getEnvironment();
		ConfigurableApplicationContext confCtx = (ConfigurableApplicationContext)ctx; // ���������� ���ؽ�Ʈ�� �ٿ�ĳ����
		ConfigurableEnvironment confEnv = (ConfigurableEnvironment)env; 			  // ���������� ȯ������ �ٿ�ĳ����
		
		MutablePropertySources propertySources = confEnv.getPropertySources();
		
		// ����ó���� ���� throws �߰�
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
