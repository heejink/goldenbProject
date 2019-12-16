<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도전 골든벨!</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="js/egovframework/pcJs.js"></script>
<!-- 
<script src="../js/egovframework/pcJs.js"></script>
 -->
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);

* {
	font-family: 'Noto Sans KR', sans-serif;
}

button.btn.btn-primary.dropdown-toggle{
	height: 100px;
	width: 200px;
	font-size: 35px;
}
</style>
<script type="text/javascript">
function questionNum2(num) {
	if (num == 1){
		document.getElementById("quiz").value = list.qa1.question;
		$("#goC").attr("href", "dgcontroller/goPcAnswerPage.do?num=1");
	}
	if (num == 2){
		document.getElementById("quiz").value = list.qa2.question;
		$("#goC").attr("href", "/dgcontroller/goPcAnswerPage.do?num=2");
	}
	if (num == 3){
		document.getElementById("quiz").value = list.qa3.question;
		$("#goC").attr("href", "/dgcontroller/goPcAnswerPage.do?num=3");
	}
	
}

</script>

</head>
<body>
	<main style="text-align:center;margin-top:300px"> 
		<div class="dropdown">
			<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">문제 번호</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" onclick="questionNum2(1)">문제 1번</a>
				<a class="dropdown-item" onclick="questionNum2(2)">문제 2번</a>
				<a class="dropdown-item" onclick="questionNum2(3)">문제 3번</a>
				<a class="dropdown-item" onclick="questionNum2(4)">문제 4번</a>
				<a class="dropdown-item" onclick="questionNum2(5)">문제 5번</a>
				<a class="dropdown-item" onclick="questionNum2(6)">문제 6번</a>
				<a class="dropdown-item" onclick="questionNum2(7)">문제 7번</a>
				<a class="dropdown-item" onclick="questionNum2(8)">문제 8번</a>
				<a class="dropdown-item" onclick="questionNum2(9)">문제 9번</a>
				<a class="dropdown-item" onclick="questionNum2(10)">문제 10번</a>
				<a class="dropdown-item" onclick="questionNum2(11)">문제 11번</a>
				<a class="dropdown-item" onclick="questionNum2(12)">문제 12번</a>
				<a class="dropdown-item" onclick="questionNum2(13)">문제 13번</a>
				<a class="dropdown-item" onclick="questionNum2(14)">문제 14번</a>
				<a class="dropdown-item" onclick="questionNum2(15)">문제 15번</a>
				<a class="dropdown-item" onclick="questionNum2(16)">문제 16번</a>
				<a class="dropdown-item" onclick="questionNum2(17)">문제 17번</a>
				<a class="dropdown-item" onclick="questionNum2(18)">문제 18번</a>
				<a class="dropdown-item" onclick="questionNum2(19)">문제 19번</a>
				<a class="dropdown-item" onclick="questionNum2(20)">문제 20번</a>
				<a class="dropdown-item" onclick="questionNum2(21)">문제 21번</a>
			</div>
		</div>
		<div><h1> <br></h1></div>
		<input class="quiz" id="quiz" style="width: 1800px; height: 200px;font-weight: 600; font-size: 120px; text-align: center;">
	</main>
	<div class=finish style="text-align: center; margin-top: 150px">

		<a id="goC" href="">
			<button type="button" class="btn btn-danger"
				style="width: 250px; height: 100px;">
				<h1>마감하기</h1>
			</button>
		</a> 
	</div>

</body>
</html>