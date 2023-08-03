<%@page import="kh.test.jdbckh.department.model.dto.DepartmentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 정보</title>
</head>
<body>
	<%DepartmentDto dto = null;
	if(request.getAttribute("dto") instanceof DepartmentDto){
		dto = (DepartmentDto)request.getAttribute("dto");
	} %>
	<h2>학과 정보</h2>
	<%if(dto != null) { %>
		<h4><%=dto.getDepartmentNo() %></h4>
		학과이름 : <%=dto.getDepartmentName() %>
		<br>
		계열 : <%=dto.getCategory() %>
		<br>
		개설여부 : <%=dto.getOpenYn() %>
		<br>
		정원 : <%=dto.getCapacity() %>
		<br>
	<%} else { %>
		<h2>찾는 학과 정보가 없습니다.</h2>
	<%} %>
	<a href="<%=request.getContextPath() %>/dept/list">다시 찾기</a>
</body>
</html>