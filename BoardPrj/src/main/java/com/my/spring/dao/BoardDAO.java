package com.my.spring.dao;

import java.util.List;

import com.my.spring.dto.BoardDTO;

public interface BoardDAO {
	// 모든 게시판 조회
	List<BoardDTO> boardList();
	
	// 게시판 작성
	void write(String title, String content, String nickname);
}
