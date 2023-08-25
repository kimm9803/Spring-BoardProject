package com.my.spring.dao;

import java.util.List;

import com.my.spring.dto.BoardDTO;

public interface BoardDAO {
	
	// 게시물 전체 목록
	List<BoardDTO> list();
	
	// 게시물 작성
	void write(BoardDTO boardDTO);
}
