package com.my.spring.dto;

import java.util.Date;

public class CommentsDTO {
	/*
	 * CREATE TABLE comments (
     * 		comment_id NUMBER DEFAULT comment_seq.NEXTVAL PRIMARY KEY,  -- 댓글 번호 (시퀀스 사용)
     * 		content CLOB,                                                -- 댓글 내용
     * 		comment_date TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,       -- 댓글 작성 날짜
     * 		author_id NUMBER,                                            -- 댓글 작성자(외래키) <-> members 테이블 mid 참조
     * 		board_id NUMBER,                                            -- 댓글이 달린 게시물(외래키) <-> board 테이블 bid 참조
     * 		CONSTRAINT fk_comments_member FOREIGN KEY (author_id) REFERENCES members(mid),
     * 		CONSTRAINT fk_comments_board FOREIGN KEY (board_id) REFERENCES board(bid)
     * );
	 */	
	 
	private int commentId;
	private String content;
	private Date commentDate;
	private int authorId;
	private int boardId;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
}
