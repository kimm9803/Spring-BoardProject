package com.my.spring.dto;

import java.util.Date;

public class LikesDTO {
	/*
	 * CREATE TABLE likes (
     * 		like_id NUMBER DEFAULT like_seq.NEXTVAL PRIMARY KEY, -- 좋아요 번호 (시퀀스 사용)
     * 		member_id NUMBER,                                    -- 좋아요를 누른 회원(외래키) <-> members 테이블 mid 참조
     * 		board_id NUMBER,                                     -- 좋아요를 누른 게시물(외래키) <-> board 테이블 bid 참조
     * 		like_date TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,  -- 좋아요를 누른 날짜
     * 		CONSTRAINT fk_likes_member FOREIGN KEY (member_id) REFERENCES members(mid),
     * 		CONSTRAINT fk_likes_board FOREIGN KEY (board_id) REFERENCES board(bid)
	 * );
	 */
	private int likeId;
	private int memberId;
	private int boardId;
	private Date likeDate;
	
	public int getLikeId() {
		return likeId;
	}
	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
}
