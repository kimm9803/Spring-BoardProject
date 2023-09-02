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
	// 좋아요 체크
	@Override
	public int checkLike(int memberId, int boardId) {
		Map<String, Integer> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("boardId", boardId);
		return sqlSession.selectOne(namespace + ".checkLike", map);
	}
	
	
}
