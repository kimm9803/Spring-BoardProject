<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<p>
		<a href="/member/register">회원가입</a> &nbsp;&nbsp;&nbsp;
		<a href="/member/login">로그인</a> &nbsp;&nbsp;&nbsp;
		<a href="/member/logout">로그아웃</a>
</body>
</html>
