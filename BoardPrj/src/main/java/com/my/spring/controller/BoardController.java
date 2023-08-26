package com.my.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// 게시물 상세 조회
	@RequestMapping(value = "/view/{bno}", method = RequestMethod.GET)
	public String showView(@PathVariable int bno, Model model) {
		// 게시글 상세 조회할 때마다 조회수 증가
		boardService.views(bno);
		BoardDTO findDTO = boardService.viewDetail(bno);
		findDTO.setBno(bno);
		model.addAttribute("boardDTO", findDTO);
		return "/board/view";
	}
	
	// 수정 페이지로 이동
	@RequestMapping(value = "/modify/{bno}", method = RequestMethod.GET)
	public String showViewModify(@PathVariable int bno, Model model) {
		BoardDTO findDTO = boardService.viewDetail(bno);
		model.addAttribute("boardDTO", findDTO);
		
		return "board/modify";
	}
	
	// 수정 데이터 반환
	@RequestMapping(value = "/modify/{bno}", method = RequestMethod.POST)
	public String viewModify(BoardDTO boardDTO) {
		boardService.viewModify(boardDTO.getBno());
		return "redirect:/board/list";
	}
}
