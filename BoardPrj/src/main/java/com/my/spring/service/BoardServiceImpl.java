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
}
