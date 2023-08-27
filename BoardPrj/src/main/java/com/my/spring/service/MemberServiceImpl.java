package com.my.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.dao.MemberDAO;
import com.my.spring.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
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

}
