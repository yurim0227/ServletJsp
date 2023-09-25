<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 테스트</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
	<c:if test="${empty loginMember}">
		<form action="login" method="post">
			<label> ID : </label> <input type="text" name="memberId"> <br>
			<label>PWD : </label> <input type="password" name="memberPwd">
			<br>
			<button>로그인</button>
		</form>
	</c:if>
	<c:if test="${!empty loginMember}">
		<h3>${loginMember.memberName}님 환영합니다.</h3>
	</c:if>
	<br>
	<form action="join" method="post">
		<label> ID : </label> <input type="text" name="memberId"> <br>
		<label>PWD : </label> <input type="password" name="memberPwd"> <br>
		<label>이름 : </label> <input type="text" name="memberName">
		<br>
		<button>회원가입</button>
	</form>
	<c:forEach items="${listMember}" var="item">
		<table>
			<tr>
				<td>${item.memberId}</td>
				<td><button onclick="deleteMember('${item.memberId}')">회원탈퇴</button></td>
			</tr>
		</table>
	</c:forEach>
	<form action="update" method="post">
		<label> ID : </label> <input type="text" name="memberId">
		<br>
		<button>회원정보 수정</button>
	</form>
	<script>
	    function deleteMember(memberId) {
	    	$.ajax({
                type: "POST",
                url: "/test/list",
                data: { memberId: memberId },
                success: function(result) {
                	if(result < 1){
                		
                	} else{
                		alert("회원탈퇴 성공");
                	}
                }
            });
	    }
	</script>
</body>
</html>
