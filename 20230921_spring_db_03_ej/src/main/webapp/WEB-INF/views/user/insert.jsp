<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		var msg = '${msg}';
		if(msg){
			alert(msg);
		}
	</script>
	<form action="${pageContext.request.contextPath}/user/insert" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="userAge"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
	</form>
</body>
</html>