package springdi.z99_0309;
//springdi.z99_0309.Team

public class Team {
	private String tName;
	private Player player;
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(String tName) {
		super();
		this.tName = tName;
	}
	public void setPl2(Player pl) {
		player=pl;
	}
	public void showInfo() {
		System.out.println(tName+"팀");
		if(player!=null) {
			System.out.println("선수 명단");
			player.showInfo();
		}else {
			System.out.println("팀명단이 아직 없습니다.");
		}
	}
}
