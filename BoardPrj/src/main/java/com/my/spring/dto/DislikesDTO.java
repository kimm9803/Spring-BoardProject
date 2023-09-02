package com.my.spring.dto;

import java.util.Date;

public class DislikesDTO {
	/*
	 * CREATE TABLE dislikes (
     * 		dislike_id NUMBER DEFAULT dislike_seq.NEXTVAL PRIMARY KEY,  -- 싫어요 번호(시퀀스 사용)
     * 		member_id NUMBER,                                           -- 싫어요 누른 회원 아이디
     * 		board_id NUMBER,                                            -- 싫어요 누른 게시물 번호
     * 		dislike_date TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,       -- 싫어요 누른 날짜
     * 		CONSTRAINT fk_dislikes_member FOREIGN KEY (member_id) REFERENCES members(mid),
     * 		CONSTRAINT fk_dislikes_board FOREIGN KEY (board_id) REFERENCES board(bid)
	 * );
	 */
	
	private int dislikesId;
	private int memberId;
	private int boardId;
	private Date dislikeDate;
	
	public int getDislikesId() {
		return dislikesId;
	}
	public void setDislikesId(int dislikesId) {
		this.dislikesId = dislikesId;
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
	public Date getDislikeDate() {
		return dislikeDate;
	}
	public void setDislikeDate(Date dislikeDate) {
		this.dislikeDate = dislikeDate;
	}
}
