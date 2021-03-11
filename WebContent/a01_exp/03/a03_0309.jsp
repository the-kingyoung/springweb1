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
[하] 1. autowire란 무엇인가? 개념과 옵션을 기술하세요
	
	1) 컨테이너 안에 있는 객체들간에 연관관계가 설정되어 있을 때
	autowire 옵션에 따라서 객체들 간에 메모리가 로딩 처리되는 것을 말한다.
	ex) 컴퓨터와 부품객체
	2) 옵션 <bean class="포함할 클래스" autowire="옵션">
		- byType : 해당 객체의 type이 setXXX property가 선언되어 있고,
			매개변수로 해당 type을 입력이 가능할 때, 처리된다.
		- byName : 할당할 객체의 id/name의 속성명이 setXXX property의
			이름이 같고, 해당 type을 매개변수로 선언되었을 때 처리된다.
		- constructor : 할당할 객체의 type이 생성자의 매개변수와 같을 때,
			자동으로 할당된다.
		- autodectect : 우선 생성자의 type을 확인하고 그 다음 메서드의 type을
			확인하여 해당 객체를 자동할당한다.

	autowire란 자동 주입 선언 즉, 스프링이 요구사항과 맞는 빈을 찾아 빈간의 의존성을 자동적으로
	만족시키도록 하는 처리를 말한다.
	byType, byName, constructor, autodetect가 있다.
	
[하] 2. Team과 Player를 동일한 패키지에 선언하고, 연관관계를 설정한 후, 
    autowire의 이용하여 Player pl1, pl2, pl3이 선언되었을 때, pl2를 객체로 Team에 할당할려고 사용되는 컨테이너 코드를 기술하세요. 
    
    	Team 패키지에서 
    public void setPl2(Player pl) {
		player=pl;
	}
	public void showInfo() {
		System.out.println(tName+"팀");
		if(player!=null) {
			System.out.println("선수 명단");
			player.showInfo();
		}else {
			System.out.println("팀명단이 아직 없습니다.");
		}
	으로 메서드를 생성하여 pl2객체를 team에 할당할수 있게 한다.
    	
    	<bean id="pl1" class="springdi.z99_0309.Player">
			<constructor-arg value="김현수"/>
			<constructor-arg value="22"/>
		</bean>
		<bean id="pl2" class="springdi.z99_0309.Player">
			<constructor-arg value="박용택"/>
			<constructor-arg value="33"/>
		</bean>
		<bean id="pl3" class="springdi.z99_0309.Player">
			<constructor-arg value="라모스"/>
			<constructor-arg value="44"/>
		</bean>
		
		<bean id="team" class="springdi.z99_0309.Team" autowire="byName">
			<constructor-arg value="LG트윈스" />
		</bean>
[jquery]
[하] 1. focus/blur이벤트의 기본 형식을 기술하세요.
		- 이벤트 선언
		$(선택자).focus(function(){
			선택자에 focus 처리했을 때 이벤트 처리 내용.
		});
	
		$(선택자).blur(function(){
			선택자에 focus처리했다가 벗어났을 때 이벤트 처리 내용.
		});		
		- 이벤트 강제 호출
		$(선택자).focus();
		$(선택자).blur();
		--%>
		

	$(document).ready(function(){
<%--
	[하] 2. [0  ] X [0  ] [정답]  : 왼쪽과 같이 3개의 input창을 만들고 입력할 기존 문자가 없어지고 정답 부분을 클릭시, 
	왼쪽에 입력된 값을 연산하여 출력처리하세요.--%>
		$("#num01").focus(function(){
			$(this).val("");
		});
		$("#num02").focus(function(){
			$(this).val("");
		});
		
		$("#answer").on("click",function(){
			var num01 = $("#num01").val();
			var num02 = $("#num02").val();
			var tot = eval(num01*num02);
			$("#ex2").text(num01+"X"+num02+"="+tot);
		});
		$("input").focus(function(){
			// 전체 input은 공통적으로 초기화 처리.
			$(this).val("");
			//alert($(this).attr("name"));
			
			// <input name="tot"> 인것을 focus했을 때,
			// 연산 처리..
		});
		
<%--    
	[중] 3. 아래와 같은 내용에 select를 선택했을 때, 구매 총액이 하단에 표기되게 하세요.
	        사과    3000  [0~10]
	        바나나   4500  [0~10]
	        딸기   12000  [0~10]
	          구매 총액  @@@		--%>
		 var tot01=0;
		 var tot02=0;
		 var tot03=0;
		 
		$("#appleCnt").change(function(){
			var num01 = 3000;
			var appleCnt = $("#appleCnt>option:selected").text();
			var appleCnt = $("#appleCnt").val();
			tot01 = eval(num01*appleCnt);
			$("#total01").text(num01+"X"+appleCnt+"="+tot01);
			$("#total").text(tot01+tot02+tot03);
		});
		$("#bananaCnt").change(function(){
			var num02 = 4500;
			var bananaCnt = $("#bananaCnt>option:selected").text();
			var bananaCnt = $("#bananaCnt").val();
			tot02 = eval(num02*bananaCnt);
			$("#total02").text(num02+"X"+bananaCnt+"="+tot02);
			$("#total").text(tot01+tot02+tot03);
		});
		$("#strawberryCnt").change(function(){
			var num03 = 12000;
			var strawberryCnt = $("#strawberryCnt>option:selected").text();
			var strawberryCnt = $("#strawberryCnt").val();
			tot03 = eval(num03*strawberryCnt);
			$("#total03").text(num03+"X"+strawberryCnt+"="+tot03);
			$("#total").text(tot01+tot02+tot03);
		});
	          
<%--
	[하] 4. 3X3테이블을 만들고, 초기에 중앙에 배경색상으로 노랑색으로 되어 있다가, 키이벤트 좌우상하를 누르고 있을 때는, 중앙에 있는
	    노랑색 배경색상이 해당 방향으로 이동되어 있다가, 키를 떼었을 때, 다시 중앙으로 돌아오게 이벤트 처리하세요.				--%>
		$("#5").css("background","yellow");
		$("#table").keydown(function(event){
			if(event.keyCode=='37'){
				$("#5").css("background","white");	
			}
		});

	});
</script>
</head>
<body>
	<h2>예제 2번</h2>
	<input id="num01" type="text" value="0"/>X
	<input id="num02" type="text" value="0"/>=
	<input id="answer" type="submit" value="정답"/>
	<div id="ex2"></div>
	<br/>
	
	
	
	<h2>예제 3번</h2>
	사과 3000 
	<select id="appleCnt">
		<option>0</option>
		<option>1</option>
		<option>2</option>
		<option>3</option>
		<option>4</option>
		<option>5</option>
		<option>6</option>
		<option>7</option>
		<option>8</option>
		<option>9</option>
		<option>10</option>
	</select><br/>
	바나나 4500 
	<select id="bananaCnt">
		<option>0</option>
		<option>1</option>
		<option>2</option>
		<option>3</option>
		<option>4</option>
		<option>5</option>
		<option>6</option>
		<option>7</option>
		<option>8</option>
		<option>9</option>
		<option>10</option>
	</select><br/>
	딸기 12000 
	<select id="strawberryCnt">
		<option>0</option>
		<option>1</option>
		<option>2</option>
		<option>3</option>
		<option>4</option>
		<option>5</option>
		<option>6</option>
		<option>7</option>
		<option>8</option>
		<option>9</option>
		<option>10</option>
	</select><br/>
	구매총액
	<div id="total01"></div>
	<div id="total02"></div>
	<div id="total03"></div>
	총합<div id="total"></div>
	
	<h2>예제 3번</h2>
	<table id="table" border="1" width="200" height="200">
		<tr><td id="1">1</td><td id="2">2</td><td id="3">3</td></tr>
		<tr><td id="4">4</td><td id="5">5</td><td id="6">6</td></tr>
		<tr><td id="7">7</td><td id="8">8</td><td id="9">9</td></tr>
	</table>
</body>
</html>