package com.my.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.spring.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlsession;
	
	private final String namespace = "com.my.spring.mappers.boardMapper";
	
	// 게시물 전체 목록
	@Override
	public List<BoardDTO> list() {
		return sqlsession.selectList(namespace + ".list");
	}

	// 게시물 작성
	@Override
	public void write(BoardDTO boardDTO) {
		sqlsession.insert(namespace + ".write", boardDTO);
	}

}
