<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h2>회원 가입</h2>
	<form action="/member/register" method="post">
		<label>아이디: <input type="text" name="memberId" id="memberId"></label>
		<button type="button" onclick="checkMemberId()">중복 확인</button>
		<span id="idCheckResult"></span><br> 
		<label>비밀번호: <input type="password" name="password"></label><br>
		<label>닉네임: <input type="text" name="nickname" id="nickname"></label>
		<button type="button" onclick="checkNickname()">중복 확인</button>
		<span id="nicknameCheckResult"></span><br>
		</label><br> <label>회원 유형: <select name="memberType">
				<option value="ADMIN">관리자</option>
				<option value="GUEST">일반회원</option>
		</select>
		</label><br> <input type="submit" value="회원가입">
	</form>
<script>
function checkMemberId() {
    var memberId = document.getElementById("memberId").value;

    // Ajax 요청
    $.ajax({
        type: "GET",
        url: "/member/checkMemberId",
        data: { memberId: memberId },
        success: function(result) {
            if (result === "true") {
                document.getElementById("idCheckResult").innerHTML = "사용 가능한 아이디입니다.";
            } else {
                document.getElementById("idCheckResult").innerHTML = "중복된 아이디입니다.";
            }
        }
    });
}

function checkNickname() {
    var nickname = document.getElementById("nickname").value;

    // Ajax 요청
    $.ajax({
        type: "GET",
        url: "/member/checkNickname",
        data: { nickname: nickname },
        success: function(result) {
            if (result === "true") {
                document.getElementById("nicknameCheckResult").innerHTML = "사용 가능한 닉네임입니다.";
            } else {
                document.getElementById("nicknameCheckResult").innerHTML = "중복된 닉네임입니다.";
            }
        }
    });
}
</script>
</body>
</html>