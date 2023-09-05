package com.my.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.dao.CommentDAO;
import com.my.spring.dto.CommentsDTO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDAO commentDAO;

	// 댓글 작성
	@Override
	public void writeComment(String content, int authorId, int boardId) {
		commentDAO.writeComment(content, authorId, boardId);
	}

	// 댓글 리스트
	@Override
	public List<CommentsDTO> commentList(int bid) {
		return commentDAO.commentList(bid);
	}

	// 댓글 수정
	@Override
	public void updateComment(CommentsDTO commentsDTO) {
		commentDAO.updateComment(commentsDTO);
	}

	// 댓글 삭제
	@Override
	public void deleteComment(CommentsDTO commentsDTO) {
		commentDAO.deleteComment(commentsDTO);
	}
}
