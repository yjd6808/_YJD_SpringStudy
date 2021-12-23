package com.jdyun.practice08;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {

	@Pointcut("within(com.jdyun.practice08.*)")
	public void ptMethod() {}
	
	@Around("ptMethod()")
	public Object loggerAop(ProceedingJoinPoint jointPoint) {
		System.out.println(jointPoint.getSignature().toShortString());
		
		Object obj = null;
		try {
			obj = jointPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			System.out.println(jointPoint.getSignature().toShortString()); 
		}
		
		return obj;
	}
	
}
