<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info</title>
</head>
<body>
	<h2>${memberVO.userid }님의 회원 정보</h2>
	id: ${memberVO.userid }
	<br>
	name: ${memberVO.username }
	<br>
	email: ${memberVO.useremail }
	<br>
	regdate: ${memberVO.regdate }
	<br>
	updatedate: ${memberVO.updatedate }
	<br>
	<!-- <a href="javascript:location.href='/member/main';">돌아가기</a> -->
	<a href="javascript:history.back();">돌아가기</a>
</body>
</html>