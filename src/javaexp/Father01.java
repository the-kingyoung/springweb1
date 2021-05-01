package javaexp;

public class Father01{
	private String name="홍길동";
	int age = 25;
	protected String loc = "서울 신림동";
	public void call() {
		System.out.println("## 상속 관계에서 필드의 접근 ##");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("사는 곳 : " + loc);
	}
	
}
