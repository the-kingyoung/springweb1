package javaexp;

import java.util.ArrayList;

import javaexp.z01_vo.Person;
import javaexp.z01_vo.Product;

public class A15_Generic {
	
	public static void main(String[] args) {
	
/*
# 제너릭 타입
1. 컴파일 단계에서 잘못된 타입 사용될 수 있는 문제를 제거할 수 있게한다.
	- 실행 시 타입 에러가 나는 것을 방지한다.
2. 타입변환
	List list = new ArrayList();
	// Object타입이기에 모든 객체가 할당이 가능하다.
	list.add(new Person());
	list.add(new int[]{});
	list.add("hello");
	// 사용하고자 할 때도 typecasting이 필요하다.
	Person p = (Person)list.get(0);
	int[] arry = (int[])list.get(1);
	String str = (String)list.get(2);
	
	사전에 할당가능한 type을 지정해서 타입전환이 필요없게 처리한다.
	List<String>list2 = new ArrayList<String>();
	list2.add("홍길동");
	list2.add("신길동");
	list2.add("김길동");
	String str1 = list.get(0);	// typecasting이 필요 없음.
	String str2 = list.get(1);	// typecasting이 필요 없음.
	String str3 = list.get(2);	// typecasting이 필요 없음.
	1) 위에 예제와 같이
		Object 타입 사용 --> 빈번한 타입 변환 발생
		--> 프로그램 성능 저하
		
3. 기본 형식
	1) 타입을 파라미터로 가지는 클래스와 인터페이스
		public class Box<T>{}
	2) 선언 시 클래스 또는 인터페이스 이름 뒤에 "<>" 부호를 붙인다.
	3) "<>" 사이에 타입 파라미터 위치
		public class Box<String>{}
		public class Box<Integer>{}
		
		Box<String> box = new Box<String>();
		Box<Integer> box2 = new Box<Integer>();
*/
		ArrayList list = new ArrayList();
		list.add(new Person("홍길동",25,"서울"));
//		list.add(new Integer(25));
		list.add("hello");
		// generic을 쓰지 않으면 typecasting이 필요하다.
		Person p = (Person)list.get(0);
		System.out.println(p.getName());
		// 데이터유형<타입선언>
		ArrayList<Person> plist = new ArrayList<Person>();
		plist.add(new Person("김길동",27,"경기"));
		// generic를 활용해서 바로 객체를 사용할 수 있다.
		Person p2 = plist.get(0);
		System.out.println(p2.getName());
		
		// ex) Product를 ArrayList로 generic으로 선언한 경우
		//	와 그렇지 않는 경우를 .add()통해서 할당하고,
		//	호출처리하세요.
		
		ArrayList prolist = new ArrayList();
		prolist.add(new Product("사과",3000,3));
		Product pro = (Product)prolist.get(0);
		System.out.println(pro.getName());
		
		ArrayList<Product> prolist1 = new ArrayList<Product>();
		prolist1.add(new Product("바나나",6000,2));
		Product pro2 = prolist1.get(0);
		System.out.println(pro2.getName());
		
		
		
		// class Box<T>
		// 1. 문자열을 할당할 수 있는 객체 생성..
		Box<String> box = new Box<String>("문자열처리");
		box.setT("안녕하세요");
		System.out.println(box.getT());
		// 2. 숫자형 Wrapper를 할당할 수 있는 객체 생성.
//		Box<Integer> box2 = new Box<Integer>("숫자형처리");
//		box2.setT(25);
//		System.out.println(box2.getT());
/*
ex) Bus 여러 객체가 할당할 수 있도록 T generic를 선언하고,
	할당된 필드를 출력 처리하세요.
 */

		Bus<String> bstr = new Bus<String>("이름 할당");
		bstr.getOn("홍길동");
		bstr.getOn("신길동");
		bstr.getOn("마길동");
		System.out.println(bstr.getName());
		for(String s : bstr.getPass()) {
			System.out.println(s);
		}
		Bus<Person> bPerson = new Bus<Person>("Person 객체");
		bPerson.getOn(new Person("홍길동",25,"서울"));
		bPerson.getOn(new Person("신길동",27,"광주"));
		bPerson.getOn(new Person("마길동",25,"대구"));
		bPerson.getOn(new Person("오길동",23,"제주"));
		System.out.println(bPerson.getName());
		for(Person pe : bPerson.getPass()) {
			System.out.println(pe.getName()+", "+pe.getAge()+", "+pe.getLoc());
		}
	}

}
class Bus<T>{
	private ArrayList<T> pass;
	private String name;
	public Bus(String name) {
		super();
		pass = new ArrayList<T>();
		this.name = name;
	}
	public ArrayList<T> getPass() {
		return pass;
	}
	public String getName() {
		return name;
	}
	public void getOn(T t) {
		this.pass.add(t);
	}
	
	
}
/*
# class에서 제너릭 타입 사용 처리..
1. 클래스를 선언할 때, 타입 파라미터를 사용
	ex) public class 클래스명<T>
2. 컴파일 시, 타입 파라미터가 구체적인 클래스로 변경하여
	가변적으로 여러 클래스를 활용할 수 있다.
		private T t;
		// 해당하는 클래스 안에 있는 필드가 가변적으로 처리.
		public T get(){
			return t;
		}
		public void set(T t){
			this.t = t;
		}
	
*/
// 가변적은 필드값 T를 담을 수 
class Box<T>{
	private T t;
	private String name;

	public Box() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Box(String name) {
		super();
		this.name = name;
	}


	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}
