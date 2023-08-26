<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세 조회</title>
</head>
<body>

	글쓴이 &nbsp;
	${boardDTO.writer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	조회수 &nbsp;
	${boardDTO.viewCnt}
	<br />
		
	제목 &nbsp;
	${boardDTO.title} <br />
		
	내용 &nbsp;
	${boardDTO.content} <br />
	
	<p>
		<a href="/board/list">게시물 목록</a> &nbsp;&nbsp;&nbsp; <a href="/board/modify/${boardDTO.bno}">수정</a>
		&nbsp;&nbsp;&nbsp; <a href="/board/delete/${boardDTO.bno}">삭제</a>
	</p>
		
</body>
</html>