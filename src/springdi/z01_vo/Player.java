package springdi.z01_vo;

public class Player {
	private String name;
	private String number;
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
