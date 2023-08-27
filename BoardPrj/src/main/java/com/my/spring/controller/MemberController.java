package com.my.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.spring.dto.MemberDTO;
import com.my.spring.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	// 회원가입 폼
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm() {
		return "member/register";
	}
	
	// 회원가입
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String getRegister(MemberDTO memberDTO) {
		memberService.register(memberDTO);
		return "redirect:/";
	}
	
	// 아이디 중복체크
	@ResponseBody
	@RequestMapping(value = "/checkMemberId", method = RequestMethod.GET)
	public String checkMemberId(@RequestParam("memberId") String memberId) {
		int num = memberService.idCheck(memberId);
		if (num == 0) {
			return "true";
		} else {
			return "false";
		}
	}
	
	// 닉네임 중복체크
	@ResponseBody
	@RequestMapping(value = "/checkNickname", method = RequestMethod.GET)
	public String checkNickname(@RequestParam("nickname") String nickname) {
		int num = memberService.nicknameCheck(nickname);
		if (num == 0) {
			return "true";
		} else {
			return "false";
		}
	}
	
	// 로그인 폼
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() {
		return "member/login";
	}
	
	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getLogin(@RequestParam("memberId") String memberId,
						   @RequestParam("password") String password,
						   HttpSession session) {
		MemberDTO findDTO = memberService.login(memberId, password);
		if (findDTO == null) {
			System.out.println("로그인 실패!");
			return "redirect:/member/login";
		} else {
			session.setAttribute("memberId", findDTO.getMemberId());
			session.setAttribute("password", findDTO.getPassword());
			System.out.println("로그인 성공!");
			return "home";
		}
	}
	/*
	 * 로그인 유효성 검사
	 * 일반회원/관리자 선택 기능 추가
	 * 테스트
	 * jsp : 로그인 -> 로그아웃
	 * 회원탈퇴, 회원수정
	 * 화면에 아이디 출력
	 */
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("로그아웃!");
		return "redirect:/";
	}
}
