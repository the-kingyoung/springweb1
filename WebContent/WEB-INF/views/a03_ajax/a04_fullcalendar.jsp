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
<link href='https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.css' rel='stylesheet' />
<link href='https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.13.1/css/all.css' rel='stylesheet'>
<link href='${path}/a00_com/lib/main.css' rel='stylesheet' />
<script src='${path}/a00_com/lib/main.js'></script>
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
  #schDialog label { width:90px!important; }
  
</style>

<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<style>
	input[type=text], select, label, textarea{
	  	margin-bottom:12px; 
	  	padding:.4em;
	  	width:95%;
  	}
  	.input-group-text{
  		width:100%;
  		text-align:center;
  		background-color:linen;
  		color:black;
  		font-weight:bolder;
  	}
  	.input-group-prepend{
  		width:35%;
  	}
</style>
<script type="text/javascript">
<%--
 
 
--%>
// 전역변수로 날짜 데이터 가져오기 위한 선언 
var date = {};

// document.addEventListener("DOMContentLoaded")
// 전체 DOM에 로딩되었을 때, jquery $(document).ready(); 와 동일 
 document.addEventListener('DOMContentLoaded', function() {
	 var opts = {
			 autoOpen:false,
			 width:"350px",
			 modal:true
	 }
 	 $( "#schDialog" ).dialog(opts);
	 
	 
    var calendarEl = document.getElementById('calendar');
	// new FullCalendar.Calendar(대상 DOM객체, 
	//						{속성:속성값,속성2:속성값2...}) 
    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prevYear prev today next nextYear',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek',
        themeSystem: 'bootstrap'
      },
	  
      initialDate: new Date().toIOString, // 초기 로딩 날짜. (현재날짜)
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      // 이벤트명: function(){} : 각 날짜에 대한 이벤트를 통해 처리할 내용
      select: function(arg) {
    	  // 등록시 기존 내용 로딩을 방지 처리, 초기화 처리
    	 $("#schDialog>form")[0].reset();
    	  
    	// 화면에 보이는 형식 설정
  		// 클릭한 날짜를 전역변수에 할당/시작일과 마지막일을 date형식으로 할당 
  		date.start = arg.start;
  		date.end = arg.end; 
  		
		console.log(arg); // console을 통해서 해당 속성 확인 
		
		opts.buttons={
			"등록":function(){
		//		alert("등록 처리합니다!");
				var sch = callSch(); // 리턴값이 입력된 객체데이터 
				console.log("등록할 데이터");
				console.log(sch);
				// 화면에 출력 
				if(sch.title){
					// 화면에 처리할 이벤트 할당 
					calendar.addEvent(sch);
					calendar.unselect();
				}
				// ajax 처리 (DB 등록)
				$.ajax({
					type:"post",
					url:"${path}/calendar.do?method=insert",
					dataType:"json",
					data:sch, // 요청값을 json객체로 전달 가능 
					success:function(data){
						// data.모델명
						if(data.success=="Y"){
							alert("등록성공");
						}	
					},
					error:function(err){
						console.log(err);
					}
				});
				$("#schDialog").dialog("close");
			}
		};
		$("#schDialog").dialog(opts);
		$("#schDialog").dialog("open");
		// $("#btn01").click(); // 부트스트랩 폼 
	  //	alert("시작일: "+arg.start.toISOString());
		
		$("[name=start]").val(arg.start.toLocaleString());
		$("[name=end]").val(arg.end.toLocaleString());
		$("[name=allDay]").val(""+arg.allDay);
		$("#schDialog").dialog(opts);
		$("#schDialog").dialog("open");
      },
      eventDrop:function(arg){
    	  // alert("이벤트 드랍");
    	  console.log("###이벤트 드랍###");
    	  console.log(arg.event);
    	  var sch = arg.event;
    	  sch.start = arg.event.start.toISOString();
    	  sch.end = arg.event.end.toISOString();
    	  console.log("###드랍 수정할 데이터###");
    	  console.log(sch);
    	  //updateCall(sch);
      },
      eventResize:function(arg){
    	  alert("이벤트 날짜 크기 수정.");
    	  console.log("###이벤트 날짜 크기 수정###");
    	  console.log(arg.event);
    	  var sch = arg.event;
    	  sch.start = arg.event.start.toISOString();
    	  sch.end = arg.event.end.toISOString();
    	  console.log("###리사이즈 수정할 데이터###");
    	  console.log(sch);
    	  //updateCall(sch);
      },
      eventClick: function(arg) {
    	// 있는 일정 클릭 시 
    	// 상세 화면 보이기(등록되어 있는 데이터 출력)
    	// ajax를 통해서 수정/삭제 
   	 	date.start = arg.event.start;
   		date.end = arg.event.end; 
    	 // event에 날짜 저장 
    	console.log("# 등록된 일정 클릭 #")
    	console.log(arg.event);
    	// 각 form에 값 추가 
    	detail(arg.event);
    	opts.buttons={
    		"수정":function(){
    			// 수정 후 Json데이터 가져오기 
    			// 화면에 form하위에 있는 요소객체의 값을 가져오는 부분 
    			var sch = callSch();
    			// 1. 화면단 처리 변경 
    			// 현재 캘린더 api의 속성 변경하기 
    			var event = calendar.getEventById(sch.id);
    			console.log("## event ##");
    			console.log(event);
    			// 속성값 변경 setProp 
    			event.setProp("title",sch.title);
    			event.setProp("textColor",sch.textColor);
    			event.setProp("backgroundColor",sch.backgroundColor);
    			event.setProp("borderColor",sch.borderColor);
    			/* event.setProp("start",sch.start);
    			event.setProp("end",sch.end); */
    			// 확장 속성 :  writer, content 
    			event.setExtendedProp("writer",sch.writer);
    			event.setExtendedProp("content",sch.content);
    			event.setAllDay(sch.allDay); // boolean 처리 
    			
    			// DB 변경 
    			updateCall(sch);
    			
    			$("#schDialog").dialog("close");
    		},
    		"삭제":function(){
    			
    			var idVal= $("[name=id]").val();
    			var event = calendar.getEventById(idVal);
    			if(confirm("삭제하시겠습니까?")){
    				event.remove();
    				$("#schDialog").dialog("close");
    				$.ajax({
    					type:"post",
    					data:{id:idVal},
    					dataType:"json",
    					url:"calendar.do?method=delete",
    					success:function(data){
    						if(data.success=="Y"){
    							alert("삭제성공");
    						}
    					},
    					error:function(err){
    						alert("에러발생");
    						console.log(err);
    					}
    				})
    			}
    			
    		}
    	}
    	$("#schDialog").dialog(opts);
		$("#schDialog").dialog("open");
    	
       /*  if (confirm('이벤트를 삭제하시겠습니까')) {
          arg.event.remove()
        } */
        
      },
      editable:true,
      dayMaxEvents:true, // allow "more" link when too many events
      events:function(info,successCallback, failureCallback){
    	  // ajax처리로 데이터를 로딩 시킨다. 
    	  // 화면에 나타날 일정들을 ajax를 통해서 호출하고, 
    	  // success 함수를 통해서 서버에서 받은 데이터를 가져오고, 
    	  // successCallback 이라는 매개변수를 받은 함수에 일정 내용을 전달하면 
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
  
 function updateCall(sch){
	  // callSch() 입력된 수정된 데이터를 요청값으로 전달 
	  $.ajax({
		  type:"post",
		  url:"calendar.do?method=update",
		  data:callSch(),
		  dataType:"json",
		  success:function(data){
			  if(data.success=="Y")
				  alert("수정완료");
				  
		  },
		  error:function(err){
			  alert("에러발생: "+err);
			  console.log(err);
		  }
	  });
 }
 function callSch(){
	 var sch = {};
	 sch.id=$("[name=id]").val();
	 sch.title=$("[name=title]").val();
	 sch.writer=$("[name=writer]").val();
	 sch.content=$("[name=content]").val();
	 // Date타입은 화면에서 사용되는 형식으로 설정하여야 한다. 
	 sch.start= date.start.toISOString();
	 sch.end= date.end.toISOString();
	 // alert("등록할 시작일: "+sch.start);
	 // sch.allDay : Calendar로 처리할 데이터 boolean 형식으로 true/false 
	 // 으로 처리되어야 하는데, 화면에 보이는 내용 문자열로 되어 있다. 
	 // option value ="true" 이 선택되어 졌을 때는 == 비교연산을 통해서 
	 // true로 boolean 값을 넘기고, 그외는 false를 boolean값으로 전달 
	 sch.allDay=$("[name=allDay]").val()=="true"; // 문자열이 "true"일 때, 그외는 false 
	 sch.backgroundColor=$("[name=backgroundColor]").val(); // 배경색상 
	 sch.textColor=$("[name=textColor]").val(); // 
	 sch.borderColor=$("[name=borderColor]").val();
	 return sch;
 }
 function detail(event){
	 // form 하위 객체에 할당 
	 $("[name=id]").val(event.id);
	 $("[name=title]").val(event.title);
	 // calendar에서 추가된 속성들 
	 var exProps = event.extendedProps
	 $("[name=writer]").val(exProps.writer);
	 $("[name=content]").val(exProps.content);
	 $("[name=start]").val(event.start.toLocaleString());
	 $("[name=end]").val(event.end.toLocaleString());
	 $("[name=allDay]").val(""+event.allDay); // 문자열로 변환
	 $("[name=backgroundColor]").val(event.backgroundColor);
	 $("[name=borderColor]").val(event.borderColor);
	 $("[name=textColor]").val(event.textColor);
	 
 }
  
   $(document).ready(function(){
      
   });
</script>
</head>
<body>
 <div id='calendar'></div>
 

 <div id="schDialog" title="일정 등록">
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
  		<textarea rows="5" cols="20" class="form-control" name="content"></textarea>
  	</div>
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
  			<span class="input-group-text">종일여부</span>
  		</div>
  		<select class="form-control" name="allDay">
			<option value="true">종 일</option>  		
			<option value="false">시 간</option>  		
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
  		<input class="form-control" name="backgroundColor" type="color" value="#0099cc"/>
  	</div>
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
  			<span class="input-group-text">테두리색상</span>
  		</div>
  		<input class="form-control" name="borderColor" type="color" value="#0099cc"/>
  	</div>
  	<div class="input-group mb-3">
  		<div class="input-group-prepend">
  			<span class="input-group-text">글자색상</span>
  		</div>
  		<input class="form-control" name="textColor" type="color" value="#ccffff"/>
  	</div>
  </form>
</div>
</body>
</html>