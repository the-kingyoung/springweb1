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
[spring]
[하] 1. 스프링 MVC로 회원 정보 리스트 출력하세요.
===========================================controller=====================================================
package springweb.a01_start;
//springweb.a01_start.A00_MemberController
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jspexp.a03_database.A04_MemberDao;
import jspexp.z01_vo.Member;

@Controller
public class A00_MemberController {

	//http://localhost:7080/springweb/memberList.do
	@RequestMapping("memberList.do")
	public String memberList(Member mem, Model d) {
		A04_MemberDao dao = new A04_MemberDao();
		if(mem.getId()==null) mem.setId("");
		if(mem.getName()==null) mem.setName("");
		d.addAttribute("memberList", dao.memberList(mem.getId(), mem.getName()));
		return "WEB-INF\\views\\a01_start\\a00_memberList.jsp";
	}
}
===========================================view=====================================================
<div class="jumbotron text-center">
	<h2>회원 리스트</h2>
</div>
<div class="container">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<form class="form-inline" method="post" action="${path}/memberList.do">
		<input class="form-control mr-sm-2" type="text" name="id" value="${param.id}" placeholder="회원아이디">
		<input class="form-control mr-sm-2" type="text" name="name"  value="${param.name}" placeholder="회원이름">
		<button class="btn btn-success" type="submit">검색</button>
	</form>
	</nav>
	<table class="table table-hover">
	<thead>
		<tr class="table-success text-center">
        	<th>회원ID</th>
        	<th>회원이름</th>
        	<th>포인트</th>
        	<th>주소</th>
        	<th>등록일</th>
        	<th>권한</th>
        	
		</tr>
	</thead>
	<tbody>
	<c:forEach var="mem" items="${memberList}">
		<tr class="text-center">
			<td>${mem.id}</td>
			<td>${mem.name}</td>
			<td>${mem.point}</td>
			<td>${mem.address}</td>
			<td>${mem.regdte}</td>
			<td>${mem.auth}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>    
</div>
</body>
</html>
===========================================예제 1번 끝=====================================================
[하] 2. DI를 이용해서 Book의 생성자를 통해서 데이터를 할당해서 출력처리하세요.
===========================================vo Book=====================================================
package springdi.z01_vo;
//springdi.z01_vo.Book
public class Book {
	private String title;
	private int price;
	private String writer;
	private String publisher;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String title, int price, String writer, String publisher) {
		super();
		this.title = title;
		this.price = price;
		this.writer = writer;
		this.publisher = publisher;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
===========================================DI=====================================================
package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Book;

public class A01_DI_Start4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가상의 컨테이너 xml 파일 호출하기.A01_DI_Start.java
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_start\\container4.xml");
		Book b1 = ctx.getBean("b1", Book.class);
		System.out.println("제목 : "+b1.getTitle());
		System.out.println("가격 : "+b1.getPrice());
		System.out.println("저자 : "+b1.getWriter());
		System.out.println("제작 : "+b1.getPublisher());
	}
}
===========================================container=====================================================
		<bean id="b1" class="springdi.z01_vo.Book">
			<property name="title" value="삼국지"></property>
			<property name="price" value="12000"></property>
			<property name="writer" value="홍길동"></property>
			<property name="publisher" value="쌍용"></property>
		</bean>
===========================================예제 2번 끝=====================================================


[하] 3. DI를 이용해서 Computer객체에 부품(Cpu, Ram, Hdd 객체)를 할당하여 
        Computer의 showInfo()메서드를 통해서 출력 처리하세요.
        컴퓨터명 @@@에 포함된
        Cpu 이름은 @@, 사양은 @@@
        Ram는 이름은 @@, 사양은 @@@
        Hdd는 이름은 @@, 사양은 @@@
        입니다.
=============================Cpu, Ram, Hdd 객체를 만들고 Computer객체 생성====================================
package springdi.z01_vo;

public class Computer {
	private String name;
	private Cpu cpu;
	private Ram ram;
	private Hdd hdd;
	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void showInfo() {
		System.out.println("컴퓨터 제품을 구매하였습니다.");
		if (cpu != null && ram != null && hdd != null) {
			System.out.println("컴퓨터명 " + name + "에 포함된");
			System.out.println("Cpu 이름은 " + cpu.getName() + ", 사양은 " + cpu.getAbility());
			System.out.println("Ram 이름은 " + ram.getName() + ", 사양은 " + ram.getAbility());
			System.out.println("Hdd 이름은 " + hdd.getName() + ", 사양은 " + hdd.getAbility());
			System.out.println("입니다.");
		} else{
			System.out.println("아직 제품을 모두 구매하지 못했습니다.");
		}
	}
	public Computer(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Cpu getCpu() {
		return cpu;
	}
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	public Ram getRam() {
		return ram;
	}
	public void setRam(Ram ram) {
		this.ram = ram;
	}
	public Hdd getHdd() {
		return hdd;
	}
	public void setHdd(Hdd hdd) {
		this.hdd = hdd;
	}
}
=================================================DI 생성========================================
package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;


import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Computer;

public class A01_DI_Start5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가상의 컨테이너 xml 파일 호출하기.A01_DI_Start.java
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_start\\container5.xml");
		Computer c01 = ctx.getBean("c01", Computer.class);
		c01.showInfo();
	}
}
=================================================container========================================
		<bean id="c01" class="springdi.z01_vo.Computer">
			<constructor-arg value="엘지 그램"/>
			<property name="Cpu" ref="cpu"/>
			<property name="Ram" ref="ram"/>
			<property name="Hdd" ref="hdd"/>
		</bean>
		<bean id="cpu" class="springdi.z01_vo.Cpu">
			<constructor-arg value="i7" />
			<constructor-arg value="3.40GHz" />
		</bean>
		<bean id="ram" class="springdi.z01_vo.Ram">
			<constructor-arg value="DDR4-2400" />
			<constructor-arg value="8GB" />			
		</bean>
		<bean id="hdd" class="springdi.z01_vo.Hdd">
			<constructor-arg value="Seagate" />
			<constructor-arg value="10TB" />
		</bean>
=================================================예제3번 끝========================================
--%>
