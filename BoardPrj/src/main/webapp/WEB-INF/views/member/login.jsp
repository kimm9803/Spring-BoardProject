<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<style>
  body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    background-color: gray;
  }
  .login-form {
    width: 500px;
    padding: 70px;
    border: 1px solid #d3d3d3;
    border-radius: 5px;
    background-color: white;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
</style>
</head>
<body>
<div class="login-form">
  <h2 class="text-center mb-4"><a href="/" class="text-decoration-none text-dark">Mini Board</a></h2>
  <form action="/member/login" method="post">
    <div class="mb-3">
      <label for="memberId" class="form-label">아이디</label>
      <input type="text" class="form-control" id="memberId" name="memberId">
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">비밀번호</label>
      <input type="password" class="form-control" id="password" name="password">
    </div>
    <div class="mb-3">
      <label for="memberType" class="form-label">회원 유형</label>
      <select class="form-select" id="memberType" name="memberType">
        <option value="ADMIN">관리자</option>
        <option value="GUEST">일반회원</option>
      </select>
    </div>
    <button type="submit" class="btn btn-primary w-100">로그인</button>
    <div class="d-flex justify-content-between">
        <button type="button" class="btn btn-link text-secondary" onclick="location.href='/member/register'">회원가입</button>
        <button type="button" class="btn btn-link text-secondary">아이디/비밀번호 찾기</button>
    </div>
  </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
