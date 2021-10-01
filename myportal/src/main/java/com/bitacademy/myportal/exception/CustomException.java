package com.bitacademy.myportal.exception;

//	구체적인 예외상황을 기록하기 위해 RuntimeException의
//	구체적인 예외 클래스를 사용
public class CustomException extends RuntimeException {
	public CustomException() {
		super("MainControllerException!!");
	}
	
	public CustomException(String message) {
		super(message);
	}
}
