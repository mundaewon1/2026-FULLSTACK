package com.the703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the703.dao.BoardMapper;
import com.the703.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper dao;  // db관련
	@Override public List<BoardDto> selectAll() { return dao.selectAll(); }

	@Override public int insert(BoardDto dto) {
		try {dto.setBip(InetAddress.getLocalHost().getHostAddress());} 
		catch (UnknownHostException e) {e.printStackTrace();}
		return dao.insert(dto);
	}

	@Override public BoardDto detail(int bno) {
		// 조회수 올리기
		dao.updateHit(bno);
		return dao.select(bno);
	}

	@Override public BoardDto editView(int bno) { return dao.select(bno); }

	@Override public int edit(BoardDto dto) {
		// 비번맞으면 수정
		BoardDto bdto = dao.select(dto.getBno());
		if(bdto.getBpass().equals(dto.getBpass())) { return dao.update(dto); }
		return 0;
	}

	@Override public int delete(BoardDto dto) {
		// 비번맞으면 삭제
		BoardDto bdto = dao.select(dto.getBno());
		if(bdto.getBpass().equals(dto.getBpass())) { return dao.delete(dto.getBno()); }
		return 0;
	}
	

}
