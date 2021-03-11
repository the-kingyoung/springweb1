package springdi.a02_middle.z03_vo;
// springdi.a02_middle.z03_vo.Cpu
public class Cpu {
	private String company;
	private String spec;
	public Cpu() {
		super();
		company="삼성(기본옵션)";
		spec="3.2GHz(기본옵션)";
		// TODO Auto-generated constructor stub
	}
	public Cpu(String company, String spec) {
		super();
		this.company = company;
		this.spec = spec;
	}
	public void info() {
		System.out.println(company+"\t"+spec);
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	

}
