<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/member/header.jsp"%>

	<div class="d-flex justify-content-center align-items-center"
		style="height: 100vh;">
		<div class="col-md-7">
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th class="text-center" scope="col">번호</th>
						<th class="text-center" scope="col">제목</th>
						<th class="text-center" scope="col">글쓴이</th>
						<th class="text-center" scope="col">작성일</th>
						<th class="text-center" scope="col">조회</th>
						<th class="text-center" scope="col">추천</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${boardList}" var="board">
						<tr>
							<td class="text-center">${board.bid}</td>
							<td class="text-center">${board.title}</td>
							<td class="text-center">${board.nickname}</td>
							<td class="text-center"><fmt:formatDate value="${board.postDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td class="text-center">${board.viewCount}</td>
							<td class="text-center">${board.recommendCount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="d-flex justify-content-end">
				<!-- Primary 버튼을 오른쪽에 위치시킴 -->
				<button type="button" class="btn btn-primary" id="writeButton">글작성</button>
			</div>
		</div>
	</div>
	

	<script>
		// 로그인 상태이면 작성 페이지로 이동, 아니면 로그인 페이지로 이동
		document.getElementById('writeButton').addEventListener('click', function() {
			var memberId = "${sessionScope.memberId}";
			if (memberId !== null && memberId !== "") {
				location.href = '/board/write';
			} else {
				alert('로그인 상태에서만 글작성이 가능합니다.');
				location.href = '/member/login';
			}
		});
	</script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>