package springdi.z01_vo;

public class Computer {
	private String name;
	private Cpu cpu;
	private Ram ram;
	private Hdd hdd;
	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void showInfo() {
		System.out.println("컴퓨터 제품을 구매하였습니다.");
		if (cpu != null && ram != null && hdd != null) {
			System.out.println("컴퓨터명 " + name + "에 포함된");
			System.out.println("Cpu 이름은 " + cpu.getName() + ", 사양은 " + cpu.getAbility());
			System.out.println("Ram 이름은 " + ram.getName() + ", 사양은 " + ram.getAbility());
			System.out.println("Hdd 이름은 " + hdd.getName() + ", 사양은 " + hdd.getAbility());
			System.out.println("입니다.");
		} else{
			System.out.println("아직 제품을 모두 구매하지 못했습니다.");
		}
	}
	public Computer(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Cpu getCpu() {
		return cpu;
	}
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	public Ram getRam() {
		return ram;
	}
	public void setRam(Ram ram) {
		this.ram = ram;
	}
	public Hdd getHdd() {
		return hdd;
	}
	public void setHdd(Hdd hdd) {
		this.hdd = hdd;
	}
	

}
