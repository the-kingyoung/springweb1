package springdi.z01_vo;

import java.util.ArrayList;
//springdi.z01_vo.Computer1
public class Computer1 {
	private String company;
	private ArrayList<Compart> partList;
	public Computer1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Computer1(String company) {
		super();
		this.company = company;
		partList = new ArrayList<Compart>();
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	// 하나씩 추가하는 메서드 구현 
	public void setPart(Compart compart) {
		this.partList.add(compart);
	}
	// 출력하는 메서드 
	public void showInfo() {
		System.out.println(company+" 컴퓨터");
		if(partList.size()>=0) {
			System.out.println("장착된 부품들");
			for(Compart part: partList) {
				System.out.println(part.getName()+"\t");
				System.out.println(part.getSpec()+"\n");
			}
		}else {
			System.out.println("부품이 장착되어 있지 않습니다.");
		}
		
	}
	
	public ArrayList<Compart> getPartList() {
		return partList;
	}
	public void setPartList(ArrayList<Compart> partList) {
		this.partList = partList;
	}
	
	
	
	
}