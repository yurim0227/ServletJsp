<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax</title>
<script src="https://code.jquery.com/jquery-3.4.0.js"></script>
</head>
<body>
<!--
Q. 1. 텍스트 입력창과 바로 옆에 결과를 출력할 Span 태그를 준비한다.
 - 텍스트 입력 창의 ID 는 email
 - Span 태그의 ID는 result
-->
<!-- <input type="text" id="_____"><span id="______"></span> -->
<input type="text" id="email"><span id="result"></span>


<script>
/* 
Q. 2. 텍스트 입력창에는 사용자 입력을 감지하는 이벤트를 적용한다.
 - 입력 이벤트가 발생하면 , 현재까지 입력된 내용에 대하여 email 형식에 맞는지 검증한다.
*/
/*  $("#email").on("_________", function(){
	var email = $("#email").val();
	var regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(!regex.test(email)){ */
		/* 		
		Q. 3. email 형식에 맞지 않다면 span 태그에 "이메일 형식에 맞지 않습니다." 를 출력하고 return 한다.
		*/		
		/* $("#______").____("____");
		return;
	} */
	/* 
	 Q. 4. 만약 email 형식에 맞는다면, Controller의 CheckEmail Method 으로 {email : "입력값"} 을 비동기 전송한다.
 	*/	 
	/* $.ajax({
		url:"___________________",
		data:{email: $("#______").___()},
		success:function(resp){ */
			/* 
			Q. 10. 서버로 보낸 비동기 요청에 따른 응답이 돌아오면 그 결과값을 span 태그에 출력한다.
		 	*/
			/* $("#______").____(____);
		}
	});
}); */
 $("#email").on("input", function(){
		var email = $("#email").val();
		var regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if(!regex.test(email)){
			$("#result").html("이메일 형식에 맞지 않습니다.");
			return;
		}
		$.ajax({
			url:"${pageContext.request.contextPath}/CheckEmail",
			data:{email: $("#email").val()},
			success:function(resp){
				$("#result").html(resp);
			}
		});
	});

</script>
</body>
</html>