package com.bitacademy.myportal.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.exception.UserDaoException;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(UserVo vo) {
		int count = 0;
		
		try {
			count = sqlSession.insert("users.insert", vo);
		} catch (Exception e) {
			e.printStackTrace();
			//	상황 정보를 담은 구체적 예외로 전환
			throw new UserDaoException("회원가입 중 오류!", vo);
		}
		
		return count;
	}

	@Override
	public UserVo selectUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVo selectUser(String email, String password) {
		//	Parameter 객체가 없을 때 -> map 사용
		Map<String, String> userMap = new HashMap<>();
		userMap.put("email", email);
		userMap.put("password", password);
		
		UserVo vo = sqlSession.selectOne("users.selectUserByEmailAndPassword", userMap);
		return vo;
	}

}
