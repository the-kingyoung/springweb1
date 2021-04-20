package springaop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springaop.z01_vo.Message;

public class AOP_Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx
		= new GenericXmlApplicationContext(
				"springaop\\container01.xml");
		Message msg=ctx.getBean("proxy",Message.class);
		msg.helloApp(); 
		// 프락시안에 있는 대상 객체 Mesasge의 helloApp()
		// AOP 처리
		ctx.close();

	}

}
