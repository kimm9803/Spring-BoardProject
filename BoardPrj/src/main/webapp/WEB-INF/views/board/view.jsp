<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<style>
</style>
<title>게시물 상세조회</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/member/header.jsp"%>

	<div class="d-flex justify-content-center align-items-center"
		style="height: 100vh;">
		<div class="col-md-7">
			<div class="mb-3 d-flex align-items-center">
				<span id="type" style="margin-right: 20px; font-size: 18px;"></span>
				<input type="text" readonly class="form-control-plaintext"
					id="exampleFormControlInput1" value="${board.title}"
					style="flex: 1; width: 0; font-size: 18px;" />
			</div>
			<div class="d-flex justify-content-between align-items-center mb-2">
				<div style="font-size: 13px;">
					${board.nickname}&nbsp;&nbsp;|&nbsp;&nbsp;${board.postDate}</div>
				<div style="font-size: 13px;">
					조회&nbsp;${board.viewCount}&nbsp;&nbsp;|&nbsp;&nbsp;추천&nbsp;${likeCount}&nbsp;&nbsp;|&nbsp;&nbsp;비추천&nbsp;${dislikeCount}
				</div>
			</div>
			<hr />
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label"></label>
				<textarea readonly class="form-control"
					id="exampleFormControlTextarea1" rows="20">${board.content}</textarea>
				<!--                                  -plaintext -->
			</div>
			<div class="d-flex justify-content-between">
				<button type="button" class="btn btn-secondary"
					onclick="location.href='/board/list'">목록으로</button>
				<div class="img" style="display: flex;">
					<button type="button" id="recommendBtn"
						style="border: none; background: none; cursor: pointer; margin-right: 10px;">
						<img alt="추천" src="/resources/images/recommend.png"
							style="height: 50px; width: 50px;">
					</button>
					<button type="button" id="deprecatedBtn"
						style="border: none; background: none; cursor: pointer;">
						<img alt="비추천" src="/resources/images/deprecated.png"
							style="height: 50px; width: 50px;">
					</button>
				</div>
				<div>
					<button type="button" class="btn btn-secondary" id="modifyButton"
						onclick="location.href='/board/modify/${board.bid}'"
						style="margin-right: 10px;">수정</button>
					<button type="button" class="btn btn-secondary" id="deleteButton"
						onclick="location.href='/board/delete/${board.bid}'">삭제</button>
				</div>
			</div>
		</div>
	</div>

	<script>
		var memberType = "${board.memberType}";
		var nickname = "${sessionScope.nickname}";
		
		if (${likeCheck} == 1 && ${dislikeCheck} == 0) {
			document.getElementById('recommendBtn').addEventListener('click', function() {
				// 추천 취소 기능
				$.ajax({
					type : 'POST',
					url : '/board/like-cancel',
					contentType : 'application/json; charset=utf-8',
					data : JSON.stringify(
							{
								"boardId" : ${board.bid},
								"memberId" : ${mid}
							}
					),
					success : function(data) {
						alert('추천을 취소하였습니다!');
						window.location.href = '/board/view/${board.bid}';
					}
				})
			});
			document.getElementById('deprecatedBtn').addEventListener('click', function() {
				alert('이미 추천을 눌렀습니다!')
			});
		} else if (${likeCheck} == 0 && ${dislikeCheck} == 0) {
			document.getElementById('recommendBtn').addEventListener('click', function() {
				// 추천 증가 기능
				$.ajax({
					type : 'POST',
					url : '/board/like-up',
					contentType : 'application/json;charset=utf-8',
					data : JSON.stringify({
						"boardId" : ${board.bid},
						"memberId" : ${mid}
					}),
					success : function(data) {
						alert('추천을 눌렀습니다!');
						window.location.href = '/board/view/${board.bid}';
					}
				})
			});
			document.getElementById('deprecatedBtn').addEventListener('click', function() {
				// 비추천 증가 기능
				$.ajax({
					type : 'POST',
					url : '/board/dislike-up',
					contentType : 'application/json;charset=utf-8',
					data : JSON.stringify({
						"boardId" : ${board.bid},
						"memberId" : ${mid}
					}),
					success : function(data) {
						alert('비추천을 눌렀습니다!');
						window.location.href = '/board/view/${board.bid}';
					}
				})
			});
		} else if (${likeCheck} == 0 && ${dislikeCheck} == 1) {
			document.getElementById('recommendBtn').addEventListener('click', function() {
				alert('이미 비추천을 눌렀습니다!')
			});
			document.getElementById('deprecatedBtn').addEventListener('click', function() {
				// 비추천 취소 기능
				$.ajax({
					type : 'POST',
					url : '/board/dislike-cancel',
					contentType : 'application/json; charset=utf-8',
					data : JSON.stringify(
							{
								"boardId" : ${board.bid},
								"memberId" : ${mid}
							}
					),
					success : function(data) {
						alert('비추천을 취소하였습니다!');
						window.location.href = '/board/view/${board.bid}';
					}
				})
			});
		} else {
			document.getElementById('recommendBtn').addEventListener('click', function() {
				alert('로그인을 먼저 해주세요!');
			});
			document.getElementById('deprecatedBtn').addEventListener('click', function() {
				alert('로그인을 먼저 해주세요!');
			});
		}
		
		
		if (memberType == 'ADMIN') {
			document.getElementById('type').innerHTML = '[공지]';
		} else {
			document.getElementById('type').innerHTML = '[일반]';
		}
		
		if (nickname !== '${board.nickname}') {
			document.getElementById('deleteButton').style.display = 'none';
			document.getElementById('modifyButton').style.display = 'none';
		}
	</script>

	
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