<%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 리스트</title>
</head>
<body>
	<h2>학생 리스트</h2>
	<%
	// JSP Tag - java문법
	String a = (String)request.getAttribute("aaa");
	String b = (String)request.getAttribute("bbb");
	int c = (/* Integer */int)request.getAttribute("ccc");
	List<StudentVo> volist = (List<StudentVo>)request.getAttribute("studentList");
	%>
	<%-- <%= a %>
	<%= b %>
	<%= c %>
	<%= volist %> --%>
	<table border="1">
		<tr>
			<td>학번</td>
			<td>이름</td>
			<td>입학일</td>
		</tr>
		<%
		for(int i=0; i<volist.size(); i++){
			StudentVo vo = volist.get(i);
		%>
		
		<tr>
			<td><%=vo.getStudentNo() %></td>
			<td><%=vo.getStudentName() %></td>
			<td><%=vo.getEntranceDate() %></td>
		</tr>
		
		<%
		}
		%>
	</table>
	
</body>
</html>