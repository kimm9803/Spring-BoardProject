package com.my.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.dao.LikeDAO;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeDAO likeDAO;

	// 좋아요 체크(이미 체크했으면 1, 안 했으면 0이 반환)
	@Override
	public int checkLike(int memberId, int boardId) {
		return likeDAO.checkLike(memberId, boardId);
	}
}
