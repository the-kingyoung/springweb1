package jspexp.z01_vo;

import java.util.Date;

public class Member1 {
	private String id;
	private String pass;
	private String name;
	private Date regdte;
	private Date uptdate;
	public Member1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member1(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	public Member1(String id, String pass, String name, Date regdte, Date uptdate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regdte = regdte;
		this.uptdate = uptdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegdte() {
		return regdte;
	}
	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}
	public Date getUptdate() {
		return uptdate;
	}
	public void setUptdate(Date uptdate) {
		this.uptdate = uptdate;
	}
	

}
