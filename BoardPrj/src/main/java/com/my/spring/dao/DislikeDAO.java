package com.my.spring.dao;

public interface DislikeDAO {
	// 추천 체크 여부
	int checkDislike(int memberId, int boardId);

	// 추천 업 기능
	void dislikeInsert(int memberId, int boardId);

	// 추천 취소 기능
	void dislikeCancel(int memberId, int boardId);

	// 추천 개수
	int dislikeCount(int boardId);
}
