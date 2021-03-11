package springdi.a01_exp.exp0309;
import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.a01_exp.z01_vo.Team;

//

public class A05_0309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기.
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_exp\\exp0308\\exp0309\\cotainer3.xml");
		
		Team team = ctx.getBean("team",Team.class);
		team.showInfo();

	}
}
