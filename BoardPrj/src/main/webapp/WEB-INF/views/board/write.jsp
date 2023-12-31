<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="UTF-8">
<title>글 작성</title>
</head>
<body>
<%@ include file="/WEB-INF/views/member/header.jsp" %>

<form action="/board/write" method="post">
	<div class="d-flex justify-content-center align-items-center" style="height: 100vh;">
		<div class="col-md-7">
			<div class="mb-3">
	  			<label for="exampleFormControlInput1" class="form-label">제목</label>
	  			<input type="text" class="form-control" id="exampleFormControlInput1" name="title" placeholder="제목을 입력해 주세요">
			</div>
			<div class="mb-3">
	  			<label for="exampleFormControlTextarea1" class="form-label">내용</label>
	  			<textarea class="form-control" id="exampleFormControlTextarea1" name="content" rows="20"></textarea>
			</div>
			<div class="d-flex justify-content-end">
				<button type="button" class="btn btn-secondary" id="writeCancelButton">취소</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-primary" id="writeRegisterButton">글 등록</button>
			</div>
		</div>
	</div>
</form>

<script>
	document.getElementById('writeRegisterButton').addEventListener('click', function() {
		document.querySelector('form').submit();
	});
	document.getElementById('writeCancelButton').addEventListener('click', function() {
		location.href = '/board/list';
	});
</script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>