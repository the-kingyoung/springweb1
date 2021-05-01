package javaexp;

public class A14_String {

	public static void main(String[] args) {
		
/*
# String 객체가 지원하는 메서드
1. cacat() : 문자열을 이어주는 역할
2. replace() : 문자열을 대체 처리.
3. substring() : 부분 문자열 추출
4. toLowerCase() : 소문자 변환
5. toUpperCase() : 대문자 변환
6. endsWith() : 끝나는 문자열 비교
7. charAt() : 인덱스의 문자 출력
8. length() : 문자열 길이
9. indexOf() : 해당 문자열의 위치 출력
10. trim() : 공백제거
11. split() : 구분자로 문자열을 분리해서 배열로 처리
12. valueOf() : 특정데이터를 문자열 형식으로 변환.
13. format() : 문자열 format형식으로 데이터 할당.
 */
		String str1 = "abcde";
		String str2 = "Hello             ";
		String str3 = "홍길동/이순신/유관순";
		System.out.println(str1.concat("test")); // 문자열 연결
		System.out.println(str1.replace('a', 'c'));
		System.out.println(str1.substring(2,4));
		System.out.println(str1.toLowerCase());
		System.out.println(str1.toUpperCase());
		// 끝나는지 여부를 확인해서 boolean값 리턴 처리
		System.out.println(str1.endsWith("cde"));
		// 특정 위치에 있는 문자열 출력.
		System.out.println(str1.charAt(3));
		// ex) 주민번호를 위에 있는 기능 메서드를 활용해서
		// 생년월일/남녀를 출력처리하세요.
		// 	921215-1802715
		String civilNum = "930818-1802715";
		String yyyy = "19".concat(civilNum.substring(0,2));
		String mm = civilNum.substring(2,4);
		String dd = civilNum.substring(4,6);
		String gender = civilNum.charAt(7)=='2'?"여자":"남자";
		System.out.println(yyyy+"년 "+mm+"월 "+dd+"일생 "+gender);
		
		System.out.println(str1.length());// 문자열 길이
		System.out.println(str1.indexOf("a")); // 해당 문자열의 위치
		System.out.println(str1.indexOf("x")); // 검색되지 않으면 -1
		System.out.println(str2.trim()); // 공백제거
		String [] names = str3.split("/"); // 구분자로 문자열 분리
		for(int idx=0; idx<names.length; idx++) {
			System.out.println(names[idx]);
		}
		System.out.println(String.valueOf(123));
		System.out.println(String.valueOf(3.14));
		System.out.println(String.valueOf(true));
		// %s : 문자열, %d : 정수, %.2f 소수점이하의 자리수 지정 표현
		String formatStr = String.format("이름은 %s,"
		+" 나이는 %d, 키는 %.2f","홍길동",20,180.2);
		System.out.println(formatStr);
		
	}
}
