package springdi.z99_0309;
//springdi.z99_0309.Player
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
	public void showInfo() {
		System.out.println("# 선수 정보 #");
		System.out.print(name + "\t");
		System.out.print(number + "\n");
	}
}