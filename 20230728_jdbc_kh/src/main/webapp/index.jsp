<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보 조회(회원 번호 검색)</h2>
	<form action="<%=request.getContextPath() %>/selectUser">
		<input type="text" name=userNo placeholder="회원 번호 입력">
		<input type="submit" value="조회">
	</form>
</body>
</html>