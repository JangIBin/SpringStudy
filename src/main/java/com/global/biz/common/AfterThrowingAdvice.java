package com.global.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {

	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		
		String method = jp.getSignature().getName();
		
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력 되었습니다 ㅎㅎ");
		} else if(exceptionObj instanceof NumberFormatException) {
			System.out.println("숫자 형식이 값이 아닙니다.");
		} else if(exceptionObj instanceof Exception) {
			System.out.println("문제가 메차쿠챠 발생했습니다.");
		}
		
		
		System.out.println("[예외처리] "+method+"() 메소드 수행중 발생한 예외 메시지 :"+exceptionObj.getMessage());
	}
	
}
