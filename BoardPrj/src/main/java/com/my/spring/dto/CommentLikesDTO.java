package com.my.spring.dto;

public class CommentLikesDTO {

	/*
	 * CREATE TABLE comment_likes (
     * 		like_id NUMBER DEFAULT comment_like_seq.NEXTVAL PRIMARY KEY,  -- 댓글 추천 번호 (시퀀스 사용)
     * 		comment_id NUMBER,                                            -- 추천한 댓글(외래키) <-> comments 테이블 comment_id 참조
     * 		member_id NUMBER,                                             -- 추천한 회원(외래키) <-> members 테이블 mid 참조
     * 		like_date TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,            -- 추천한 날짜
     * 		CONSTRAINT fk_comment_likes_member FOREIGN KEY (member_id) REFERENCES members(mid),
     * 		CONSTRAINT fk_comment_likes_comment FOREIGN KEY (comment_id) REFERENCES comments(comment_id)
	 * );
	 */
	
	private int likeId;
	private int commentId;
	private int memberId;
	private int likeDate;
	
	public int getLikeId() {
		return likeId;
	}
	public void setLikeId(int likeId) {
		this.likeId = likeId;
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
	public int getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(int likeDate) {
		this.likeDate = likeDate;
	}
}
