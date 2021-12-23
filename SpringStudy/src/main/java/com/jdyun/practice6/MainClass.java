package com.jdyun.practice6;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext configurableApplicationContext = new GenericXmlApplicationContext();
		ConfigurableEnvironment configurableEnvironment = configurableApplicationContext.getEnvironment();
		MutablePropertySources mutablePropertySources = configurableEnvironment.getPropertySources();
		
		mutablePropertySources.addLast(new ResourcePropertySource("classpath:practice6/jdbc.driver"));		
		System.out.println(configurableEnvironment.getProperty("oracle"));
		System.out.println(configurableEnvironment.getProperty("mysql"));
		
		GenericXmlApplicationContext genericXmlApplicationContext = (GenericXmlApplicationContext)configurableApplicationContext;
		genericXmlApplicationContext.load("classpath:practice6/applicationCTX.xml");
		genericXmlApplicationContext.refresh();
		genericXmlApplicationContext.getBean("driver", JDBCDriver.class).print();
	}
}
