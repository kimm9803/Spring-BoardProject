package com.my.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.dao.LikeDAO;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeDAO likeDAO;

	// 추천 체크(이미 체크했으면 1, 안 했으면 0이 반환)
	@Override
	public int checkLike(int memberId, int boardId) {
		return likeDAO.checkLike(memberId, boardId);
	}

	// 추천 업 기능
	@Override
	public void likeInsert(int memberId, int boardId) {
		likeDAO.likeInsert(memberId, boardId);
	}

	// 추천 취소 기능
	@Override
	public void likeCancel(int memberId, int boardId) {
		likeDAO.likeCancel(memberId, boardId);
	}

	// 추천 개수
	@Override
	public int likeCount(int boardId) {
		return likeDAO.likeCount(boardId);
	}
}
