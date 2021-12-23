package com.jdyun.example12_aop_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	
	// �� ��Ű���ȿ� �ִ� ��� ��鿡 �����Ѵ�.
	@Pointcut("within(com.jdyun.example12_aop_annotation.*)")
	private void pointcutMethod() {
		
	}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint jointPoint) {

		// �ٽɱ�� Ŭ������ �޼ҵ� ������ ������ ��
		String signatureName = jointPoint.getSignature().toShortString();
		
		// ������ ����(advice) - �ٽɱ���� ���۵Ǿ���.
		System.out.println(signatureName + " is start.");
		long st = System.currentTimeMillis();
		
		Object obj = null;
		
		try {
			// �ٽɱ�� ����
			obj = jointPoint.proceed();
			
		} catch (Throwable e) {
			// �ٽɱ���� ���ǰ� �ȵ� ���
			e.printStackTrace();
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureName + " is finished.");
			System.out.println(signatureName + " ����ð� : " + (et - st));
			System.out.println("===================================");
		}
		
		return obj;
	}
}
