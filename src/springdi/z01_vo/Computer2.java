package springdi.z01_vo;

//springdi.z01_vo.Computer2
public class Computer2 {
	private String company;
	private Compart part;
	
	public Computer2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Computer2(String company) {
		super();
		this.company = company;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	// 하나씩 추가하는 메서드 구현 
	// autowire="byName"일 때, id="part2"로 설정되어 있을 떄
	// type이 같을 때 해당 객체를 할당 처리한다.
	
	public void setPart2(Compart compart) {
		part=compart;
	}
	// 출력하는 메서드 
	public void showInfo() {
		System.out.println(company + " 컴퓨터");
		if (part != null) {
			System.out.println("장착된 부품들");
			System.out.println(part.getName() + "\t");
			System.out.println(part.getSpec() + "\n");

		} else {
			System.out.println("부품이 장착되어 있지 않습니다.");
		}
	}

}