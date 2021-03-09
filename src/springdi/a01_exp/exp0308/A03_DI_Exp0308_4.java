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
		Product prod = ctx.getBean("prod",Product.class);
		System.out.println("# 파일에 객체 호출 #");
		System.out.println(prod.getPname());
		System.out.println(prod.getPrice());
		System.out.println(prod.getCnt());
	}

}
