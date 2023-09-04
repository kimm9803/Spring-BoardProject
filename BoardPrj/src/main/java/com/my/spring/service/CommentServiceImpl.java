package com.my.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.dao.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDAO commentDAO;

	// 댓글 작성
	@Override
	public void writeComment(String content, int authorId, int boardId) {
		commentDAO.writeComment(content, authorId, boardId);
	}
}
