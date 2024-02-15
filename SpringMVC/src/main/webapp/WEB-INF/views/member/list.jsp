<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>userid</th>
			<th>uesrpw</th>
			<th>username</th>
			<th>useremail</th>
			<th>regdate</th>
			<th>updatedate</th>
		</tr>
		<c:forEach var="list" items="${memberVOList }">
			<tr>
				<td>${list.userid }</td>
				<td>${list.userpw }</td>
				<td>${list.username }</td>
				<td>${list.useremail }</td>
				<td>${list.regdate }</td>
				<td>${list.updatedate }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/member/main">돌아가기</a>
</body>
</html>