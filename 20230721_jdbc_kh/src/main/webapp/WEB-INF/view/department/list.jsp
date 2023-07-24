<%@page import="java.util.List"%>
<%@page import="kh.test.jdbckh.department.model.vo.DepartmentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 리스트</title>
</head>
<body>
<h2>학과 리스트</h2>
	<%
	// JSP Tag - java문법
	String a = (String)request.getAttribute("aaa");
	String b = (String)request.getAttribute("bbb");
	int c = (int)request.getAttribute("ccc");
	List<DepartmentVo> volist = (List<DepartmentVo>)request.getAttribute("departmentList");
	%>
	<%-- <%= a %>
	<%= b %>
	<%= c %>
	<%= volist %> --%>
	<table border="1">
		<tr>
			<td>학과 번호</td>
			<td>학과 이름</td>
			<td>카테고리</td>
			<td>개설 여부</td>
			<td>정원</td>
		</tr>
		<%
		for(int i=0; i<volist.size(); i++){
			DepartmentVo vo = volist.get(i);
		%>
		
		<tr>
			<td><a href="<%=request.getContextPath()%>/department/get?sno=<%=vo.getDepartmentNo() %>"><%=vo.getDepartmentNo() %></td>
			<td><%=vo.getDepartmentName() %></td>
			<td><%=vo.getCategory() %></td>
			<td><%=vo.getOpenYn() %></td>
			<td><%=vo.getCapacity() %></td>
		</tr>
		
		<%
		}
		%>
	</table>
	
</body>
</html>