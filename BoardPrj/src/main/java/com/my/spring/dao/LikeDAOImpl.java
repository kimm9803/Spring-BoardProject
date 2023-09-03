package com.my.spring.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikeDAOImpl implements LikeDAO {
	
	@Autowired
	SqlSession sqlSession;

	private final String namespace = "com.my.spring.mappers.likesMapper";
	
	// 추천 체크 여부
	@Override
	public int checkLike(int memberId, int boardId) {
		Map<String, Integer> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("boardId", boardId);
		return sqlSession.selectOne(namespace + ".checkLike", map);
	}
	
	// 추천 업 기능
	@Override
	public void likeInsert(int memberId, int boardId) {
		Map<String, Integer> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("boardId", boardId);
		sqlSession.insert(namespace + ".likeInsert", map);
	}

	// 추천 취소 기능
	@Override
	public void likeCancel(int memberId, int boardId) {
		Map<String, Integer> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("boardId", boardId);
		sqlSession.insert(namespace + ".likeCancel", map);
	}

	// 추천 개수
	@Override
	public int likeCount(int boardId) {
		return sqlSession.selectOne(namespace + ".likeCount", boardId);
	}
}
