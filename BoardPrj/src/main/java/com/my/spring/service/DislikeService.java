package com.my.spring.service;

public interface DislikeService {
	// 좋아요 체크
	int checkDislike(int memberId, int boardId);

	// 추천 업 기능
	void dislikeInsert(int memberId, int boardId);

	// 추천 취소 기능
	void dislikeCancel(int memberId, int boardId);

	// 추천 개수
	int dislikeCount(int boardId);
}
