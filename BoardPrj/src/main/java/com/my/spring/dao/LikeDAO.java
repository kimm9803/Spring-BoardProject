package com.my.spring.dao;

public interface LikeDAO {
	// 추천 체크 여부
	int checkLike(int memberId, int boardId);
	
	// 추천 업 기능
	void likeInsert(int memberId, int boardId);
	
	// 추천 취소 기능
	void likeCancel(int memberId, int boardId);
	
	// 추천 개수
	int likeCount(int boardId);
}
