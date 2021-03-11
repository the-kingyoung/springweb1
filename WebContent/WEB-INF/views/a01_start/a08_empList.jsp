<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<c:set var="path" value="${pageContext.request.contextPath}"/> 
<fmt:requestEncoding value="UTF-8" /> 
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
      $("[name=deptno]").val("${sch.deptno}");
      $("[name=mgr]").val("${sch.mgr}");
   });
</script>
</head>
<div class="jumbotron text-center">
  <h2>사원 정보</h2>
</div>
<div class="container">
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
     <form class="form-inline" method="post" action="${path}/empList.do">
       <input class="form-control mr-sm-2" type="text" 
      	 	name="ename" value="${sch.ename}" style="width:20%;" placeholder="사원명">
       <input class="form-control mr-sm-2" type="text" 
       		name="job"  value="${sch.job}" style="width:20%;" placeholder="직책명">
       		
       <select name="deptno" class="form-control mr-sm-2"
       		style="width:20%;">
       		<option value="0">부서선택</option>
       		<c:forEach var="dept" items="${deptList}">
       			<option value="${dept.deptno}">${dept.dname}</option>
       		</c:forEach>
       </select>
       <!-- 
       mgrList
        -->
       <select name="mgr" class="form-control mr-sm-2"
       		style="width:20%;">
       		<option value="0">관리자 선택</option>
       		<c:forEach var="emp" items="${mgrList}">
       			<option value="${emp.mgr}">${emp.ename}</option>
       		</c:forEach>
       </select>
       
       
       
       <button class="btn btn-success" type="submit">Search</button>
     </form>
  </nav>
  <table class="table table-hover">
    <thead>
      <tr class="table-success text-center">
        <th>사원번호</th>
        <th>사원명</th>
        <th>관리자명</th>
        <th>직책</th>
        <th>급여</th>
        <th>부서이름</th>
      </tr>
    </thead>
    <tbody>
		<c:forEach var="emp" items="${emplist}">  
      <tr class="text-center">
        <td>${emp.empno}</td>
        <td>${emp.ename}</td>
        <td>${emp.mname}</td>
        <td>${emp.job}</td>
        <td>${emp.sal}</td>
        <td>${emp.dname}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>    
</div>
</body>
</html>