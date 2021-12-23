package com.jdyun.example05_bean_lifecycle_callback;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	
	public static void main(String[] args) {
		
		// refresh 함수 사용전
		{
			GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
			applicationContext.load("classpath:example05/applicationCTX.xml");	// 로딩	
			
			// 스프링컨테이너 설정 - 안해도 로딩은 됨
			// refresh() 함수를 호출하지 않으면 생성할 때 afterPropertySet, 소멸할 때 destroy() 오버라이딩 함수가 호출이 안됨
			
			applicationContext.close();
			
			// [출력결과 없음]
		}
		
		
		// applicationCTX.xml에 <context:annotation-config> 추가 전 
		{
			GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
			applicationContext.load("classpath:example05/applicationCTX.xml");	// 로딩
			applicationContext.refresh();
			
			applicationContext.close();
			
			// [출력결과] 
			// afterPropertiesSet()
			// destroyMethod()
		}
		
		// applicationCTX.xml에 <context:annotation-config> 추가 후 
		{
			GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
			applicationContext.load("classpath:example05/applicationCTX.xml");	// 로딩
			applicationContext.refresh();
			
			applicationContext.close();
			
			// [출력결과] 
			// afterPropertiesSet()
			// initMethod()
			
			// destroyMethod()
			// destroy()
		}
		
	}		

}
