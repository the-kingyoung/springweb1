package springdi.a01_exp.z01_vo;

import org.springframework.beans.factory.annotation.Autowired;

public class Company {
	private String name;
	@Autowired(required=false)
	private Ceo ceo;
	@Autowired(required=false)
	private Manager manager;
	@Autowired(required=false)
	private Emp emp;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
		name="행복한 회사";
	}
	public void show() {
		System.out.println("# 회사 정보 #");
		System.out.println(name);
		if(ceo!=null) ceo.show();
		if(manager!=null) manager.show();
		if(emp!=null) emp.show();
	}
	public Company(String name) {
		super();
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
