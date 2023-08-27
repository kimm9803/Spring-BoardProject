package com.my.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.spring.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	private final String namespace = "com.my.spring.mappers.memberMapper";

	// 회원가입
	@Override
	public void register(MemberDTO memberDTO) {
		sqlSession.insert(namespace + ".register", memberDTO);
	}

	// 아이디 중복체크
	@Override
	public int idCheck(String memberId) {
		return sqlSession.selectOne(namespace + ".idCheck", memberId);
	}

	// 닉네임 중복체크
	@Override
	public int nicknameCheck(String nickname) {
		return sqlSession.selectOne(namespace + ".nicknameCheck", nickname);
	}
	
	
}
