package com.my.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.spring.dto.MemberDTO;
import com.my.spring.dto.MemberType;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	private final String namespace = "com.my.spring.mappers.memberMapper";
	
	// 회원목록
	@Override
	public List<MemberDTO> memberList() {
		return sqlSession.selectList(namespace + ".memberList");
	}
	
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

	// 로그인
	@Override
	public MemberDTO login(String memberId, String password, String memberType) {
		Map<String, String> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("password", password);
		map.put("memberType", memberType);
		
		return sqlSession.selectOne(namespace + ".login", map);
	}

	// 회원탈퇴
	@Override
	public void withdrawl(String memberId) {
		sqlSession.delete(namespace + ".withdrawl", memberId);
	}

	// 회원검색
	@Override
	public MemberDTO searchMember(String memberId) {
		return sqlSession.selectOne(namespace + ".searchMember", memberId);
	}

	// 회원수정
	@Override
	public void updateMember(MemberDTO memberDTO) {
		sqlSession.update(namespace + ".updateMember", memberDTO);
	}

	
}
