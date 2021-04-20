package javaexp;

import java.util.Set;
import java.util.TreeSet;

public class A08_Set {
	
	public static void main(String[] args) {
		
		/*
# Set 컬렉션
1. 순서가 없으며, 중복되지 않는 객체를 저장하는 자료구조 지원
2. 추가된 메서드는 없지만 중복되는 요소는 배제 처리.
3. 인덱스가 없어 저장 순서가 무시된다.
		 */
		Set<String> s01 = new TreeSet();
		s01.add("사과");
		s01.add("바나나");
		s01.add("딸기");
		s01.add("오렌지");
		s01.add("수박");
		
		System.out.println(s01);
		// ex) Integer로 된 사원번호 정수형 4자리 수를 set객체에
		// 할당하고, 출력하세요..
		Set<Integer> p01 = new TreeSet();
		p01.add(1943);
		
		System.out.println(p01);
	}

}
