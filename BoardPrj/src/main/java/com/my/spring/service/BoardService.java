package com.my.spring.service;

import java.util.List;

import com.my.spring.dto.BoardDTO;

public interface BoardService {
	// 게시물 전체 목록
	List<BoardDTO> list();
}
