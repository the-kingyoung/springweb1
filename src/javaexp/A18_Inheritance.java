package javaexp;

public class A18_Inheritance {

	public static void main(String[] args) {
		
/*
# 클래스의 상속
1. 상위에 선언된 클래스의 구성요소는 하위에서 사용할 수 있다.
2. 기본형식과 패턴
	1) 	class 상위클래스{
			상위 필드
			상위 메서드(){}
		}
	2) 	class 하위클래스 extends 상위클래스{
			하위 필드;
			하위 메서드(){}
		}
	
	3) 호출과 활용
		하위 클래스 obj1 = new 하위클래스();
		// 접근제어자의 허락되는 범위 안에서 상위크래스의 구성요소를
		// 활용할 수 있다.
		obj1.상위필드;
		obj1.상위메서드();
		obj1.하위필드;
		obj1.하위메서드();
3. 상속의 유형 3가지
	1) 상위 실제 클래스, 상위 실제 클래스 상속
		실제 클래스 : 모든 메서드에 body({})가 있는 클래스
	2) 상위 추상 클래스, 상위 실제 클래스 상속
		추상 클래스 : 상위 메서드 중에 하나라도 body가 없으면
			추상 메서드가 되고, 추상 메서드가 있는 클래스는 
			추상 클래스가 된다.
		하위 실제 클래스는 상위에 있는 추상 메서드를 반드시 
			재정의(메서드 오버라이딩)하여야 한다.
			재정의 : 상위에 있는 추상 메서드를 하위에서는 실제
			메서드로 body가 있는 정의하는 것을 말한다.
	3) 상위 인터페이스, 하위 실제 클래스 상속
		상위 인터페이스 : 추상메서드와 default메소드만 존재한다.
		하위 실제 클래스는 상위에 있는 추상메서드를 반드시
		재정의 하여야 한다.
		ex) Mybatis 프레임워크에서 인터페이스 dao 선언 부분
		으로 내부적으로 프레임워크에서 자동으로 하위 실제 클래스를
		생성해서 사용할 수 있게 한다.
4. 주요개념
	1) Polymorphism(다형성) : 상위 클래스를 참조하여 하위 객체를
		생성할 수 있다. 상위를 상속받은 모든 클래스는
		상위 클래스의 참조변수로 하위의 여러객체로 생성하는 것을 말한다.
	2) 메서드 오버라이딩(재정의) : 상위 클래스의 선언된 메서드를
		하위 클래스에서 기능에 따라서 메서드 재정의 하여 사용할 수 있다.
	3) 상속에 있는 생성자 처리 : 상위 실제 클래스를 상속 받은 하위 클래스는
		생성자에서 상위에 선언된 생성자를 반드시 선언하여야 한다.
		ex) 일반적으로 default 생성자를 상위에 선언되어 있는 경우에
		default 생성자를 호출하기에 따로 정의하지 않지만,
		상위에 매개변수가 있는 생성자만 선언되어 있는 경우에는 반드시
		하위에서 생성자(super(매개데이터))를 호출하여야 한다.
	4) 접근제어자
		상속을 하더라도 상위에 private로 정의된 필드는 직접호출하여
		사용할 수 없다.
			private는 상속하는 모든 클래스에서 사용을 할 수 없다.
		x 접근제어자가 없는 경우에는 상속관계 설정시, 같은 패키지 안에서만
		사용할 수 있다.
		
		protected로 선언한 접근제어자는 상속관계에 있으면 다른 패키지에서도
		호출하여 사용할 수 있다.
		
		
		
		
	5) final
		필드 : 상수를 의미
		메서드명 : 하위 클래스에서 재정의하지 못한다.
		클래스명 : 하위 클래스로 상속되지 못한다.
		
	
 */
		
		// 상속 클래스 사용
		Son s1 = new Son();
		System.out.println(s1.name);
		s1.call();
		System.out.println(s1.age);
		s1.call2();
	}
}
// 기본 상속
class Father{
	String name="홍판서(아버지필드)";
	void call() {
		System.out.println("부모 메서드");
	}
}
// 기본 상속은 상위에 있는 필드나 메서드를 외부에서 내부로
// 호출하여 사용할 수 있다.
class Son extends Father{
	int age=25;
	void call2() {
		System.out.println("자식 메서드");
		System.out.println("이름(내부에서 상위 필드 호출) : "
				+name);
	}
}
// 상위 추상클래스, 하위 실제클래스
abstract class Duck{
	String kind="오리";
	// 추상메서드
	abstract void fly(); 
	// body가 없는 메서드는 하나라도 있으면
	// class에서는 반드시 클래스명 앞에 abstract가 붙어야 한다.
	//
	//실제메서드
	void swim() {
		System.out.println(kind+"가 수영을 한다!!");
	}
}
class NormalDuck extends Duck{
	//상위에 있는 추상메서드는 하위에서 반드시 선언하여야 한다.
	@Override
	void fly() {
		System.out.println("보통 오리는 날지 못한다.");
	}
}
// 상위 인터페이스, 하위 실제 클래스
interface FlyWay{
	void fly();
	default void method2() {
		System.out.println("default 실제 메서드");
	}
}
// 인터페이스 implements로 상속받는다.
class Wing01 implements FlyWay{
	@Override
	public void fly() {
		System.out.println("날개 1호로 하늘을 날다!");
	}
}
// ex) 인터페이스로 SwimmingWay라고 선언하고,
//		하위에서 추상메서드 swim()를 재정의 하세요.
interface SwimmingWay{

	// 인터페이스의 구성요소
	// 1. 상수만 사용가능 하다.
	int MAX_VEL = 30; // public final이 자동으로 붙어진다.
	// SwimmingWay.MAX_VEL 형식으로 호출하여 사용된다.
	// 2. 하위에서 재정의할 추상메서드
	// 자동으로 public static final이 붙는다.
	void swim();
	// 3. default 메서드(1.8이상에서 지원된다)
	default void call() {
		System.out.println("default 메서드");
	}
	// 4. static 메서드(1.8이상에서 지원된다)
	static void call2() {
		System.out.println("정적 구상 메서드");
	}
}

class SeaSwimming implements SwimmingWay{
	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.println("바닷가에서 수영을 하다.");
	}
}