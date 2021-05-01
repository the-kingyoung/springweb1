package javaexp;

public class A20_InheritanceAccess {
	
	public static void main(String[] args) {
		
	}

}
class Son01 extends Father01{
	public void call() {
		System.out.println("## 상속 관계에서 필드의 접근 ##");
		//System.out.println("이름 : " + name);
		// 상속 관계에 있더라도 private는 직접 접근을 할 수 없다.
		System.out.println("나이 : " + age);
		System.out.println("사는 곳 : " + loc);
	}
}