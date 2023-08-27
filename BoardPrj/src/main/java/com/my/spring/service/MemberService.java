package com.my.spring.service;

import com.my.spring.dto.MemberDTO;

public interface MemberService {
	
	// 회원가입
	void register(MemberDTO memberDTO);
	
	// 아이디 중복체크
	int idCheck(String memberId);
	
	// 닉네임 중복체크
	int nicknameCheck(String nickname);
}
