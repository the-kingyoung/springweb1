package springaop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Person;

public class AOP_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx
		= new GenericXmlApplicationContext(
				"springaop\\container00.xml");
		Person p01=ctx.getBean("p01",Person.class);
		ctx.close();

	}

}
