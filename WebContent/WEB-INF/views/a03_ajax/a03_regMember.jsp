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


--%>
//
	$(document).ready(function(){
		// form이 가지고 있는 submit처리를 방지 처리..
		// 웹기반 화면에서 form 하위에 입력 요소객체에서 enter키를
		// 입력하면 submit()처리가 되는 경우가 있다.
		// 이러한 default submit() 처리를 방지하기 위하여 아래와 같은
		// 기능 메서드를 선언하였다.
		// $("form").submit() : form이 submit 처리될 때,
		// e.preventDefault(); : 기본 이벤트인 submit 방지 처리.
		$("form").submit(function(e){
			e.preventDefault();			
		});
		$("#id").keyup(function(e){
			if(e.keyCode==13){ // 입력할 항목에 enter 키를 입력시 처리
				ckId();
			}
		});
		$("#ckIdBtn").click(function(){	// 등록여부확인 버튼 클릭 시
			ckId();
		});
	});
	function ckId(){
		//alert($("form").serialize());
		$.ajax({
			type:"post",
			url:"${path}/hasMember.do",
			data:$("form").serialize(),
			dataType:"json",
			success:function(data){
				if(data.mCnt==1){
					alert("등록된 아이디가 있습니다.")
					$("#id").val("").focus();
				}else{
					alert("등록 가능한 아이디입니다.")
				}
			},
			error:function(err){
				console.log(err);
			}
		});
	}


</script>
</head>
<div class="jumbotron text-center">
	<h2>회원 등록 여부</h2>
</div>
<div class="container">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<form class="form-inline">
		<input class="form-control mr-sm-2" type="text" 
			name="id" id="id" placeholder="등록할 id 입력">
		<button class="btn btn-success" type="button" id="ckIdBtn">등록여부확인</button>
	</form>
	</nav> 
</div>
</body>
</html>