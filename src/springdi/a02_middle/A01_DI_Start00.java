package springdi.a02_middle;

import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Person;

public class A01_DI_Start00 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기.
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a02_middle\\container00.xml");
		Person p01 = ctx.getBean("p01", Person.class);
		
		
	}

}
