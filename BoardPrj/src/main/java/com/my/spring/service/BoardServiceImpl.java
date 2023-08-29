package com.my.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.dao.BoardDAO;
import com.my.spring.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;

	// 모든 게시판 조회
	@Override
	public List<BoardDTO> boardList() {
		return boardDAO.boardList();
	}

	// 게시판 작성
	@Override
	public void write(String title, String content, String nickname) {
		boardDAO.write(title, content, nickname);
	}
}
