package com.bitacademy.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.BoardDao;
import com.bitacademy.myportal.repository.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boarddaoImpl;
	@Override
	public List<BoardVo> getList() {
		List<BoardVo> list = boarddaoImpl.selectAll();
		return list;
	}

	@Override
	public BoardVo getContent(Long no) {
		BoardVo vo = boarddaoImpl.getContent(no);
		return vo;
	}

	@Override
	public boolean write(BoardVo vo) {
		int insertedCount = boarddaoImpl.insert(vo);
		return insertedCount==1;
	}

	@Override
	public boolean update(BoardVo vo) {
		int updateCount = boarddaoImpl.update(vo);
		return 1 == updateCount;

	}

	@Override
	public boolean delete(Long no) {
		int deletedCount = boarddaoImpl.delete(no);
		return 1==deletedCount;
	}

}