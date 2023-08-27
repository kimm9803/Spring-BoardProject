<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/member/login" method="post">
		<label>아이디: <input type="text" name="memberId" id="memberId" /></label> <br />
		<label>비밀번호: <input type="password" name="password" /></label> <br />
		<input type="submit" value="로그인" />
	</form>
</body>
</html>