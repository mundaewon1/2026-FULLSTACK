package com.the703.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dao.BoardMapper;
import com.the703.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper dao;  // db관련
	@Override public List<BoardDto> selectAll() { return dao.selectAll(); }

	@Override public int insert(BoardDto dto, MultipartFile file) {
		String fileName = "the703.png";
		if( !file.isEmpty()) {
			fileName   = file.getOriginalFilename();
			String uploadPath = "C:/file/";
			File       demp   = new File(uploadPath + fileName);  //파일경로
			
			try { file.transferTo(demp);} // 파일옮기기
			catch (IOException e) { e.printStackTrace(); }
		}
		
		dto.setBfile(fileName);
		
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

	@Override public int edit(BoardDto dto,  MultipartFile file) {
		int result = -1; // 비번 안맞음
		
		// 비번맞으면 수정
		BoardDto bdto = dao.select(dto.getBno());
		if(bdto.getBpass().equals(dto.getBpass())) { 
			String fileName = dto.getBfile();  //1. 기본파일명으로 들어간거 넣어놓고
			
			if( !file.isEmpty()) {
				fileName = file.getOriginalFilename();
				String uploadPath = "C:/file/";
				File demp = new File( uploadPath + fileName);
				
				try {file.transferTo(demp);}  //2. 파일올리기
				catch (IOException e) { e.printStackTrace(); }
			}
			dto.setBfile(fileName);  //3. 파일명셋팅
			result = dao.update(dto); }
		return result;
	}

	@Override public int delete(BoardDto dto) {
		int result = -1; // 비번 안맞음
		
		// 비번맞으면 삭제


		BoardDto bdto = dao.select(dto.getBno());
		if(bdto.getBpass().equals(dto.getBpass())) { result = dao.delete(dto.getBno()); }
		return result;
	}

		/* paging*/
		/* paging*/
	@Override
	public List<BoardDto> select10(int pstartno) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("start", (pstartno-1)*10); //// (1) 1  0번째부터,10개  (2) 2  10번째부터,10개  (3) 3  20번째부터,10개
		map.put("end", 10);
		return dao.select10(map);
	}
	
	@Override public int selectCnt() { return dao.selectCnt();}

}
