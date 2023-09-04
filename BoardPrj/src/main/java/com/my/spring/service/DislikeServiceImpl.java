package com.my.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.dao.DislikeDAO;

@Service
public class DislikeServiceImpl implements DislikeService {
	
	@Autowired
	DislikeDAO dislikeDAO;
	
	// 비추천 체크(이미 체크했으면 1, 안 했으면 0이 반환)
	@Override
	public int checkDislike(int memberId, int boardId) {
		return dislikeDAO.checkDislike(memberId, boardId);
	}

	// 비추천 업 기능
	@Override
	public void dislikeInsert(int memberId, int boardId) {
		dislikeDAO.dislikeInsert(memberId, boardId);
	}

	// 비추천 취소 기능
	@Override
	public void dislikeCancel(int memberId, int boardId) {
		dislikeDAO.dislikeCancel(memberId, boardId);
	}

	// 비추천 개수
	@Override
	public int dislikeCount(int boardId) {
		return dislikeDAO.dislikeCount(boardId);
	}

}
