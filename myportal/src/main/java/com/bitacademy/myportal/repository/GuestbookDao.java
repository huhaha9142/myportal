package com.bitacademy.myportal.repository;

import java.util.List;

public interface GuestbookDao {
	public List<GuestbookVo> selectAll();	//	리스트를 위한 전체 레코드
	public int insert(GuestbookVo vo);		//	방명록 작성 메서드
	public int delete(GuestbookVo vo);		//	방명록 삭제 메서드
}
