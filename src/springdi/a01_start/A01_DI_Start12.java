package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z05_vo.Buyer;

public class A01_DI_Start12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기.
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_start\\container12.xml");
		
		Buyer buyer = ctx.getBean("buyer", Buyer.class);
		buyer.buy();
	}

}