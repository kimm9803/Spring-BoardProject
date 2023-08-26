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
	
	// 게시물 전체 목록
	@Override
	public List<BoardDTO> list() {
		return boardDAO.list();
	}

	//	 게시물 작성
	@Override
	public void write(BoardDTO boardDTO) {
		boardDAO.write(boardDTO);
	}

	// 게시물 상세 조회
	@Override
	public BoardDTO viewDetail(int bno) {
		return boardDAO.viewDetail(bno);
	}

	// 조회수
	@Override
	public void views(int bno) {
		boardDAO.views(bno);
	}

	// 게시물 수정
	@Override
	public void viewModify(BoardDTO boardDTO) {
		boardDAO.viewModify(boardDTO);
	}
}
