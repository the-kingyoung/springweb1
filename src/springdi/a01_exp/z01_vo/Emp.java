package springdi.a01_exp.z01_vo;

public class Emp {
	private String name;

	public Emp() {
		super();
		name="홍길동(사원)";
		// TODO Auto-generated constructor stub
	}
	public void show() {
		System.out.println("이름 : "+ name);
	}
	public Emp(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
