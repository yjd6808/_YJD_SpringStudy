package com.jdyun.example06_environment_loading_property_files;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.GenericApplicationContext;
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
		ConfigurableEnvironment confEnv = (ConfigurableEnvironment)env; //���������� ȯ������ �ٿ�ĳ����
		
		
		MutablePropertySources propertySources = confEnv.getPropertySources();
		
		// ����ó���� ���� throws �߰�
		propertySources.addLast(new ResourcePropertySource("classpath:example06/admin.properties"));
		System.out.println(confEnv.getProperty("admin.id"));
		System.out.println(confEnv.getProperty("admin.pw")); 	
		
		
		{
			System.out.println("[������ �����̳��� ������ ������ ���� ������Ƽ �ε� ���]");
			GenericXmlApplicationContext xmlCtx = (GenericXmlApplicationContext)ctx;
			xmlCtx.load("classpath:example06/applicationCTX.xml");
			xmlCtx.refresh();	// �ȳ־��ָ� ������ �߻��Ѵ�. 
			AdminConnection adminConnection =xmlCtx.getBean("adminConnection", AdminConnection.class);
			
			System.out.println(adminConnection.getAdminId());
			System.out.println(adminConnection.getAdminPw());
		}
	}
}
