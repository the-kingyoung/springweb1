package javaexp.z01_vo;

public class Product implements Cloneable {
	private String name;
	private int price;
	private int cnt;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public Product clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Product cloned = (Product)super.clone();
		cloned.name = new String(this.name);
		cloned.price = this.price;
		cloned.cnt = this.cnt;
		
		return cloned;
	}



	public Product(String name, int price, int cnt) {
		super();
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	

}
