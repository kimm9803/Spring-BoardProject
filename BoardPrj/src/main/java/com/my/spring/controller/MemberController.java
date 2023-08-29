package com.my.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		if (num == 0 && memberId.equals("")) {
			return "null";
		} else if (num == 0 && !memberId.equals("")) {
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
		if (num == 0 && nickname.equals("")) {
			return "null";
		} else if (num == 0 && !nickname.equals("")) {
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
						   @RequestParam("memberType") String memberType,
						   HttpSession session) {
		MemberDTO findDTO = memberService.login(memberId, password, memberType);
		if (findDTO == null) {
			System.out.println("로그인 실패!");
			return "redirect:/member/login";
		} else {
			session.setAttribute("memberId", findDTO.getMemberId());
			session.setAttribute("password", findDTO.getPassword());
			session.setAttribute("nickname", findDTO.getNickname());
			
			System.out.println("로그인 성공!");
			return "redirect:/";
		}
	}
	/*
	 * 로그인 유효성 검사
	 * 테스트
	 */
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("로그아웃!");
		return "redirect:/";
	}
	
	// 회원탈퇴
	@RequestMapping(value = "/withdrawl", method = RequestMethod.GET)
	public String withdrawl(HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		memberService.withdrawl(memberId);
		session.invalidate();
		return "redirect:/";
	}
	
	// 회원정보 수정 폼
	@RequestMapping(value = "/modifyMember", method = RequestMethod.GET)
	public String modifyMemberForm(HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("memberId");
		MemberDTO findMember = memberService.searchMember(memberId);
		model.addAttribute("member", findMember);
		return "member/modify";
	}
	
	// 회원정보
	@RequestMapping(value = "/modifyMember", method = RequestMethod.POST)
	public String modifyMember(MemberDTO memberDTO) {
		memberService.updateMember(memberDTO);
		return "redirect:/";
	}
	/*
	 * 회원가입, 로그인, 회원수정 예외처리
	 * ADMIN, GUEST 화면&기능 나누기
	 */
}
