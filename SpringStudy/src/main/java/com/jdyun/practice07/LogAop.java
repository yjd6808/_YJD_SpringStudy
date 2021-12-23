package com.jdyun.practice07;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	public Object loggerAop(ProceedingJoinPoint jointPoint) {

		// 핵심기능 클래스의 메소드 정보를 가지고 옴
		String signatureName = jointPoint.getSignature().toShortString();
		
		// 공통기능 실행(advice) - 핵심기능이 시작되었다.
		System.out.println("start --------------=-=-=- :" + signatureName );
		long st = System.currentTimeMillis();
		
		Object obj = null;
		
		try {
			// 핵심기능 실행
			obj = jointPoint.proceed();
			
		} catch (Throwable e) {
			// 핵심기능이 정의가 안된 경우
			e.printStackTrace();
		} finally {
			System.out.println("end --------------=-=-=- : " + signatureName);
		}
		
		return obj;
	} 
}
