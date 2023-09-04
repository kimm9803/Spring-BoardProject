package com.my.spring.dto;

import java.util.Date;

public class CommentDislikesDTO {
	
	/*
	 * CREATE TABLE comment_dislikes (
     * 		dislike_id NUMBER DEFAULT comment_dislike_seq.NEXTVAL PRIMARY KEY,  -- 댓글 비추천 번호 (시퀀스 사용)
     * 		comment_id NUMBER,                                                 -- 비추천한 댓글(외래키) <-> comments 테이블 comment_id 참조
     * 		member_id NUMBER,                                                  -- 비추천한 회원(외래키) <-> members 테이블 mid 참조
     * 		dislike_date TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,              -- 비추천한 날짜
     * 		CONSTRAINT fk_comment_dislikes_member FOREIGN KEY (member_id) REFERENCES members(mid),
     * 		CONSTRAINT fk_comment_dislikes_comment FOREIGN KEY (comment_id) REFERENCES comments(comment_id)
	 * );
	 */
	
	private int dislikeId;
	private int commentId;
	private int memberId;
	private Date dislikeDate;
	
	public int getDislikeId() {
		return dislikeId;
	}
	public void setDislikeId(int dislikeId) {
		this.dislikeId = dislikeId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Date getDislikeDate() {
		return dislikeDate;
	}
	public void setDislikeDate(Date dislikeDate) {
		this.dislikeDate = dislikeDate;
	}
}
