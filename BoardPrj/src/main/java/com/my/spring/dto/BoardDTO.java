package com.my.spring.dto;

import java.util.Date;

public class BoardDTO {
	/*
	 * CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1; -- 시퀀스 생성
	 * 
	 * CREATE TABLE board (
	 * 		bid NUMBER DEFAULT board_seq.NEXTVAL PRIMARY KEY, -- 게시판 번호
	 * 		title VARCHAR2(100) NOT NULL,					  -- 제목
	 * 		content CLOB,									  -- 내용
	 * 		post_date TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,-- 작성 날짜
	 * 		author_id NUMBER,								  -- 작성자(외래키) <-> member테이블 mid 참조
	 * 		view_count NUMBER DEFAULT 0,					  -- 조회수
	 * 		recommend_count NUMBER DEFAULT 0,				  -- 추천수
	 * 		FOREIGN KEY (author_mid) REFERENCES members(mid)
	 * );
	 */
	
	private int bid;
	private String title;
	private String content;
	private Date postDate;
	private int authorId;
	private int viewCount;
	private int recommendCount;
	private String nickname;	// members 테이블에서 가져옴
	private MemberType memberType;	// members 테이블에서 가져옴	
	
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getRecommendCount() {
		return recommendCount;
	}
	public void setRecommendCount(int recommendCount) {
		
		this.recommendCount = recommendCount;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	

}
