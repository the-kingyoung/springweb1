package springdi.a01_exp.z01_vo;
//springdi.a01_exp.exp0308.z01_vo.Team

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
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public void setPl2(Player player) {
		this.player=player;
	}
	public void showInfo() {
		System.out.println(tName+"팀");
		if(player!=null) {
			player.showInfo();
		}

	}
	
	
	
}
