<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <div class="container">
    <a class="navbar-brand" href="#">Mini Board</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/board/list/1">게시판 목록</a>
        </li>
      </ul>
    </div>
    <ul class="navbar-nav" style="margin-left: auto;">
      <c:choose>
        <c:when test="${empty sessionScope.memberId}">
          <li class="nav-item">
            <a class="nav-link" href="/member/login" style="color: white;">로그인</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/member/register" style="color: white;">회원가입</a>
          </li>
        </c:when>
        <c:otherwise>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white;">
              ${sessionScope.nickname}님
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/member/modifyMember">회원정보 수정</a>
              <a class="dropdown-item" href="/member/logout">로그아웃</a>
              <a class="dropdown-item" href="/member/withdrawl">회원탈퇴</a>
            </div>
          </li>
        </c:otherwise>
      </c:choose>
    </ul>
  </div>
</nav>
