package javaexp;

public class A21_InheritFinal {
/*
5) final
	필드 : 상수를 의미
	클래스명 : 하위 클래스로 상속되지 못한다.	
	메서드명 : 하위 클래스에서 재정의하지 못한다.
 */
	public static void main(String[] args) {
		
	}

}
final class Son02{
	public void call() {
		System.out.println("메서드1");
	}
}
// Son02가 final 클래스이기 때문에 상속을 받지 못한다.
//class GrandSon extends Son02{
	
//}
class Son03{
	public void call01() {
		System.out.println("일반 메서드");
	}
	public final void call02() {
		System.out.println("final 메서드!!");
	}
}
class GrandSon extends Son03{
	public void call01() {	// 메서드를 재정의가 가능하다.
		super.call01();
		System.out.println("추가한 내용!!");
	}
	// final이 붙은 메서드는 하위 클래스에서 메서드를 재정의하지 못한다.
//	public void call02() {

//	}
}
