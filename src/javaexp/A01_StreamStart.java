package javaexp;

import java.io.IOException;
import java.io.InputStream;

public class A01_StreamStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
# 파일을 처리하기 위한 객체..
1. Stream
	1) 연속된 데이터의 단방향 흐름을 추상화하는 것을 말한다.
	2) 데이터 소스와 상관없이 적용할 수 있어 매우 효과적
	3) 스트림의 예
		키보드 및 모니터의 입출력
		프로그램과 외부 장치, 파일의 입출력에서 데이터 흐름도 스트림
		네트워크와 통신하는 데이터의 흐름 
		ex) 브라우저 화면에 html코드 전달도 스트림을 통해서 처리된다.
		데이터 집합체의 각 원소를 순회하면서 람다식으로 반복 처리되는 데이터 흐름
2. 입출력 스트림의 특징
	1) 선입선출(FIFO) 구조라서 순차적으로 흘러가고 순차적으로 접근
	2) 임의 접근 파일 스트림을 제외한 모든 스트림은 단방향
	3) 입출력 스트림은 객체(InputStream, OutputStream 상위로 하위 객체)
	4) 출력 스트림과 입력 스트림을 연결해서 파이프라인 구성 가능
		ex) 다른 파일의 내용을 읽어서 화면에 출력 처리
		ex) 특정 경로의 파일을 stream으로 읽어와서 네트워크를 통해 다른
			위치에 다시 저장 처리.
	5) 지연가능. 프로그램에 연결한 출력 스트림에 데이터가 가득 차면 프로그램을
		더 이상 출력할 수 없어 빈 공간이 생길 때까지 지연되며,
		데이터 소스에 연결한 입력 스트림도 가득 차면 프로그램이
		데이터를 처리해서 빈 공간이 생길 때까지 스트림이 지연된다.
		ex) buffedstream 객체를 활용하여 이 차이를 해소한다.
3. 바이트 스트림과 문자 스트림
	바이트 스트림 : inputstream, outputstream
	문자 스트림 : reader, writer
4. InputStream과 OutputStream
	1) 모든 자식 바이트 스트림에서 공통으로 사용하는 메서드를 포함한
		바이트 스트림의 최상위 클래스
	2) 각각 read()와 writer()라는 추상 메서드를 포함
	3) 바이트 스트림 클래스가 제공하는 주요 메서드
5. InputStream과 OutputStream
	read() 메서드의 반환값은 0~255의 ASCII 값이며,
		더 이상 읽을 데이터가 없을 때는 -1을 반환
	read() 메서드는 int 타입을 반환
	writer() 메서드에서 인수가 배열일 때는 byte[], 배열이 아닐 때는
		int타입
	대부분의 운영체제나 JVM은 표준 출력 장치를 효율적으로 관리하려고
		버퍼를 사용
	BufferedStream이 아니지만 System.out은 표준 출력이므로 버퍼를 사용
	System.out을 사용해 출력할 대는 버퍼를 비우기 위하여 flush()호출 필요
	
6. FileInputStream 및 FileOutputStream
시스템에 있는 모든 파일을 읽거나 쓸 수 있는 기능을 제공
생성자로 스트림 객체를 생성할 때는 FileNotFoundException 예외 가능성이 
있기 때문에 반드시 예외 처리 필요
7. BufferedInputStream 및 BufferedOutputStream
버퍼는 스트림과 프로그램 간에 데이터를 효율적으로 전송하려고 사용하는 메모리
입출력 장치와 프로그램 간 동작 속도가 크게 차이가 날 때 버퍼를 사용하면 매우 효율적
8. DataInputStream 및 DataOutputStream
	1) 각각 기초 타입 데이터를 읽는 메서드와 기초 타입 데이터를 
		기록하는 메서드를 사용할 수 있는 스트림
	2) 직접 키보드에서 데이터를 입력 받거나 콘솔 뷰에 데이터를 출력하기에는 부적합
	FileInputStream 및 FileOutputStream 등 다른 스트림과 연결해서
	파이프라인을 구성해 사용
9. 문자 스트림
데이터를 2바이트 단위인 유니코드로 전송하거나 수신하는데, 이진데이터로 된 이미지나
동영상 파일보다는 한글처럼 언어로 된 파일을 처리할 때 유용
Reader와 Writer는 객체를 생성할 수 없는 추상 클래스이기 때문에 Reader와
Writer의 자식인 구현 클래스를 사용
FileReader와 FileWriter는 파일 입출력 클래스로, 파일에서 문자 데이터를
읽거나 파일에 문자 데이터를 저장할 때 사용
InputStreamReader 및 OutputStreamWriter는 바이트 스트림과 문자
스트림을 연결하는 브리지 스트림으로 사용
BufferedReader와 BufferedWriter는 데이터를 효율적으로 전송하려고
버퍼로 처리할 때 사용
10. Reader와 Writer
   추상 메서드인 read(), close()와 write(), flush(), close()를 각각 포함하는 추상 클래스
   문자 스트림 클래스가 제공하는 주요 메서드
*/
		// 1. 기본 inputstream 선언.(1byte 내에서 입력 가능)
		InputStream is = null;
		System.out.println("데이터를 입력하세요:");
		// 키보드를 통해서 자바의 기본 입력장치(console)에 입력 처리
		is = System.in;
		try {
			int n = is.read();
		// 입력 받은 내용을 int로 가져온다. io발생
		// io발생시에는 반드시 예외처리 해준다.
		// 읽은 내용을 문자로 변환 출력
			System.out.println("입력된 값: "+(char)n);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();// 자원해제
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

}
