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

}
