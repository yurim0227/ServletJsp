<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user get</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty userGet}">
			번호: ${userGet.userNo}
			<br>
			아이디: ${userGet.userId}
			<br>
			이름: ${userGet.userName}
			<br>
			번호: ${userGet.userAge}
		</c:when>
		<c:otherwise>
			<h2>정보가 없습니다.</h2>
		</c:otherwise>
	</c:choose>
</body>
</html>