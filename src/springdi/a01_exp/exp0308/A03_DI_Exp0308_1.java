package springdi.a01_exp.exp0308;
//
import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Team;

public class A03_DI_Exp0308_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기.
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_exp\\exp0308\\containerExp0308_1.xml");
		Team bTeam = ctx.getBean("bTeam",Team.class);
		bTeam.showInfo();
	}
}
