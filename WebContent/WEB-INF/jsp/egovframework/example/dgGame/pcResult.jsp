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
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);

* {
	font-family: 'Noto Sans KR', sans-serif;
}

table {
	width: 100%;
	height: 100%;
	float: left;
}

.reset, .next {
	margin-bottom: 30px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		console.log("start");
		$(".tbs").css("height", $(window).height() + "px");

	}); // $(document).ready() 끝

	function reset() {
		alert("문제를 리셋하시겠습니까?");
		
		$.ajax({
			type : 'POST',
			url : '../dgcontroller/updateReset.do',
			dataType : 'text', 
			cache : false,
			success : function(data) {
				console.log(data);
				if (data == 'success') {
					alert("문제가 리셋되었습니다.");
				} else if (data == 'fail') {
					alert("리셋을 실패하였습니다.");
				}
				
			},
			error : function(request, status, error) {
				alert("code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:" + error);
			}
		}) // $.ajax 끝
	} // function reset() 끝
</script>

</head>
<body>
	<div id="empList">

		<table class="table table-borderless" style="text-align: center;">
			<tr>
				<th colspan="2"><span style="font-size: 80px;">🏆정답자🥇</span></th>
			</tr>
			<tr>
				<th><span style="font-size: 50px; margin-left: 40px">이름</span></th>
				<th><span style="font-size: 50px; margin-left: 40px">제출답안</span></th>
			</tr>
			<tr>
				<td class="tbs" width="50%"><c:if test="${empty empPassYlist}">
						<h1>정답자가 없습니다.</h1>
					</c:if> <c:forEach items="${empPassYlist}" var="row">
						<span style="font-size: 50px; margin: 5px">${row.empName}</span><br>
					</c:forEach></td>

				<td class="tbs"><c:if test="${empty empPassYlist}">
						<h1>제출답안이 없습니다.</h1>
					</c:if> <c:forEach items="${empPassYlist}" var="row">
						<span style="font-size: 50px; margin: 5px">${row.empAnswer}</span><br>
					</c:forEach></td>
			</tr>

		</table>
	</div>

	<div class=buttons>
		<div class=reset style="float: left; text-align:left; margin-left: 20px;">
			<button type="button" class="btn btn-outline-danger" onclick="reset()">
				<h1>재시작</h1>
			</button>
		</div>
		<div class=next style="float: right; text-align: right; margin-right: 20px;">
			<a href="../dgcontroller/goPcQuizPage.do">
			<button type="button" class="btn btn-outline-secondary">
				<h1>다음</h1>
			</button>
			</a>
		</div>
	</div>
	
	<!-- 		
	<div style="float: right; text-align: right; margin-right: 20px;">
		<a href="../controller/goPcQuizPage.do">
			<button type="button" class="btn btn-outline-secondary">
				<h1>다음</h1>
			</button>
		</a>
	</div>
	<div class=add style="float:right;text-align: right; margin-right: 20px;">
			<button type="button" class="btn btn-outline-warning"
				value="추가" onclick="addEmp()"><h1>추가</h1></button>
		</div> -->
</body>
</html>