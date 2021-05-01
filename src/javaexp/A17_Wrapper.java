package javaexp;

import java.util.ArrayList;
import java.util.List;

public class A17_Wrapper {
	
	public static void main(String[] args) {
		
/*
# Wrapper 객체란?
1. 기본 타입 (byte, char, short, int, long, float, double, boolean)
		값을 내부에 두고 포장하는 객체
		- 대부분 객체형으로 변환하기에 대문자로 시작
		byte ==> Byte
		short ==> Short
		- 문자열이 차이가 나는 객체도 있다.
		char ==> Character
		int ==> Integer
2. 객체화하여 처리하는 순간, 객체의 기능 메서드를 통해서 형변환 등
	여러가지 기능 처리가 가능해진다.
	ex) 숫자형태의 문자열 ==> 숫자
	Integer.parseInt("25") ==> 25
3. 객체형으로만 할당되는 데이터를 BOXING, UNBOXING 개념으로 데이터를
	처리할 수 있다.
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.add(new Integer(25)); 
	list.add(25); 
		Integer i = 25; 식으로 기본데이터 타입이 Boxing으로 객체로
		자동변환되어 할당했기 때문에 가능하다..
	list.add(30);
	list.add(40);
		Wrapper로 처리된 객체화된 25를 unboxing하여 다시 기본 데이터
		타입으로 할당 처리된 것을 말한다.
		
		int num01 = list.get(1);
		==> int num01 = new Integer(30);
	1) boxing : 기본 타입의 값을 포장 객체로 만드는 과정
	2) unboxing : 포장 객체에서 기본 타입의 값을 얻어내는 과정		
 */
		// 자동 박싱 : 포장 클래스 타입에 기본값이 대입될 경우 발생
		Integer obj01 = 100;
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		// 자동 언박싱 : 기본 타입에 포장 객체가 대입된 경우 발생
		Integer obj02 = new Integer(100);
		int num02 = obj02;
		int num03 = obj02 + 100;
		// ex) double의 Wrapper클래스를 활용하여,
		// ArrayList형태로 boxing과 unboxing 처리를 하고, 
		// Double, double 자체로 boxing과 unboxing 처리를
		// 해보세요.
		
		ArrayList<Double> dlist = new ArrayList<Double>();
		// boxing 처리..
		dlist.add(10.1);
		dlist.add(10.2);
		dlist.add(10.3);
		
		Double obj03 = new Double(10.4);
		double num04 = 10.7; // boxing 처리
		double num05 = obj03;// unboxing 처리
		double num06 = dlist.get(0); // unboxing
/*
# 문자열을 기본 타입으로 변환 처리해주는 기능 메서드
1. parse + 기본타입명 ==> 정적 메소드
 */
		byte num07 = Byte.parseByte("10");
		float num08 = Float.parseFloat("2.5F");
		boolean bool = Boolean.parseBoolean("true");
		System.out.println("형변환 후 연산 : " + (num07+20));
		System.out.println("형변환 후 연산 : " + (num08+20));
		if(bool) {
			System.out.println("조건문1");
		}else {
			System.out.println("조건문2");
		}
		// ex) args 값을 2개를 args[0], args[1]
		//		을 하나는 float에 하나는 double에 형변환하여
		//		할당한 후, 합산처리하여 출력하세요.
		double dnum = Double.parseDouble(args[0]);
		float fnum = Float.parseFloat(args[1]);
		double sum = dnum = fnum;
		System.out.println("합산:"+sum);
// 숫자형을 문자열로 형변환처리.
// 1) String.valueOf(기본유형데이터);
// 2) "" + 기본유형데이터
		String stnum01 = String.valueOf(true);
		System.out.println(stnum01);
		String stnum02 = String.valueOf('A');
		String stnum03 = ""+35.7;
		System.out.println(stnum02);
		System.out.println(stnum03);
		
		
		
		
		
		
	}

}
