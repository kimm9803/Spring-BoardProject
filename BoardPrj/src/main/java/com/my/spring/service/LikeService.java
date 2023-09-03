package com.my.spring.service;

public interface LikeService {
	
	// 좋아요 체크
	int checkLike(int memberId, int boardId);
	
	// 추천 업 기능
	void likeInsert(int memberId, int boardId);
	
	// 추천 취소 기능
	void likeCancel(int memberId, int boardId);
	
	// 추천 개수
	int likeCount(int boardId);
}
