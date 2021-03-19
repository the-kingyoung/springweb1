package javaexp;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;


public class A06_Path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
# Path 객체를 통한 파일 처리.
1. java.nio.file 하위에 있는 객체로 보다 파일의 처리를 
효과적으로 해준다.
2. 주요기능 메서드
	1) getFileName() : 파일 이름 가져오기
	2) getParent() : 상위 경로 정보
	3) getRoot() : root경로 정보
	4) isAbsolute() : 절대 경로 인지 여부
	5) toUri() : 브라우저에서 열수 있는 Path 반환처리
	6) resolve() : 경로를 결합하여 새로운 경로를 가져온다.
# Paths : 
1. 여러개의 파일이나 폴드를 관리하는 객체..
2. 주요기능 메서드
	1) get("파일명") 해당 파일의 Path 객체를 가져온다.
	2) toAbsolutePath() : 해당 파일의 절대 경로를 가져온다.
	3) subpath() : 하위 경로를 만들어 경로의 일부를 가져온다.
	4)
*/
		String orpath = "C:\\eclipse-workspace\\springweb\\src\\javaexp";
		String fname = "\\z02_test.txt";
		Path path = Paths.get(orpath+fname);
		System.out.println("getFileName : "+path.getFileName());
		System.out.println("getParent : " + path.getParent());
		System.out.println("getRoot : "+path.getRoot());
		System.out.println("isAbsolute : " + path.isAbsolute());
		// toUri() : 브라우저에서 열 수 있는 Path 반환
		URI ul = path.toUri();
		System.out.println(ul);
		// toAbsolutePath() : 절대경로를 사용하는 path 반환
		Path xxx = Paths.get(fname);
		Path xxx2 = xxx.toAbsolutePath();
		System.out.println(xxx2);
		// subpath : 하위 경로를 만들어 경로의 일부를 가져온다.
		Path yyy = Paths.get(orpath + fname);
		Path yyy2 = yyy.subpath(0, 3);
		System.out.println(yyy2);
		
		//resolve : 경로를 결합하여 새 경로를 생성한다.
	}

}
