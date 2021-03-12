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
[스프링]
[하] 1. dao와 XXXMapper.xml 관계를 선언형식을 리턴값(단일/다중), 매개변수(변수/객체)에 따른 선언방법을 기술하세요
		리턴값이 단일일때는 resultType
			   다중일 경우에는 resultMap,
		
		매개변수의 변수가 없을때는 따로 선언하지 않는다.
		매개변수의 변수가 단일데이터일 경우 parameterType이 타입,
					  단일 객체일 경우 parameterType이 클래스명,
					  배열형 객체일 경우 parameterType으로 HashMap사용
					  
		
[하] 2. 다음의 sql에 해당 하는 dao단과 XXXMapper.xml을 선언하세요
        0)  select *
            from dept
            where dname like '%'||#{dname}||'%'
            and job  like '%'||#{job}||'%'
            
        1) SELECT empno, ename, sal, grade
            FROM emp, salgrade
            WHERE sal BETWEEN losal AND hisal
            AND sal>=#{sal}
            
        2) SELECT empno, ename, job, sal
            FROM EMP e 
            WHERE ( sal >=#{start} AND sal<=#{end} )
            OR job = #{job}
            
        3) SELECT ename, loc, to_char(hiredate, 'Q') part
            FROM emp e, dept d
            WHERE e.deptno = d.deptno
            AND to_char(hiredate, 'Q') IN (#{p01},#{p02})
            
[하] 3. 아래의 실제 업무바탕으로 dao단과 XXXMapper.xml을 선언하세요
         1) 부서번호로 사원번호, 사원명, 부서명, 급여 조회
         2) 관리자이름으로 사원명 리스트 조회
         3) 사원명 3명 입력하여 최고급여 조회
         4) 입사년도기준으로 사원정보(전체) 조회
[하] 4. mybatis기준으로 부서정보 조회 화면을 만드세요(웹화면까지)   DeptDao(인터페이스), DeptMapper.xml 추가
[중] 5. mybatis기준으로 사원정보+부서정보+급여등급 조회(직책/부서명/급여등급) 화면을 만드세요(웹화면까지)

--%>
//
	$(document).ready(function(){
		
	});
</script>
</head>
<div class="jumbotron text-center">
	<h2>부트스트랩 form</h2>
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
	<table class="table table-hover">
	<thead>
		<tr class="table-success text-center">
        	<th>타이틀</th>
		</tr>
	</thead>
	<tbody>
		<tr class="text-center">
			<td>내용</td>
		</tr>
	</tbody>
	</table>    
</div>
</body>
</html>