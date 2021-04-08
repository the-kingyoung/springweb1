<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/> 
<fmt:requestEncoding value="UTF-8" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<link href='${path}/a00_com/lib/main.css' rel='stylesheet' />
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}
#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
<link href='https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.css' rel='stylesheet' />
<link href='https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.13.1/css/all.css' rel='stylesheet'>
<style>
input[type=text], select, label, textarea{
	margin-bottom: 12px; padding: .4em; width: 95%;}
.input-group-text{width: 100%; text-align: center; background-color: linen;color:black; font-weight:bolder;}
.input-group-prepend{width: 35%;}
</style>
<script src='${path}/a00_com/lib/main.js'></script>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">

// 전역변수로 날짜 데이터 가져오기 위해 선언.
var date = {};

// 전체 DOM에 로딩되었을 때, jquery $(document).ready(); 와 동일
document.addEventListener('DOMContentLoaded', function() {
	var opts={
		autoOpen: false, // 초기에 로딩하지 않게 처리
		width: "350px",
		modal: true    
	};

	$( "#schDialog" ).dialog(opts);

	var calendarEl = document.getElementById('calendar');
		// new FullCalendar.Calendar(대상 DOM객체,{속성:속성값,속성2:속성값2...})
		// # calendar의 new FullCalendar.Calendar()를 통해서 화면에
		// 나타날 객체를 참조변수로 가지고 있고..
		//alert(new Date().toISOString());
	var calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar: {
			left: 'prevYear prev today next nextYear',
			center: 'title',
			right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
		},
		themeSystem: 'bootstrap',
		initialDate: new Date().toISOString(), // 초기 로딩 날짜(현재날짜).
		navLinks: true, // can click day/week names to navigate views
		selectable: true,
		selectMirror: true,
		select: function(arg) {
			// 등록시, 기존 내용 로딩을 방지 처리, 초기화 처리.  
			$("#schDialog>form")[0].reset();
			date.start = arg.start;
			date.end = arg.end; 
			opts.buttons = {
				"등록" : function(){
					var sch = callSch(); // 리턴값이 입력된 객체데이터
					/* 데이터 확인 */
					console.log("##등록할 데이터 확인 ##");
					console.log(sch);
					// 화면에 출력..
					if(sch.title){
						// 화면에 처리할 이벤트 할당
						calendar.addEvent(sch);
						calendar.unselect();
					}
					// ajax 처리. (DB 등록)
					$.ajax({
						type: "post",
						url: "${path}/calendar.do?method=insert",
						data: sch, // 요청값을 json객체로 전달 가능
						dataType: "json",
						success:function(data){
						// data.모델명
							if(data.success=="Y"){
								alert("등록 성공");
							}
						},
						error:function(err){
						alert("에러발생");
						console.log(err);
						}
					});
					$( "#schDialog" ).dialog("close");
				}     
			};
			
			// 화면에 보이는 형식 설정.
			// 클릭한 날짜를 전역변수(date)에 할당 / 시작일과 마지막을 date형식으로 할당
			$("[name=start]").val(arg.start.toLocaleString());
			$("[name=end]").val(arg.end.toLocaleString());
			//화면에 보이는 날짜는 한국 표현식으로 처리..
			$("[name=start]").val(arg.start.toLocaleString());
			$("[name=end]").val(arg.end.toLocaleString());			
			// #ccffff #0099cc #0099cc
			// all.Day는 boolean값이기에 select의 선택형식에 맞게
			// 처리하려면 ""+형식으로 문자열 처리가 필요하다
			$("[name=allDay]").val("" + arg.allDay);
			// 등록버튼이 있는 dialog옵션 설정
			$( "#schDialog" ).dialog(opts);
			// 
			$( "#schDialog" ).dialog("open");
		},
		eventDrop:function(arg){
			//alert("이벤트 드랍");
			//console.log("# 이벤트 드랍 #");
			//console.log(arg.event);
			//var sch = arg.event;
			//sch.start = arg.event.start.toISOString();
			//sch.end = arg.event.end.toISOString();
			//console.log("## 드랍 수정할 데이터 ##");
			//console.log(sch);
			//updateCall(sch);
			eventUpt(arg.event);
		},
		eventResize:function(arg){
			//alert("이벤트 날짜 크기 수정");
			//console.log("# 이벤트 날짜 크기 수정 #");
			//console.log(arg.event);
			//var sch = arg.event;
			//sch.start = arg.event.start.toISOString();
			//sch.end = arg.event.end.toISOString();
			//console.log("## 리사이즈 수정할 데이터 ##");
			//console.log(sch);
			//updateCall(sch);
			eventUpt(arg.event);
		},
		eventClick: function(arg) {
			// 있는 일정을 클릭시,
			// 상세 화면 보이기(등록되어 있는 데이터 출력)
			// ajax를 통해서 수정/삭제
			// 삭제1 : 화면에서 삭제
			/* event의 날짜 저장 */
			date.start = arg.event.start;
			date.end = arg.event.end;
			/* 각 form에 값 추가 */
			// 1. 화면로딩..
			detail(arg.event);
			// 2. 기능별 버튼에 대한 처리.
			opts.buttons = {
				"수정": function(){
					// 수정 후, json 데이터 가져오기
					// 화면에 form 하위에 있는 요소객체의 값을 가져오는 부분
					var sch = callSch();
					console.log("#수정할 값");
					console.log(sch);
                
					/* 1. 화면단 변경. */
 					/* 현재 캘린더 api의 속성 변경하기 */
					var event = calendar.getEventById( sch.id );
					// 속성값 변경 setProp
					event.setProp("title", sch.title);
					event.setProp("textColor", sch.textColor);
					event.setProp("backgroundColor", sch.backgroundColor);
					event.setProp("borderColor", sch.borderColor);
					// 확장 속성 : writer, content
					event.setExtendedProp("writer", sch.writer);
					event.setExtendedProp("content", sch.content);
					event.setAllDay(sch.allDay);
					// 2. DB 변경.
                
					updateCall(sch);
					// 수정 처리 확인
					$("#schDialog").dialog("close");
				},
				"삭제": function(){
					var idVal = $("[name=id]").val();
					// 화면에서 삭제 처리
					var event = calendar.getEventById( idVal );
					event.remove();
					// DB 삭제 처리
					$.ajax({
						type:"post",
						url:"calendar.do?method=delete",
						data:{id:idVal},
						dataType:"json",
						success:function(data){
							if(data.success == "Y"){
								alert("삭제 성공");
							}
						},
						error:function(err){
							alert("에러 발생");
							console.log(err);
						}
					});
					$("#schDialog").dialog("close");
				}
			}
          
			$("#schDialog").dialog(opts);
			$("#schDialog").dialog("open");
		},
		editable: true,
		dayMaxEvents: true, // allow "more" link when too many events
		events:function(info, successCallback, failureCallback){
		// ajax 처리로 데이터를 로딩 시킨다.
		// 화면에 나타날 일정들을 ajax를 통해서 호출하고,
		// success:function 함수를 통해서 서버에서 받은 데이터를 가져오고,
		// successCallback이라는 매개변수를 받은 함수에 일정 내용을 전달하면
		// 전체 화면에서 일정이 반영된다.
			$.ajax({
				type:"get",
				url:"${path}/calendar.do?method=data",
				dataType:"json",
				success:function(data){
					console.log(data.list);
					successCallback(data.list);
				},
				error:function(err){
					console.log(err);
				}
			});
		} 
	});

	calendar.render();
});
//form 하위 요소객체에서 사용할 데이터를 json 형식을 만들어 준다.
	function callSch(){
		var sch = {};
		sch.id = $("[name=id]").val();
		sch.title = $("[name=title]").val();
		sch.writer = $("[name=writer]").val();
		sch.content = $("[name=content]").val();
		/* Date타입은 화면에서 사용되는 형식으로 설정해야 한다.
			전역변수에 할당한 date.start//date.end의 ISO형태로 속성 할당.
			
			?? calendar api에서 사용되는 날짜 처리 방식이 ISO문자열 형식이기
			때문이다.		ex) Date ==> toISOString() 형식
		*/
		sch.start = date.start.toISOString();
		sch.end = date.end.toISOString();
		//alert("등록할 시작일:"+sch.start);
		// sch.allDay : calendar로 처리할 데이터 boolean형식으로 true/false
		// 으로 처리되어야 하는데, 화면에 보이는 내용은 문자열로 되어 있다.
		// option value="true" 가 선택되었을 때는 == 비교연산을 통해서
		// true로 boolean값을 넘기고 그외는 flase를 boolean 값으로 전달.
		sch.allDay = $("[name=allDay]").val()=="true";
		// 문자열 "true"일때 할당. 그외는 false
		sch.textColor = $("[name=textColor]").val();
		sch.backgroundColor = $("[name=backgroundColor]").val(); // 배경색상
		sch.borderColor = $("[name=borderColor]").val();

		return sch;
	}
   
	function detail(event){
		// event 안에 기본 속성값이 초기에 데이터 로딩시, 가지고 있음.
		// form 하위 객체에 할당
		$("[name=id]").val(event.id);
		$("[name=title]").val(event.title);
		// calendar에서 추가된 속성들..
		/*
		ex) event.extendedProps
		calendar api 자체에서 지원되는 기본적인 속성이 아니고,
		사용자에 의해서 DB 관리가 필요한 속성을 처리할 때, 사용된다.
		*/
		var exProps = event.extendedProps;
		$("[name=writer]").val(exProps.writer);
		$("[name=content]").val(exProps.content);
		$("[name=start]").val(event.start.toLocaleString());
		$("[name=end]").val(event.end.toLocaleString());
		$("[name=allDay]").val("" + event.allDay);

		$("[name=textColor]").val(event.textColor);
		$("[name=backgroundColor]").val(event.backgroundColor);
		$("[name=borderColor]").val(event.borderColor);
	}
	// 수정 처리 ajax
	function updateCall(sch){
		// callSch() 입력된 수정된 데이터를 요청값으로 전달
		$.ajax({
			type:"post",
			url:"calendar.do?method=update",
			data:sch,
			dataType: "json",
			success:function(data){
				if(data.success=="Y"){
					console.log("성공");
					alert("수정완료");
				}else{
					console.log("실패");
				}
			},
			error:function(err){
				alert("에러발생:"+err);
				console.log(err);
			}
		});
	}
	function eventUpt(event){
		var sch={};
		sch.id=event.id;
		sch.title=event.title;
		sch.start=event.start.toISOString();
		sch.end=event.end.toISOString();
		sch.content=event.extendedProps.content;
		sch.textColor=event.textColor;
		sch.backgroundColor=event.backgroundColor;
		sch.borderColor=event.borderColor;
		sch.allDay=event.allDay;
		console.log("# 이벤트에 의한 수정 #");
		console.log(sch);
		updateCall(sch);
	}
</script>
</head>
<body>
<div id='calendar'></div>
<div id="schDialog" title="일정">
	<form id="frm">
		<input name="id" type="hidden" value="0"/>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">제목</span>
			</div>
			<input class="form-control" name="title" type="text"/>
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">작성자</span>
			</div>
			<input class="form-control" name="writer" type="text"/>
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">내용</span>
			</div>
			<textarea class="form-control" name="content" rows="5" cols="20"></textarea>
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">종일여부</span>
			</div>
			<select name="allDay" class="form-control">
				<option value="true"> 종 일 </option>
				<option value="false"> 시 간 </option>
			</select>
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">시작일</span>
			</div>
			<input class="form-control" name="start" type="text"/>
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">종료일</span>
			</div>
			<input class="form-control" name="end" type="text"/>
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">배경색상</span>
			</div>
			<input name="backgroundColor" class="form-control" type="color" value="#0099cc"/>
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">보더색상</span>
			</div>
			<input name="borderColor" class="form-control" type="color" value="#0099cc"/>
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">글자색상</span>
			</div>
			<input name="textColor" class="form-control" type="color" value="#ccffff"/>
		</div>
	</form>
</div>
</body>
</html>