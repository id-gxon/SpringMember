<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberjoin</title>
</head>
<body>
	<fieldset>
		<legend>회원가입</legend>
		<!-- <form action="./memberJoinAction" method="post" -->
		<!-- <form action="/member/memberJoinAction" method="post" -->
		<!-- action 속성 값이 없는 경우 자기 자신의 주소를 호출 -->
		<form action="" method="post">
			아이디:
			<input type="text" name="userid">
			<br>

			비밀번호:
			<input type="password" name="userpw">
			<br>

			이름:
			<input type="text" name="username">
			<br>

			이메일:
			<input type="email" name="useremail">
			<br>

			<input type="submit" value="회원가입">
		</form>
	</fieldset>
</body>
</html>