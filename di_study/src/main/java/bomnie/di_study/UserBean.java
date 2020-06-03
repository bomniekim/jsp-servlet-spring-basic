package bomnie.di_study;

public class UserBean {
	
	/*
	 1) private 필드
	 2) 기본생성자 존재
	 3) getter and setter / property 라고 부름 (* 용어 중요!)
	 */

	private String name;
	private int age;
	private boolean male;
	
	public UserBean() {} // 기본생성자
	
	public UserBean(String name, int age, boolean male) {
		super();
		this.name = name;
		this.age = age;
		this.male = male;
	}
	
	// getter and setter 
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
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	
	
	
}
