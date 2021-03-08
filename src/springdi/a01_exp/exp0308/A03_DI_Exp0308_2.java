package springdi.a01_exp.exp0308;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Exp0308;

public class A03_DI_Exp0308_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가상의 컨테이너 xml 파일 호출하기.A01_DI_Start.java
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_exp\\exp0308\\containerExp0308_2.xml");

		Exp0308 exp2 = ctx.getBean("exp2",Exp0308.class);
		System.out.println(exp2);
	}

}
