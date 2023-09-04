package com.my.spring.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	SqlSession sqlSession;
	
	private final String namespace = "com.my.spring.mappers.commentMapper";
	
	// 댓글 작성
	@Override
	public void writeComment(String content, int authorId, int boardId) {
		Map<String, Object> map = new HashMap<>();
		map.put("content", content);
		map.put("authorId", authorId);
		map.put("boardId", boardId);
		sqlSession.insert(namespace + ".writeComment", map);
	}

}
