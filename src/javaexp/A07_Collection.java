package javaexp;

import java.util.ArrayList;
import java.util.List;

import springdi.z01_vo.Person;
import springdi.z01_vo.Product;

public class A07_Collection {
/*
# Collection 프레이뭐크
1. 인터페이스와 클래스로 구성되어 있다.
2. 인터페이스는 컬렉션에서 수행할 수 있는 각종 연산을 제네릭 타입으로
	정의해 유사한 클래스에 일관성 있게 접근하게 할 수 있다.
3. 인터페이스와 구현 클래스
	1) List : 객체의 순서가 있고, 원소가 중복될 수 있다.
		ArrayList, Stack, Vector, LinkedList
	2) Queue : 객체를 입력한 순서대로 저장하여, 원소가 중복될 수 있다.
		DelayQueue, PriorityQueue, LinkedList
	3) Set : 객체의 순서가 없으며, 동일한 원소를 중복할 수 없다.
		HashSet, TreeSet, EnumSet
4. 주요 메서드(공통메서드)
	add : 객체를 맨 끝에 추가한다.
	clear() : 저장된 모든 객체를 제거한다.
	contains() : 명시한 객체의 저장 여부를 조사한다.
	isEmpty() : 리스트가 비어있는지 조사한다.
	iterator() : iterator를 반환한다.
	remove() : 명시한 첫번째 객체를 제거하고, 저장 여부를 반환한다.
	size() : 저장된 전체 객체의 갯수를 반환한다.
	toArray : 리스트 배열로 반환한다.
	
# List 컬렉션
1. 순서가 있는 객체를 중복 여부와 상관없이 저장하는 리스트 자료 구조를 지원한다.
2. 배열과 매우 유사하지만 크기가 가변적이고 원소의 순서가 있으므로 원소를 저장하거나
	읽어올 때 인덱스를 사용한다.
3. 주요메서드
	get(index) : 인덱스로 가져온다.
	indexOf(Object) : 명시한 객체가 있는 첫번째 인덱스를 반환한다.
	remove(index) : 해당 인덱스에 있는 객체를 제거한다.
	set(idx, 요소객체) : 해당 인덱스에 객체를 대체한다.
	subList(from,to) : 범위에 해당하는 객체를 리스트로 반환한다.
*/
	
	
	
	public static void main(String[] args) {
		
		// 1. 기본 ArrayList 객체 선언(List(상위) = 하위 ArrayList)
		//		인터페이스 = 실제객체
		//		List<객체> : 선언하지 않거나 <Object>로 선언하면,
		//			기본적으로 모든 객체를 할당하여 사용할 수 있다.
		List<Object> list = new ArrayList<>();
		list.add("안녕하세요");
		list.add(null);
		list.add(new Integer(25));
		list.add(new Person("홍길동",25,"서울 강남"));
		// 특정한 위치에 추가하려면 .add(위치, 추가할객체)
		list.add(1,"반가워요");
		//	해당 위치에 객체가 추가되면, 그 위치 이후로 모든 객체를 자동으로
		//	index가 증가되는 것을 볼 수 있다.
		//	.size() : 크기,
		//	.get(index) : 특정위치에 있는 객체
		for(int idx=0;idx<list.size(); idx++) {
			Object o = list.get(idx);
			System.out.println(o);
		}
		// 요소객체가 Object이기에 Person객체를 typecasting 필요
		Person p02 = (Person)list.get(4);
		System.out.println("타입 캐스팅 후, Person 객체 호출");
		System.out.println(p02.getName());
		System.out.println(p02.getAge());
		System.out.println(p02.getLoc());
		
		// ex) list2로 ArrayList객체를 선언하고,
		//		이름문자열, 배열객체, Double, Product 객체를 할당하고
		//		출력처리하세요
		List<Object> list2 = new ArrayList<>();
		list2.add("홍길동");
		list2.add(new int[]{25,30,40,70});
		list2.add(1, new Double(30.7));
//		list2.add(2, new Product("사과",3000,2));
		
		for(int idx=0; idx<list2.size(); idx++) {
			Object o1 = list2.get(idx);
			System.out.println(o1);
		}
		// 위와 같이 List<Object>는 선형으로 모든 객체를 할당할 수 있다.
		// 그렇지만, 해당 객체의 고유한 특정을 사용하기 위하여 아래와 같이
		// typecastring이 필요로 한다.
		int[] arry = (int[])list2.get(2);
		
		for(int num : arry) {
			System.out.println("번호:"+num);
		}
//		Product p01 = (Product) list2.get(3);
//		System.out.println(p01.getPname());
//		System.out.println(p01.getPrice());
//		System.out.println(p01.getCnt());
		// ex) list객체의 내용 typecasting하여 해당 속성값을 출력 처리하세요.
		
/*
# generic
1. ArrayList나 default로 특정한 Object형 데이터를 받는 부분을
초기에 데이터 유형을 <데이터유형>을 선언해 놓음으로 typecasting을 하지 않고도
효과적으로 데이터를 처리할 수 있게 하는 것을 말한다.
 */
		// 정수형 객체만 들어올 수 있게 처리하는 generic선언.
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(new Integer(30));
		intList.add(40); 
		// boxing처리 개념으로 가능함 Integer i = 25;
		intList.add(70);
		intList.add(50);
		System.out.println("list된 데이터 확인");
		for(int num:intList) {
			// unboxing 개념으로 wrapper 클래스에 있는 데이터를
			// 숫자형으로 할당 가능 int num01 = new Integer(25);
			System.out.println(num);
		}
		// 객체형데이터..
		ArrayList<Person> plist = new ArrayList<Person>();
		plist.add(new Person("홍길동",25,"서울 방배동"));
		plist.add(new Person("신길동",23,"서울 청담동"));
		plist.add(new Person("마길동",22,"서울 신림동"));
		plist.add(new Person("오길동",27,"서울 서초"));
		// 특정한 위치에 있는 객체를 변경 처리..
		plist.set(0, new Person("김현정",25,"경기 동탄"));
		// Generic으로 인해 typecasting 필요없이 객체를 바로 활용할 수 있다.
		for(Person p : plist) {
			System.out.print(p.getName()+"\t");
			System.out.print(p.getAge()+"\t");
			System.out.print(p.getLoc()+"\n");
			
		}
		
		
		
		
	}
}
