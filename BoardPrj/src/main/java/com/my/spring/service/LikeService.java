package com.my.spring.service;

public interface LikeService {
	// 좋아요 체크
	int checkLike(int memberId, int boardId);
}
