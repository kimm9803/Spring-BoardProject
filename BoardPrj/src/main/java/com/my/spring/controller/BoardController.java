package com.my.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.spring.dto.BoardDTO;
import com.my.spring.dto.DislikesDTO;
import com.my.spring.dto.LikesDTO;
import com.my.spring.dto.MemberDTO;
import com.my.spring.dto.Page;
import com.my.spring.service.BoardService;
import com.my.spring.service.DislikeService;
import com.my.spring.service.LikeService;
import com.my.spring.service.MemberService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@Autowired
	MemberService memberService;
	
	@Autowired
	LikeService likeService;
	
	@Autowired
	DislikeService dislikeService;

	// 게시물 조회(페이징 + 검색)
	@RequestMapping(value = "/list/{num}", method = RequestMethod.GET)
	public String boardList(@PathVariable("num") int num, Model model,
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {

		Page page = new Page();
		page.setNum(num);
		page.setCount(boardService.searchCount(searchType, keyword));
		page.setSearchTypeKeyword(searchType, keyword);
		
		List<BoardDTO> boardList = boardService.listPage(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
		List<MemberDTO> memberList = memberService.memberList();
		model.addAttribute("boardList", boardList);
		model.addAttribute("memberList", memberList);
		model.addAttribute("select", num);
		model.addAttribute("page", page);

		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
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

	// 작성폼으로 이동(스크립트 로그인 예외처리)
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String showWriteForm() {
		return "board/write";
	}

	// 게시판 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String getWrite(HttpSession session, Model model, BoardDTO board) {
		String nickname = (String) session.getAttribute("nickname");
		boardService.write(board.getTitle(), board.getContent(), nickname);

		return "redirect:/board/list";
	}

	// 게시판 상세조회 + 추천&비추천 기능
	@RequestMapping(value = "/view/{num}", method = RequestMethod.GET)
	public String getView(@PathVariable("num") int num, Model model, HttpSession session) {
		// 조회수 증가 후 상세조회
		boardService.views(num);
		int likeCount = likeService.likeCount(num);
		int dislikeCount = dislikeService.dislikeCount(num);
		String loginId = (String)session.getAttribute("memberId");
		int likeCheck = -1;
		int dislikeCheck = -1;
		if (loginId != null) {
			MemberDTO findMember = memberService.searchMember(loginId);
			// 0 or 1 반환
			likeCheck = likeService.checkLike(findMember.getMid(), num);
			dislikeCheck = dislikeService.checkDislike(findMember.getMid(), num);
			model.addAttribute("mid", findMember.getMid());
		} else {
			model.addAttribute("mid", 0);
		}
		model.addAttribute("likeCheck", likeCheck);
		model.addAttribute("dislikeCheck", dislikeCheck);
		model.addAttribute("likeCount", likeCount);
		model.addAttribute("dislikeCount", dislikeCount);
		BoardDTO findDTO = boardService.view(num);
		model.addAttribute("board", findDTO);

		return "board/view";
	}

	// 수정폼으로 이동
	@RequestMapping(value = "/modify/{num}", method = RequestMethod.GET)
	public String showModifyForm(@PathVariable("num") int num, Model model) {
		BoardDTO findDTO = boardService.view(num);
		model.addAttribute("board", findDTO);

		return "board/modify";
	}

	// 게시물 수정
	@RequestMapping(value = "/modify/{num}", method = RequestMethod.POST)
	public String getModify(@PathVariable("num") int num, BoardDTO boardDTO) {
		boardService.modify(boardDTO);

		return "redirect:/board/view/{num}";
	}

	// 게시물 삭제
	@RequestMapping(value = "/delete/{num}", method = RequestMethod.GET)
	public String deleteView(@PathVariable("num") int num) {
		boardService.delete(num);

		return "redirect:/board/list";
	}

	/*
	 * 할 것
	 * 특정 url로 들어갔을 때 수정, 삭제 못하게 예외처리 / 댓글기능 + 댓글 추천기능
	 * 상세조회에서 목록으로 버튼 눌렀을 때 에러처리
	 * 공지, 일반글 나누기
	 * 개념글
	 * 피드백 받은 거 리팩토링
	 */
	
	@ResponseBody
	@RequestMapping(value = "/like-up", method = RequestMethod.POST, consumes = "application/json")
	public void likeUp(@RequestBody LikesDTO dto) {
		 likeService.likeInsert(dto.getMemberId(), dto.getBoardId());
	}
	
	@ResponseBody
	@RequestMapping(value = "/like-cancel", method = RequestMethod.POST, consumes = "application/json")
	public void likeCancel(@RequestBody LikesDTO dto) {
		likeService.likeCancel(dto.getMemberId(), dto.getBoardId());
	}
	
	@ResponseBody
	@RequestMapping(value = "/dislike-up", method = RequestMethod.POST, consumes = "application/json")
	public void dislikeUp(@RequestBody DislikesDTO dto) {
		 dislikeService.dislikeInsert(dto.getMemberId(), dto.getBoardId());
	}
	
	@ResponseBody
	@RequestMapping(value = "/dislike-cancel", method = RequestMethod.POST, consumes = "application/json")
	public void dislikeCancel(@RequestBody DislikesDTO dto) {
		dislikeService.dislikeCancel(dto.getMemberId(), dto.getBoardId());
	}
}
