package javaexp;

import javaexp.z01_vo.Person;
import javaexp.z01_vo.Product;

public class A13_Clone {

	public static void main(String[] args) {
		
/*
# 객체의 메모리 할당과 복사처리.
1. 객체는 참조변수로 할당하면 동일한 메모리를 사용하게 된다.
 */
	
		int []intArr1 = {1,2,3,4,5};
		System.out.println("# intArr1의 데이터 #");
		for(int num:intArr1) {
			System.out.print(num+",");
		}
		// 참조변수를 다른 변수에 할당하면 해당 heap영역의
		// 객체는 동일한 객체를 사용하게 된다.
		int [] intArr2 = intArr1;
		// clone()메서드를 통한 객체 생성
		int [] intArr3 = intArr1.clone();
		System.out.println();
		System.out.println("# intArr2의 데이터 #");
		for(int num:intArr2) {
			System.out.print(num+",");
		}
		intArr2[0]=50;	// intArr1에 영향 미쳐서 데이터 변경 됨.
		System.out.println();
		System.out.println("# intArr2의 변경 후, intArr1의 데이터");
		for(int num:intArr1) {
			System.out.print(num+",");
		}
		System.out.println();
		System.out.println("# clone()의 처리는 객체" + "intArr3 #");
		// intArr3은  intArr2의 변경에 영향을 받지 않고,
		// 새로운 메모리로 할당하여 사용이 가능하다.
		for(int num:intArr3) {
			System.out.print(num+",");
		}
		// ex) javaexp.z01_vo 하위에 Person 클래스를
		// 선언하고, 이름/나이/사는 곳을 설정하여,
		// p01객체를 만들었을 때, p02 참조변수만 할당한 것과
		// .clone()으로 p03객체를 만든 것의 차이점을 
		// p01속성값을 변경함으로 확인을 하세요.
		Person p1 = new Person("홍길동",25,"서울 신림동");
		Person p2 = p1;
		try {
			Person p3 = p1.clone();
			p2.setName("마길동");
			System.out.println();
			System.out.println("p1의 주소 : " + p1+p1.getName());
			System.out.println("p2의 주소 : " + p2+p2.getName());
			System.out.println("p3의 주소 : " + p3+p3.getName());
			// z01_vo.Product(물건명/가격/갯수)
			//		clone()메서드 재정의 처리
			//	prod1, prod2, prod3 처리 확인
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Product prod1 = new Product("사과", 3000,3);
		Product prod2 = prod1;
		try {
			Product prod3 = prod1.clone();
			prod2.setName("바나나");
			System.out.println();
			System.out.println("prod1의 주소 : " + prod1+prod1.getName());
			System.out.println("prod2의 주소 : " + prod2+prod2.getName());
			System.out.println("prod3의 주소 : " + prod3+prod3.getName());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
