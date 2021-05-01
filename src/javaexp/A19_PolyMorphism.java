package javaexp;

import java.util.ArrayList;

public class A19_PolyMorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
# 다형성
1. 상속관계에 있으면 상위 클래스를 참조변수로
하여 여러가지 하위객체가 만들어 지는 것을 말한다.
 */
		// 상위클래스 참조변수1 = new  하위클래스생성자();
		// 상위클래스 참조변수2 = new  하위클래스생성자();
		// 여러 형태로 변환하여 처리한다.
		Vehicle v1 = new Car();
		Vehicle v2 = new Truck();
		// 같은 메서드명이라도 overriding에 의해서 여러가지
		// 기능 처리를 할 수 있다.
		v1.driving();
		v2.driving();
		ArrayList<Vehicle> vlist = new ArrayList<Vehicle>();
		// 상속 관계에 있는 하위 여러객체를 할당이 가능하다.
		vlist.add(new Car());
		vlist.add(new Truck());
		vlist.add(new Car());
		vlist.add(new Truck());
		System.out.println("# 다형성 처리된 리스트 내용 #");
		for(Vehicle v : vlist) {
			v.driving();
		}
		
		Worker w1 = new PoliceMan();
		Worker w2 = new WebProgrammer();
		Worker w3 = new Musician();
		w1.working();
		w2.working();
		w3.working();
		
		ArrayList<Worker> wlist = new ArrayList<Worker>();
		wlist.add(new PoliceMan());
		wlist.add(new WebProgrammer());
		wlist.add(new Musician());
		System.out.println("##################예시##################");
		for(Worker w : wlist) {
			w.working();
		}
	}
	//ex) Worker라는 상위 클래스의 필드 kind,
	//		메서드 정의 working()
	//		PoliceMan, WebProgrammer, Musician
	//		오버라이딩하여 다형성으로 처리한 list를 출력하세요.
}
class Worker{
	String job;
	Worker(String job){
		this.job = job;
	}
	
	void working() {
		System.out.println("저의 직업은 "+job+"입니다.");
	}
}
class PoliceMan extends Worker{
	PoliceMan() {
		super("경찰");
		// TODO Auto-generated constructor stub
	}

	void working() {
		//job="경찰";
		super.working();
		System.out.println("나라의 치안 담당을 하고 있습니다.");
	}
}
class WebProgrammer extends Worker{
	WebProgrammer() {
		super("웹 개발자");
		// TODO Auto-generated constructor stub
	}

	void working() {
		//job="웹 개발자";
		super.working();
		System.out.println("웹상의 다양한 시스템을 만듭니다.");
	}
}
class Musician extends Worker{
	Musician() {
		// 상위에서 정의된 생성자를 하위에서 매개변수를 통해서
		// 호출하여 처리..
		super("음악가");
		// TODO Auto-generated constructor stub
	}

	void working() {
		//job="음악가";
		super.working();
		System.out.println("아름다운 음악을 만들어냅니다.");
	}
}


abstract class Vehicle{
	String kind;
	Vehicle(String kind){	// 매개변수가 있는 생성자 선언..
		this.kind=kind;
		
	}
	void driving() {
		System.out.println(kind+"을 속도 50km/h로 운행한다.");
	}
	abstract void speedUp();
	// 추상메서드가 되면 하위에서 해당 메서드는 반드시
	// 재정의(overriding)을 하여야 한다.
	// 상위보다는 하위에서 생성하여 재정의 된 것이 중요할 때는
	// 추상메서드로 선언한다.
}
// 상속관계에서 생성자 구조는 위와 같이 default 생성자가 선언되어 있을 때
class Car extends Vehicle{
	Car(){	// 하위에서도 default로 생성이 된다.
		// 1. 상위에 있는 생성자대로 호출하여야 한다.
		super("자동차");
	}
	
	void driving() {	
		// 메서드 오버라이딩 : 상위에 재정의된 내용을 구현.
		//kind="자동차";
		super.driving();
		// super를 통해서 상위에 정의된 멤버(구성요소)를 호출
		System.out.println("사람 4명을 태우고 속도를 100km/h로 높여 운행한다.");
	}
	@Override
	void speedUp() {
		// TODO Auto-generated method stub
		// 재정의 된 것을 반드시 실제 body가 있게 구현
		System.out.println("속도가 20km씩 증가합니다.");
		
	}
}
// 상위의 클래스를 기반으로 필드/메서드의 속성값을 변경 처리한다.
class Truck extends Vehicle{
	Truck(){
		super("트럭");
		// 하위 클래스는 상위 클래스의 생성자와 동일한 것을
		// 호출하여 사용하여야 한다.
		
	}
	
	
	
	void driving() {	
		// 메서드 오버라이딩 : 상위에 재정의된 내용을 구현.
		//kind="트럭";
		super.driving();
		// super를 통해서 상위에 정의된 멤버(구성요소)를 호출
		System.out.println("짐 2.5 ton을 싣고, 속도를 60km/h로 높여 운행한다.");
		
	}
	@Override
	void speedUp() {
		// TODO Auto-generated method stub
		System.out.println("속도가 10km씩 증가합니다.");
	}
}