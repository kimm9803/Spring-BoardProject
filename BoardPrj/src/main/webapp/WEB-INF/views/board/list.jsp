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
<title>게시판 목록</title>
<style>
    /* Set a fixed height for the table container */

    .pagination-container {
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 20px;
    }
    .write-button {
        margin-left: auto;
    }
    
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/member/header.jsp"%>

	<div class="d-flex justify-content-center align-items-center"
		style="height: 100vh;">
		<div class="col-md-7">
			<nav class="navbar">
                <div class="container-fluid d-flex justify-content-end">
                    <form class="form-inline">
                    	<select class="form-select text-center mr-2" aria-label="Default select example" name="searchType">
							  <option value="title" <c:if test="${searchType eq 'title'}">selected</c:if>>제목</option>
							  <option value="content" <c:if test="${searchType eq 'content'}">selected</c:if>>내용</option>
							  <option value="titleAndContent" <c:if test="${searchType eq 'titleAndContent'}">selected</c:if>>제목+내용</option>
							  <option value="nickname" <c:if test="${searchType eq 'nickname'}">selected</c:if>>작성자</option>
						</select>
                        <input class="form-control mr-2" type="search" name="keyword" value="${keyword}" placeholder="통합 검색 창" aria-label="Search" autocomplete="off">
                        <button class="btn btn-outline-success" type="submit">검색</button>
                    </form>
                </div>
            </nav>
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
							<td class="text-center"><a href="/board/view/${board.bid}">${board.title}</a></td>
							<td class="text-center">${board.nickname}</td>
							<td class="text-center"><fmt:formatDate value="${board.postDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td class="text-center">${board.viewCount}</td>
							<td class="text-center">${board.recommendCount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br />
			<div class="pagination-container">
                <!-- 바뀐 부분: 페이징 번호 중앙 정렬 -->
                <div style="flex-grow: 1; text-align: center; font-size: 15	px;">
                    <c:if test="${page.prev}">
                        <span class="mr-3">
                            <a href="/board/list/${page.startPageNum-1}${page.searchTypeKeyword}">[이전]</a>
                        </span>
                    </c:if>
                    <c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
                    	<span class="mr-3">
                        	<c:if test="${select != num}"><a href="/board/list/${num}${page.searchTypeKeyword}">${num}</a></c:if>
                        	<c:if test="${select == num}"><b>${num}</b></c:if>
                        </span>
                    </c:forEach>
                    <c:if test="${page.next}">
                        <span class="mr-3">
                            <a href="/board/list/${page.endPageNum+1}${page.searchTypeKeyword}">[다음]</a>
                        </span>
                    </c:if>
                </div>
                <div class="write-button">
                    <button type="button" class="btn btn-primary" id="writeButton">글작성</button>
                </div>
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