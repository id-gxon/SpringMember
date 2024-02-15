<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
</head>
<body>
	<fieldset>
		<legend>회원정보 삭제</legend>
		<form action="" method="post">
			<input type="hidden" name="userid" value="${sessionScope.id }">
			<input type="password" name="userpw" placeholder="비밀번호를 입력해주세요." required="required" autofocus="autofocus">

			<br>
			<input type="submit" value="삭제하기">
			<a href="/member/main">돌아가기</a>
		</form>
	</fieldset>
</body>
</html>