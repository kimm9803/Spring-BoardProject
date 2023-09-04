package com.my.spring.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DislikeDAOImpl implements DislikeDAO {

	@Autowired
	SqlSession sqlSession;

	private final String namespace = "com.my.spring.mappers.likesMapper";

	// 비추천 체크 여부
	@Override
	public int checkDislike(int memberId, int boardId) {
		Map<String, Integer> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("boardId", boardId);
		return sqlSession.selectOne(namespace + ".checkDislike", map);
	}

	// 비추천 업 기능
	@Override
	public void dislikeInsert(int memberId, int boardId) {
		Map<String, Integer> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("boardId", boardId);
		sqlSession.insert(namespace + ".dislikeInsert", map);
	}

	// 비추천 취소 기능
	@Override
	public void dislikeCancel(int memberId, int boardId) {
		Map<String, Integer> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("boardId", boardId);
		sqlSession.insert(namespace + ".dislikeCancel", map);
	}

	// 비추천 개수
	@Override
	public int dislikeCount(int boardId) {
		return sqlSession.selectOne(namespace + ".dislikeCount", boardId);
	}

}
