<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itwill</title>
</head>
<body>
	<!-- ModelAttribute로 전달된 정보를 EL 표현식을 사용하여 출력 -->
	<h3>전달된 정보(msg): ${msg }</h3>
	<h3>전달된 정보(msg): ${pageScope.msg }</h3>
	<h3>전달된 정보(msg): ${requestScope.msg }</h3>
	<h3>전달된 정보(msg): ${sessionScope.msg }</h3>
	<h3>전달된 정보(msg): ${applicationScope.msg }</h3>

	<hr>
	<h2>@ModelAttribute</h2>
	<h3>전달된 정보(msg): ${msg }</h3>
	<h3>전달된 정보(tel): ${tel }</h3>

	<hr>

	<h2>@RequestParam</h2>
	<h3>전달된 정보(param.msg): ${param.msg }</h3>
	<h3>전달된 정보 (param.tel) : ${param.tel }</h3>
	<h3>전달된 정보(param.tel[0]): ${paramValues.tel[0] }</h3>
	<h3>전달된 정보(param.tel[1]): ${paramValues.tel[1] }</h3>
</body>
</html>