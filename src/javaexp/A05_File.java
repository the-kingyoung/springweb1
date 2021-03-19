package javaexp;

import java.io.File;

public class A05_File {

	public static void main(String[] args) {
		/*
		ex) z01_text/z02_test.txt 임의의 데이터로 파일 저장하고
			해당 파일정보를 읽어 오고, 해당 폴드의 파일의 리스트를 읽어오고,
			마지막으로 삭제 처리하세요.
		C:\eclipse-workspace\springweb\src\javaexp\z01_test\z02_test.txt
		*/
				try {
					String orpath = "C:\\eclipse-workspace\\springweb\\src\\javaexp";
					String mkDir = "\\z02_test";
					boolean b = new File(orpath+mkDir).mkdir();	//디렉토리 생성
					String path = orpath+mkDir;
					for(int cnt=1; cnt<10; cnt++) {
						File f = new File(path,"z"+cnt+"_test.txt");
						f.createNewFile();	//파일 생성 처리.
						System.out.println(f.getName());
						System.out.println(f.exists());
						System.out.println(f.getPath());
						System.out.println(f.length());
					}
					System.out.println(File.separator);
					boolean b2 = new File(path,"z1_test.txt").delete();
					//파일 삭제 처리./
					String [] listing = new File(path).list();
					//해당 경로에 있는 파일명 리스트
					for(String str : listing) {
						System.out.println("현재 폴더내용 : " + str);
					}
				}catch(Exception e) {e.printStackTrace();}
	}
}
