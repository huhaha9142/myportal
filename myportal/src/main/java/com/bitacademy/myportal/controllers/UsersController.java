package com.bitacademy.myportal.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.myportal.exception.UserDaoException;
import com.bitacademy.myportal.repository.UserVo;
import com.bitacademy.myportal.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping(value= {"", "/", "/join"},
			method=RequestMethod.GET)
	public String joinForm() {
		return "users/joinform";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinAction(@ModelAttribute UserVo userVo) {
		System.out.println("가입 폼:" + userVo);
		
		boolean bSuccess = false;
		try {
			bSuccess = userServiceImpl.join(userVo);
		} catch (UserDaoException e) {
			System.err.println("에러상황의 UserVo:" + userVo);
			e.printStackTrace();
		}
		
		if (bSuccess) {	//	가입 성공
			return "redirect:/users/joinsuccess";
		}
		return "redirect:/users/join";	//	실패시 가입폼으로
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "users/joinsuccess";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "users/loginform";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(
			@RequestParam(value="email", required=false)
			String email,
			@RequestParam(value="password", required=false)
			String password,
			HttpSession session
			) {
		System.out.println("email:" + email);
		System.out.println("password:" + password);
		
		if(email.length() == 0 || password.length() == 0) {
			System.err.println("로그인 불가!");
			return "redirect:/users/login";
		}
		
		UserVo authUser = userServiceImpl.getUser(email, password);
		
		if (authUser != null) {
			//	로그인 성공
			System.out.println("로그인 성공:" + authUser);
			//	세션에 로그인 사용자 정보 저장
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		} else {
			//	로그인 실패
			return "redirect:/users/login";
		}
	}
	
	//	로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		//	세션 무효화
		session.invalidate();
		return "redirect:/";
	}
	
	//	이메일 중복 체크(JSON API)
	@ResponseBody //	MessageConverter 통과
	@RequestMapping("/emailcheck")
	public Object exists(@RequestParam(value="email", 
										required=true, 
										defaultValue="")String email) {
		UserVo vo = userServiceImpl.getUser(email);
		//	vo == null이면 중복 이메일이 없다
		boolean exists = vo != null ? true : false;	//	중복 여부
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", exists);
		
		return map;
	}
}
