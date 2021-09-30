package com.bitacademy.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitacademy.myportal.repository.GuestbookDao;
import com.bitacademy.myportal.repository.GuestbookVo;

@Service
public class GuestbookServiceImpl implements GuestbookService {
	@Autowired
	GuestbookDao guestbookDaoImpl;

	@Override
	public List<GuestbookVo> getMessageList() {
		List<GuestbookVo> list = guestbookDaoImpl.selectAll();
		return list;
	}

	@Transactional
	@Override
	public boolean writeMessage(GuestbookVo vo) {
		int insertedCount = guestbookDaoImpl.insert(vo);
		System.out.println("삽입된 방명록 레코드:" + insertedCount);
		return 1 == insertedCount;
	}

	@Override
	public boolean deleteMessage(GuestbookVo vo) {
		int deletedCount = guestbookDaoImpl.delete(vo);
		return 1 == deletedCount;
	}

}