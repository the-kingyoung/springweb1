package springaop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springaop.z01_vo.Message;

public class AOP_Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx
		= new GenericXmlApplicationContext(
				"springaop\\container00.xml");
		Message msg=ctx.getBean("aspect",Message.class);
		msg.helloApp();
		ctx.close();

	}

}
