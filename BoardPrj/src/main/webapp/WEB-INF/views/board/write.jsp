<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<body>
	<form action="/board/write" method="post">
		<label id="writer">글쓴이</label>
		<input type="text" id="writer" name="writer" required /> <br />
		
		<label id="title">제목</label>
		<input type="text" id="title" name="title" required /> <br />
		
		<label id="content">내용</label>
		<textarea rows="5" cols="30" name="content" required></textarea> <br />
		
		<input type="submit" value="작성" />
	</form>
</body>
</html>