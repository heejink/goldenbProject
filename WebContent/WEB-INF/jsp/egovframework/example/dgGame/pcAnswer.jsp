<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%!String answer = "";%>
<%!String count = "";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도전 골든벨!</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="../js/egovframework/pcJs.js"></script>

<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);

* {
	font-family: 'Noto Sans KR', sans-serif;
}


#clickAnswer:hover {
	color: blue;
	font-weight: 700;
	
}
</style>

<script type="text/javascript">
	var answer = "";
	
	$(document).ready(function(){
		  $('[data-toggle="tooltip"]').tooltip();   
		});
	
	function markAnswer() {
		// pc 결과 컨트롤러 -> pc 정답자 결과 로 보내기
			document.answerForm.action = "../dgcontroller/updateMcAnswerAndEmpPass.do";
			document.answerForm.submit();
	}
	
</script>

</head>
<body>
<% System.out.println("pcAnswer.jsp>>> "+ count);%>
<form name="answerForm" method="get">
		<input type="hidden" id="mcAnswer" name="mcAnswer" value="what?" />
	<div style="text-align:center;margin-top:300px"> <!-- 한글 10자 size -->
		<p id="showEmp" style="font-size: 80px;" >총  ${count} 명이 답을 제출하셨습니다.</p><br>
		<p id="clickAnswer" style="font-size: 140px;" onclick="answerNum()" data-toggle="tooltip" title="클릭하세요!">과연 정답은??
		</p><br>
		<input type="hidden" id="qNum" value="${num}">
			<p id="answer" name="answer" class="site__title mega"
				style="width: 1100px; height: 200px; font-size: 200px;font-weight: 600; display:none;"></p>
	</div>
	</form>
	<div class=markAnswer style="text-align: center; margin-top: 100px">
		<button type="button" class="btn btn-danger" value=""
			onclick="markAnswer()" style="width: 250px; height: 100px;">
			<h1>채점하기</h1>
		</button>


	</div>
</body>
</html>