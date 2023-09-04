package com.my.spring.service;

public interface CommentService {

	// 댓글 작성
	void writeComment(String content, int authorId, int boardId);
}
