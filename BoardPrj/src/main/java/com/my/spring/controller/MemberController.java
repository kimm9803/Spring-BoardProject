package com.my.spring.controller;

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
}
