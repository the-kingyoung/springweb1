package javaexp;
/*
# enum의 구성요소 설정
1. 생성자 선언
	enum 이름{
		변수명("할당할데이터"),....	
			
		할당할 필드값;
	
		이름(초기값){
			필드값
		}
	}


2. 기능메서드 선언.
	enum 이름{
		변수명,.....
		메서드명(){
		
		}
	
	}


*/


enum Family{
	FATHER("아빠"), MOTHER("엄마"), SON("아들"),
	DAUGHTER("딸");
	private String kor;
	Family(String kor){
		this.kor = kor;
	}
	public String getKor() {
		return kor;
	}
}

enum Emp2{
	홍길동(7780), 김길동(7781), 신길동(7782);
	private int empno;
	Emp2(int empno){
		this.empno=empno;
	}
	public int getEmpno() {
		return empno;
	}
	
}

// ex) Emp enum변수를 선언하고 
//		사원번호와 사원이름을 enum으로 연결하여 출력되게 하세요.
// 
public class A11_EnumStructor {
	
	public static void main(String[] args) {
		
		Emp2 emp = Emp2.신길동;
		System.out.println(emp+":"+emp.getEmpno());
		
		for(Emp2 emp2:Emp2.values()) {
			System.out.println(emp2.ordinal()+1+":"+emp2+":"+emp2.getEmpno());
		}
		
		
		Family cur = Family.MOTHER;
		System.out.println(cur+":"+cur.getKor());
	}

}
