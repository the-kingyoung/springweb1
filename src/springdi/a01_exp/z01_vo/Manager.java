package springdi.a01_exp.z01_vo;

public class Manager {
	private String name;

	public Manager() {
		super();
		name="신과장(관리)";
		// TODO Auto-generated constructor stub
	}
	public void show() {
		System.out.println("이름 : "+ name);
	}
	public Manager(String name) {
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
