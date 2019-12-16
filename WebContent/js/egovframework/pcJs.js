// 문제와 답 리스트
var list = { qa1 : { question : "한글을 창제한 조선시대 왕은?",
					 answer : "세종대왕"},
			 qa2 : { question : "올포랜드가 위치한 건물 이름은?",
				 	 answer : "에이스 하이엔드 3차"},
			 qa3 : { question : "겨울왕국1에 나오는 눈사람 이름은?",
				 	 answer : "올라프"}
			};

// 문제 리스트와 함께 함수 업데이트 예정
function questionNum(num) {
	if (num == 1){
		document.getElementById("quiz").value = list.qa1.question;
		$("#goC").attr("href", "../dgcontroller/goPcAnswerPage.do?num=1");
	}
	if (num == 2){
		document.getElementById("quiz").value = list.qa2.question;
		$("#goC").attr("href", "../dgcontroller/goPcAnswerPage.do?num=2");
	}
	if (num == 3){
		document.getElementById("quiz").value = list.qa3.question;
		$("#goC").attr("href", "../dgcontroller/goPcAnswerPage.do?num=3");
	}
	
}

// 문제 리스트와 함께 함수 업데이트 예정
function answerNum() {
	var num = $("#qNum").val();

	$('#showEmp').css('display','none');
	$('#clickAnswer').css('display','none');
	$('#answer').fadeIn(2000);
	$('#answer').css('display','inline');
	
	
	if (num == 1){
		document.getElementById("answer").innerHTML = list.qa1.answer;
		document.getElementById("mcAnswer").value = list.qa1.answer;
	}
	if (num == 2){
		document.getElementById("answer").innerHTML = list.qa2.answer;
		document.getElementById("mcAnswer").value = list.qa2.answer;
	}
	if (num == 3){
		document.getElementById("answer").innerHTML = list.qa3.answer;
		document.getElementById("mcAnswer").value = list.qa3.answer;
	}
}

