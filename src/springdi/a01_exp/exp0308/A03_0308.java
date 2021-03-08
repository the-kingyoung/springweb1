package springdi.a01_exp.exp0308;

import springdi.z01_vo.Exp0308;
import springdi.z01_vo.Product;
import springdi.z01_vo.Team;
import springdi.z04_vo.Game;
import springdi.z04_vo.Player;

public class A03_0308 {
	public static void main(String[] args) {
		
		
/*
[spring]
[하] 1. 1:다의 예제로  스포츠에  팀과 선수를 설정하여 Team, ArrayList<Player> 형태로 처리하셔서 출력하세요
==========================================예제1번======================================================
Player vo에 name과 number를,
Team vo에 tName과 ArrayList<Player>를 만들어두고
		<bean id="no19" class="springdi.z01_vo.Player">
			<constructor-arg value="고우석"/>
			<constructor-arg value="19"/>
		</bean>
		<bean id="no22" class="springdi.z01_vo.Player">
			<constructor-arg value="김현수"/>
			<constructor-arg value="22"/>
		</bean>
		<bean id="no33" class="springdi.z01_vo.Player">
			<constructor-arg value="박용택"/>
			<constructor-arg value="33"/>
		</bean>
		<bean id="no44" class="springdi.z01_vo.Player">
			<constructor-arg value="라모스"/>
			<constructor-arg value="44"/>
		</bean>
		<bean id="bTeam" class="springdi.z01_vo.Team">
			<constructor-arg value="LG트윈스" />
			<property name="pList">
				<list>
					<ref bean="no19"/>
					<ref bean="no22"/>
					<ref bean="no33"/>
					<ref bean="no44"/>
				</list>
			</property>
		</bean>
==========================================컨테이너로 값을 설정=============================================
		Team bTeam = ctx.getBean("bTeam",Team.class);
		bTeam.showInfo();
==========================================DI로 값을 출력================================================
[하] 2. 여러가지 Collection 타입(list, set, properties, map)의 특징을 기술하고, 해당 예제를 di로 처리하세요.
Exp0308이라는 vo에 Collection타입을 설정하고
==========================================예제2번======================================================
	<bean id="exp2" class="springdi.z01_vo.Exp0308">
		<property name="list">
			<list>
				<value>예제1번</value>
				<value>예제2번</value>
				<value>예제3번</value>
			</list>
		</property>
		
		//동일한 이름이 있으면 하나만 출력이 된다.
		<property name="sets">
			<set value-type="java.lang.String">
				<value>예제1</value>
				<value>예제1</value>
				<value>예제2</value>
				<value>예제3</value>
			</set>
		</property>
		
		<property name="props">
			<props>
				<prop key="1">정답</prop>
				<prop key="2">오답</prop>
			</props>
		</property>
		
		//동일한 key에 value가 다르면 뒤에 나오는 key값의 value만 출력이 된다.
		<property name="maps">
			<map>
				<entry key="예제1번" value="X"></entry>
				<entry key="예제2번" value="O"></entry>
				<entry key="예제3번" value="O"></entry>
				<entry key="예제1번" value="O"></entry>
			</map>
		</property>
	</bean>
==========================================컨테이너에 값을 등록=============================================
		Exp0308 exp2 = ctx.getBean("exp2",Exp0308.class);
		System.out.println(exp2);
==========================================DI로 값을 출력================================================
[하] 3. z04_vo 폴드에 Team, Player, Game 클래스를 선언하고, 해당 클래스롤 객체로 로딩하는 처리를
    @Component형식, RegExp형식으로 호출하여 처리하세요
==========================================예제3번======================================================
    - 클래스를 모두 생성을 한 뒤 각 클래스마다 @Component를 설정,
    	<context:component-scan base-package="springdi.z04_vo">
			<context:include-filter type="regex" expression=".*"/>
		</context:component-scan>
		컨테이너에 값을 넣어주고 DI에서
		Team team = ctx.getBean("team",Team.class);
		Player player = ctx.getBean("player",Player.class);
		Game game = ctx.getBean("game",Game.class);
		System.out.println("객체생성확인(team)"+team);
		System.out.println("객체생성확인(player)"+player);
		System.out.println("객체생성확인(game)"+game);
		
		각 클래스마다 객체 생성이 잘 되는지 확인을 해준다.
==========================================예제3번======================================================
[하] 4. info2 파일에 물건명, 가격, 갯수를 key=value 형식으로 저장하고, 해당 파일로 Product 클래스롤 di로 호출한 객체에서
    할당하여, 저장된 값을 호출하세요.
==========================================예제4번======================================================
info2에 값을 할당하고 
		<context:property-placeholder
			location="classpath:/springdi/a01_exp/exp0308/info2"/>
		<bean id="prod01" class="springdi.z01_vo.Product">
			<property name="pname" value="${pname}"/>
			<property name="price" value="${price}"/>
			<property name="cnt" value="${cnt}"/>
		</bean>
		경로를 지정해준 뒤 key=value값을 받아온다.

		Product prod01 = ctx.getBean("prod01",Product.class);
		System.out.println(prod01.getPname());
		System.out.println(prod01.getPrice());
		System.out.println(prod01.getCnt());
		
		출력
==========================================예제4번======================================================
*/
	}

}
