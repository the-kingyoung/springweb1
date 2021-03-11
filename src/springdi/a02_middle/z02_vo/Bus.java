package springdi.a02_middle.z02_vo;
// springdi.a02_middle.z01_vo.Bus
import org.springframework.beans.factory.annotation.Autowired;

public class Bus {
	private int no;
	@Autowired
	private Passenger pass;
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bus(int no) {
		super();
		this.no = no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void goBus() {
		System.out.println("버스 번호 : "+ no);
		if(pass!=null) {
			pass.info();
		}else {
			System.out.println("탑승 승객이 없습니다.");
		}
	}

}
