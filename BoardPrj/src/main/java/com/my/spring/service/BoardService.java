package com.my.spring.service;

import java.util.List;

import com.my.spring.dto.BoardDTO;

public interface BoardService {
	// 모든 게시판 조회
	List<BoardDTO> boardList();
	
	// 게시판 작성
	void write(String title, String content, String nickname);
}
