package com.bitacademy.myportal.service;

import com.bitacademy.myportal.repository.UserVo;

public interface UserService {
	public boolean join(UserVo vo);	//	회원 가입
	public UserVo getUser(String email, String password);	//	로그인 메서드
	public UserVo getUser(String email);	//	중복 로그인 체크용
}
