package com.my.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.spring.dto.CommentsDTO;

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

	// 댓글 리스트
	@Override
	public List<CommentsDTO> commentList(int bid) {
		return sqlSession.selectList(namespace + ".commentList", bid);
	}

	// 댓글 수정
	@Override
	public void updateComment(CommentsDTO commentsDTO) {
		sqlSession.update(namespace + ".updateComment", commentsDTO);
	}

	// 댓글 삭제
	@Override
	public void deleteComment(CommentsDTO commentsDTO) {
		sqlSession.delete(namespace + ".deleteComment", commentsDTO);
	}

}
