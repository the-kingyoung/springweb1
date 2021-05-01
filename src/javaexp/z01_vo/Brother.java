package javaexp.z01_vo;

import javaexp.Father01;

public class Brother extends Father01 {
	public void call() {
		System.out.println("## 상속 관계에서 필드의 접근 ##");
//		System.out.println("이름 : " + name);
//		상속 관계에 있더라도 private는 직접 접근을 할 수 없다.	
//		System.out.println("나이 : " + age);
//		상속 관계에 있더라도 default는 같은 패키지에서만 활용할 수 있다.		
		System.out.println("사는 곳 : " + loc);
//		protected 이상은 다른 패키지이더라도 사용이 가능하다.
	}
}
