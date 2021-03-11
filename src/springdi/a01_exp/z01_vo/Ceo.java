package springdi.a01_exp.z01_vo;

public class Ceo {
	private String name;

	public Ceo() {
		super();
		name="마대표(ceo)";
		// TODO Auto-generated constructor stub
	}
	public void show() {
		System.out.println("이름 : "+ name);
	}
	public Ceo(String name) {
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
