package javaexp.z01_vo;



public class Person implements Cloneable{
	private String name;
	private int age;
	private String loc;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Person clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		// 새로운 객체를 생성하고, 각각의 속성을 할당 처리..
		Person cloned = (Person)super.clone();
		cloned.name = new String(this.name);
		cloned.age = this.age;
		cloned.loc = new String(this.loc);
		
		return cloned;
	}

	public Person(String name, int age, String loc) {
		super();
		this.name = name;
		this.age = age;
		this.loc = loc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	

}
