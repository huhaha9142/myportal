package com.bitacademy.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping({"/", "/main"})
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/WEB-INF/views/home.jsp");
		mav.setViewName("home");	//	ViewResolver가 prefix와 suffix 조합 -> 완전한 ViewName 리턴
		return mav;
	}
}
