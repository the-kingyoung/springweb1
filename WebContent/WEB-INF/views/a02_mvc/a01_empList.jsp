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
<style>
<%--
<c:forEach>
	h1:{background-color:${모델데이터}}
</c:forEach>
--%>
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">

//
   $(document).ready(function(){
  //    $("[name=job]").val("${sch.job}");  // spring에서 지원,, 
      $("#regBtn").click(function(){
    	  // 등록 컨트롤러 호출 
    	  location.href="${path}/insEmpForm.do";
      });
   });
</script>
</head>
<div class="jumbotron text-center">
  <h2>사원정보검색(mybatis)</h2>
</div>
<div class="container">
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
     <form:form modelAttribute="sch" class="form-inline" method="post">
       <form:input path="ename" class="form-control mr-sm-2"  placeholder="사원명"/>
       <form:select path="job" class="form-control mr-sm-2">
       		<option value="">직책선택</option>
       		<form:options items="${jobs }"/>
       </form:select>
       <button class="btn btn-success" type="submit">Search</button>&nbsp;
        <button class="btn btn-info" type="button" id="regBtn">사원등록</button>
     </form:form>
  </nav>
  <table class="table table-hover">
    <thead>
      <tr class="table-success text-center">
        <th>사원번호</th><th>사원명</th><th>직책</th><th>연봉</th><th>입사일</th>
      </tr>
    </thead>
    <tbody>
      	<c:forEach var="emp" items="${emplist}">
     		 <tr class="text-center">
      	  <td>${emp.empno}</td><td>${emp.ename}</td><td>${emp.job }</td><td>${emp.sal }</td><td><fmt:formatDate value="${emp.hiredate }"/></td>
     		 </tr>
      	</c:forEach>
    </tbody>
  </table>    
</div>
</body>
</html>