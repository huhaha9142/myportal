package com.bitacademy.myportal.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestbookDaoImpl implements GuestbookDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<GuestbookVo> selectAll() {
		List<GuestbookVo> list = sqlSession.selectList("guestbook.selectAll");
		return list;
	}

	@Override
	public int insert(GuestbookVo vo) {
		int insertedCount = sqlSession.insert("guestbook.insert", vo);
		return insertedCount;
	}

	@Override
	public int delete(GuestbookVo vo) {
		int deletedCount = sqlSession.delete("guestbook.delete", vo);
		return deletedCount;
	}

}