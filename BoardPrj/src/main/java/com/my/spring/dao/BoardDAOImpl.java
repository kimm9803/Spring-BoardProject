package com.my.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.spring.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;
	
	private final String namespace = "com.my.spring.mappers.boardMapper";
	
	// 모든 게시판 조회
	@Override
	public List<BoardDTO> boardList() {
		return sqlSession.selectList(namespace + ".boardList");
	}

	// 게시판 작성
	@Override
	public void write(String title, String content, String nickname) {
		Map<String, String> map = new HashMap<>();
		map.put("title", title);
		map.put("content", content);
		map.put("nickname", nickname);
		
		sqlSession.insert(namespace + ".write", map);
	}

	// 게시판 상세조회
	@Override
	public BoardDTO view(int bid) {
		return sqlSession.selectOne(namespace + ".view", bid);
	}

	// 조회수 증가
	@Override
	public void views(int bid) {
		sqlSession.update(namespace + ".views", bid);
	}

	// 게시물 수정
	@Override
	public void modify(BoardDTO boardDTO) {
		sqlSession.update(namespace + ".modify", boardDTO);
	}

	// 게시물 삭제
	@Override
	public void delete(int bid) {
		sqlSession.delete(namespace + ".delete", bid);
	}

	// 개시물 총 갯수
	@Override
	public int totalCount() {
		return sqlSession.selectOne(namespace + ".totalCount");
	}

	// 페이징 + 검색
	@Override
	public List<BoardDTO> listPage(int displayPost, int postNum, String searchType, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("displayPost", displayPost);
		map.put("postNum", postNum);
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		return sqlSession.selectList(namespace + ".listPage", map);
	}

	// 게시물 총 갯수 + 검색 적용
	@Override
	public int searchCount(String searchType, String keyword) {
		Map<String, String> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		return sqlSession.selectOne(namespace + ".searchCount", map);
	}
}
