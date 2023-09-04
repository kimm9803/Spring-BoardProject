package com.my.spring.dao;

public interface CommentDAO {
	
	// 댓글 작성
	void writeComment(String content, int authorId, int boardId);
}
