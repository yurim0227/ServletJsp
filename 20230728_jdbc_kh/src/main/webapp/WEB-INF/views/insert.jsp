<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/insert.do2" method="post">
		<table>
			<tr>
				<td>아디</td>
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