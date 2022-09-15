package com.global.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {

	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		
		String method = jp.getSignature().getName();
		
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("�������� ���� �Է� �Ǿ����ϴ� ����");
		} else if(exceptionObj instanceof NumberFormatException) {
			System.out.println("���� ������ ���� �ƴմϴ�.");
		} else if(exceptionObj instanceof Exception) {
			System.out.println("������ ������í �߻��߽��ϴ�.");
		}
		
		
		System.out.println("[����ó��] "+method+"() �޼ҵ� ������ �߻��� ���� �޽��� :"+exceptionObj.getMessage());
	}
	
}