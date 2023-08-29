package com.my.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.spring.dto.BoardDTO;
import com.my.spring.dto.MemberDTO;
import com.my.spring.service.BoardService;
import com.my.spring.service.MemberService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	MemberService memberService;
	
	// 모든 게시물 조회
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String boardList(Model model) {
		List<BoardDTO> boardList = boardService.boardList();
		List<MemberDTO> memberList = memberService.memberList();
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("memberList", memberList);
		return "board/list";
	}
	
	// 작성폼으로 이동 - 컨트롤러에서 alert 출력 후 바로 리다이렉트
//	@ResponseBody
//	@RequestMapping(value = "/write", produces="text/html;charset=UTF-8", method = RequestMethod.GET)
//	public String showWriteForm(HttpSession session) {
//		String message = "";
//		String memberId = (String)session.getAttribute("memberId");
//		if (memberId == null) {
//			message = "<script>alert('로그인 상태에서만 작성이 가능합니다.');location.href='/member/login';</script>";
//			return message;
//		} else {
//			return "board/write";
//		}
//	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String showWriteForm() {
	    return "board/write";
	}
}
