<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<fieldset>
		<legend>로그인</legend>
		<form action="" method="post">
			ID:
			<input type="text" name="userid">
			<br>
			PW:
			<input type="password" name="userpw">
			<br>

			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onclick="location.href='/member/memberjoin';">
			<!-- memberLoginPOST(MemberVO, HttpSession) 호출 -->
		</form>
	</fieldset>
</body>
</html>