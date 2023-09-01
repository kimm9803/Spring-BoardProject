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

	// 게시판 상세조회
	@Override
	public BoardDTO view(int bid) {
		return boardDAO.view(bid);
	}

	// 조회수 증가
	@Override
	public void views(int bid) {
		boardDAO.views(bid);
	}

	// 게시물 수정
	@Override
	public void modify(BoardDTO boardDTO) {
		boardDAO.modify(boardDTO);
	}

	// 게시물 삭제
	@Override
	public void delete(int bid) {
		boardDAO.delete(bid);
	}

	// 게시물 총 갯수(페이징)
	@Override
	public int totalCount() {
		return boardDAO.totalCount();
	}

	// 페이징 + 검색
	@Override
	public List<BoardDTO> listPage(int displayPost, int postNum, String searchType, String keyword) {
		return boardDAO.listPage(displayPost, postNum, searchType, keyword);
	}

	// 검색 + 페이징 적용
	@Override
	public int searchCount(String searchType, String keyword) {
		return boardDAO.searchCount(searchType, keyword);
	}
}
