package com.my.spring.dao;

import com.my.spring.dto.MemberDTO;

public interface MemberDAO {
	// 회원가입
	void register(MemberDTO memberDTO);
	
	// 아이디 중복체크
	int idCheck(String memberId);
	
	// 닉네임 중복체크
	int nicknameCheck(String nickname);
	
	// 로그인
	MemberDTO login(String memberId, String password);
}
