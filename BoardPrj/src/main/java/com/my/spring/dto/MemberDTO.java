package com.my.spring.dto;

import java.util.Date;

public class MemberDTO {
	/*
	 * CREATE TABLE members (
	 * 		mid	NUMBER DEFAULT member_seq.NEXTVAL PRIMARY KEY, 
	 * 		memberId VARCHAR2(50) UNIQUE,
	 * 		password VARCHAR2(255) NOT NULL,
	 * 		nickname VARCHAR2(50) UNIQUE,
	 * 		signup_date TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,
	 * 		member_type VARCHAR2(10)
	 * );
	 */
	
	private int mid;
	private String memberId;
	private String password;
	private String nickname;
	private Date signupDate;
	private MemberType memberType;
	
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getSignupDate() {
		return signupDate;
	}
	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}
}
