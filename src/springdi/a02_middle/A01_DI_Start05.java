package springdi.a02_middle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.a02_middle.z03_vo.Computer;
import springdi.a02_middle.z03_vo.Ram;

public class A01_DI_Start05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기.
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a02_middle\\container05.xml");
		Computer computer = ctx.getBean("computer", Computer.class);
		Ram ram = ctx.getBean("ram", Ram.class);
		ram.setCompany("하이닉스");
		ram.setSpec("16G");
		computer.info();
		
	}

}
