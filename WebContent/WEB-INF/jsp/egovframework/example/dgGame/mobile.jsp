<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("userName");
%>
<%!HttpSession hs = null;%>
<%!String session = "";%>
<%!String answer = "";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도전 골든벨 </title>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
* {
	font-family: 'S-CoreDream-8Heavy';
}

.layer {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	text-align: center;
}

.layer .content {
	display: inline-block;
	vertical-align: middle;
	width: 210vpx;
}

.layer .blank {
	display: inline-block;
	width: 0;
	height: 100%;
	vertical-align: middle;
}

@font-face {
	font-family: 'S-CoreDream-8Heavy';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-8Heavy.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

<script type="text/javascript">
	$(document).ready(
			function() {
				// 넘겨야 할 값 : 이름, 세션값, 제출한 답
				var user = $("#name").val();
				//console.log(user);
				var session = $("#session").val();
				//console.log(session);
				var input = document.getElementById("answer");
				document.getElementById("userName").innerHTML = user;

				$("button").click(
						function() {
							var answer = input.value;
							var ajson = {
								"empName" : user,
								"empSession" : session,
								"empAnswer" : answer
							}

							var data = JSON.stringify(ajson);
							// alert(data);

							$.ajax({
								type : 'POST',
								url : '../dgcontroller/updateEmpAnswer.do',
								data : ajson,
								dataType : 'text',
								cache : false,
								success : function(data) { // data는 서버로부터 전송받은 결과(JSON)
									// 정답 보내고  input text 비우기
									document.getElementById("answerForm").reset();
									
									if (data == 'success') {
										alert("답이 전송되었습니다.");
									} else if (data == 'fail') {
										alert("답이 전송에 실패하였습니다.");
									} else if (data == 'deny') {
										alert("답을 제출하실 수 없습니다.");
									}

								}, // success 끝

								error : function(request, status, error) {
									alert("code:" + request.status + "\n"
											+ "message:" + request.responseText
											+ "\n" + "error:" + error);
								} // error 끝

							}); // $.ajax 끝
						});

			})
</script>
</head>
<body>
	<%
		hs = request.getSession(true);
		name = (String) hs.getAttribute("name");
		if (name != null) {
	%>
	<div class="layer">
		<span class="content"><h1 id="userName"></h1> </br> 
		<form name="answerForm" id="answerForm">
		<input
			type="text" id="answer" name="answer" placeholder="답을 입력해주세요." /></br> </br>
			<button type="button" class="btn btn-primary btn-sm"
				style="margin: 3%" value="">전송</button></form> </span> <span class="blank"></span>
	</div>

	<input type="hidden" id="name" name="name" value=<%=name%> />
	<input type="hidden" id="session" name="session" value=<%=session%> />

	<%
		} else {
	%>

	<p>
	<h3>처음부터 이용해주세요</h3>
	</p>
	<br>
	<a href="../dgcontroller/getName.do">시작페이지로</a>
	<%
		}
	%>
</body>
</html>