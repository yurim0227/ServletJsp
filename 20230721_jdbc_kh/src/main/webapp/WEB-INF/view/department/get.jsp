<%@page import="kh.test.jdbckh.department.model.vo.DepartmentVo"%>
<%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 상세 정보</title>
</head>
<body>
	<h1>학과 상세 정보</h1>
	<%-- <%=request.getAttribute("svo") %> --%>
	<%
	DepartmentVo vo = null;
	if(request.getAttribute("svo") instanceof DepartmentVo){
		vo = (DepartmentVo)request.getAttribute("svo");
	}
	%>
	<table border="1">
		<tr>
			<td>소속학과번호</td>
			<td><%=vo.getDepartmentNo() %></td>
		</tr>
		<tr>
			<td>소속학과이름</td>
			<td><%=vo.getDepartmentName() %></td>
		</tr>
		<tr>
			<td>소속계열</td>
			<td><%=vo.getCategory() %></td>
		</tr>
		<tr>
			<td>개설여부</td>
			<td><%=vo.getOpenYn() %></td>
		</tr>
	</table>
	
</body>
</html>