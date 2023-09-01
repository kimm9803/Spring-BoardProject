package com.my.spring.service;

import java.util.List;

import com.my.spring.dto.BoardDTO;

public interface BoardService {
	// 모든 게시판 조회
	List<BoardDTO> boardList();
	
	// 게시판 작성
	void write(String title, String content, String nickname);
	
	// 게시판 상세조회
	BoardDTO view(int bid);
	
	// 조회수 증가
	void views(int bid);
	
	// 게시물 수정
	void modify(BoardDTO boardDTO);
	
	// 게시물 삭제
	void delete(int bid);
	
	// 개시물 총 갯수(페이징)
	int totalCount();
	
	// 페이징 + 검색
	List<BoardDTO> listPage(int displayPost, int postNum, String searchType, String keyword);
	
	// 게시물 총 갯수 + 검색 적용
	int searchCount(String searchType, String keyword);
}
