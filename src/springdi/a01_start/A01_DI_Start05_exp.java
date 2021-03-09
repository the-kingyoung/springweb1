package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;


import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Computer;

public class A01_DI_Start05_exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가상의 컨테이너 xml 파일 호출하기.A01_DI_Start.java
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_start\\container05_exp.xml");
		Computer c01 = ctx.getBean("c01", Computer.class);
		c01.showInfo();
	}

}
