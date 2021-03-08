package springdi.z01_vo;
//springdi.z01_vo.Team
import java.util.ArrayList;

public class Team {
	private String tName;
	private ArrayList<Player> pList;
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(String tName) {
		super();
		this.tName = tName;
		pList = new ArrayList<Player>();
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public void setPlayer(Player player) {
		this.pList.add(player);
	}
	public void showInfo() {
		System.out.println(tName+"팀");
		if(pList.size()>0) {
			System.out.println("선수 명단");
			for(Player player : pList) {
				System.out.print(player.getNumber()+"번\t");
				System.out.println(player.getName()+"선수");
			}
		}else {
			System.out.println("팀명단이 아직 없습니다.");
		}
	}
	public ArrayList<Player> getpList() {
		return pList;
	}
	public void setpList(ArrayList<Player> pList) {
		this.pList = pList;
	}
	
	
	
}
