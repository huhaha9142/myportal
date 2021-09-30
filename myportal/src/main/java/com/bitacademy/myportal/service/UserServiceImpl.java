package com.bitacademy.myportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.UserDao;
import com.bitacademy.myportal.repository.UserVo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDaoImpl;
	@Override
	public boolean join(UserVo vo) {
		int insertedCount = userDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public UserVo getUser(String email, String password) {
		UserVo userVo = userDaoImpl.selectUser(email, password);
		return userVo;
	}

	@Override
	public UserVo getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
