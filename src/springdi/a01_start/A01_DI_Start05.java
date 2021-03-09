package springdi.a01_start;

import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.z01_vo.Mart;
import springdi.z01_vo.MyMusic;
import springdi.z03_vo.Sensor;

public class A01_DI_Start05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가상의 컨테이너 xml 파일 호출하기.A01_DI_Start.java
		AbstractApplicationContext ctx
		=new GenericXmlApplicationContext(
				"springdi\\a01_start\\container05.xml");
		Mart fMart = ctx.getBean("fMart", Mart.class);
		fMart.buyStrList();
		
		MyMusic myMusic = ctx.getBean("myMusic", MyMusic.class);
		myMusic.musicList();
		
//		Sensor sensor1 = ctx.getBean("sensor1",Sensor.class);
//		// sensor1 참조변수만 호출하면 기본적으로 toString()로 선언된 부분이 호출된다.
//		System.out.println(sensor1);
	}

}
