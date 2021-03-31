<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}"/> 
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
<%--
# jquery ui dialogue 박스 처리.
1. jquery 및 jquery ui css 및 js lib 설정
2. 화면에 div로 title과 함께 id값으로 설정.
3. div의 id값을 기준으로 기본 옵션 설정.
	1) 	$("요소객체").dialog({
		속성:속성값..
		})
	2) 주요 속성
		autoOpen : 초기화면에 출력할지 여부를 선언.
		modal : 로딩시 다른 요소객체 비활성화 처리
		button:{"버튼명":function(){버튼을 통해 처리할 내용..}}
	3) 호출이벤트
		$("요소객체").dialog("open"); 이벤트를 통해서 화면 로딩.
		$("요소객체").dialog("close"); 이벤트를 통해서 화면 닫기.
		
		
--%>
//
	$(document).ready(function(){
		$("h2").text("시작");
		$("h2").click(function(){
			//$("#dialog").dialog("open");
			$("#btn01").click();	// bootstrap dialogue 호출 처리..
		});	
		/*
		해당 버튼 속성 display:none; 으로 처리 후, 위와 같이 h2를 클릭시,
		다이얼로그가 나오게 한다.
		<button type="button"
		id="btn01" style="display:none;"
		*/
		
		
		$( "#dialog" ).dialog({
			autoOpen:false,
			modal:true,
			buttons:{
				"기능버튼":function(){
					alert("버튼클릭!");
				},
				"창닫기":function(){
					$("#dialog").dialog("close");
				}
			}
		});	
		
		$("#btn02").click(function(){
			$("#dialog2").dialog("open");
		});	
		$( "#dialog2" ).dialog({
			autoOpen:false,
			modal:true,
			buttons:{
				"등록":function(){
					alert("등록클릭!");
				},
				"수정":function(){
					alert("수정클릭!");
				},
				"삭제":function(){
					alert("삭제클릭!");
				}

			}
		});	
	});
</script>
</head>
<body>
<div id="dialog" title="Empty the recycle bin?">
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>These items will be permanently deleted and cannot be recovered. Are you sure?</p>
</div>
<div id="dialog2" title="Empty the recycle bin?">
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>These items will be permanently deleted and cannot be recovered. Are you sure?</p>
</div>
 
<div class="jumbotron text-center">
	<h2>부트스트랩 form</h2>
	<button type="button" id="btn02">버튼클릭</button>
</div>
<div class="container">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<form class="form-inline" method="post">
		<input class="form-control mr-sm-2" type="text" 
			name="ename" value=""
			placeholder="사원명">
		<input class="form-control mr-sm-2" type="text" 
			name="job"  value=""
			placeholder="직책명">
		<button class="btn btn-success" type="submit">Search</button>
	</form>
	</nav>
	<!-- Button to Open the Modal  style="display:none;"-->
	<button type="button"
	id="btn01" class="btn btn-primary" style="display:none;"
	data-toggle="modal" data-target="#myModal">
		Open modal(boot strap)
	</button>
	<!-- The modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="bodal-header">
					<h4 class="modal-title">Modal Heading</h4>
					<button type="button" class="close" 
					data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					Modal body..
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-info"
					data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>