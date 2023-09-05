package com.my.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.spring.dto.MemberDTO;
import com.my.spring.service.CommentService;
import com.my.spring.service.MemberService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	MemberService memberService;
	
	// 댓글 작성
	@PostMapping("/register/{num}")
	public String writeComment(@PathVariable("num") int num, @RequestParam("content") String content,
			HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("memberId");
		if (memberId != null) {
			MemberDTO findMember = memberService.searchMember(memberId);
			commentService.writeComment(content, findMember.getMid(), num);
		}
		
		return "redirect:/board/view/{num}";
	}
	
	/*
	// 댓글 수정
	@PostMapping("/update/{num}")
	public String updateComment(@PathVariable("num") int num) {
		
	}
	
	// 댓글 삭제
	@PostMapping("/delete/{num}")
	
	수정 삭제 컨트롤러 만들고 댓글수정.jsp, 본인이 쓴 댓글만 수정, 삭제 버튼 보이기
	*/
}
