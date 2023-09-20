<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user list</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/get">
		<input type="text" name="userId">
		<br>
		<input type="submit" value="검색">
	</form>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>이름</td>
			<td>나이</td>
		</tr>
		<c:forEach items="${userList}" var="item">
			<tr>
				<td>${item.userNo}</td>
				<td>${item.userId}</td>
				<td>${item.userName}</td>
				<td>${item.userAge}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>