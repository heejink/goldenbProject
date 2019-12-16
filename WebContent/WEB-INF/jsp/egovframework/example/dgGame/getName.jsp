<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
*{font-family: 'S-CoreDream-8Heavy';}

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
}

.layer .blank {
	display: inline-block;
	width: 0;
	height: 100%;
	vertical-align: middle
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
<title>도전 골든벨에 오신걸 환영합니다.</title>
<script type="text/javascript">
var user = "";

	function send() {
		user = $("#userName").val();
		if (user !== "") {
			document.nameForm.action = "dgcontroller/insertEmp.do";
			document.nameForm.submit();
		} else {
			alert("이름을 입력해주세요.")
		}
	}
</script>
</head>
<body>

	<div class="layer">
		<span class="content"><h1>🔔도전 골든벨!🔔</h1>
			<form name="nameForm" method="get">
				<input type="text" id="userName" name="userName" placeholder="이름을 입력해주세요." /></br> </br>
			<input type="button" class="btn" value="전송" onclick="send()" />
			</form> </span>
			 <span class="blank"></span>
	</div>


</body>
</html>
