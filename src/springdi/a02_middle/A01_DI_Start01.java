package springdi.a02_middle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.a02_middle.z01_vo.Buyer;

public class A01_DI_Start01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기.
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a02_middle\\container01.xml");
		Buyer buyer01 = ctx.getBean("buyer01", Buyer.class);
		buyer01.buy();
	}

}
