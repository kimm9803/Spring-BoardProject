package com.my.spring.dao;

import java.util.List;

import com.my.spring.dto.MemberDTO;

public interface MemberDAO {
	// 회원목록
	List<MemberDTO> memberList();
	
	// 회원가입
	void register(MemberDTO memberDTO);
	
	// 아이디 중복체크
	int idCheck(String memberId);
	
	// 닉네임 중복체크
	int nicknameCheck(String nickname);
	
	// 로그인
	MemberDTO login(String memberId, String password, String memberType);
	
	// 회원탈퇴
	void withdrawl(String memberId);
	
	// 회원검색
	MemberDTO searchMember(String memberId);
	
	// 회원수정
	void updateMember(MemberDTO memberDTO);
}
