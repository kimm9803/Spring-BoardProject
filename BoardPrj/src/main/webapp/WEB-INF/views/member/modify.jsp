<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
  body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    background-color: gray;
  }
  .modify-form {
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
<div class="modify-form">
  <h2 class="text-center mb-4"><a href="/" class="text-decoration-none text-dark">Mini Board</a></h2>
  <form action="/member/modifyMember" method="post">
    <div class="mb-3">
      <label for="memberId" class="form-label">아이디</label>
      <input type="text" class="form-control" id="memberId" name="memberId" value="${member.memberId}" readonly>
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">비밀번호</label>
      <input type="password" class="form-control" id="password" name="password" value="${member.password}">
    </div>
    <div class="mb-3">
      <label for="nickname" class="form-label">닉네임</label>
      <div class="input-group">
        <input type="text" class="form-control" id="nickname" name="nickname" value="${member.nickname}">
        <button type="button" class="btn btn-secondary" onclick="checkNickname()">중복 확인</button>
      </div>
      <span id="nicknameCheckResult" class="form-text"></span>
    </div>
    <button type="submit" class="btn btn-primary w-100">정보 수정</button>
  </form>
</div>
<script>
function checkNickname() {
    var nickname = document.getElementById("nickname").value;

    // Ajax 요청
    $.ajax({
        type: "GET",
        url: "/member/checkNickname",
        data: { nickname: nickname },
        success: function(result) {
            if (result === "true") {
                document.getElementById("nicknameCheckResult").innerHTML = "<span style='color: green;'>사용 가능한 닉네임입니다.</span>";
            } else if (result == "null"){
            	document.getElementById("nicknameCheckResult").innerHTML = "<span style='color: red;'>닉네임을 입력해주세요.</span>";
            } else {
            	document.getElementById("nicknameCheckResult").innerHTML = "<span style='color: red;'>중복된 닉네임입니다.</span>";
            }
        }
    });
}
</script>
</body>
</html>
