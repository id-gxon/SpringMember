<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
	<fieldset>
		<legend>회원정보 수정</legend>
		<form action="" method="post">
			id:
			<input type="text" name="userid" value="${memberVO.userid }" readonly="readonly">
			<br>
			pw:
			<input type="password" name="userpw" placeholder="비밀번호를 입력해주세요." required="required" autofocus="autofocus">
			<br>
			name:
			<input type="text" name="username" value="${memberVO.username }">
			<br>
			email:
			<input type="email" name="useremail" value="${memberVO.useremail }">
			<br>

			<input type="submit" value="수정하기">
			<a href="javascript:location.href='/member/main';">돌아가기</a>
		</form>
	</fieldset>
</body>
</html>