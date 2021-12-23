package com.jdyun.example12_aop_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	
	// 이 패키지안에 있는 모든 빈들에 적용한다.
	@Pointcut("within(com.jdyun.example12_aop_annotation.*)")
	private void pointcutMethod() {
		
	}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint jointPoint) {

		// 핵심기능 클래스의 메소드 정보를 가지고 옴
		String signatureName = jointPoint.getSignature().toShortString();
		
		// 공통기능 실행(advice) - 핵심기능이 시작되었다.
		System.out.println(signatureName + " is start.");
		long st = System.currentTimeMillis();
		
		Object obj = null;
		
		try {
			// 핵심기능 실행
			obj = jointPoint.proceed();
			
		} catch (Throwable e) {
			// 핵심기능이 정의가 안된 경우
			e.printStackTrace();
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureName + " is finished.");
			System.out.println(signatureName + " 경과시간 : " + (et - st));
			System.out.println("===================================");
		}
		
		return obj;
	}
}
