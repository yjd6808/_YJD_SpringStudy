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

		System.out.println("[수동으로 프로퍼티 로딩]");
		ApplicationContext ctx = new GenericXmlApplicationContext();
		Environment env = ctx.getEnvironment();
		
		ConfigurableApplicationContext confCtx = (ConfigurableApplicationContext)ctx; // 설정가능한 컨텍스트로 다운캐스팅
		ConfigurableEnvironment confEnv = (ConfigurableEnvironment)env; //설정가능한 환경으로 다운캐스팅
		
		
		MutablePropertySources propertySources = confEnv.getPropertySources();
		
		// 예외처리를 위해 throws 추가
		propertySources.addLast(new ResourcePropertySource("classpath:example06/admin.properties"));
		System.out.println(confEnv.getProperty("admin.id"));
		System.out.println(confEnv.getProperty("admin.pw")); 	
		
		
		{
			System.out.println("[스프링 컨테이너의 의존성 주입을 통한 프로퍼티 로딩 방식]");
			GenericXmlApplicationContext xmlCtx = (GenericXmlApplicationContext)ctx;
			xmlCtx.load("classpath:example06/applicationCTX.xml");
			xmlCtx.refresh();	// 안넣어주면 오류가 발생한다. 
			AdminConnection adminConnection =xmlCtx.getBean("adminConnection", AdminConnection.class);
			
			System.out.println(adminConnection.getAdminId());
			System.out.println(adminConnection.getAdminPw());
		}
	}
}
