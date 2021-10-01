package com.bitacademy.myportal.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitacademy.myportal.repository.UserVo;
import com.bitacademy.myportal.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping("/users/emailcheck")
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
