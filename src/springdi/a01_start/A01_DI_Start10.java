package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Computer1;
import springdi.z01_vo.Mart;

public class A01_DI_Start10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기.
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_start\\container10.xml");
		Mart mart = ctx.getBean("mart", Mart.class);
		mart.buy();
		
		Computer1 com = ctx.getBean("com", Computer1.class);
		com.showInfo();
	}

}
