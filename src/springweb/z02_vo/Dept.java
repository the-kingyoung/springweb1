package springweb.z02_vo;
// springweb2.a01_mvc.z01_vo.Dept
public class Dept {
	private String deptno;
	private String dname;
	private String loc;
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept(String deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	

}
