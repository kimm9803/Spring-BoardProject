package com.my.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.spring.dto.BoardDTO;
import com.my.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	// 게시물 전체 목록 조회
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showList(Model model) {
		
		List<BoardDTO> boardList = boardService.list();
		model.addAttribute("list", boardList);
		return "board/list";
	}

	// 게시물 작성 페이지 이동
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String showWrite() {
		return "board/write";
	}
	
	// 게시물 목록으로 redirect
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String getWrite(BoardDTO boardDTO) {
		boardService.write(boardDTO);
		
		return "redirect:/board/list";
	}
}
