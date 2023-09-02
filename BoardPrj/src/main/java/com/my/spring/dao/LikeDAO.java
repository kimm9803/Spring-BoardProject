package com.my.spring.dao;

public interface LikeDAO {
	// 좋아요 체크
	int checkLike(int memberId, int boardId);
}
