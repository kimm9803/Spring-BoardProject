package com.my.spring.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.dao.MemberDAO;
import com.my.spring.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
	// 회원목록
	@Override
	public List<MemberDTO> memberList() {
		return memberDAO.memberList();
	}
	
	// 회원가입
	@Override
	public void register(MemberDTO memberDTO) {
		memberDAO.register(memberDTO);
	}

	// 아이디 중복체크
	@Override
	public int idCheck(String memberId) {
		return memberDAO.idCheck(memberId);
	}

	// 닉네임 중복체크
	@Override
	public int nicknameCheck(String nickname) {
		return memberDAO.nicknameCheck(nickname);
	}

	// 로그인
	@Override
	public MemberDTO login(String memberId, String password, String memberType) {
		return memberDAO.login(memberId, password, memberType);
	}

	// 로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	// 회원탈퇴
	@Override
	public void withdrawl(String memberId) {
		memberDAO.withdrawl(memberId);
	}

	// 회원검색
	@Override
	public MemberDTO searchMember(String memberId) {
		return memberDAO.searchMember(memberId);
	}

	// 회원수정
	@Override
	public void updateMember(MemberDTO memberDTO) {
		memberDAO.updateMember(memberDTO);
	}
}
