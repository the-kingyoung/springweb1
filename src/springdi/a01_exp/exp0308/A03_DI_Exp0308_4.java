package springdi.a01_exp.exp0308;

import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Product;

public class A03_DI_Exp0308_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기.
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_exp\\exp0308\\containerExp0308_4.xml");
		Product prod01 = ctx.getBean("prod01",Product.class);
		System.out.println(prod01.getPname());
		System.out.println(prod01.getPrice());
		System.out.println(prod01.getCnt());
				
	}

}
