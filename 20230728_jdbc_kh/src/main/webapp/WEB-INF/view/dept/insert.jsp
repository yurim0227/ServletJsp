<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/insert.do" method="post">
		<table>
			<tr>
				<td>학과 번호</td>
				<td><input type="text" name="departmentNo"></td>
			</tr>
			<tr>
				<td>학과 이름</td>
				<td><input type="text" name="departmentName"></td>
			</tr>
			<tr>
				<td>계열</td>
				<td><input type="text" name="category"></td>
			</tr>
			<tr>
				<td>뭐지</td>
				<td><input type="text" name="openYn"></td>
			</tr>
			<tr>
				<td>정원</td>
				<td><input type="text" name="capacity"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
	</form>
</body>
</html>