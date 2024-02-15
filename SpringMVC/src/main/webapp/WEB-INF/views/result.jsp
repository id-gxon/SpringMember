<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
	<h3>결과: ${userid }</h3>
	<h3>결과: ${requestScope.userid }</h3>
	<h3>결과(param): ${param.userid }</h3>

	<hr>

	<h3>결과(vo): ${vo }</h3>
	<h3>결과(memberVO): ${memberVO }</h3>
	<h3>결과(memberVO): ${memberVO.userid }</h3>
	<%-- $ {requestScope } 정보 출력을 사용해서 이름을 모르는 객체 확인 --%>

	<hr>

	<h3>결과(model): ${vo }</h3>
	
	<hr>
	
	<h3>doC2 결과</h3>
	<h3>결과(memberVO): ${memberVO }</h3>
	<h3>결과(mvo): ${mvo }</h3>
</body>
</html>