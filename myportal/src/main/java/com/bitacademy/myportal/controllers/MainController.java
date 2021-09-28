package com.bitacademy.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	//	메서드가 /home URL 요청에 반응하도록 한다.
//	@RequestMapping("/main")
	@RequestMapping({"/", "/main"})
//	public ModelAndView home(@RequestParam String name) {
	public ModelAndView home() {
		//	서블릿에서 getParameter로 해준 것을
		//	 RequestParam이 대신 해준 것
		ModelAndView mav = new ModelAndView();
		
		// 	객체 추가: 서블릿에서 addAttribute의 역할
//		mav.addObject("message",	//	키 
//				"Main " + name);	//	값
		//	뷰파일을 연결: 서블릿에서 RequestDispatcher로 포워드한 것과 비슷
		mav.setViewName("/WEB-INF/views/home.jsp");
		
		return mav;
	}

}
