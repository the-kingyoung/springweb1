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
		
	});
</script>
</head>
<div class="jumbotron text-center">
	<h2>파일 업로드 연습</h2>
</div>
<div class="container">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<form method="post" enctype="multipart/form-data">
	<!-- 요청 url이 호출 url과 동일하게 처리했기때문에 action을
	생략 가능하다.(get/post)방식으로 구분 처리. -->
		<input class="form-control mr-sm-2" type="text" 
			name="content" value=""
			placeholder="파일내용"><br>
		<input class="form-control mr-sm-2" type="file" 
			name="report"><br>
		<input class="form-control mr-sm-2" type="file" 
			name="report"><br>
		<input class="form-control mr-sm-2" type="file" 
			name="report"><br>
			
			
		<button class="btn btn-success" type="submit">자료업로드</button>
	</form>
	</nav>   
</div>
</body>
</html>