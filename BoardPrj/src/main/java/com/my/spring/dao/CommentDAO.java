package com.my.spring.dao;

import java.util.List;

import com.my.spring.dto.CommentsDTO;

public interface CommentDAO {
	
	// 댓글 작성
	void writeComment(String content, int authorId, int boardId);
	
	// 댓글 리스트
	List<CommentsDTO> commentList(int bid);
	
	// 댓글 수정
	void updateComment(CommentsDTO commentsDTO);
	
	// 댓글 삭제
	void deleteComment(CommentsDTO commentsDTO);
}
