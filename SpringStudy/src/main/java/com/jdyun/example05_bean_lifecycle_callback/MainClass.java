package com.jdyun.example05_bean_lifecycle_callback;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	
	public static void main(String[] args) {
		
		// refresh �Լ� �����
		{
			GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
			applicationContext.load("classpath:example05/applicationCTX.xml");	// �ε�	
			
			// �����������̳� ���� - ���ص� �ε��� ��
			// refresh() �Լ��� ȣ������ ������ ������ �� afterPropertySet, �Ҹ��� �� destroy() �������̵� �Լ��� ȣ���� �ȵ�
			
			applicationContext.close();
			
			// [��°�� ����]
		}
		
		
		// applicationCTX.xml�� <context:annotation-config> �߰� �� 
		{
			GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
			applicationContext.load("classpath:example05/applicationCTX.xml");	// �ε�
			applicationContext.refresh();
			
			applicationContext.close();
			
			// [��°��] 
			// afterPropertiesSet()
			// destroyMethod()
		}
		
		// applicationCTX.xml�� <context:annotation-config> �߰� �� 
		{
			GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
			applicationContext.load("classpath:example05/applicationCTX.xml");	// �ε�
			applicationContext.refresh();
			
			applicationContext.close();
			
			// [��°��] 
			// afterPropertiesSet()
			// initMethod()
			
			// destroyMethod()
			// destroy()
		}
		
	}		

}
