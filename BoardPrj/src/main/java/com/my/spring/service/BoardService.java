package com.my.spring.service;

import java.util.List;

import com.my.spring.dto.BoardDTO;

public interface BoardService {
	// 게시물 전체 목록
	List<BoardDTO> list();
	
	// 게시물 작성
	void write(BoardDTO boardDTO);
	
	// 게시물 상세 조회
	BoardDTO viewDetail(int bno);
	
	// 조회수
	void views(int bno);
	
	// 게시물 수정
	void viewModify(BoardDTO boardDTO);
	
	// 게시물 삭제
	void viewDelete(int bno);
}
