package springdi.a01_exp.exp0308;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springdi.z04_vo.Game;
import springdi.z04_vo.Player;
import springdi.z04_vo.Team;

public class A03_DI_Exp0308_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가상의 컨테이너 xml 파일 호출하기.
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_exp\\exp0308\\containerExp0308_3.xml");
		// Component 기본 형식으로 호출..
		Team team = ctx.getBean("team",Team.class);
		Player player = ctx.getBean("player",Player.class);
		Game game = ctx.getBean("game",Game.class);
		System.out.println("객체생성확인(team)"+team);
		System.out.println("객체생성확인(player)"+player);
		System.out.println("객체생성확인(game)"+game);
	}
}
