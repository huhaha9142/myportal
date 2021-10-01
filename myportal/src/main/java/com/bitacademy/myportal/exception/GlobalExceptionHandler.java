package com.bitacademy.myportal.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(
			HttpServletRequest request,
			Exception e) {
		//	1. 로깅
		System.err.println("============");
		System.err.println("ControllerAdvice에 의한 ErrorHandling");
		e.printStackTrace();	//	로그 남기기
		
		//	2.	시스템오류 안내 화면
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());
		mav.setViewName("errors/exception");
		
		return mav;
	}
}
