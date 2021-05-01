package javaexp;

public class A16_StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
# StringBuffer api
1. String 객체의 concatㅓ리시, 메모리 비효율에
	대비하여 하나의 메모리 안에 추가적인 문자열을
	처리하는 객체를 말한다.	
	
ex) String s = "사과"; 	// heap영역 메모리 1
	s+=" 바나나";			// heap영역 메모리 2
	overflow의 원인이 된다.
2. StringBuffer를 활용하면 append()라는 메서드를
	통해서 추가적인 문자열 처리를 하더라도 같은 heap영역에서
	누적하여 데이터를 할당처리하여 String 보다
	효과적으로 메모리 관리를 할 수 있다.
	
 */
		
		StringBuffer sb = new StringBuffer("Hello");
		sb.append(" world");
		// append("추가문자열")
		System.out.println(sb);
		sb.insert(5,  "!!!!");
		// insert(인덱스위치, 위치에 문자열 추가)
		System.out.println(sb);
		sb.delete(0, 5);
		// delete(시작index, 마지막) : 해당 위치의 문자열을 삭제 처리
		System.out.println(sb);
		// ex1) 초기"Good " 
		//			문자열 추가 : bye!! 
		//			특정 위치 추가 My friend Good bye!
		//			삭제 후, 추가 welcome my friend
		StringBuffer sb1 = new StringBuffer("Good ");
//		sb1.append("bye!!!");
//		System.out.println(sb1);
//		sb1.insert(11, "My friend Good bye!");
//		System.out.println(sb1);
//		sb1.delete(11, 30);
//		System.out.println(sb1);
//		sb1.insert(11, "welcome my friend");
//		System.out.println(sb1);
		sb1.append("bye!!");
		sb1.insert(0, "My friend");
		sb1.delete(9, sb1.length());
		sb1.insert(0, "Welcome ");
		System.out.println(sb1);
		
	}

}
