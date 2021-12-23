package com.jdyun.example11_aop_xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
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
