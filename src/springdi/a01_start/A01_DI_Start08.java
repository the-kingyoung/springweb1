package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z02_vo.Person;
import springdi.z02_vo.Product;

public class A01_DI_Start08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기.
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_start\\container08.xml");
		Person p02 = ctx.getBean("p02",Person.class);
		Product prod03 = ctx.getBean("prod03",Product.class);
		System.out.println("객체생성여부(p02):"+p02);
		System.out.println("객체생성여부(prod03):"+prod03);
	}

}
