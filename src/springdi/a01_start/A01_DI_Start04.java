package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Book;
import springdi.z03_vo.Compart;
import springdi.z03_vo.Computer1;

public class A01_DI_Start04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가상의 컨테이너 xml 파일 호출하기.A01_DI_Start.java
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_start\\container04.xml");
		Book b1 = ctx.getBean("b1", Book.class);
		System.out.println("제목 : "+b1.getTitle());
		System.out.println("가격 : "+b1.getPrice());
		System.out.println("저자 : "+b1.getWriter());
		System.out.println("제작 : "+b1.getPublisher());
		
		
		Computer1 com = ctx.getBean("com", Computer1.class);
		Compart p002 = ctx.getBean("p002", Compart.class);
		Compart p003 = ctx.getBean("p003", Compart.class);
		com.setPart(p002);
		com.setPart(p003);
		com.showInfo();
		Computer1 comM = ctx.getBean("comM",Computer1.class);
		comM.showInfo();
		
	}
}