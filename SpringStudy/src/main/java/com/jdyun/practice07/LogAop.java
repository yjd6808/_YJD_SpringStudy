package com.jdyun.practice07;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	public Object loggerAop(ProceedingJoinPoint jointPoint) {

		// �ٽɱ�� Ŭ������ �޼ҵ� ������ ������ ��
		String signatureName = jointPoint.getSignature().toShortString();
		
		// ������ ����(advice) - �ٽɱ���� ���۵Ǿ���.
		System.out.println("start --------------=-=-=- :" + signatureName );
		long st = System.currentTimeMillis();
		
		Object obj = null;
		
		try {
			// �ٽɱ�� ����
			obj = jointPoint.proceed();
			
		} catch (Throwable e) {
			// �ٽɱ���� ���ǰ� �ȵ� ���
			e.printStackTrace();
		} finally {
			System.out.println("end --------------=-=-=- : " + signatureName);
		}
		
		return obj;
	} 
}
